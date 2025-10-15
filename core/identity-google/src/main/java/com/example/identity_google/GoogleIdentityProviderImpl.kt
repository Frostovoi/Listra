package com.example.identity_google

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialException
import androidx.credentials.exceptions.NoCredentialException
import com.example.api.utils.Result
import com.example.api.utils.mapError
import com.example.api.utils.runOperationCatching
import com.example.identity_api.GoogleIdentityProvider
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import java.security.SecureRandom
import java.util.Base64
import javax.inject.Inject

private const val TAG = "GoogleIdentityProvider"

class GoogleIdentityProviderImpl @Inject constructor() : GoogleIdentityProvider {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun requestIdToken(context: Context): Result<String, Throwable> {


        return runOperationCatching {
            val cm = CredentialManager.create(context)

            val option = GetSignInWithGoogleOption.Builder(
                serverClientId = BuildConfig.SERVER_CLIENT_ID
            )
                .setNonce(generateSecureRandomNonce())
                .build()
//            val option = GetGoogleIdOption.Builder()
//                .setServerClientId(BuildConfig.SERVER_CLIENT_ID)
//                .setFilterByAuthorizedAccounts(false)
//                .build()

            val request = GetCredentialRequest.Builder()
                .addCredentialOption(option)
                .build()

            val res =  cm.getCredential(context, request)

            val cred = res.credential

            if (cred is CustomCredential &&
                cred.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
            ) {
                val token = GoogleIdTokenCredential.createFrom(cred.data).idToken
                require(token.isNotBlank()) { "Empty Google ID Token" }
                Log.d(TAG, "Got ID token (${token.length} chars)")
                token
            } else {
                throw IllegalStateException("No Google ID Token")
            }
        }.mapError { e ->
            when (e) {
                is NoCredentialException -> IllegalStateException("No credentials available", e)
                is GetCredentialException -> IllegalStateException("Credential error: ${e.message}", e)
                else -> e
            }
        }
    }
}


//This function is used to generate a secure nonce to pass in with our request
@RequiresApi(Build.VERSION_CODES.O)
private fun generateSecureRandomNonce(byteLength: Int = 32): String {
    val randomBytes = ByteArray(byteLength)
    SecureRandom.getInstanceStrong().nextBytes(randomBytes)
    return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes)
}
package com.example.identity_google.di

import com.example.identity_api.GoogleIdentityProvider
import com.example.identity_google.GoogleIdentityProviderImpl
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface GoogleCredentialModule {
    @Binds
    @Singleton
    fun bindGoogleIdentity(impl: GoogleIdentityProviderImpl): GoogleIdentityProvider
}
package com.example.auth_repo.di

import com.example.api.repository.AuthRepository
import com.example.auth_repo.AuthRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface AuthRepositoryModule{
    @Binds
    fun bindSearchRepository(impl: AuthRepositoryImpl): AuthRepository
}
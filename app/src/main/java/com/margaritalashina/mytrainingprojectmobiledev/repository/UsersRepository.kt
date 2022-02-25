package com.margaritalashina.mytrainingprojectmobiledev.repository

import com.haroldadmin.cnradapter.NetworkResponse
import com.margaritalashina.mytrainingprojectmobiledev.data.network.Api
import com.margaritalashina.mytrainingprojectmobiledev.di.AppCoroutineScope
import com.margaritalashina.mytrainingprojectmobiledev.di.IoCoroutineDispatcher
import com.margaritalashina.mytrainingprojectmobiledev.entity.User
import dagger.Lazy
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsersRepository @Inject constructor(
    private val apiLazy: Lazy<Api>,
    @AppCoroutineScope externalCoroutineScope: CoroutineScope,
    @IoCoroutineDispatcher private val ioDispatcher: CoroutineDispatcher
) {
    private val api by lazy { apiLazy.get() }

    suspend fun getUsers() : NetworkResponse<List<User>, Unit> {
        return api.getUsers()
    }
}
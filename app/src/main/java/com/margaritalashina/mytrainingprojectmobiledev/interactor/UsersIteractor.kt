package com.margaritalashina.mytrainingprojectmobiledev.interactor


import com.haroldadmin.cnradapter.NetworkResponse
import com.margaritalashina.mytrainingprojectmobiledev.entity.User
import com.margaritalashina.mytrainingprojectmobiledev.repository.UsersRepository
import javax.inject.Inject

class UserListInteractor @Inject constructor(
    private val usersRepository: UsersRepository
) {
    suspend fun getUsers(): NetworkResponse<List<User>, Unit> {
        return usersRepository.getUsers()
    }
}
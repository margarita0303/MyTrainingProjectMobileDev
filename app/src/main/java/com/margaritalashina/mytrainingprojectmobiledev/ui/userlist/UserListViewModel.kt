package com.margaritalashina.mytrainingprojectmobiledev.ui.userlist

import androidx.lifecycle.viewModelScope
import com.haroldadmin.cnradapter.invoke
import com.margaritalashina.mytrainingprojectmobiledev.BuildConfig

import com.margaritalashina.mytrainingprojectmobiledev.data.network.Api
import com.margaritalashina.mytrainingprojectmobiledev.data.network.MockApi
import com.margaritalashina.mytrainingprojectmobiledev.entity.User
import com.margaritalashina.mytrainingprojectmobiledev.interactor.UserListInteractor
import com.margaritalashina.mytrainingprojectmobiledev.ui.base.BaseViewModel
import com.squareup.moshi.Moshi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val userListInteractor: UserListInteractor
) : BaseViewModel() {

    sealed class ViewState {
        object Loading : ViewState()
        data class Data(val userList: List<User>) : ViewState()
    }

    // некоторая обертка, которая позволяет следить за этим значением
    private val _viewState = MutableStateFlow<ViewState>(ViewState.Loading)
    val viewState : Flow<ViewState> get() = _viewState.asStateFlow()

    init {
        viewModelScope.launch {
            // emit sets value to flow
            _viewState.emit(ViewState.Loading)
            val users = loadUsers()
            _viewState.emit(ViewState.Data(users))
        }
    }

    private suspend fun loadUsers() : List<User> {
        return withContext(Dispatchers.IO) {
            Timber.d("loadUsers()")
            Thread.sleep(3000)
            provideApi().getUsers().invoke()?.toList() ?: emptyList()
        }
    }

    private fun provideApi(): Api =
        if (BuildConfig.USE_MOCK_BACKEND_API) {
            MockApi()
        } else {
            Retrofit.Builder()
                .client(provideOkHttpClient())
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(MoshiConverterFactory.create(provideMoshi()))
                .build()
                .create(Api::class.java)
        }

    private fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient
            .Builder()
//            .addInterceptor(AuthorizationInterceptor(AuthRepository(api, ...)))
//            .authenticator(OurAwesomeAppAuthenticator(authRepository))
            .apply {
                if (BuildConfig.DEBUG) {
                    addNetworkInterceptor (
                        HttpLoggingInterceptor { message ->
                            Timber.d(message)
                        }.setLevel(HttpLoggingInterceptor.Level.BODY)
                    )
                }
            }
            .build()

    private fun provideMoshi(): Moshi {
        return Moshi.Builder().build()
    }
}


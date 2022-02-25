package com.margaritalashina.mytrainingprojectmobiledev.ui.signup

import androidx.lifecycle.viewModelScope
import com.margaritalashina.mytrainingprojectmobiledev.repository.AuthRepositoryOld
import com.margaritalashina.mytrainingprojectmobiledev.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(): BaseViewModel() {

    private val _eventChannel = Channel<Event>(Channel.BUFFERED)

    fun eventsFlow(): Flow<Event> {
        return _eventChannel.receiveAsFlow()
    }

    fun signUp(
        firstname: String,
        lastname: String,
        nickname: String,
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            try {
                AuthRepositoryOld.signUp(
                    firstname,
                    lastname,
                    nickname,
                    email,
                    password
                )
                // _eventChannel.send(Event.SignUpSuccess)
                _eventChannel.send(Event.SignUpEmailConfirmationRequired)
            } catch (error: Exception) {
                _eventChannel.send(Event.SignUpEmailConfirmationRequired)
            }
        }
    }

    sealed class Event {
        object SignUpSuccess : Event()
        object SignUpEmailConfirmationRequired : Event()
    }
}
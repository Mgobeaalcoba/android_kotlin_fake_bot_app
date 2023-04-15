package com.example.fakebot

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private var _messagesList: MutableLiveData<MutableList<Message>> = MutableLiveData()
    private var _possibleAnswers: MutableLiveData<MutableList<Message>> = MutableLiveData()

    val messageList: LiveData<MutableList<Message>>
        get() = _messagesList

    val possibleAnswers: LiveData<MutableList<Message>>
        get() = _possibleAnswers

    init {
        _messagesList.value = mutableListOf<Message>()
        _possibleAnswers.value = mutableListOf<Message>(
            Message("Bot","No", System.currentTimeMillis()),
            Message("Bot","Si", System.currentTimeMillis()),
            Message("Bot","Pregunta de nuevo", System.currentTimeMillis()),
            Message("Bot","Es muy probable", System.currentTimeMillis()),
            Message("Bot","No lo creo", System.currentTimeMillis()),
            Message("Bot","No sé \uD83D\uDE41", System.currentTimeMillis()),
            Message("Bot","Tal vez", System.currentTimeMillis()),
            Message("Bot","Solo Díos sabe", System.currentTimeMillis())
        )
    }

    fun addMessage(message: Message) {
        _messagesList.value?.add(message)
    }

    fun returnMessage(): Message {
        return _possibleAnswers.value!!.random()
    }

    fun returnList(): MutableList<Message>? {
        return _messagesList.value
    }


}
package com.example.newyorktimes.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newyorktimes.data.datamodels.ResultStories

class CommunicatorViewModel : ViewModel() {

    var messageContainerA: MutableLiveData<ResultStories> = MutableLiveData<ResultStories>()
    var  messageContainer:MutableLiveData<ResultStories> = MutableLiveData<ResultStories>()


    fun sendMessageToB( msg : ResultStories ) {
        messageContainer.value=msg
    }

    fun sendMessageToA( msg : ResultStories ) {
        messageContainerA.value=msg
    }
    fun getMessageContainerA () : LiveData<ResultStories> {
        return messageContainerA
    }

    fun getMessageContainerB () : LiveData<ResultStories> {
        return messageContainer
    }


}
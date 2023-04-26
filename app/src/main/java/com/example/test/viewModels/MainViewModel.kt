package com.example.test.viewModels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.models.GetAllPost
import com.example.test.models.GetAllPostItem
import com.example.test.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: Repository) : ViewModel() {

    var job: Job? = null
    val getAllPost = MutableLiveData<ArrayList<GetAllPostItem>>()
    val errorMessage = MediatorLiveData<String>()
    val loading = MutableLiveData<Boolean>()

    fun getAllPost() {
        job = CoroutineScope(Dispatchers.Main).launch {
            val response = repository.getAllPost()
            if (response.isSuccessful){
                getAllPost.postValue(response.body())
                loading.value = false
            }else{
                onError("Error : ${response.message()}")
            }
        }

    }

    private fun onError(message : String){
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}
package com.example.baseprojectusinghilt.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.ResultHandler
import com.example.api.ServerBaseResponse
import com.example.baseprojectusinghilt.dataBase.Entity.DemoData
import com.example.baseprojectusinghilt.repo.Repo1
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel1 @Inject constructor(private val repo1: Repo1) : ViewModel() {


    private val demoLiveData = MutableLiveData<ResultHandler<ServerBaseResponse<List<DemoData>>>>()
    val demoData: LiveData<ResultHandler<ServerBaseResponse<List<DemoData>>>>
        get() = demoLiveData

    fun getProduct() {
        viewModelScope.launch {
            repo1.getProduct().collect{
                demoLiveData.postValue(it)
            }
        }
    }

}
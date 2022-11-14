package com.example.basecodes.di.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basecodes.data.api.ApiRepositoryImpl
import com.example.basecodes.data.api.ApiService
import com.example.basecodes.utils.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ApiViewModel @Inject constructor(private val apiService: ApiRepositoryImpl) : ViewModel() {


    //change 'Any' to model class
    private val dataList = MutableLiveData<Resource<List<Any>>>()
    val data: LiveData<Resource<List<Any>>>
        get() = dataList


    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            dataList.postValue(Resource.loading(null))
            apiService.getDataList<Any>().let {
                if (it.isSuccessful) {
                    dataList.postValue(Resource.success(it.body()))
                } else {
                    dataList.postValue(Resource.error(null, it.errorBody().toString()))
                }
            }
        }
    }


}
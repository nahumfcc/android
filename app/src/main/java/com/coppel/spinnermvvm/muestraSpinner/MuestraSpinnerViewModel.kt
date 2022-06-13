package com.coppel.spinnermvvm.muestraSpinner

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coppel.spinnermvvm.entities.EntityUser
import com.coppel.spinnermvvm.service.StructureResponse
import com.coppel.spinnermvvm.service.UserService
import kotlinx.coroutines.launch

class MuestraSpinnerViewModel :ViewModel(){

    val usersModel = MutableLiveData<StructureResponse<List<EntityUser>>>()
    var service = UserService()

    fun getUsers()
    {
        viewModelScope.launch {
            val result:StructureResponse<List<EntityUser>> = service.getAllUsers()
            if (result.meta.count==200)
            {
                usersModel.postValue(result)
            }
        }
    }
}
package com.coppel.spinnermvvm.service

import com.coppel.spinnermvvm.entities.EntityUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserService {

    private val retrofitGet = RetrofitClient.getRetrofitInstanceForGET()

    suspend fun getAllUsers():StructureResponse<List<EntityUser>>{
        return withContext(Dispatchers.IO){
            var response:Response<StructureResponse<List<EntityUser>>>
            = retrofitGet.create(UserApiInterface::class.java)
                .getAllUsers()
            response.body()?: StructureResponse(
                List<EntityUser>(1){
                    EntityUser(
                        false,"",
                        "",
                        "",
                        0,
                        "")
                }
                ,Meta("No se pudo recuperar", 0))
        }
    }
}
package com.coppel.spinnermvvm.service

import com.coppel.spinnermvvm.entities.EntityUser
import retrofit2.Response
import retrofit2.http.GET

interface UserApiInterface {

    @GET("login")
    suspend fun getAllUsers(): Response<StructureResponse<List<EntityUser>>>
}
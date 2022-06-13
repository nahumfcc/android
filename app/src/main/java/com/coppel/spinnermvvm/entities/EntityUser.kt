package com.coppel.spinnermvvm.entities

import com.google.gson.annotations.SerializedName

data class EntityUser(
    @SerializedName("IsValidUser") var isValidUser: Boolean,
    @SerializedName("Nombre") var nombre: String,
    @SerializedName("ApellidoPaterno") var apellidoPaterno: String,
    @SerializedName("ApellidoMaterno") var apellidoMaterno: String,
    @SerializedName("idRol") var idRol: Int,
    @SerializedName("usuario") var usuario: String
){
    override fun toString(): String {
        return usuario
    }
}


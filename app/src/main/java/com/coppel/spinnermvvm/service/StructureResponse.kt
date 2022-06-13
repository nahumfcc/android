package com.coppel.spinnermvvm.service

import com.google.gson.annotations.SerializedName

data class StructureResponse<T>(
    @SerializedName("data") val data: T,
    @SerializedName("meta") val meta: Meta)
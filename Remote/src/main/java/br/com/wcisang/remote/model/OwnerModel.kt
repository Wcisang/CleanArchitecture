package br.com.wcisang.remote.model

import com.google.gson.annotations.SerializedName

class OwnerModel(@SerializedName("login") val ownerNAme: String,
                 @SerializedName("avatar_url") val ownerAvatar: String) {


}
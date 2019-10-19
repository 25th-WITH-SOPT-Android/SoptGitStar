package com.greedy0110.soptgitstar.data.user

import com.google.gson.annotations.SerializedName

//Git Response : https://developer.github.com/v3/users/#response
class GetUserData(
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("bio")
    val bio: String?,
    @SerializedName("followers")
    val numOfFollowers: Int
)
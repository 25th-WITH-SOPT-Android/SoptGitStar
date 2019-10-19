package com.greedy0110.soptgitstar.data.user

import com.google.gson.annotations.SerializedName

// TODO User 정보를 모두 만들지 못한다. 어떻게 해야할까?
//Git Response : https://developer.github.com/v3/users/followers/#response-1
class GetFollowerData(
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String?
)
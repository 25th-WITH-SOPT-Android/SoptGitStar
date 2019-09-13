package com.greedy0110.soptgitstar.data.user

data class User(
    val avatarImageUrl: String,
    val login: String,
    val name: String,
    val bio: String,
    val followerCount: Int
)
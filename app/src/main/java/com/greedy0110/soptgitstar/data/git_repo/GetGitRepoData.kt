package com.greedy0110.soptgitstar.data.git_repo

import com.google.gson.annotations.SerializedName

//GitHub Response : https://developer.github.com/v3/repos/#response
data class GetGitRepoData(
    //서버의 데이터 규약과 맞는 이름이 들어와야한다.
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("language")
    val language: String?
)
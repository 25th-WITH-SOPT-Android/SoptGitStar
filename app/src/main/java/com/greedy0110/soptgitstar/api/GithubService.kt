package com.greedy0110.soptgitstar.api

import com.greedy0110.soptgitstar.data.git_repo.GetGitRepoData
import com.greedy0110.soptgitstar.data.user.GetFollowerData
import com.greedy0110.soptgitstar.data.user.GetUserData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubService {
    @GET("/users/{login}")
    fun getUser(
        @Path("login") login: String
    ): Call<GetUserData>

    @GET("/users/{login}/followers")
    fun getFollowers(
        @Path("login") login: String
    ): Call<List<GetFollowerData>>

    @GET("/users/{login}/repos")
    fun getRepos(
        @Path("login") login: String
    ): Call<List<GetGitRepoData>>
}
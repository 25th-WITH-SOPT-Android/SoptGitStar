package com.greedy0110.soptgitstar.api

import retrofit2.http.GET
import retrofit2.http.Path


interface GithubService {
    @GET("/user/{login}")
    fun getUser(
        @Path("login") login: String
    )

    @GET("/users/{login}/followers")
    fun getFollowers(
        @Path("login") login: String
    )

    @GET("/user/{login}/repos")
    fun getRepos(
        @Path("login") login: String
    )
}
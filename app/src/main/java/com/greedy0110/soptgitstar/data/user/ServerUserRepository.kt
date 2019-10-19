package com.greedy0110.soptgitstar.data.user

import com.greedy0110.soptgitstar.api.GithubServiceImpl
import retrofit2.Call

class ServerUserRepository: UserRepository {
    override fun getUser(login: String): Call<GetUserData> {
        return GithubServiceImpl.service.getUser(login)
    }

    override fun getFollowers(login: String): Call<List<GetFollowerData>> {
        return GithubServiceImpl.service.getFollowers(login)
    }
}
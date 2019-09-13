package com.greedy0110.soptgitstar.data.user

import com.greedy0110.soptgitstar.data.user.User

interface UserRepository {
    /**
     * login 에 해당하는 유저 정보를 받아온다.
     * */
    fun getUser(login: String): User
}
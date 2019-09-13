package com.greedy0110.soptgitstar.data.follower

import com.greedy0110.soptgitstar.data.follower.Follower

interface FollowerRepository {
    /**
     * login 한 유저의 follower 리스트를 반환한다.
     * */
    fun getFollowers(login: String): List<Follower>
}
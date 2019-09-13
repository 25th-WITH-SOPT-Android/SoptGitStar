package com.greedy0110.soptgitstar.data.follower

class DummyFollowerRepository : FollowerRepository {
    override fun getFollowers(login: String): List<Follower> {
        return listOf(
            Follower(
                avatarImageUrl = "",
                login = "greedy0110"
            ),
            Follower(
                avatarImageUrl = "",
                login = "greedy0111"
            ),
            Follower(
                avatarImageUrl = "",
                login = "greedy0112"
            ),
            Follower(
                avatarImageUrl = "",
                login = "greedy0113"
            ),
            Follower(
                avatarImageUrl = "",
                login = "greedy0114"
            ),
            Follower(
                avatarImageUrl = "",
                login = "greedy0115"
            ),
            Follower(
                avatarImageUrl = "",
                login = "greedy0116"
            ),
            Follower(
                avatarImageUrl = "",
                login = "greedy0117"
            ),
            Follower(
                avatarImageUrl = "",
                login = "greedy0118"
            ),
            Follower(
                avatarImageUrl = "",
                login = "greedy0119"
            ),
            Follower(
                avatarImageUrl = "",
                login = "greedy0110"
            ),
            Follower(
                avatarImageUrl = "",
                login = "greedy0111"
            ),
            Follower(
                avatarImageUrl = "",
                login = "greedy0112"
            )
        )
    }
}
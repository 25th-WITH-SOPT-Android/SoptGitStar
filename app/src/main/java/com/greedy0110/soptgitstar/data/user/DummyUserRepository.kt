package com.greedy0110.soptgitstar.data.user

import retrofit2.Call
import retrofit2.mock.Calls

class DummyUserRepository : UserRepository {
    override fun getUser(login: String): Call<GetUserData> {
        return Calls.response(
            GetUserData(
                avatarUrl = "",
                login = "greedy0110",
                name = "seungmin shin",
                bio = "developer, interested in Android (Kotlin) & Machine learning",
                numOfFollowers = 23
            )
        )
    }

    override fun getFollowers(login: String): Call<GetFollowersData> {
        return Calls.response(
            GetFollowersData(
                listOf(
                    FollowerData(
                        avatarUrl = "",
                        login = "greedy0110"
                    ),
                    FollowerData(
                        avatarUrl = "",
                        login = "greedy0111"
                    ),
                    FollowerData(
                        avatarUrl = "",
                        login = "greedy0112"
                    ),
                    FollowerData(
                        avatarUrl = "",
                        login = "greedy0113"
                    ),
                    FollowerData(
                        avatarUrl = "",
                        login = "greedy0114"
                    ),
                    FollowerData(
                        avatarUrl = "",
                        login = "greedy0115"
                    ),
                    FollowerData(
                        avatarUrl = "",
                        login = "greedy0116"
                    ),
                    FollowerData(
                        avatarUrl = "",
                        login = "greedy0110"
                    )
                )
            )
        )
    }
}
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

    override fun getFollowers(login: String): Call<List<GetFollowerData>> {
        return Calls.response(
            listOf(
                GetFollowerData(
                    avatarUrl = "",
                    login = "greedy0110"
                ),
                GetFollowerData(
                    avatarUrl = "",
                    login = "greedy0111"
                ),
                GetFollowerData(
                    avatarUrl = "",
                    login = "greedy0112"
                ),
                GetFollowerData(
                    avatarUrl = "",
                    login = "greedy0113"
                ),
                GetFollowerData(
                    avatarUrl = "",
                    login = "greedy0114"
                ),
                GetFollowerData(
                    avatarUrl = "",
                    login = "greedy0115"
                ),
                GetFollowerData(
                    avatarUrl = "",
                    login = "greedy0116"
                ),
                GetFollowerData(
                    avatarUrl = "",
                    login = "greedy0110"
                )
            )
        )
    }
}
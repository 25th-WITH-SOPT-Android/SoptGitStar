package com.greedy0110.soptgitstar.data.user

import retrofit2.Call
import retrofit2.mock.Calls

class DummyUserRepository : UserRepository {
    override fun getUser(login: String): Call<User> {
        return Calls.response(
            User(
                avatarImageUrl = "",
                login = "greedy0110",
                name = "seungmin shin",
                bio = "developer, interested in Android (Kotlin) & Machine learning",
                followerCount = 23
            )
        )
    }

    override fun getFollowers(login: String): Call<List<User>> {
        return Calls.response(
            listOf(
                User(
                    avatarImageUrl = "",
                    login = "greedy0110",
                    name = "seungmin shin",
                    bio = "developer, interested in Android (Kotlin) & Machine learning",
                    followerCount = 23
                ),
                User(
                    avatarImageUrl = "",
                    login = "greedy0111",
                    name = "seungmin shin",
                    bio = "developer, interested in Android (Kotlin) & Machine learning",
                    followerCount = 23
                ),
                User(
                    avatarImageUrl = "",
                    login = "greedy0112",
                    name = "seungmin shin",
                    bio = "developer, interested in Android (Kotlin) & Machine learning",
                    followerCount = 23
                ),
                User(
                    avatarImageUrl = "",
                    login = "greedy0113",
                    name = "seungmin shin",
                    bio = "developer, interested in Android (Kotlin) & Machine learning",
                    followerCount = 23
                ),
                User(
                    avatarImageUrl = "",
                    login = "greedy0114",
                    name = "seungmin shin",
                    bio = "developer, interested in Android (Kotlin) & Machine learning",
                    followerCount = 23
                ),
                User(
                    avatarImageUrl = "",
                    login = "greedy0115",
                    name = "seungmin shin",
                    bio = "developer, interested in Android (Kotlin) & Machine learning",
                    followerCount = 23
                ),
                User(
                    avatarImageUrl = "",
                    login = "greedy0116",
                    name = "seungmin shin",
                    bio = "developer, interested in Android (Kotlin) & Machine learning",
                    followerCount = 23
                )
            )
        )
    }
}
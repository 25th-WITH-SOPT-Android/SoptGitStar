package com.greedy0110.soptgitstar.data.user

class DummyUserRepository : UserRepository {
    override fun getUser(login: String): User {
        return User(
            avatarImageUrl = "",
            login = "greedy0110",
            name = "seungmin shin",
            bio = "developer, interested in Android (Kotlin) & Machine learning",
            followerCount = 23
        )
    }

    override fun getFollowers(login: String): List<User> {
        return listOf(
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
    }
}
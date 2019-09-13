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
}
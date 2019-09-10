package com.greedy0110.soptgitstar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.greedy0110.soptgitstar.data.dummyUser
import kotlinx.android.synthetic.main.activity_follower_list.*

class FollowerListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_follower_list)

        makeController()
    }

    private fun makeController() {
        makeProfile()
        makeFollowerListView()
    }

    // 상단에 profile 정보를 그려준다.
    private fun makeProfile() {
        // 현재 사용자 정보를 더미 데이터를 받아온다.
        val currentUser = dummyUser

        // 더미 데이터를 이용해 Profile을 채운다.
        txtFollowerListLogin.text = currentUser.login
        txtFollowerListName.text = currentUser.name
        txtFollowerListBio.text = currentUser.bio
        txtFollowerListFollowerCount.text = "followers : ${currentUser.followerCount}"
    }

    // 하단의 follower list view를 구현한다.
    private fun makeFollowerListView() {
        // TODO 여기에 recyclerView 구현을 해야한다.
    }
}

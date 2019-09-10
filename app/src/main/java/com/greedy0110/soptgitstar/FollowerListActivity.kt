package com.greedy0110.soptgitstar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.greedy0110.soptgitstar.data.dummyFollowers
import com.greedy0110.soptgitstar.data.dummyUser
import kotlinx.android.synthetic.main.activity_follower_list.*

class FollowerListActivity : AppCompatActivity() {
    private lateinit var adapter: FollowerAdapter

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
        // adapter를 초기회 한다.
        adapter = FollowerAdapter(this, listOf())

        // recyclerView와 어뎁터를 연결한다.
        recyclerViewFollowerList.adapter = adapter

        // recyclerView 아이템이 어떤 layout으로 그려질지 선택한다.
        recyclerViewFollowerList.layoutManager = LinearLayoutManager(this)

        // adapter에 데이터 갱신하기
        adapter.data = dummyFollowers
        // 데이터 갱신한 다음, 어뎁터에게 다시 그리라고 알려준다. (이거 안하면 변화가 갱신되지 않는다.)
        adapter.notifyDataSetChanged()
    }
}

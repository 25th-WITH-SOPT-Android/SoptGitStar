package com.greedy0110.soptgitstar.ui.follower_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.greedy0110.soptgitstar.R
import com.greedy0110.soptgitstar.data.follower.DummyFollowerRepository
import com.greedy0110.soptgitstar.data.user.DummyUserRepository
import com.greedy0110.soptgitstar.data.follower.FollowerRepository
import com.greedy0110.soptgitstar.data.user.UserRepository
import kotlinx.android.synthetic.main.activity_follower_list.*

class FollowerListActivity : AppCompatActivity() {
    private lateinit var adapter: FollowerAdapter
    private val userRepository: UserRepository =
        DummyUserRepository()
    private val followerRepository: FollowerRepository =
        DummyFollowerRepository()
    private var login: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_follower_list)

        // 엘비스 연산자를 사용해서 null 반환이 없도록 변경했다.
        login = intent.getStringExtra("login")?:""

        makeController()
    }

    private fun makeController() {
        makeProfile()
        makeFollowerListView()
    }

    // 상단에 profile 정보를 그려준다.
    private fun makeProfile() {
        // 현재 사용자 정보를 더미 데이터를 받아온다.
        val currentUser = userRepository.getUser(login)

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
        // 데이터의 소스는 repository가 관리한다.
        adapter.data = followerRepository.getFollowers(login)
        // 데이터 갱신한 다음, 어뎁터에게 다시 그리라고 알려준다. (이거 안하면 변화가 갱신되지 않는다.)
        adapter.notifyDataSetChanged()
    }
}

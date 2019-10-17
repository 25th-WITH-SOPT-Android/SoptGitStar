package com.greedy0110.soptgitstar.feature.git_repo_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.greedy0110.soptgitstar.R
import com.greedy0110.soptgitstar.data.git_repo.DummyGitRepoRepository
import com.greedy0110.soptgitstar.data.git_repo.GitRepoRepository
import com.greedy0110.soptgitstar.data.user.DummyUserRepository
import com.greedy0110.soptgitstar.data.user.UserRepository
import kotlinx.android.synthetic.main.activity_git_repo_list.*

class GitRepoListActivity : AppCompatActivity() {
    private lateinit var adapter: GitRepoAdapter
    private val userRepository: UserRepository = DummyUserRepository()
    private val gitRepoRepository: GitRepoRepository = DummyGitRepoRepository()
    private var login: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_repo_list)

        // 엘비스 연산자를 사용해서 null 반환이 없도록 변경했다.
        login = intent.getStringExtra("follower_name")?:""

        makeController()
    }

    private fun makeController() {
        makeProfile()
        makeGitRepoListView()
    }

    private fun makeProfile() {
        // 현재 사용자 정보를 더미 데이터를 받아온다.
        val currentUser = userRepository.getUser(login)

        // 더미 데이터를 이용해 Profile을 채운다.
        txtGitRepoListLogin.text = currentUser.login
        txtGitRepoListName.text = currentUser.name
        txtGitRepoListBio.text = currentUser.bio
        txtGitRepoListFollowerCount.text = "followers : ${currentUser.followerCount}"
    }

    private fun makeGitRepoListView() {
        adapter = GitRepoAdapter(this)

        recyclerViewGitRepoList.adapter = adapter
        recyclerViewGitRepoList.layoutManager = LinearLayoutManager(this)

        adapter.data = gitRepoRepository.getRepos(login)
        adapter.notifyDataSetChanged()
    }
}

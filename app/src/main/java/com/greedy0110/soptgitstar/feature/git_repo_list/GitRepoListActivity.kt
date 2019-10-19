package com.greedy0110.soptgitstar.feature.git_repo_list

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        profile_login.text = currentUser.login
        profile_name.text = currentUser.name
        profile_description.text = currentUser.bio
    }

    private fun makeGitRepoListView() {
        adapter = GitRepoAdapter(this)

        recyclerViewGitRepoList.adapter = adapter
        recyclerViewGitRepoList.layoutManager = LinearLayoutManager(this)
        // 아이템 기준 상단에 margin 을 구현하기 위해서 작성된 Item Decoration
        // 아이템 자체에 margin 을 두는 것 보다 권장되고, 다양한 상황에 응용 가능하다. (구글링 추천)
        recyclerViewGitRepoList.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                outRect.top = 15.dpToPx()
            }
        })

        adapter.data = gitRepoRepository.getRepos(login)
        adapter.notifyDataSetChanged()
    }

    private fun Int.dpToPx(): Int = TypedValue
        .applyDimension(TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(), resources.displayMetrics).toInt()
}

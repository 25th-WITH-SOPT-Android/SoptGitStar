package com.greedy0110.soptgitstar.feature.git_repo_list

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.greedy0110.soptgitstar.R
import com.greedy0110.soptgitstar.data.git_repo.*
import com.greedy0110.soptgitstar.feature.user_profile.UserProfileFragment
import kotlinx.android.synthetic.main.activity_git_repo_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitRepoListActivity : AppCompatActivity() {
    private lateinit var adapter: GitRepoAdapter
    private val gitRepoRepository: GitRepoRepository = ServerGitRepoRepository()
    private var login: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_repo_list)

        // 엘비스 연산자를 사용해서 null 반환이 없도록 변경했다.
        login = intent.getStringExtra("follower_name") ?: ""
        Log.d("sopt_git_star", "get repos $login")

        makeController()
    }

    private fun makeController() {
        makeProfile()
        makeGitRepoListView()
    }

    private fun makeProfile() {
        val profileFragment = UserProfileFragment.newInstance(login)

        val transaction = supportFragmentManager.beginTransaction()
        // container 를 fragment 로 대치한다! Fragment 앞에서 알아서 User 정보를 채워줄 것이다.
        transaction
            .replace(R.id.profile_container, profileFragment)
            .commit()
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

        // 지정한 사용자의 팔로워 정보를 비동기적으로 받아온다.
        // Callback 내부의 코드는 나중에 데이터를 받아오고 실행된다.
        gitRepoRepository.getRepos(login).enqueue(object : Callback<List<GetGitRepoData>> {
            override fun onFailure(call: Call<List<GetGitRepoData>>, t: Throwable) {
                //네트워크 통신에 실패했을 때
                Log.e("sopt_git_star", "error : $t")
            }

            override fun onResponse(
                call: Call<List<GetGitRepoData>>,
                response: Response<List<GetGitRepoData>>
            ) {
                //네트워크 통신에 성공했을때, response 에 서버에서 받아온 데이터가 있을 것이다.
                if (response.isSuccessful) {
                    val gitRepos =
                        response.body()!! // TODO 여기서 body 가 없다면, 어플리케이션이 죽을 것이다 어떻게 해야할까?

                    // adapter에 데이터 갱신하기
                    // 데이터의 소스는 repository가 관리한다.
                    adapter.data = gitRepos
                    // 데이터 갱신한 다음, 어뎁터에게 다시 그리라고 알려준다. (이거 안하면 변화가 갱신되지 않는다.)
                    adapter.notifyDataSetChanged()
                }
            }
        })
    }

    private fun Int.dpToPx(): Int = TypedValue
        .applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(), resources.displayMetrics
        ).toInt()
}

package com.greedy0110.soptgitstar.feature.follower_list

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.greedy0110.soptgitstar.R
import com.greedy0110.soptgitstar.data.user.*
import kotlinx.android.synthetic.main.activity_follower_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowerListActivity : AppCompatActivity() {
    private lateinit var adapter: FollowerAdapter

    private val userRepository: UserRepository = ServerUserRepository()

    private var login: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_follower_list)

        // 엘비스 연산자를 사용해서 null 반환이 없도록 변경했다.
        login = intent.getStringExtra("login")?:""
        Log.d("sopt_git_star", "$login 's followers")

        makeProfile()
        makeFollowerListView()
    }

    // 상단에 profile 정보를 그려준다.
    private fun makeProfile() {
        // 히히히히
        // 현재 사용자 정보를 비동기적으로 받아온다.
        // Callback 내부의 코드는 나중에 데이터를 받아오고 실행된다.
        userRepository.getUser(login).enqueue(object : Callback<GetUserData> {
            override fun onFailure(call: Call<GetUserData>, t: Throwable) {
                //네트워크 통신에 실패했을 때
                Log.e("sopt_git_star", "error : $t")
            }

            override fun onResponse(call: Call<GetUserData>, response: Response<GetUserData>) {
                //네트워크 통신에 성공했을때, response 에 서버에서 받아온 데이터가 있을 것이다.
                Log.d("sopt_git_star", "get user info success ${response.isSuccessful}")
                if (response.isSuccessful) {
                    val currentUser = response.body()!! // TODO 여기서 body 가 없다면, 어플리케이션이 죽을 것이다 어떻게 해야할까?

                    Log.d("sopt_git_star", "get user info $currentUser")
                    // 더미 데이터를 이용해 Profile을 채운다.
                    profile_login.text = currentUser.login
                    profile_name.text = currentUser.name
                    profile_description.text = currentUser.bio
                }
            }
        })
    }

    // 하단의 follower list view를 구현한다.
    private fun makeFollowerListView() {
        // adapter를 초기회 한다.
        adapter = FollowerAdapter(this)

        // recyclerView와 어뎁터를 연결한다.
        follower_list.adapter = adapter

        // recyclerView 아이템이 어떤 layout으로 그려질지 선택한다.
        follower_list.layoutManager = LinearLayoutManager(this)
        follower_list.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                outRect.top = 15.dpToPx()
            }
        })

        // 현재 사용자 정보를 비동기적으로 받아온다.
        // Callback 내부의 코드는 나중에 데이터를 받아오고 실행된다.
        userRepository.getFollowers(login).enqueue(object : Callback<List<GetFollowerData>> {
            override fun onFailure(call: Call<List<GetFollowerData>>, t: Throwable) {
                //네트워크 통신에 실패했을 때
                Log.e("sopt_git_star", "error : $t")
            }

            override fun onResponse(call: Call<List<GetFollowerData>>, response: Response<List<GetFollowerData>>) {
                //네트워크 통신에 성공했을때, response 에 서버에서 받아온 데이터가 있을 것이다.
                if (response.isSuccessful) {
                    val followers = response.body()!! // TODO 여기서 body 가 없다면, 어플리케이션이 죽을 것이다 어떻게 해야할까?

                    // adapter에 데이터 갱신하기
                    // 데이터의 소스는 repository가 관리한다.
                    adapter.data = followers
                            // 데이터 갱신한 다음, 어뎁터에게 다시 그리라고 알려준다. (이거 안하면 변화가 갱신되지 않는다.)
                    adapter.notifyDataSetChanged()
                }
            }
        })

    }

    private fun Int.dpToPx(): Int = TypedValue
        .applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(), resources.displayMetrics).toInt()
}

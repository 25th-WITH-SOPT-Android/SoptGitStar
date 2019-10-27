package com.greedy0110.soptgitstar.feature.user_profile


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.greedy0110.soptgitstar.R
import com.greedy0110.soptgitstar.data.user.GetUserData
import com.greedy0110.soptgitstar.data.user.ServerUserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val ARG_LOGIN = "login"

class UserProfileFragment : Fragment() {
    private var login: String? = null

    private lateinit var txtLogin: TextView
    private lateinit var txtName: TextView
    private lateinit var txtDescription: TextView
    private lateinit var imgAvatar: ImageView

    private val userRepository = ServerUserRepository()

    // 프래그먼트를 생성할 때 실행됩니다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            login = it.getString(ARG_LOGIN)
        }
    }

    // 실제로 View 를 만드는 곳, inflate 기억 나시나요?
    // activity onCreate 의 setContentView 와 유사한 느낌입니다요.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 우리가 이 Fragment 를 위해 작성한 layout file 을 inflate 시키는 코드입니다.
        val view: View = inflater.inflate(R.layout.fragment_user_profile, container, false)
        return view
    }

    // activity 의 onCreate 호출이 종료된 후 실행됩니다.
    // 즉 activity 에 접근해서 어떤 행동을 하려면 이 생명주기에서 작업을 해야합니다.
    // 그 전에는 activity 가 접근해도 이상한 행동을 하게 될거에요.
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        view?.let { view ->
            txtLogin = view.findViewById(R.id.profile_login)
            txtName = view.findViewById(R.id.profile_name)
            txtDescription = view.findViewById(R.id.profile_description)
            imgAvatar = view.findViewById(R.id.profile_image)

            login?.let { login ->
                userRepository.getUser(login).enqueue(object : Callback<GetUserData> {
                    override fun onFailure(call: Call<GetUserData>, t: Throwable) {
                        //네트워크 통신에 실패했을 때
                        Log.e("sopt_git_star", "error : $t")
                    }

                    override fun onResponse(
                        call: Call<GetUserData>,
                        response: Response<GetUserData>
                    ) {
                        //네트워크 통신에 성공했을때, response 에 서버에서 받아온 데이터가 있을 것이다.
                        if (response.isSuccessful) {
                            val currentUser =
                                response.body()!! // TODO 여기서 body 가 없다면, 어플리케이션이 죽을 것이다 어떻게 해야할까?

                            Log.d("sopt_git_star", "user info : $currentUser")

                            // 더미 데이터를 이용해 Profile을 채운다.
                            txtLogin.text = currentUser.login
                            txtName.text = currentUser.name
                            txtDescription.text = currentUser.bio

                            // Glide 라이브러리를 이용해 이미지 로드
                            Glide
                                .with(this@UserProfileFragment)
                                .load(currentUser.avatarUrl)
                                .into(imgAvatar)
                        }
                    }
                })
            }
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param login 사용자가 로그인 할 때 사용하는 아이디
         * @return A new instance of fragment UserProfileFragment.
         */
        @JvmStatic
        fun newInstance(login: String) =
            UserProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_LOGIN, login)
                }
            }
    }
}

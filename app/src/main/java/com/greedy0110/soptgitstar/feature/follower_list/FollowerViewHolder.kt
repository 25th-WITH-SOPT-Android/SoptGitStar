package com.greedy0110.soptgitstar.feature.follower_list

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.greedy0110.soptgitstar.R
import com.greedy0110.soptgitstar.data.user.FollowerData
import com.greedy0110.soptgitstar.feature.git_repo_list.GitRepoListActivity

// ViewHolder는 list_item_follower가 사용할 view의 객체를 가지고 있는다!!
class FollowerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val profileImage: ImageView = view.findViewById(R.id.profile_image)
    val profileLogin: TextView = view.findViewById(R.id.profile_login)
    val profileName: TextView = view.findViewById(R.id.profile_name)

    fun onBind(follower: FollowerData) {
        profileLogin.text = follower.login
        //profileName.text = follower.name

        // 아이템을 클릭하면, 해당 유저의 GitRepo 리스트를 확인하는 화면으로 넘어가자.
        // itemView 를 사용하면 아이템 최상단 뷰를 지칭하는 것이다.
        itemView.setOnClickListener {
            val context = it.context
            val intent = Intent(context, GitRepoListActivity::class.java)

            // 선택한 팔로워 이름을 전달한다.
            intent.putExtra("follower_name", follower.login)

            context.startActivity(intent)
        }
    }
}
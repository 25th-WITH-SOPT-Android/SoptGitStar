package com.greedy0110.soptgitstar.feature.follower_list

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.greedy0110.soptgitstar.R
import com.greedy0110.soptgitstar.data.user.User
import com.greedy0110.soptgitstar.feature.git_repo_list.GitRepoListActivity

// ViewHolder는 list_item_follower가 사용할 view의 객체를 가지고 있는다!!
class FollowerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    // Item 어디를 클릭해도 다음 화면으로 이동하도록 View 참조를 받아오자.
    val container: View = view.findViewById(R.id.containerListItemFollower)

    val imgListItemFollowerAvatar: ImageView = view.findViewById(R.id.imgListItemFollowerAvatar)
    val txtListItemFollowerLogin: TextView = view.findViewById(R.id.txtListItemFollowerLogin)

    fun onBind(user: User) {
        txtListItemFollowerLogin.text = user.login

        // 아이템을 클릭하면, 해당 유저의 GitRepo 리스트를 확인하는 화면으로 넘어가자.
        container.setOnClickListener {
            val intent = Intent(itemView.context, GitRepoListActivity::class.java)

            // 선택한 팔로워 이름을 전달한다.
            intent.putExtra("follower_name", user.login)

            itemView.context.startActivity(intent)
        }
    }
}
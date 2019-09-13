package com.greedy0110.soptgitstar.ui.follower_list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.greedy0110.soptgitstar.R

// ViewHolder는 list_item_follower가 사용할 view의 객체를 가지고 있는다!!
class FollowerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    // Item 어디를 클릭해도 다음 화면으로 이동하도록 View 참조를 받아오자.
    val container: View = view.findViewById(R.id.containerListItemFollower)

    val imgListItemFollowerAvatar: ImageView = view.findViewById(R.id.imgListItemFollowerAvatar)
    val txtListItemFollowerLogin: TextView = view.findViewById(R.id.txtListItemFollowerLogin)
}
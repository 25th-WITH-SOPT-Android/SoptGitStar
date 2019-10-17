package com.greedy0110.soptgitstar.feature.follower_list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greedy0110.soptgitstar.R
import com.greedy0110.soptgitstar.data.user.User

class FollowerAdapter(
    private val context: Context
) : RecyclerView.Adapter<FollowerViewHolder>() {
    var data: List<User> = listOf()

    // 우리가 정의한 ViewHolder를 실제로 만들어주는 것 (activity의 onCreate, setContentView와 비슷한 느낌)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        // list item follower.xml을 객체화 한다(inflate 한다).
        val view: View = LayoutInflater
            .from(context)
            .inflate(R.layout.list_item_follower, parent, false)
        return FollowerViewHolder(view)
    }

    // 아이템의 총 갯수
    override fun getItemCount(): Int {
        return data.size
    }

    // 만들어진 ViewHolder에 실제 데이터, 이벤트를 연결한다(bind).
    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(data[position])
    }
}

package com.greedy0110.soptgitstar.ui.follower_list

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greedy0110.soptgitstar.R
import com.greedy0110.soptgitstar.data.follower.Follower
import com.greedy0110.soptgitstar.ui.git_repo_list.GitRepoListActivity

class FollowerAdapter(
    private val context: Context,
    var data: List<Follower>
) : RecyclerView.Adapter<FollowerViewHolder>() {
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
        holder.txtListItemFollowerLogin.text = data[position].login

        // 아이템을 클릭하면, 해당 유저의 GitRepo 리스트를 확인하는 화면으로 넘어가자.
        holder.container.setOnClickListener {
            val intent = Intent(context, GitRepoListActivity::class.java)

            // 선택한 팔로워 이름을 전달한다.
            intent.putExtra("follower_name", data[position].login)

            context.startActivity(intent)
        }
    }
}
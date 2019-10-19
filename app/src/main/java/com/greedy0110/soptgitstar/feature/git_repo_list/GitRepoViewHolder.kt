package com.greedy0110.soptgitstar.feature.git_repo_list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.greedy0110.soptgitstar.R
import com.greedy0110.soptgitstar.data.git_repo.GitRepo

class GitRepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val imgListItemGitRepoOwner: ImageView = view.findViewById(R.id.imgListItemGitRepoOwner)
    val txtListItemGitRepoName: TextView = view.findViewById(R.id.txtListItemGitRepoName)
    val txtListItemGitRepoDesc: TextView = view.findViewById(R.id.txtListItemGitRepoDesc)

    fun onBind(data: GitRepo) {
        txtListItemGitRepoName.text = data.name
        txtListItemGitRepoDesc.text = data.description
    }
}
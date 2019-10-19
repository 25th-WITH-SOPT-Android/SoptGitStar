package com.greedy0110.soptgitstar.feature.git_repo_list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greedy0110.soptgitstar.R
import com.greedy0110.soptgitstar.data.git_repo.GetGitRepoData
import com.greedy0110.soptgitstar.data.git_repo.GitRepo

class GitRepoAdapter(
    private val context: Context
) : RecyclerView.Adapter<GitRepoViewHolder>() {

    var data: List<GetGitRepoData> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_git_repo, parent, false)
        return GitRepoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: GitRepoViewHolder, position: Int) {
        holder.onBind(data[position])
    }
}
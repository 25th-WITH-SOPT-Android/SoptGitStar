package com.greedy0110.soptgitstar.feature.git_repo_list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.greedy0110.soptgitstar.R
import com.greedy0110.soptgitstar.data.git_repo.GetGitRepoData
import com.greedy0110.soptgitstar.data.git_repo.GitRepo

class GitRepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val title: TextView = view.findViewById(R.id.title)
    val updated: TextView = view.findViewById(R.id.updated)
    val description: TextView = view.findViewById(R.id.description)
    val languageColor: ImageView = view.findViewById(R.id.language_color)
    val language: TextView = view.findViewById(R.id.language)

    fun onBind(data: GetGitRepoData) {
        title.text = data.name
        description.text = data.description
        language.text = data.language
        // TODO Upadted on 날짜 월 로 표현되도록 리팩토링 해야함
        updated.text = data.updatedAt
    }
}
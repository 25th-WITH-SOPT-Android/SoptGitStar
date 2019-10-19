package com.greedy0110.soptgitstar.data.git_repo

import com.greedy0110.soptgitstar.api.GithubServiceImpl
import retrofit2.Call

class ServerGitRepoRepository: GitRepoRepository {
    override fun getRepos(login: String): Call<List<GetGitRepoData>> {
        return GithubServiceImpl.service.getRepos(login)
    }
}

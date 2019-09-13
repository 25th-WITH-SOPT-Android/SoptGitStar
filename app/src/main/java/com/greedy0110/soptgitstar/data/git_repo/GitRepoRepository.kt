package com.greedy0110.soptgitstar.data.git_repo

interface GitRepoRepository {
    /**
     * login 한 유저의 GitRepo를 리스트 형태로 반환하는 함수
     * */
    fun getRepos(login: String): List<GitRepo>
}
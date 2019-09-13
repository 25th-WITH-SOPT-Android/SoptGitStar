package com.greedy0110.soptgitstar.data.git_repo

class DummyGitRepoRepository : GitRepoRepository {
    override fun getRepos(login: String): List<GitRepo> {
        return listOf(
            GitRepo(name = "Activity2Fragment", description = "Activity 와 Fragment 사이 데이터 교환을 위해 ViewModel + LiveData 를 사용한 기본적인 구현"),
            GitRepo(name = "Activity3Fragment", description = "Activity 와 Fragment 사이 데이터 교환을 위해 ViewModel + LiveData 를 사용한 기본적인 구현"),
            GitRepo(name = "Activity4Fragment", description = "Activity 와 Fragment 사이 데이터 교환을 위해 ViewModel + LiveData 를 사용한 기본적인 구현"),
            GitRepo(name = "Activity5Fragment", description = "Activity 와 Fragment 사이 데이터 교환을 위해 ViewModel + LiveData 를 사용한 기본적인 구현"),
            GitRepo(name = "Activity6Fragment", description = "Activity 와 Fragment 사이 데이터 교환을 위해 ViewModel + LiveData 를 사용한 기본적인 구현"),
            GitRepo(name = "Activity7Fragment", description = "Activity 와 Fragment 사이 데이터 교환을 위해 ViewModel + LiveData 를 사용한 기본적인 구현"),
            GitRepo(name = "Activity8Fragment", description = "Activity 와 Fragment 사이 데이터 교환을 위해 ViewModel + LiveData 를 사용한 기본적인 구현"),
            GitRepo(name = "Activity9Fragment", description = "Activity 와 Fragment 사이 데이터 교환을 위해 ViewModel + LiveData 를 사용한 기본적인 구현"),
            GitRepo(name = "Activity0Fragment", description = "Activity 와 Fragment 사이 데이터 교환을 위해 ViewModel + LiveData 를 사용한 기본적인 구현"),
            GitRepo(name = "Activity1Fragment", description = "Activity 와 Fragment 사이 데이터 교환을 위해 ViewModel + LiveData 를 사용한 기본적인 구현")
        )
    }
}
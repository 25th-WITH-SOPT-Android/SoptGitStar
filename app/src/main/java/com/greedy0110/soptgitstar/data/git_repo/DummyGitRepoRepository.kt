package com.greedy0110.soptgitstar.data.git_repo

import retrofit2.Call
import retrofit2.mock.Calls
import java.util.*

class DummyGitRepoRepository : GitRepoRepository {
    override fun getRepos(login: String): Call<List<GitRepo>> {
        return Calls.response(
            listOf(
                GitRepo(
                    name = "SoptStagram",
                    description = "IT 창업 동아리 SOPT 안드로이드 교육 프로젝트",
                    language = "Kotlin",
                    updated = Calendar.getInstance().apply {
                        set(
                            2019, Calendar.JANUARY, 10, 15, 12
                        )
                    }.time
                ),
                GitRepo(
                    name = "artic_android",
                    description = "Forked from artic_development/artic_android",
                    language = "Kotlin",
                    updated = Calendar.getInstance().apply {
                        set(
                            2019, Calendar.AUGUST, 16, 15, 12
                        )
                    }.time
                ),
                GitRepo(
                    name = "CalculatorWithEspresso",
                    description = "UI Test with Espresso + Unit Test Calculator",
                    language = "Kotlin",
                    updated = Calendar.getInstance().apply {
                        set(
                            2018, Calendar.OCTOBER, 10, 15, 12
                        )
                    }.time
                ),
                GitRepo(
                    name = "problemSovingGuZongMan",
                    description = "프로그래밍 대회에서 배우는 알고리즘 문제해결전략 공부하자",
                    language = "Kotlin",
                    updated = Calendar.getInstance().apply {
                        set(
                            2018, Calendar.NOVEMBER, 10, 15, 12
                        )
                    }.time
                )
            )
        )
    }
}
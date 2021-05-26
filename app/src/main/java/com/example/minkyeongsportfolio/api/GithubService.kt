package org.sopt.soptseminar_week1.api

import com.example.minkyeongsportfolio.model.GithubUserInfo
import com.example.minkyeongsportfolio.model.Repo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("/users/{username}/repos")
    fun getRepositories(@Path("username") username  : String): Call<List<Repo>>

    @GET("/users/{username}")
    fun getUserInfo(@Path("username") username  : String): Call<GithubUserInfo>

}
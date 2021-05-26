package com.example.minkyeongsportfolio.ui

import android.app.ActivityOptions
import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.util.Pair
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.minkyeongsportfolio.R
import com.example.minkyeongsportfolio.model.GithubUserInfo
import com.example.minkyeongsportfolio.model.Repo
import kotlinx.android.synthetic.main.activity_github.*
import kotlinx.android.synthetic.main.activity_main.*
import org.sopt.soptseminar_week1.api.RetrofitServiceCreator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github)
        handleGetRequest()
        Handler(Looper.getMainLooper()).postDelayed({
            loading.visibility = View.GONE
            }, 2000)
    }

    private fun handleGetRequest() {
        val call: Call<List<Repo>> =
            RetrofitServiceCreator.githubService.getRepositories("minkyeongk")
        call.enqueue(object : Callback<List<Repo>> {
            override fun onResponse(
                call: Call<List<Repo>>,
                response: Response<List<Repo>>
            ) {
                if (response.body() != null) {
                    println(response.body())
                    initRecyclerview(response.body()!!)
                }
            }
            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                Log.d("Repos Fail", t.toString())
            }
        })

        val call2: Call<GithubUserInfo> =
            RetrofitServiceCreator.githubService.getUserInfo("minkyeongk")
        call2.enqueue(object : Callback<GithubUserInfo> {
            override fun onResponse(
                call: Call<GithubUserInfo>,
                response: Response<GithubUserInfo>
            ) {
                if (response.body() != null) {
                    text_home_profile_github_id.text = requireNotNull(response.body()).login
                    text_home_profile_github_comment.text = requireNotNull(response.body()).bio

                    Glide.with(img_home_profile.context).load(response.body()!!.avatar_url)
                        .into(img_home_profile)
                }
            }

            override fun onFailure(call: Call<GithubUserInfo>, t: Throwable) {
                Log.d("Info Fail", t.toString())
            }

        })
    }

    private fun initRecyclerview(repositoryList: List<Repo>) {
        repoRecyclerview.layoutManager = LinearLayoutManager(this)
        repoRecyclerview.adapter = RepositoriesAdapter(repositoryList)
    }
}
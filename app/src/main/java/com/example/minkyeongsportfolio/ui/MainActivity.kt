package com.example.minkyeongsportfolio.ui

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.minkyeongsportfolio.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var intent: Intent
        project_button.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.notion.so/Minkyeong-Kim-5b20d2d8509d4dec891b873fb2bfe9cf"))
            startActivity(intent)
        }

        github_button.setOnClickListener {
            intent = Intent(this, GithubActivity::class.java)
            startActivity(intent)
        }

        blog_button.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://happy-mincoder.tistory.com/"))
            startActivity(intent)
        }

        resume_button.setOnClickListener {
            Toast.makeText(this, "Available Not Yet", Toast.LENGTH_SHORT).show()
        }
    }
}
package com.example.minkyeongsportfolio.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.minkyeongsportfolio.model.Repo

/**
 * ReposAdapter (Repositories adapter)
 * repositoies list의 어댑터 Adapter
 * 뷰홀더는 외부 클래스로 생성
 */

class RepositoriesAdapter(private val RepoList: List<Repo>) :RecyclerView.Adapter<RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val repoItem = RepoList[position]
        holder.bind(repoItem)
    }

    override fun getItemCount(): Int {
        return RepoList.size
    }
}
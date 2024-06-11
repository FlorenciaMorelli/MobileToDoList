package com.example.alertdialog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alertdialog.R
import com.example.alertdialog.data.Task

class TaskListAdapter(val taskList: List<Task>): RecyclerView.Adapter<TaskListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TaskListViewHolder(layoutInflater.inflate(R.layout.task_item, parent, false))
    }

    override fun getItemCount() = taskList.size

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        val item = taskList[position]
        holder.bind(item)
    }

}
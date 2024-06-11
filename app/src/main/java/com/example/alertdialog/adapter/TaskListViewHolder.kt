package com.example.alertdialog.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.alertdialog.data.Task
import com.example.alertdialog.databinding.TaskItemBinding

class TaskListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = TaskItemBinding.bind(view)

    fun bind(task: Task){
        binding.tvTitle.text = task.title
        binding.tvDescription.text = task.description
    }

}
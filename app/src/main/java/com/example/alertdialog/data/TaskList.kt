package com.example.alertdialog.data

object TaskList{
    val listOfTasks = mutableListOf<Task>()

    fun addTask(task: Task){
        listOfTasks.add(task)
    }
}
package com.example.alertdialog.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alertdialog.data.Task
import com.example.alertdialog.data.TaskList

class TaskListViewModel: ViewModel() {
    private val _taskList = MutableLiveData<List<Task>>()
    val taskList: LiveData<List<Task>> = _taskList

    // Lo que está dentro del init es lo que se va a crear cuando instanciemos la clase
    init{
        _taskList.value = TaskList.listOfTasks
    }

    fun addTask(title: String, description: String){
        val task = Task(title, description)
        val updatedList = _taskList.value.orEmpty().toMutableList()

        updatedList.add(task)
        _taskList.value = updatedList
    }
}
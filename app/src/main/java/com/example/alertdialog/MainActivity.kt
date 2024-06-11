package com.example.alertdialog

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alertdialog.adapter.TaskListAdapter
import com.example.alertdialog.data.Task
import com.example.alertdialog.data.TaskList
import com.example.alertdialog.databinding.ActivityMainBinding
import com.example.alertdialog.databinding.DialogTaskBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var dialogTaskBinding: DialogTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        dialogTaskBinding = DialogTaskBinding.inflate(layoutInflater)
        val alertDialogBuilder = AlertDialog.Builder(this)
        // Cuando se quiera pintar, que busque el componente dialog_task
        alertDialogBuilder.setView(dialogTaskBinding.root)

        val alertDialog = alertDialogBuilder.create()

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecycler(TaskList.listOfTasks)

        setListener(alertDialog)

    }

    fun initRecycler(taskList:List<Task>){

        binding.rvTasks.layoutManager = LinearLayoutManager(this)
        binding.rvTasks.adapter = TaskListAdapter(taskList)
    }

    fun setListener(alertDialog: AlertDialog){
        binding.fabAddTask.setOnClickListener{
            showAlertDialog(alertDialog)
        }
    }

    fun showAlertDialog(alertDialog: AlertDialog){
        alertDialog.show()
        clearEditText()

        dialogTaskBinding.fabPlus.setOnClickListener{
            val title = addTitleTask()
            val description = addDescriptionTask()

            if(!title.isNullOrEmpty() && !description.isNullOrEmpty()){
                saveTask(title, description)
                clearEditText()
                alertDialog.dismiss()
            }
        }
    }

    fun saveTask(title: String, description: String){
        val task = Task(title, description)

        TaskList.addTask(task)
    }

    fun addTitleTask(): String{
        val title = dialogTaskBinding.etTitle.text.toString()

        return title
    }

    fun addDescriptionTask(): String{
        val description = dialogTaskBinding.etDescription.text.toString()

        return description
    }

    fun clearEditText(){
        dialogTaskBinding.etTitle.text.clear()
        dialogTaskBinding.etDescription.text.clear()
    }
}
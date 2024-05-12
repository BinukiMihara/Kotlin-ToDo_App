package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.todoapp.adapter.ToDoAdapter
import com.example.todoapp.db.DBOpenHelper
import com.example.todoapp.model.ToDoModel

class MainActivity : AppCompatActivity() {


    private lateinit var mainRecyclerView: RecyclerView
    private lateinit var fabCreate: FloatingActionButton
    private lateinit var myDataset: MutableList<ToDoModel>
    private val dbOpenHelper = DBOpenHelper(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainRecyclerView = findViewById(R.id.main_recycler_view)
        fabCreate = findViewById(R.id.fab_create)

        myDataset = dbOpenHelper.readToDo   ()

        mainRecyclerView.adapter = ToDoAdapter(this, myDataset)
        mainRecyclerView.setHasFixedSize(true)


        fabCreate.setOnClickListener {
            val intentToAddNoteActivity = Intent(this, AddActivity::class.java)
            startActivity(intentToAddNoteActivity)
            finish()
        }

    }
}
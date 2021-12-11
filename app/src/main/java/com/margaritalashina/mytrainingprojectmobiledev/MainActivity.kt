package com.margaritalashina.mytrainingprojectmobiledev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView = findViewById<RecyclerView>(R.id.usersRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = UserAdapter()
        recyclerView.adapter = adapter
        adapter.userList = loadUsers()
        adapter.notifyDataSetChanged()
    }

    private fun loadUsers() : List<User> {
        return listOf(
            User(
                avatarUrl = "",
                userName = "UserName 1",
                groupName = "A"
            ),
            User(
                avatarUrl = "",
                userName = "UserName 2",
                groupName = "A"
            ),
            User(
                avatarUrl = "",
                userName = "UserName 3",
                groupName = "C"
            ),
            User(
                avatarUrl = "",
                userName = "UserName 4",
                groupName = "A"
            ),
            User(
                avatarUrl = "",
                userName = "UserName 5",
                groupName = "B"
            ),
            User(
                avatarUrl = "",
                userName = "UserName 6",
                groupName = "A"
            ),
            User(
                avatarUrl = "",
                userName = "UserName 7",
                groupName = "A"
            ),
            User(
                avatarUrl = "",
                userName = "UserName 8",
                groupName = "C"
            ),
            User(
                avatarUrl = "",
                userName = "UserName 9",
                groupName = "A"
            ),
            User(
                avatarUrl = "",
                userName = "UserName 10",
                groupName = "B"
            ),
        )
    }
}
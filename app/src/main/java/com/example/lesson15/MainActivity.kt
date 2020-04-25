package com.example.lesson15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter:ListAdapter=ListAdapter(this)
    private var count=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        recycleView.adapter=adapter
        recycleView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recycleView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        val models:MutableList<User> = mutableListOf()
            val model: User= User()
            model.title="Title $count"
            model.description="Description $count"
            models.add(model)
        adapter.setDatas(models)
    }

    fun itemSetOnClick(user: User){
        count += user.number
        val models:MutableList<User> = mutableListOf()
        for(i in 0 until count) {
            val model: User = User()
            model.number+=i
            model.title="Title ${i+1}"
            model.description = "Description ${i+1}"
            models.add(model)
        }
        adapter.setDatas(models)
        Toast.makeText(this,"You added ${user.number} item",Toast.LENGTH_SHORT).show()
    }
}

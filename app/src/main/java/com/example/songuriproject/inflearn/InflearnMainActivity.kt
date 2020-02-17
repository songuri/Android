package com.example.songuriproject.inflearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.songuriproject.R
import com.example.songuriproject.inflearn.Permission.PermissionActivity
import com.example.songuriproject.inflearn.thread.AsyncTaskActivity
import com.example.songuriproject.inflearn.thread.HandlerActivity
import com.example.songuriproject.inflearn.thread.ThreadActivity
import kotlinx.android.synthetic.main.activity_inflearn_main.*
import kotlinx.android.synthetic.main.activity_main.*

class InflearnMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inflearn_main)


        btn_go_permission.setOnClickListener {
            val intent = Intent(this, PermissionActivity::class.java)
            startActivity(intent)
        }

        btn_go_thread.setOnClickListener {
            val intent = Intent(this, ThreadActivity::class.java)
            startActivity(intent)
        }
        btn_go_hanlder.setOnClickListener {
            val intent = Intent(this, HandlerActivity::class.java)
            startActivity(intent)
        }

        btn_go_async.setOnClickListener {
            val intent = Intent(this, AsyncTaskActivity::class.java)
            startActivity(intent)
        }

    }
}

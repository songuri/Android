package com.example.songuriproject

import android.app.Activity
import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.listview.ListViewTestActivitty
import com.example.songuriproject.testpage.AnimationTestActivity
import com.example.viewpager.vertical.VerticalViewPagerTestActivity
import com.example.viewpager.ViewPagerTestActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		initListener()
	}

	private fun initListener() {
		btn_go_anim.setOnClickListener {
			val intent = Intent(this, AnimationTestActivity::class.java)
			startActivity(intent)
		}

		btn_go_listview.setOnClickListener {
			val intent = Intent(this, ListViewTestActivitty::class.java)
			startActivity(intent)
		}

		btn_go_viewpager.setOnClickListener {
			val intent = Intent(this, ViewPagerTestActivity::class.java)
			startActivity(intent)
		}

		btn_go_vertical.setOnClickListener {
			val intent = Intent(this, VerticalViewPagerTestActivity::class.java)
			startActivity(intent)
		}
	}

}

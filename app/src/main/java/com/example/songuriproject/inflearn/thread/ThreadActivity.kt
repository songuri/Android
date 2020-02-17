package com.example.songuriproject.inflearn.thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import com.example.songuriproject.R
import kotlinx.android.synthetic.main.activity_thread.*

class ThreadActivity : AppCompatActivity() {

	var isRunning = true

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_thread)

		btn_thread.setOnClickListener { view ->
			var now = System.currentTimeMillis();
			textView2.text = "버튼 클릭 : ${now}"
		}

		var thread = ThreadClass1()
		thread.start()
	}

	inner class ThreadClass1 : Thread() {
		override fun run() {
			while (isRunning) {
				sleep(1000)
				var now = System.currentTimeMillis()
//				tv_time_text.text = "Thread Time : ${now}" // 8.0 이하는 앱이 죽어 버린다.
				/**
				 * 안드로이드 8.0 이상부터는 사용자가 만든 쓰레드에서  UI 처리가 가능하다.
				 */
				Log.d("test1", "Thread Time : ${now}")
			}
		}

	}

	override fun onDestroy() {
		isRunning = false
		super.onDestroy()
	}
}

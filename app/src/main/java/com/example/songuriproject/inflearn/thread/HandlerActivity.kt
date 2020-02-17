package com.example.songuriproject.inflearn.thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.os.SystemClock
import android.widget.TextView
import com.example.songuriproject.R
import kotlinx.android.synthetic.main.activity_handler.*

class HandlerActivity : AppCompatActivity() {

	var handler : Handler? = null
	var handler2 : DisplayHandler? = null
	/**
	 * MainThread 에서의 반복
	 * 1. Main Thread 에서 처리하는 코드 중에 일정 작업을 계속 반복 처리해야할 경우가 있다.
	 * 2. 이때 무한 루프를 쓰면 화면 처리가 불가능 하다
	 * 3. Handler를 통하면 원하는 코드를 반복해서 작업하는 것이 가능하다.
	 */

	/**
	 * Hanlder
	 * 1. Handler 는 개발자가 안드로이드 OS에게 작업 수행을 요청하는 역할을 한다.
	 * 2. 개발자가 작업을 요청하면 Android Os는 작업을 하지 않을 때, 개발자가 요청한 작업을 처리하게 된다.
	 * 3. 이 처리는 ainThread에서 처리 한다.
	 * 4. 5초 이상 걸리는 작업 불가
	 * 5. 화면 처리 가능
	 */
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_handler)

		button1.setOnClickListener { view ->
			var time = System.currentTimeMillis()
			textView1.text = "버튼 클릭 : ${time}"
		}
		handler2 = DisplayHandler()

		/**
		 * 이렇게 하면 MainThread 가 너무 바뻐서 화면을 그리지 못한다.
		 */
//		while (true) {
//			SystemClock.sleep(100)
//			var time = System.currentTimeMillis()
//			textView2.text = "while : ${time}"
//		}
//		handler = Handler()
//		var thread = ThreadClass()
//		handler?.post(thread)
		var thread2 = ThreadClass2()
		thread2.start()
	}

	inner class ThreadClass : Thread() {
		override fun run() {
			var time = System.currentTimeMillis()
			textView2.text = "Handler : ${time }"

			/**
			 * 자기 자신을 다시 호출
			 */
			handler?.post(this)
		}
	}

	inner class ThreadClass2 : Thread() {
		override fun run() {
			while(true) {
				var time = System.currentTimeMillis()
				textView2.text = "Handler : ${time}"

				/**
				 * 자기 자신을 다시 호출
				 */
				var msg = Message()
				msg.what = 0
				msg.obj = time
				handler2?.sendMessage(msg)
			}

		}
	}



	inner class DisplayHandler : Handler() {
		override fun handleMessage(msg: Message) {
			super.handleMessage(msg)
			if(msg.what == 0) {
				var time = System.currentTimeMillis()

				textView2.text = "Hanlder : ${msg.obj}"
			}
		}
	}
}

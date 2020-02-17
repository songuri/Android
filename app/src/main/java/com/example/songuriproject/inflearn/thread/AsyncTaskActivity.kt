package com.example.songuriproject.inflearn.thread

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.songuriproject.R
import kotlinx.android.synthetic.main.activity_async_task.*

class AsyncTaskActivity : AppCompatActivity() {
	/**
	 * AsyncTask
	 * 1. AsynkTask는 비 동기 처리를 위해 제공되는 클래스 이다.
	 * 2. 개발자가 발생 시키는 쓰래드와 핸들러의 조합으로 쓰래드 운영 중 화면 처리가 가능햇던 구조를 클래스로 제공하는 것이다.
	 */

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_async_task)

		btn_btn.setOnClickListener { view ->
			var time = System.currentTimeMillis()
			textView1.text = "버튼 클릭 : ${time}"
		}

		var sync = AsyncTaskClass()
		sync.execute(10,20)

	}

	/**
	 * 첫번째 인자는 doinBackground 메서드에 선언하는 가변인수 매개변수의 타입
	 * 두번째 인자는 onProgressUpdate 메서드에 선언하는    가변인수 매개변수의 타입
	 * 세번째 인자는 onPostExecute 메서드에 선언한는 가변인수 타입.
	 */
	inner class AsyncTaskClass : AsyncTask<Int, Long, String>() {

		/**
		 * onPreExecute: doInBackground 메서드가 호출되기 전에 호출되는 메서드. 최초 딱 한번 호출됨
		 * MainThread가 처리한다.
		 */
		override fun onPreExecute() {
			super.onPreExecute()
			textView2.text = "AsyncTask 가동"
		}


		/**
		 * 새로운 쓰레드가 생성되어 처리 된다.
		 */
		override fun doInBackground(vararg params: Int?): String {
			TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
		}
	}
}

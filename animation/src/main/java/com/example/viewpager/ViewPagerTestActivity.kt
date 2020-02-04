package com.example.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.animation.R
import com.example.viewpager.adapter.pagerAdapter
import kotlinx.android.synthetic.main.activity_vertical_view_pager_test.*

class ViewPagerTestActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_view_pager_test)
		initViewPager()
		initBtnListener()
	}

	/**
	 * 코틀린의 리스너 만들기 예!!!
	 */
	var movePageListener  = View.OnClickListener {
		val tag = it.tag
		viewpager.setCurrentItem(tag as Int)
	}

	/**
	 * 버튼 이벤트
	 */
	fun initBtnListener() {
		btn_first.tag = 0
		btn_first.setOnClickListener(movePageListener)

		btn_second.tag = 1
		btn_second.setOnClickListener(movePageListener)

		btn_third.tag = 2
		btn_third.setOnClickListener(movePageListener)
	}

	/**
	 * View Pager 셋팅
	 */
	fun initViewPager() {
		viewpager.adapter = pagerAdapter(supportFragmentManager)
		viewpager.setCurrentItem(0)
	}
}

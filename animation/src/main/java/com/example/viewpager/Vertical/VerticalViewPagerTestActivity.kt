package com.shinhan.yjandroid.viewpager.Vertical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.example.animation.R
import com.example.viewpager.adapter.ViewPagerScroller
import com.example.viewpager.adapter.pagerAdapter

import kotlinx.android.synthetic.main.activity_vertical_view_pager_test.*
import java.lang.reflect.Field

class VerticalViewPagerTestActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_vertical_view_pager_test)
		initViewPager()
		initBtnListener()
		changePagerScroller()
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

	/**
	 * 속도 조절
	 */
	fun changePagerScroller() {
		var mScroller : Field? = null
		mScroller = ViewPager::class.java!!.getDeclaredField("mScroller")
		if (mScroller != null) {
			mScroller.isAccessible = true
		}
		val scroller : ViewPagerScroller = ViewPagerScroller(viewpager.context)
		if (mScroller != null) {
			mScroller.set(viewpager, scroller)
		}


	}
}

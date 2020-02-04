package com.example.viewpager.adapter
import android.content.Context
import android.graphics.Interpolator
import android.widget.Scroller



/**
ViewPager 페이지 이동 애니메이션 속도 조절을 위한 클래스.
 */


class ViewPagerScroller : Scroller {


	private val mScrollDuration = 1000//  속도 조절...

	constructor(context: Context) : super(context) {}
	constructor(context: Context, interpolator: Interpolator) : super(context, interpolator as android.view.animation.Interpolator) {}

	override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int, duration: Int) {
		super.startScroll(startX, startY, dx, dy, mScrollDuration)
	}

	override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int) {
		super.startScroll(startX, startY, dx, dy, mScrollDuration)
	}


}
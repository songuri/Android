package com.example.listview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animation.R
import kotlinx.android.synthetic.main.activity_list_view_test_activitty.*

class ListViewTestActivitty : AppCompatActivity() {

	var list = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_list_view_test_activitty)

		val lm = LinearLayoutManager(this)
		val vm = GridLayoutManager(this, 4)
		/**
		 * lm , vm 에 따라서 리스트 뷰 모양이 달라짐.
		 */
		mRecyclerView.layoutManager = lm

		btn_falldown.setOnClickListener {
			runAnimation(1)
		}
		btn_bottom.setOnClickListener {
			runAnimation(2)
		}
		btn_right.setOnClickListener {
			runAnimation(3)
		}
	}


	fun runAnimation(type: Int) {
		mRecyclerView.visibility = View.VISIBLE
		var context: Context = mRecyclerView.context
		var controller: LayoutAnimationController? = null

		/**
		 * 어떠한 애니메이션 사용할지 결정.
		 */
		if (type == 1) {
			controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_fall_down)
		} else if (type == 2) {
			controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_slide_down)
		} else {
			controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_slide_right)
		}

		/**
		 * 이게 지림
		 */
		val mAdapter = MainRvAdapter(this, list) { i: Int, v: View ->
			Toast.makeText(this, i.toString(), Toast.LENGTH_SHORT).show()
			hideAnimation(v)
		}
		mRecyclerView.adapter = mAdapter
		mRecyclerView.layoutAnimation = controller
		mRecyclerView.adapter!!.notifyDataSetChanged()
		mRecyclerView.scheduleLayoutAnimation()

	}

	fun hideAnimation(v: View) {
//		var toX = tv_top_text.x;
//		var toY = tv_top_text.y;
//
//		var transanim :TranslateAnimation = TranslateAnimation(0.0F, toX, 0.0F, -100F)
//		transanim.duration = 300

		var anim: Animation = AnimationUtils.loadAnimation(this, R.anim.item_animation_hide_up)
		var anim2: Animation = AnimationUtils.loadAnimation(this, R.anim.item_animation_hide_up)
		anim2.setAnimationListener(object : Animation.AnimationListener {
			override fun onAnimationRepeat(p0: Animation?) {

			}

			override fun onAnimationEnd(p0: Animation?) {
				mRecyclerView.visibility = View.GONE

			}

			override fun onAnimationStart(p0: Animation?) {

			}

		})
		anim.setAnimationListener(object : Animation.AnimationListener {
			override fun onAnimationRepeat(p0: Animation?) {

			}

			override fun onAnimationEnd(p0: Animation?) {
				v.visibility = View.GONE
				mRecyclerView.startAnimation(anim2)

			}

			override fun onAnimationStart(p0: Animation?) {

			}

		})
		v.startAnimation(anim)

	}
}

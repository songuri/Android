package com.example.songuriproject.testpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import com.example.animation.XMLAnimation
import com.example.songuriproject.R
import kotlinx.android.synthetic.main.activity_animation_test.*

class AnimationTestActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_animation_test)
		setAnim()
	}

	fun setAnim() {
		var mXMLAnimation = XMLAnimation(this)
		var anim1: Animation = mXMLAnimation.getTranslateAnim()
		var anim2: Animation = mXMLAnimation.getScaleAnim()


		subtitle.startAnimation(anim1)
		headertitle.startAnimation(anim2)
	}
}

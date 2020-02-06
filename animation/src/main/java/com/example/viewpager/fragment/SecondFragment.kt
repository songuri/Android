package com.example.viewpager.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.example.animation.R



class SecondFragment : Fragment() {

	//TODO 생성자 어떻게 만들지 ....?

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		var layout : RelativeLayout  = inflater.inflate(R.layout.fragment_second, container, false) as RelativeLayout

		return layout
	}
}
package com.example.viewpager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.shinhan.yjandroid.viewpager.fragment.FirstFragment
import com.shinhan.yjandroid.viewpager.fragment.SecondFragment
import com.shinhan.yjandroid.viewpager.fragment.ThirdFragment


/**
 * View Pager 어뎁터
 */
class pagerAdapter : FragmentStatePagerAdapter {

	public constructor(manager: FragmentManager) : super(manager) {
	}

	override fun getItem(position: Int): Fragment {
		when(position) {
			0		-> {return FirstFragment()
			}
			1		-> {return SecondFragment()
			}
			2		-> {return ThirdFragment()
			}
		}
		return Fragment()
	}

	override fun getCount(): Int {
		return 3
	}

}
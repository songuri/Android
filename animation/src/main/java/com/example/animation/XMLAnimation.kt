package com.example.animation

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils

class XMLAnimation {
    var mContext : Context? = null

    constructor(context: Context) {
        mContext = context
    }

    fun getTranslateAnim() : Animation {
        return AnimationUtils.loadAnimation(mContext, R.anim.ttb)
    }
    fun getScaleAnim() : Animation {
        return AnimationUtils.loadAnimation(mContext, R.anim.stb)
    }
}
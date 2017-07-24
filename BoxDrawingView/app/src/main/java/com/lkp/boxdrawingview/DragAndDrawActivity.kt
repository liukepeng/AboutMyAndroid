package com.lkp.boxdrawingview

import android.support.v4.app.Fragment

/**
 * Created by Administrator on 2017/7/24.
 */
class DragAndDrawActivity : SingleFragmentActivity(){
    override fun createFragment(): Fragment {
        return DragAndDrawFragment.newInstance()
    }
}
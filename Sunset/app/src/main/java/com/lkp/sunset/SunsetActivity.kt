package com.lkp.sunset

import android.support.v4.app.Fragment

/**
 * Created by Administrator on 2017/7/24.
 */
class SunsetActivity : SingleFragmentActivity(){
    override fun createFragment(): Fragment {
        return SunsetFragment.newInstance();
    }

}
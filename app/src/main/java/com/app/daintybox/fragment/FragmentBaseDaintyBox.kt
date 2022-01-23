package com.app.daintybox.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.app.daintybox.activity.DaintyBoxBaseActivity
import com.app.daintybox.libs.UtilsDainty

open class FragmentBaseDaintyBox: Fragment() {
    var mActivity: DaintyBoxBaseActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = activity as DaintyBoxBaseActivity?
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        UtilsDainty.reset_click_time()
    }
}
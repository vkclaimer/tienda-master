package com.app.daintybox.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.daintybox.R

class ExplorarFragment: FragmentBaseDaintyBox() {
    companion object{
        val TAG: String = "EXPLORAR_FRAGMENT"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_explorar,container,false)
    }
}
package com.app.daintybox.activity

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.app.daintybox.R
import com.app.daintybox.libs.UtilsDainty

open class DaintyBoxBaseActivity : AppCompatActivity() {

    var backButtonActive = false
    var mActionBar: ActionBar? = null
    var mToolbar: Toolbar? = null

    val KEY_SAVED_BACK = "back_flag"

    open fun baseCreate(savedInstanceState: Bundle?) {
        UtilsDainty.reset_click_time()
        if (savedInstanceState != null) {
            backButtonActive =
                savedInstanceState.getBoolean(KEY_SAVED_BACK)
        } else {
            backButtonActive = false
        }
        init_views()
    }

    open fun init_views() {

        /** Toolbar acting like actionbar  */
        mToolbar = findViewById(R.id.toolbar_daintybox)
        if (mToolbar != null) {
            try {
                setSupportActionBar(mToolbar)
            } catch (t: Throwable) {
                /** WTF Samsung 4.2.2  */
            }

            //set_toolbar_color();
        }
    }

    open fun setActionbarTitle(title: String?) {
        val toolbar: Toolbar = findViewById(R.id.toolbar_daintybox)
        if (toolbar != null) {

            /** Le doy titulo al fragment  */
            val mTitle: TextView = toolbar.findViewById(R.id.toolbar_title)
            if (mTitle != null) {
                mTitle.text = title
                mTitle.visibility = TextView.VISIBLE
            }
            /** Quito el logo del fragment  */
            val mTitleLogo: ImageView = toolbar.findViewById(R.id.title_image)
            if (mTitleLogo != null) {
                mTitleLogo.visibility = ImageView.GONE
            }

        }
    }

    open fun offActionbarTitle() {
        val toolbar: Toolbar = findViewById(R.id.toolbar_daintybox)
        if (toolbar != null) {

            /** Quito el titulo  */
            val mTitle: TextView = toolbar.findViewById(R.id.toolbar_title)
            mTitle.visibility = TextView.GONE

            /** Muestro el logo  */
            val mTitleLogo: ImageView = toolbar.findViewById(R.id.title_image)
            if (mTitleLogo != null) {
                mTitleLogo.visibility = ImageView.VISIBLE
            }


        }
    }

    open fun alignTitleStart() {
        val toolbar: Toolbar = findViewById(R.id.toolbar_daintybox)
        if (toolbar != null) {
            val mTitle: TextView = toolbar.findViewById(R.id.toolbar_title)
            if (mTitle != null && mTitle.gravity != Gravity.START) {
                val params = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                params.weight = 1f
                params.leftMargin = 0
                mTitle.gravity = Gravity.START
                mTitle.gravity = Gravity.CENTER_VERTICAL
                mTitle.layoutParams = params
            }
        }
    }

    open fun activeDisplayBack() {
        mActionBar = supportActionBar
        if (mActionBar != null) {
            mActionBar!!.setHomeButtonEnabled(true)
            mActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
        val toolbar: Toolbar = findViewById(R.id.toolbar_daintybox)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    /**
     *
     * Mostrar el botón de back en el actionbar
     *
     */
    open fun shouldDisplayHomeUp() {
        backButtonActive = true
        mActionBar = supportActionBar
        if (mActionBar != null) {
            mActionBar!!.setHomeButtonEnabled(false)
            mActionBar!!.setHomeButtonEnabled(true)
            mActionBar!!.setDisplayHomeAsUpEnabled(false)
            mActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    }

    /**
     *
     * Back button enabled
     *
     */
    open fun backButtonEnabled() {
        val toolbar: Toolbar = findViewById(R.id.toolbar_daintybox)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    open fun offBackButton() {
        backButtonActive = false
        mActionBar = supportActionBar
        if (mActionBar != null) {
            mActionBar!!.setHomeButtonEnabled(true)
            mActionBar!!.setHomeButtonEnabled(false)
            mActionBar!!.setDisplayHomeAsUpEnabled(true)
            mActionBar!!.setDisplayHomeAsUpEnabled(false)
        }
    }


}
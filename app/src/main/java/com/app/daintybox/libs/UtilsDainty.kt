package com.app.daintybox.libs

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.os.SystemClock
import androidx.appcompat.app.AlertDialog
import java.lang.IllegalArgumentException

open class UtilsDainty {


    companion object {
        var progressDialog: ProgressDialog? = null
        private var mLastClickTime: Long = 0
        var progressDialogDg: ProgressDialog? = null

        fun isFirstClick(): Boolean {
            val flag_click: Boolean

            // mis-clicking prevention, using threshold of 1000 ms
            flag_click = SystemClock.elapsedRealtime() - mLastClickTime >= 1000
            mLastClickTime = SystemClock.elapsedRealtime()
            return flag_click
        }

        fun reset_click_time() {
            mLastClickTime = 0
        }

        /**
         *
         * Mostrar un loading
         *
         * @param activity actividad actual
         * @param msg mensaje que ira en el loading
         */
        fun show_loading_dialog(activity: Activity?, msg: String?) {

            // Oculto cualquier otro loading que haya
            progressDialog?.dismiss()

            progressDialog = ProgressDialog(activity)
            progressDialog!!.setMessage(msg)
            progressDialog!!.setCancelable(false)
            progressDialog!!.show()
        }

        fun hide_loading_dialog() {
            if (progressDialog != null) {
                try {
                    progressDialog!!.dismiss()
                } catch (e: IllegalArgumentException) {
                    //Crashlytics.logException(e);
                }
            }
        }


        fun show_accept_msg(
            context: Context?,
            msg: String?,
            callbackOK: DialogInterface.OnClickListener?
        ) {
            AlertDialog.Builder(context!!).setMessage(msg).setPositiveButton("Aceptar", callbackOK)
                .show()
        }

        fun show_accept_msg(context: Context?, msg: String?) {
            AlertDialog.Builder(context!!).setMessage(msg).setPositiveButton("Aceptar", null).show()
        }


    }
}
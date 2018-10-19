package com.lifecycle.ca

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    private val ON_CREATE = "onCreate"
    private val ON_START = "onStart"
    private val ON_RESUME = "onResume"
    private val ON_PAUSE = "onPause"
    private val ON_STOP = "onStop"
    private val ON_RESTART = "onRestart"
    private val ON_DESTROY = "onDestroy"
    private val ON_SAVE_INSTANCE_STATE = "onSaveInstanceState"
    private val LIFECYCLE_CALLBACKS_TEXT_KEY = "callbacks"

    //private val mLifecycleDisplay: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(LIFECYCLE_CALLBACKS_TEXT_KEY)) {
                val allPreviousLifecycleCallbacks = savedInstanceState
                    .getString(LIFECYCLE_CALLBACKS_TEXT_KEY)
                mLifecycleDisplay!!.setText(allPreviousLifecycleCallbacks)
            }
        }

        logAndAppend(ON_CREATE)
    }


    override fun onStart() {
        super.onStart()

        logAndAppend(ON_START)
    }


    override fun onResume() {
        super.onResume()

        logAndAppend(ON_RESUME)
    }


    override fun onPause() {
        super.onPause()

        logAndAppend(ON_PAUSE)
    }


    override fun onStop() {
        super.onStop()

        logAndAppend(ON_STOP)
    }


    override fun onRestart() {
        super.onRestart()

        logAndAppend(ON_RESTART)
    }


    override fun onDestroy() {
        super.onDestroy()

        logAndAppend(ON_DESTROY)
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        logAndAppend(ON_SAVE_INSTANCE_STATE)
        val lifecycleDisplayTextViewContents = mLifecycleDisplay!!.getText().toString()
        outState.putString(LIFECYCLE_CALLBACKS_TEXT_KEY, lifecycleDisplayTextViewContents)
    }


    private fun logAndAppend(lifecycleEvent: String) {
        Log.d(TAG, "Lifecycle Event: $lifecycleEvent")

        mLifecycleDisplay!!.append(lifecycleEvent + "\n")
    }


    private fun resetLifecycleDisplay(view: View) {
        mLifecycleDisplay!!.setText("Lifecycle callbacks:\n")
    }
}

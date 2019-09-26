package com.example.jetpack_component.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MainActivityLifeCycle : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onCreateCall() {
        Log.e("TAG: activity","Hiiii i am on pause")
    }
}
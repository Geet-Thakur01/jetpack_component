package com.example.jetpack_component

import android.content.Context
import android.widget.Toast

open class EventHandlers(val ctx:Context) {

    fun onButtonClick(){
        (ctx as MainActivity).setUpdateData("update data")
        Toast.makeText(ctx,"click",Toast.LENGTH_LONG).show()
    }

}
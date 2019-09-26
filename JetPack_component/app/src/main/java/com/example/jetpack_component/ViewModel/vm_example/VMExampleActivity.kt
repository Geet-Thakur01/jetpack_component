package com.example.jetpack_component.ViewModel.vm_example

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.jetpack_component.R
import kotlinx.android.synthetic.main.activity_vmexample.*

class VMExampleActivity : AppCompatActivity() {
    private lateinit var vm_modal: MyVM
    private lateinit var vmbiding: com.example.jetpack_component.databinding.ActivityVmexampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.activity_vmexample)
        vmbiding = DataBindingUtil.setContentView(this, R.layout.activity_vmexample)

        vm_modal = ViewModelProviders.of(this).get(MyVM::class.java)
        vm_modal.getProduct().observe(this, Observer {
            tv_data.text = it.productName
        })

        Toast.makeText(this, "hi", Toast.LENGTH_LONG).show()
    }

    fun onFatchClick(view: View) {
        vm_modal.generateRandomData()
    }

}

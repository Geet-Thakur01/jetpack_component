package com.example.jetpack_component

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.jetpack_component.ViewModel.DataGenerator
import com.example.jetpack_component.ViewModel.vm_example.VMExampleActivity
import com.example.jetpack_component.lifecycle.MainActivityLifeCycle
import com.example.jetpack_component.work_manager.WorkManagerExample
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var binding: com.example.jetpack_component.databinding.ActivityMainBinding
    private lateinit var dataGenerator: DataGenerator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        lifecycle.addObserver(MainActivityLifeCycle())

        dataGenerator = ViewModelProviders.of(this).get(DataGenerator::class.java)

        val mrandomNo = dataGenerator.getNumber()
        mrandomNo.observe(this, Observer { randon_tv.text = it })

        val product = dataGenerator.getProduct()
        product.observe(this, Observer {
            binding.product = it
        })
//        binding.product = dataGenerator.getProduct().value


        binding.eventhandler = EventHandlers(this)
        randon_tv.text = dataGenerator.getNumber().value
    }

    fun setUpdateData(msg: String) {
        binding.name.text = msg
        dataGenerator.createRandomNumber()
    }

    fun setRandomNo() {
        randon_tv.text = dataGenerator.getNumber().value
    }

    fun navigationClick(view: View) {
        startActivity(Intent(this, VMExampleActivity::class.java))
    }

    fun onWorkManagerClick(view: View) {
        startActivity(Intent(this, WorkManagerExample::class.java))
    }

}

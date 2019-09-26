package com.example.jetpack_component.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpack_component.Product
import java.util.*

class DataGenerator : ViewModel() {
    private lateinit var number: MutableLiveData<String>
    private lateinit var product_data: MutableLiveData<Product>
    fun getNumber(): MutableLiveData<String> {
        if (!::number.isInitialized) {
            number = MutableLiveData()
            createRandomNumber()
        }
        return number
    }

    fun getProduct(): MutableLiveData<Product> {
        if (!::product_data.isInitialized) {
            product_data = MutableLiveData()
            product_data.value = Product(
                "mobile",
                "It’s been a month since I joined Annyce in migrating our codebase away from Java to Kotlin. Every time she sent a PR"
            )
        }

        return product_data
    }


    fun createRandomNumber() {
        number.value = "Number is " + (Random().nextInt(10 - 1) + 1)
        if (::product_data.isInitialized) {
            product_data.value!!.productName = "update ${number.value}"
        }
    }

    override fun onCleared() {
        super.onCleared() //method using for clear all View model when activity destroyed.
    }
}
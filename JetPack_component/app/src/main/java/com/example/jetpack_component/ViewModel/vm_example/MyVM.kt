package com.example.jetpack_component.ViewModel.vm_example


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpack_component.Product

class MyVM : ViewModel() {
    private var count: Int = 0
    private lateinit var productData: MutableLiveData<Product>


    fun getProduct(): MutableLiveData<Product> {
        if (!::productData.isInitialized) {
            loaduser()
        }
        return productData
    }

    private fun loaduser() {
        productData = MutableLiveData()
        productData.value = Product(
            "mobile",
            "It’s been a month since I joined Annyce in migrating our codebase away from Java to Kotlin. Every time she sent a PR"
        )
    }

    fun generateRandomData() {
        productData.value?.apply {
            productName = "New Value ${count++}"
        }?.notifyObservers()
    }
}
package com.example.jetpack_component

import java.util.*

class Product(var productName: String, val shortDescription: String) : Observable() {

    constructor(
        productId: String, productName: String, shortDescription: String, longDescription: String,
        price: String, productImage: String, reviewRating: Int, reviewCount: String, inStock: Boolean
    ) : this(productName, shortDescription)

}

package com.example.jetpack_component

import androidx.paging.PageKeyedDataSource

class ProductDataSource: PageKeyedDataSource<Long, Product>() {
    override fun loadInitial(params: LoadInitialParams<Long>, callback: LoadInitialCallback<Long, Product>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, Product>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, Product>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
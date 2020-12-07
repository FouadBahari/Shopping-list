package com.fouadbahari.shippinglistapp.database.repositories

import com.fouadbahari.shippinglistapp.database.db.ShoppingDatabase
import com.fouadbahari.shippinglistapp.database.db.entities.ShoppingItem

class ShoppingRepository(
    private val db : ShoppingDatabase
){
    suspend fun upsert(item:ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item:ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()

}
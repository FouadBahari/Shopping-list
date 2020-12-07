package com.fouadbahari.shippinglistapp.ui.shippingList

import androidx.lifecycle.ViewModel
import com.fouadbahari.shippinglistapp.database.db.entities.ShoppingItem
import com.fouadbahari.shippinglistapp.database.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingListViewModel(
    private val repository: ShoppingRepository
):ViewModel() {
    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()

}
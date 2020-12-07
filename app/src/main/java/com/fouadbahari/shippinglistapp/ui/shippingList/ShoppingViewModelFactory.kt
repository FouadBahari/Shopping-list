package com.fouadbahari.shippinglistapp.ui.shippingList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fouadbahari.shippinglistapp.database.repositories.ShoppingRepository

@Suppress("UNCHECKED_CAST")
class ShoppingViewModelFactory(
    private val repository: ShoppingRepository
):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingListViewModel(repository) as T
    }
}
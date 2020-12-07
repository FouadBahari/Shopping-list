package com.fouadbahari.shippinglistapp.ui.shippingList

import com.fouadbahari.shippinglistapp.database.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)

}
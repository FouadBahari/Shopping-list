package com.fouadbahari.shippinglistapp.ui.shippingList

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.fouadbahari.shippinglistapp.R
import com.fouadbahari.shippinglistapp.database.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_item.*

class AddShoppingItemDialog(context: Context,var addDialogListener: AddDialogListener) :AppCompatDialog(context){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_item)
        tvAdd.setOnClickListener {
            val name = edtName.text.toString()
            val amount = edtAmount.text.toString()

            if (name.isEmpty() && amount.isEmpty()){
                Toast.makeText(context, "Please enter all the informations", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item =ShoppingItem(name,amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        tvCancel.setOnClickListener {
            cancel()
        }
    }
}
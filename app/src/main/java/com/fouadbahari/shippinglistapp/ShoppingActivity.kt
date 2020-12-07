package com.fouadbahari.shippinglistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.fouadbahari.shippinglistapp.database.db.ShoppingDatabase
import com.fouadbahari.shippinglistapp.database.db.entities.ShoppingItem
import com.fouadbahari.shippinglistapp.database.repositories.ShoppingRepository
import com.fouadbahari.shippinglistapp.other.ShoppingListAdapder
import com.fouadbahari.shippinglistapp.ui.shippingList.AddDialogListener
import com.fouadbahari.shippinglistapp.ui.shippingList.AddShoppingItemDialog
import com.fouadbahari.shippinglistapp.ui.shippingList.ShoppingListViewModel
import com.fouadbahari.shippinglistapp.ui.shippingList.ShoppingViewModelFactory
import kotlinx.android.synthetic.main.activity_shopping.*
import org.kodein.di.android.kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class ShoppingActivity : AppCompatActivity(),KodeinAware {

    override val kodein by kodein()
    private val factory : ShoppingViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val viewModel = ViewModelProvider(this,factory).get(ShoppingListViewModel::class.java)
        val adapder = ShoppingListAdapder(listOf(),viewModel)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapder
        viewModel.getAllShoppingItems().observe(this, Observer {
            adapder.items = it
            adapder.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddShoppingItemDialog(this,object: AddDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }

            }).show()
        }
    }

}
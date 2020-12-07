package com.fouadbahari.shippinglistapp.other

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fouadbahari.shippinglistapp.R
import com.fouadbahari.shippinglistapp.database.db.entities.ShoppingItem
import com.fouadbahari.shippinglistapp.ui.shippingList.ShoppingListViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingListAdapder(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingListViewModel
) : RecyclerView.Adapter<ShoppingListAdapder.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShoppingListAdapder.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingListAdapder.MyViewHolder, position: Int) {
        val currentShoppingItem = items.get(position)
        holder.itemView.tvName.text = currentShoppingItem.name
        holder.itemView.tvAmount.text = currentShoppingItem.amount.toString()

        holder.itemView.imgDelete.setOnClickListener {
            viewModel.delete(currentShoppingItem)
            notifyItemRemoved(position)
        }

        holder.itemView.imgMinus.setOnClickListener {
            if (currentShoppingItem.amount > 0){
                currentShoppingItem.amount--
                viewModel.upsert(currentShoppingItem)
            }

        }

        holder.itemView.imgPlus.setOnClickListener {

            currentShoppingItem.amount++
            viewModel.upsert(currentShoppingItem)

        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}
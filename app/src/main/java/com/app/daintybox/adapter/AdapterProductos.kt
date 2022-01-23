package com.app.daintybox.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.daintybox.R
import com.bumptech.glide.Glide
import com.google.firebase.firestore.QueryDocumentSnapshot

class AdapterProductos(context: Context?, data: ArrayList<QueryDocumentSnapshot>?) : RecyclerView.Adapter<AdapterProductos.ViewHolder>(){

    var data: ArrayList<QueryDocumentSnapshot>? = null
    private var inflater: LayoutInflater? = null
    var context: Context? = null

    init {
        this.context = context
        inflater = LayoutInflater.from(context)
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = inflater!!.inflate(R.layout.layout_item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {
        var producto: QueryDocumentSnapshot = data!![position]

        holder.tw_product_name.text = producto.data["name"].toString()

        val images: ArrayList<String> = producto.data["images"] as ArrayList<String>

        if(images.size>0) {

            Glide
                .with(this.context!!)
                .load(images[0])
                .into(holder.iw_product)

        }

    }

    override fun getItemCount(): Int {
        return data!!.size
    }

    class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iw_product: ImageView
        var tw_product_name: TextView

        init {
            iw_product = itemView.findViewById(R.id.iw_product)
            tw_product_name = itemView.findViewById(R.id.tw_product_name)
        }
    }
}
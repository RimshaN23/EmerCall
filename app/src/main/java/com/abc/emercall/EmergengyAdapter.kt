package com.abc.emercall

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class EmergengyAdapter(val model_list: List<model>, val context: Context) :RecyclerView.Adapter<EmergengyAdapter.EmerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmerViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.itemview_list,parent,false);
        return EmerViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: EmerViewHolder, position: Int) {
        val item= model_list[position]
        holder.imageview.setImageResource(item.image)
        holder.name.text= item.name
        holder.num.text= item.number.toString()

        holder.card.setOnClickListener {


            val intent= Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:" +item.number.toString())
            context.startActivity(intent)

        }

    }

    override fun getItemCount()= model_list.size

    class EmerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imageview: ImageView= itemView.findViewById(R.id.imageview)
        val name: TextView = itemView.findViewById(R.id.emerName)
        val num: TextView = itemView.findViewById(R.id.emerNum)
        val card: CardView = itemView.findViewById(R.id.cardview)
    }
}
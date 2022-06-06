@file:Suppress("LiftReturnOrAssignment")

package com.binar.latihanchapter8.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binar.latihanchapter8.R
import com.binar.latihanchapter8.room.Notes
import kotlinx.android.synthetic.main.item_note_adapter.view.*

class RvAdapter(private var onClick : (Notes)->Unit) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    private var dataBuku : List<Notes>? = null

    fun setDataFilm(buku : List<Notes>){
        this.dataBuku = buku
    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context).inflate(R.layout.item_note_adapter, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.judulNote.text = dataBuku!![position].title
        holder.itemView.tanggalNote.text = dataBuku!![position].date



        holder.itemView.cardFilm.setOnClickListener{
            onClick(dataBuku!![position])
        }

    }

    override fun getItemCount(): Int {
        if (dataBuku == null){
            return 0
        }else{
            return dataBuku!!.size

        }
    }
}
package github.areebmalik1989.leafnotes.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import github.areebmalik1989.core.domain.LeafNote
import github.areebmalik1989.leafnotes.R
import kotlinx.android.synthetic.main.list_item.view.*
import java.util.ArrayList

class NoteAdapter(val noteList: ArrayList<LeafNote>) : RecyclerView.Adapter<NoteAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemTitle.text = noteList[position].title
        holder.itemId.text = noteList[position].id.id.toString()
    }

    class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val itemTitle = itemView.item_title
        val itemId = itemView.item_id
    }

}
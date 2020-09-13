package com.example.firstkotlinexample.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.firstkotlinexample.R
import com.example.firstkotlinexample.data.model.Color
import com.example.firstkotlinexample.data.model.Note
import kotlinx.android.synthetic.main.item_note.view.*

class MainAdapter(private val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<MainAdapter.NoteViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(note: Note)
    }

    var noteList: List<Note> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(note: Note) {
            val color = when (note.color) {
                Color.WHITE -> R.color.white
                Color.VIOLET -> R.color.violet
                Color.YELLOW -> R.color.yellow
                Color.RED -> R.color.red
                Color.GREEN -> R.color.green
                Color.BLUE -> R.color.blue
            }
            with(itemView) {
                title.text = note.title
                body.text = note.text
                itemView.setBackgroundColor(ContextCompat.getColor(context, color))
                itemView.setOnClickListener { onItemClickListener.onItemClick(note) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount() = noteList.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) =
        holder.bind(noteList[position])
}


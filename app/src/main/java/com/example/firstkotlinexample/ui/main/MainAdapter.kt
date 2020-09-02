package com.example.firstkotlinexample.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstkotlinexample.R
import com.example.firstkotlinexample.data.model.Note
import kotlinx.android.synthetic.main.item_note.view.*

class MainAdapter : RecyclerView.Adapter<NoteViewHolder>() {

    var noteList: List<Note> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
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

class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(note: Note) {
        with(itemView) {
            title.text = note.title
            body.text = note.note
            itemView.setBackgroundColor(note.color)
        }
    }
}
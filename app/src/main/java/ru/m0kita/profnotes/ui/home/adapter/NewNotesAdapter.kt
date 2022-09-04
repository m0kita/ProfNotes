package ru.m0kita.profnotes.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.m0kita.profnotes.R
import ru.m0kita.profnotes.databinding.ItemNewNoteBinding
import ru.m0kita.profnotes.model.NewNote
import ru.m0kita.profnotes.ui.home.HomeFragment

class NewNotesAdapter(private val newNotes: List<NewNote>, private val context: Context): RecyclerView.Adapter<NewNotesAdapter.NotesViewHolder>() {
    
    class NotesViewHolder(val binding: ItemNewNoteBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder
    = NotesViewHolder(
        ItemNewNoteBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        Glide.with(context).load(newNotes[position].avatar).into(holder.binding.civUserAvatar)
        holder.binding.tvDate.text = newNotes[position].date
        holder.binding.tvNoteName.text = newNotes[position].name
        holder.binding.tvDescription.text = newNotes[position].description
        holder.binding.rvUsersAvatars.adapter = NewNotesAvatarsAdapter(newNotes[position].usersAvatars, context)
    }

    override fun getItemCount(): Int = newNotes.size
}
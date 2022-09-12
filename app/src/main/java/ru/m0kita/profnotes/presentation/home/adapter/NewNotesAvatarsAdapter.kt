package ru.m0kita.profnotes.presentation.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.m0kita.profnotes.databinding.ItemAvatarBinding

class NewNotesAvatarsAdapter(private val usersAvatars: List<String>, private val context: Context) :
    RecyclerView.Adapter<NewNotesAvatarsAdapter.NewNotesAvatarsViewHolder>() {
    class NewNotesAvatarsViewHolder(val binding: ItemAvatarBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewNotesAvatarsViewHolder =
        NewNotesAvatarsViewHolder(
            ItemAvatarBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: NewNotesAvatarsViewHolder, position: Int) {
        Glide.with(context).load(usersAvatars[position]).into(holder.binding.civAvatar)
    }

    override fun getItemCount(): Int = usersAvatars.size
}
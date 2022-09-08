package ru.m0kita.profnotes.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import ru.m0kita.profnotes.R
import ru.m0kita.profnotes.databinding.ItemMyTaskBinding
import ru.m0kita.profnotes.model.Note

class MyTasksAdapter(
    private val tasks: List<Note>,
    private val context: Context,
    private val fragment: Fragment
) :
    RecyclerView.Adapter<MyTasksAdapter.MyTasksViewHolder>() {

    class MyTasksViewHolder(val binding: ItemMyTaskBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyTasksAdapter.MyTasksViewHolder =
        MyTasksAdapter.MyTasksViewHolder(
            ItemMyTaskBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MyTasksAdapter.MyTasksViewHolder, position: Int) {
        holder.binding.apply {
            tvSwapStatus.setOnClickListener {
                fragment.findNavController().navigate(R.id.action_homeFragment_to_statusFragment)

            }
            tvNameNote.text = tasks[position].name
            tvDescription.text = tasks[position].description
            tvStatus.text = tasks[position].status.statusName
            tvStatus.setTextColor(context.getColor(tasks[position].status.color))
            viewStatusLine.background = context.getDrawable(tasks[position].status.color)
        }

    }

    override fun getItemCount(): Int = tasks.size
}
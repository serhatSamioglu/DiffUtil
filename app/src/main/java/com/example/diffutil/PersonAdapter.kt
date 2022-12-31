package com.example.diffutil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutil.databinding.ItemPersonBinding

class PersonAdapter: RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    inner class PersonViewHolder(private val binding: ItemPersonBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindItem(person: Person) {
            binding.apply {
                textViewID.text = person.id.toString()
                textViewName.text = person.name
            }
        }
    }

    private val differCallback = object: DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val binding = ItemPersonBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        return PersonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bindItem(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    /*private var onItemClickListener: ((Person) -> Unit)? = null

    fun setOnItemClickListener(listener: (Person) -> Unit) {
        onItemClickListener = listener
    }*/
}
package com.example.diffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutil.databinding.ActivityPersonListBinding

class PersonListActivity : AppCompatActivity() {

    lateinit var binding: ActivityPersonListBinding
    private val personAdapter by lazy { PersonAdapter() }
    private val personList: MutableList<Person> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        personAdapter.differ.submitList(loadData())

        binding.recyclerViewPerson.apply {
            layoutManager = LinearLayoutManager(this@PersonListActivity)
            adapter = personAdapter
        }

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean { return false }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val deletedPerson = personList[viewHolder.adapterPosition]
                Log.d("testperson", deletedPerson.toString())

                personList.removeAt(viewHolder.adapterPosition)
                personAdapter.notifyItemRemoved(viewHolder.adapterPosition)

            }
        }).attachToRecyclerView(binding.recyclerViewPerson)
    }

    private fun loadData(): MutableList<Person> {
        personList.add(Person(1, "Person 1"))
        personList.add(Person(2, "Person 2"))
        personList.add(Person(3, "Person 3"))
        personList.add(Person(4, "Person 4"))
        personList.add(Person(5, "Person 5"))
        personList.add(Person(6, "Person 6"))
        personList.add(Person(7, "Person 7"))
        personList.add(Person(8, "Person 8"))
        personList.add(Person(9, "Person 9"))
        personList.add(Person(10, "Person 10"))
        personList.add(Person(11, "Person 11"))
        personList.add(Person(12, "Person 12"))
        personList.add(Person(13, "Person 13"))
        personList.add(Person(14, "Person 14"))
        personList.add(Person(15, "Person 15"))
        personList.add(Person(16, "Person 16"))
        personList.add(Person(17, "Person 17"))
        personList.add(Person(18, "Person 18"))
        personList.add(Person(19, "Person 19"))
        personList.add(Person(20, "Person 20"))

        return personList
    }
}
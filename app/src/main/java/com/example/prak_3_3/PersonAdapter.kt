package com.example.prak_3_3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prak_3_3.databinding.PersonLayoutBinding

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.PersonHolder>() {
    var personList: ArrayList<Person> = arrayListOf(
        Person("Тереньтьев Павел", "+7(124)137-10-00", true),

    )

    class PersonHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = PersonLayoutBinding.bind(item)
        fun bind(person: Person) {
            binding.personName.text = person.name
            binding.personPhoneNumber.text = person.phoneNumber
            val num = when (person.sex) {
                true -> R.drawable.man
                false -> R.drawable.woman
                else -> R.drawable.unknow
            }
            binding.personSexPicture.setImageResource(num)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.person_layout, parent, false)
        return PersonHolder(view)
    }

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        holder.bind(personList[position])
    }

    override fun getItemCount(): Int {
        return personList.size
    }
}
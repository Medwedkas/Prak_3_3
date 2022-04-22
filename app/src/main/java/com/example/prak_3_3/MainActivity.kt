package com.example.prak_3_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prak_3_3.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = PersonAdapter() // создаем экземпляр класса адаптера
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.sortByName.setOnClickListener {
            adapter.personList.sortBy { it.name }
            binding.recView.adapter = adapter
        }
        binding.sortImage.setOnClickListener {
            adapter.personList.sortBy { it.sex }
            binding.recView.adapter = adapter
        }
        binding.sortByPhone.setOnClickListener {
            adapter.personList.sortBy { it.phoneNumber }
            binding.recView.adapter = adapter
        }
        init()
    }

    private fun init() { // функция инициализации адаптера
        val fileName = "person.json"
        val jsonString = application.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
        val listType = object : TypeToken<ArrayList<Person?>?>() {}.type
        val users: ArrayList<Person> = Gson().fromJson(jsonString, listType)

        binding.recView.layoutManager =
            LinearLayoutManager(this@MainActivity) //указываем как у нас будет показываться список
        binding.recView.adapter = adapter //инициализируем адаптер для RecycleView в activity_main
        adapter.personList = users
    }
}
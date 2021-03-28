package com.example.interactivelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val adapter by lazy { Adapter() }

    private val bAdd by lazy { findViewById<Button>(R.id.bAdd) }
    private val etNewElement by lazy { findViewById<EditText>(R.id.etNewElement) }
    private val rvList by lazy { findViewById<RecyclerView>(R.id.rvList) }

    private val list = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    private fun initUI() {
        rvList.adapter = adapter

        bAdd.setOnClickListener {
            list.add(etNewElement.text.toString())

            adapter.submitList(list)
            adapter.notifyDataSetChanged()
        }
    }
}

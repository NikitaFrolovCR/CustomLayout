package com.example.nikita.customlayout

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner.adapter = ArrayAdapter.createFromResource(this, R.array.count_image, android.R.layout.simple_spinner_item).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        spinner.onItemSelectedListener = this
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        Toast.makeText(this, getString(R.string.nothing_choose), Toast.LENGTH_SHORT).show()
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        collageMaker.removeAllViews()
        for (i in 0 until position + 1) {
            collageMaker.addView(ImageView(this).apply { setImageResource(R.mipmap.ic_launcher_round) })
        }
    }
}

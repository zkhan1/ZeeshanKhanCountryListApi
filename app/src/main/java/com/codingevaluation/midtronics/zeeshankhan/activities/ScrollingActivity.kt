package com.codingevaluation.midtronics.zeeshankhan

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.codingevaluation.midtronics.zeeshankhan.databinding.ActivityScrollingBinding
import android.widget.*
import com.codingevaluation.midtronics.zeeshankhan.activities.CountriesList


class ScrollingActivity : AppCompatActivity() {

    private val TAG = "ScrollingActivity"
    private lateinit var binding: ActivityScrollingBinding

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar
        ))
        binding.toolbarLayout.title = title

        val imageView = ImageView(this)
        imageView.setImageResource(R.drawable.zk)


        val btn1 = findViewById<Button>(R.id.btn1)
        btn1.setOnClickListener {
            val intent = Intent(this, CountriesList::class.java)
            startActivity(intent)
        }



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

private fun Button.setOnClickListener() {
}

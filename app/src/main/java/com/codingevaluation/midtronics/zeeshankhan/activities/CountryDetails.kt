package com.codingevaluation.midtronics.zeeshankhan.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codingevaluation.midtronics.zeeshankhan.R
import com.codingevaluation.midtronics.zeeshankhan.model.CountryItemDetails
import com.codingevaluation.midtronics.zeeshankhan.model.ItemViewModel

class CountryDetails : AppCompatActivity() {

    var name: String? = null
    var area: String? = null
    var capital: String? = null
    var population: String? = null
    var region: String? = null
    var subRegion: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_detail)

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            name = bundle.getString("name")
            capital = bundle.getString("capital")
            area = bundle.getString("area")
            population = bundle.getString("population")
            region = bundle.getString("region")
            subRegion = bundle.getString("subRegion")
        }

        // getting the recyclerview by its id
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_main)

        // this creates a vertical layout Manager
        recyclerView.layoutManager = LinearLayoutManager(this)

        val data = ItemViewModel(name, area, capital, population, region, subRegion)

        // This will pass the ArrayList to our Adapter
        val adapter = MainAdapter(data)
        // Setting the Adapter with the recyclerview
        recyclerView.adapter = adapter
    }
}
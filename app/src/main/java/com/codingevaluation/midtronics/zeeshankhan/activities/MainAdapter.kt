package com.codingevaluation.midtronics.zeeshankhan.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codingevaluation.midtronics.zeeshankhan.R
import com.codingevaluation.midtronics.zeeshankhan.model.ItemViewModel

class MainAdapter(private val mList: ItemViewModel): RecyclerView.Adapter<CustomViewHolder>() {

    // number of items
    override fun getItemCount(): Int {
        return 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        // inflates the countrydetail_row view that is used to hold this item
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.countrydetail_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        // bind the data to the view
        holder?.view.findViewById<TextView>(R.id.txtViewName).text = mList.name
        holder?.view.findViewById<TextView>(R.id.txtViewCapital).text = mList.capital
        holder?.view.findViewById<TextView>(R.id.txtViewArea).text = mList.area
        holder?.view.findViewById<TextView>(R.id.txtViewPopulation).text = mList.population
        holder?.view.findViewById<TextView>(R.id.txtViewRegion).text = mList.region
        holder?.view.findViewById<TextView>(R.id.txtViewSubRegion).text = mList.subregion
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {}
package com.codingevaluation.midtronics.zeeshankhan.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.ArrayAdapter
import androidx.annotation.RequiresApi
import com.codingevaluation.midtronics.zeeshankhan.R
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONTokener
import java.io.IOException


class CountriesList : AppCompatActivity() {

    private val TAG = "CountriesList"
    private val BASE_URL = "https://restcountries.com/v3.1/name/"
    var name: String? = ""
    var area: String? = ""
    var capital: String? = ""
    var population: String? = ""
    var region: String? = ""
    var subRegion: String? = ""

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries_list)

        // use array adapter and define an array
        val arrayAdapter: ArrayAdapter<*>

        // access the listView from xml file
        val countriesListView = findViewById<ListView>(R.id.cListView)

        val countries = resources.getStringArray(R.array.countries_array)

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countries)
        countriesListView.adapter = arrayAdapter

        countriesListView.setOnItemClickListener { parent, view, position, id ->
            var element = parent.getItemAtPosition(position) as String
            var countryDetails = getCountryDetails(element)
            val jsonArray = JSONTokener(countryDetails).nextValue() as JSONArray
            for (i in 0 until jsonArray.length()) {
                name = jsonArray.getJSONObject(i).getString("name").substringAfter(":")
                    .substringBefore(",").substring(1)
                name = name!!.substring(0, name!!.length - 1)
                try {
                    area = jsonArray.getJSONObject(i).getString("area")
                    capital = jsonArray.getJSONObject(i).getString("capital").substring(2)
                    capital = capital!!.substring(0, capital!!.length - 2)
                    population = jsonArray.getJSONObject(i).getString("population")
                    region = jsonArray.getJSONObject(i).getString("region")
                    subRegion = jsonArray.getJSONObject(i).getString("subregion")
                } catch (e: Exception) {
                    Log.i(TAG, "onCreate: ${e.localizedMessage}")
                    capital = "No data found"
                    area = "No data found"
                    population = "No data found"
                    region = "No data found"
                    subRegion = "No data found"
                }

            }

            val bundle = Bundle()
            bundle.putString("name", name)
            bundle.putString("capital", capital)
            bundle.putString("area", area)
            bundle.putString("population", population)
            bundle.putString("region", region)
            bundle.putString("subRegion", subRegion)

            val intent = Intent(this, CountryDetails::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    private fun getCountryDetails(element: String): String {
        // URL request using a 3rd party library e.g. Retrofit/OkHttp, etc. (Sqaure.github.io/okhttp)
        val url = "$BASE_URL$element/"
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        var body = ""

        // can't use Request.execute because android doesn't allow "execute" on a main thread
        // this is why we would need to use enqueue
        client.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                if (response.isSuccessful) {
                    body = response.body!!.string()
                }
            }

            override fun onFailure(call: okhttp3.Call, e: IOException) {
                println("Failed to execute request: ${e.localizedMessage}")
            }
        })

        if (body == "") { // want to make sure I receive the data before UI update

            Thread.sleep(1_000)  // wait for 1 second
        }
        return body
    }

}





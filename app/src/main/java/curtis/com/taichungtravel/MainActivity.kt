package curtis.com.taichungtravel

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.coroutineScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import curtis.com.taichungtravel.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

import curtis.com.taichungtravel.data.DataTourist
import curtis.com.taichungtravel.api.ApiConnector
import curtis.com.taichungtravel.api.InterfaceApiConnector

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    companion object{
        lateinit var buttonLanguage : Button
        lateinit var spinnerFlower : Spinner
        lateinit var flowerType : ArrayList<String>
    }
    //lateinit var spinnerFlower : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SetInitialInterface()
        SetInitialData()
    }

    private fun SetInitialInterface() {

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_flower, R.id.navigation_tour
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        supportActionBar?.hide() //hide top action bar

        buttonLanguage = findViewById<Button>(R.id.button_language)
        spinnerFlower = findViewById<Spinner>(R.id.spinner_flower_search)


        flowerType = arrayListOf("ALL", "落羽松", "櫻花", "鬱金香", "荷花", "百合花", "向日葵", "波斯菊", "玻斯菊", "梅花", "桐花", "楓葉", "木棉花", "阿勃勒", "鳳凰花", "紫藤花", "魯冰花", "薰衣草", "繡球花", "黃金風鈴木", "金針花", "白雪木", "臺灣欒樹", "風鈴木", "洋紅風鈴木", "苦楝", "藍花楹", "芒草", "流蘇", "九重葛", "美人樹", "稻穗")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, flowerType)
        spinnerFlower.adapter = adapter
        /*
        spinnerFlower.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                Log.d("MainActivity", "flowerType[pos] : " + flowerType[pos])
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }*/

    }


    //set initial data
    private fun SetInitialData(){
        lifecycle.coroutineScope.launch { // launching a coroutine
            /*
            try {
                val apiconnector = ApiConnector()
                val resultFlower = apiconnector.GetRequest(InterfaceApiConnector.urlFlower)//get data from api

                // do something with result
                DataFlower(resultFlower)
                Log.d("TestingMain2", DataFlower.flowerData.toString())
            }
            catch (exception: Exception) {
                // error here
            }
            */


            try {
                val apiconnector2 = ApiConnector()
                val resultTour = apiconnector2.GetRequest(InterfaceApiConnector.urlTourist)//get data from api

                DataTourist(resultTour)
                Log.d("TestingMain2",DataTourist.tourData.toString())
            }
            catch (exception: Exception) {
                // error here
            }

        }
    }



}
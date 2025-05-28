package curtis.com.taichungtravel

import android.os.Bundle
import android.util.Log
import android.widget.Button
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
import curtis.com.taichungtravel.data.DataFlower
import curtis.com.taichungtravel.navigation.tour.Setting
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    companion object{
        lateinit var buttonLanguage: Button
    }


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
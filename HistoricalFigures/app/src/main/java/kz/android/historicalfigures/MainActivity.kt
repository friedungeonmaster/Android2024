package kz.android.historicalfigures

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kz.android.historicalfigures.api.RetrofitModule
import kz.android.historicalfigures.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    val adapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)



        binding.figuresListRecycler.adapter = adapter
        binding.figuresListRecycler.layoutManager = LinearLayoutManager(this)
        binding.searchBtn.setOnClickListener {
            search(binding.searchInput.text.toString())
        }

        setContentView(binding.root)
    }
    private fun search(name: String) {
        RetrofitModule.apiService.getFiguresByName(name).enqueue(object :
            Callback<List<HistoricalFigure>> {
            override fun onResponse(call: Call<List<HistoricalFigure>>, response: Response<List<HistoricalFigure>>) {
                if (response.isSuccessful) {
                    adapter.submitList(response.body())
                }
            }
            override fun onFailure(call: Call<List<HistoricalFigure>>, t: Throwable) {
                t.message?.let { Log.e("network", it) }
            }
        })
    }

}
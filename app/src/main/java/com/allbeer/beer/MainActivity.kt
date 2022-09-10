package com.allbeer.beer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.allbeer.beer.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        lifecycleScope.launch {
            val beers = withContext(Dispatchers.IO) {
                RetrofitService.provideService().getBeers()
            }
            val adapter = Adapter(beers)
            binding.recyclerView.adapter = adapter
        }
    }
}
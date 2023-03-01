package com.example.practicaclima.UI.view

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.app.ActivityCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicaclima.R
import com.example.practicaclima.UI.view.elementosAdapter.PronosAdapter
import com.example.practicaclima.UI.viewModel.ClimaViewModel
import com.example.practicaclima.data.dataPronostico.model.ListaDias
import com.example.practicaclima.databinding.ActivityMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    lateinit var binding: ActivityMainBinding

    private val climaViewModel : ClimaViewModel by viewModels()

    private lateinit var adapter: PronosAdapter

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        getUnicacion()

        binding.svClima.setOnQueryTextListener(this)

        climaViewModel.isLoading.observe(this) {
            binding.pb.isVisible = it
            binding.clElementos.isVisible = !it
            binding.clElementosClima.isVisible = !it
            binding.clElementosViento.isVisible = !it
            binding.rvPronos.isVisible = !it
        }

        climaViewModel.pronosticoModel.observe(this) {
            initRecycleView(it)
        }

        climaViewModel.climaActualVM.observe(this) { Clima ->
            if (Clima != null) {
                val temp = Clima.mainCA.temp.toInt().toString()
                val direccion = Clima.vientoCA.direccion.toFloat()
                val vientoSpeed = Clima.vientoCA.speed.toString() + getString(R.string.ms)
                val sensacionReal =
                    Clima.mainCA.comoSiente.toInt().toString() + getString(R.string.centigr)
                val humedad = Clima.mainCA.Humedad.toString() + getString(R.string.porcentaje)
                val persion = Clima.mainCA.presion.toString()

                //setImagen(Clima.detallesCA[0].icon)
                binding.ivClima.setImageResource(setImagen(Clima.detallesCA[0].icon))

                binding.tvTempAct.text = temp
                binding.ivFlecha.rotation = direccion
                binding.tvViento.text = vientoSpeed
                binding.tvSensacion.text = sensacionReal
                binding.tvHumedad.text = humedad
                binding.tvPresion.text = persion

                hideKeyboard()
            }
        }

    }

    private fun getUnicacion() {
        val task = fusedLocationProviderClient.lastLocation
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) !=
            PackageManager.PERMISSION_GRANTED
        ){
          ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),101)
            return
        }
        task.addOnSuccessListener {
            if (it != null){
                val ubicacion = "lat=${it.latitude}&lon=${it.longitude}"
                climaViewModel.ClimaDeCiudad(ubicacion)
            }
        }
    }

    @SuppressLint("ResourceType")
     fun setImagen(id: String?):Int{
        var imagen = 0
        when(id){
            "01d"-> imagen = R.drawable.i01d
            "01n"-> imagen = R.drawable.i01n

            "02d"-> imagen = R.drawable.i02d
            "02n"-> imagen = R.drawable.i02n

            "03d"-> imagen = R.drawable.i03d
            "03n"-> imagen = R.drawable.i03n

            "04d"-> imagen = R.drawable.i04d
            "04n"-> imagen = R.drawable.i04d

            "09d"-> imagen = R.drawable.i09d
            "09n"-> imagen = R.drawable.i09n

            "10d"-> imagen = R.drawable.i10d
            "10n"-> imagen = R.drawable.i10n

            "11d"-> imagen = R.drawable.i11d
            "11n"-> imagen = R.drawable.i11n

            "13d"-> imagen = R.drawable.i13d
            "13n"-> imagen = R.drawable.i13n

            "50d"-> imagen = R.drawable.i50d
            "50n"-> imagen = R.drawable.i50n
        }
        return imagen
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()){
            val ubicacion = "q=" + query.lowercase(Locale.ROOT)
            climaViewModel.ClimaDeCiudad(ubicacion)
        }
        return true
    }

    private fun initRecycleView(lista: List<ListaDias>){
        adapter = PronosAdapter()
        adapter.setItems(lista)
        binding.rvPronos.layoutManager = LinearLayoutManager(this)
        binding.rvPronos.adapter = adapter
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

    private fun hideKeyboard() {
        val imm : InputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.viewRoot.windowToken, 0)
    }

}
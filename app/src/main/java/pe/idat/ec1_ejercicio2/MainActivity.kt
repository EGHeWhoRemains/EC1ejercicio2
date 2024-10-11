package pe.idat.ec1_ejercicio2

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.idat.ec1_ejercicio2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btncalcularprestamo.setOnClickListener(this)
    }
    override fun onClick(p0: View?) {
        val montoPrestamo = binding.etmontoPrestamo.text.toString().toDouble()
        var cuotas = 0
        var tasaInteres = 0.0
        cuotas = when {
            montoPrestamo > 5000 -> 3
            montoPrestamo < 1000 -> 1
            montoPrestamo in 2000.0..3000.0 -> 2
            else -> 5
        }
        tasaInteres = if (montoPrestamo < 4000) 0.12 else 0.10
        val montoTotal = montoPrestamo * (1 + tasaInteres)
        val valorCuota = montoTotal / cuotas
        binding.etresultadoprestamos.setText(
            "El préstamo de $montoPrestamo se pagará en $cuotas cuotas.\n" +
                    "Cada cuota será de %.2f con un interés del %.2f".format(valorCuota,tasaInteres)
        )
    }

}
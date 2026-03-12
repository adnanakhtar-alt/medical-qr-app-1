
package com.example.medicalqr

import android.graphics.Bitmap
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.medicalqr.databinding.ActivityMainBinding
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.journeyapps.barcodescanner.BarcodeEncoder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.generate.setOnClickListener {

            val data = "Name: " + binding.name.text.toString() +
                    "\nBlood Group: " + binding.blood.text.toString() +
                    "\nDisease: " + binding.disease.text.toString() +
                    "\nEmergency Phone: " + binding.phone.text.toString() +
                    "\nAddress: " + binding.address.text.toString()

            val writer = MultiFormatWriter()
            val matrix = writer.encode(data, BarcodeFormat.QR_CODE, 600, 600)

            val encoder = BarcodeEncoder()
            val bitmap: Bitmap = encoder.createBitmap(matrix)

            binding.qrImage.setImageBitmap(bitmap)
        }
    }
}

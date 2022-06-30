package com.example.polygonclaculator

import android.icu.number.NumberFormatter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.polygonclaculator.databinding.ActivityMainBinding
import com.example.polygonclaculator.model.Polygon
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeTextViews()

        binding.calculateTextButton.setOnClickListener {
            val numberOfSides = binding.numberOfSidesEditText.text.toString().toIntOrNull()
            val sideLength = binding.sideLengthEditText.text.toString().toDoubleOrNull()
            if (numberOfSides == null || sideLength == null){
                initializeTextViews()
                Toast.makeText(this, "Check Input Data", Toast.LENGTH_LONG).show()
            } else{
                calculateData(sideLength, numberOfSides)
            }
        }

    }

    private fun initializeTextViews(){
        binding.perimeterTextView.text = this.resources.getString(R.string.perimeter, "0")
        binding.areaTextView.text = this.resources.getString(R.string.area, "0")
        binding.interiorAngleTextView.text = this.resources.getString(R.string.interior_angle, "0")
    }

    private fun calculateData(sideLength: Double, numberOfSides : Int){
        val polygon : Polygon = Polygon(sideLength, numberOfSides)
        binding.perimeterTextView.text = this.resources.getString(R.string.perimeter, polygon.calculatePerimeter().toString())
        binding.areaTextView.text = this.resources.getString(R.string.area, NumberFormat.getNumberInstance().format(polygon.calculateArea()))
        binding.interiorAngleTextView.text = this.resources.getString(R.string.interior_angle, polygon.calculateInteriorAngle().toString())
        Toast.makeText(this, "Successfully Calculated", Toast.LENGTH_LONG).show()
    }
}
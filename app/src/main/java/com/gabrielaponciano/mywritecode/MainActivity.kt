package com.gabrielaponciano.mywritecode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import com.gabrielaponciano.mywritecode.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val foodCheckBoxes = mutableListOf<CheckBox>()
    private val foodPrices = mutableListOf<Double>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonReady.setOnClickListener(this)

        foodCheckBoxes.add(findViewById(R.id.checkbox))
        foodPrices.add(23.0)
        foodCheckBoxes.add(findViewById(R.id.checkbox1))
        foodPrices.add(35.0)
        foodCheckBoxes.add(findViewById(R.id.checkbox2))
        foodPrices.add(17.0)
        foodCheckBoxes.add(findViewById(R.id.checkbox3))
        foodPrices.add(21.0)
        foodCheckBoxes.add(findViewById(R.id.checkbox4))
        foodPrices.add(6.0)
        foodCheckBoxes.add(findViewById(R.id.checkbox5))
        foodPrices.add(6.5)
        foodCheckBoxes.add(findViewById(R.id.checkbox6))
        foodPrices.add(3.5)

        for (checkBox in foodCheckBoxes){
            checkBox.setOnClickListener{
                calculate()
            }
        }
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_ready){
            makeOrder()
        }
    }
private fun isValid():Boolean {
    for (checkBox in foodCheckBoxes) {
        if (checkBox.isChecked) {
             return true
            }
        }
    return false
    }
    private fun makeOrder() {
        if(isValid()) {
            Toast.makeText(this, R.string.did_order, Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(this, R.string.no_order, Toast.LENGTH_SHORT).show()
        }
    }
    private fun calculate() {
        var totalPrice = 0.0
        for (i in foodCheckBoxes.indices) {
            val checkBox = foodCheckBoxes[i]
            if (checkBox.isChecked) {
                totalPrice += foodPrices[i]
            }

        }

        binding.textResult.text = String.format("R$%.2f", totalPrice)
    }
}
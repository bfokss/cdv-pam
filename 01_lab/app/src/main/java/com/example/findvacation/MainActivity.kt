package com.example.findvacation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findPlaceButton: Button = findViewById(R.id.button_get_place)
        val displayPlaceName: TextView = findViewById(R.id.text_place_name)
        val displayPlaceDescription: TextView = findViewById(R.id.text_place_description)
        val passedName: EditText = findViewById(R.id.text_get_name)
        var userName = passedName.text

        findPlaceButton.setOnClickListener{
            if (userName.isEmpty()){
                displayPlaceName.text = "Nie podano imienia!"
                displayPlaceDescription.text = ""
            }
            else{
                var vacationPlace = getVacationPlace(userName)
                displayPlaceName.text = "${vacationPlace[0]}"
                displayPlaceDescription.text = "${vacationPlace[1]}"
            }
        }

    }




}
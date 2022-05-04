package com.example.messagecipher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val encryptButton: Button = findViewById<Button>(R.id.button_encrypt)
        val cipherChoice = findViewById<Spinner>(R.id.get_cipher)
        val messageField = findViewById<EditText>(R.id.text_get_message).text
        val errorField = findViewById<TextView>(R.id.text_error)

        encryptButton.setOnClickListener{
            if(messageField.isEmpty()){
                errorField.text="Pass message to encrypt!"
            }
            else{
                val intent = Intent(this, EncryptMessage::class.java)
                val userMessage = findViewById<EditText>(R.id.text_get_message).text.toString()
                val userCipher = cipherChoice.selectedItem.toString()
                intent.putExtra(EncryptMessage.USER_MESSAGE, userMessage)
                intent.putExtra(EncryptMessage.USER_CIPHER, userCipher)
                startActivity(intent)
            }
        }
    }
}
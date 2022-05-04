package com.example.messagecipher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView

class EncryptMessage : AppCompatActivity() {
    companion object {
        const val USER_MESSAGE = "userMessage"
        const val USER_CIPHER = "userCipher"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encrypt_message)

        val userMessage = intent.getStringExtra(USER_MESSAGE)
        val displayUserMessage = findViewById<TextView>(R.id.text_show_message)

        val userCipher = intent.getStringExtra(USER_CIPHER)
        var encryptedMessage = ""
        val displayEncryptedMessage = findViewById<TextView>(R.id.text_show_enc_message)

        val shareOriginal = findViewById<Switch>(R.id.switch_message)
        val shareButton = findViewById<Button>(R.id.button_share_cipher)

        when(userCipher){
            "P0K3M0N" -> {
                displayUserMessage.text = userMessage
                if (userMessage != null) {
                    encryptedMessage = pokemonCypher(userMessage)
                    displayEncryptedMessage.text = encryptedMessage
                }

            }
            "SpOnGeBoB cAsE" -> {
                displayUserMessage.text = userMessage
                if (userMessage != null) {
                    encryptedMessage = spongebobCase(userMessage)
                    displayEncryptedMessage.text = encryptedMessage
                }
            }
            else -> displayEncryptedMessage.text = "Something went wrong"
        }

        shareButton.setOnClickListener{
            if (shareOriginal.isChecked){
                var messageToShare = "$userMessage - $encryptedMessage"
                val intent = Intent().apply{
                    action = Intent.ACTION_SEND
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, messageToShare)
                }
                startActivity(intent)
            }
            else{
                val intent = Intent().apply{
                    action = Intent.ACTION_SEND
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, encryptedMessage)
                }
                startActivity(intent)
            }
        }

    }
}
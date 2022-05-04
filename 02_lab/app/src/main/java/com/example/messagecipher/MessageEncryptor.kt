package com.example.messagecipher

fun pokemonCypher(paramString: String = "Message"): String{
    var message = paramString
    message = message.replace('a', '@', ignoreCase = true)
    message = message.replace('b', '8', ignoreCase = true)
    message = message.replace('e', '3', ignoreCase = true)
    message = message.replace('h', '#', ignoreCase = true)
    message = message.replace('i', '1', ignoreCase = true)
    message = message.replace('o', '0', ignoreCase = true)
    message = message.replace('s', '$', ignoreCase = true)
    message = message.replace('t', '7', ignoreCase = true)
    return message
}

fun spongebobCase(paramString: String = "Message"): String{
    var message = paramString
    var messageChars = message.toCharArray()
    var messageLength = messageChars.size
    for (char in messageChars){
        var charIndex = messageChars.indexOf(char)
        if ((charIndex % 2) == 0){
            var newChar = char.uppercaseChar()
            messageChars[messageChars.indexOf(char)] = newChar
        }
        else{
            var newChar = char.lowercaseChar()
            messageChars[messageChars.indexOf(char)] = newChar
        }
    }
    message = String(messageChars)
    return message
}
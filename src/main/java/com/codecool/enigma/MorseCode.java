package com.codecool.enigma;

class MorseCode implements Cipher {

    @Override
    public String encrypt(String message) {
        String[] alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".split("");
        String[] morse = morseCharacters().split(" ");
        message = message.toUpperCase().replaceAll("[^a-z0-9 ]","");
        message = message.replaceAll(" ","/").replaceAll(""," ");
        String encryptedMessage = "";
        for (int i = 0; i < alphanumeric.length; i++) {
            encryptedMessage = message.replaceAll(alphanumeric[i], morse[i]);
        }
        return encryptedMessage;
    }

    @Override
    public String decrypt(String message) {
        String[] alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".split("");
        String[] morse = morseCharacters().split(" ");
        String decryptedMessage = "";
        message = " " + message + " ";
        for (int i = 0; i < alphanumeric.length; i++) {
            decryptedMessage = message.replaceAll(" " +  morse[i] + " " ,
                                                  " " +  alphanumeric[i] + " ");
        }
        decryptedMessage = decryptedMessage.replaceAll(" ", "").replaceAll("/", " ");
        return decryptedMessage;
    }
    public static String morseCharacters(){
        return ".-" + " " +
                "-..." + " " +
                "-.-." + " " +
                "-.." + " " +
                "." + " " +
                "..-." + " " +
                "--." + " " +
                "...." + " " +
                ".." + " " +
                ".---" + " " +
                "-.-" + " " +
                ".-.." + " " +
                "--" + " " +
                "-." + " " +
                "---" + " " +
                ".--." + " " +
                "--.-" + " " +
                ".-." + " " +
                "..." + " " +
                "-" + " " +
                "..-" + " " +
                "...-" + " " +
                ".--" + " " +
                "-..-" + " " +
                "-.--" + " " +
                "--.." + " " +
                ".----" + " " +
                "..---" + " " +
                "...--" + " " +
                "....-" + " " +
                "....." + " " +
                "-...." + " " +
                "--..." + " " +
                "---.." + " " +
                "----." + " " +
                "-----";
    }
}


package com.codecool.enigma;

import java.util.Arrays;

class MorseCode implements Cipher {

    @Override
    public String encrypt(String message) {
        message = message.toUpperCase().replaceAll("[^A-Z0-9 ]","");
        String[] messageArr = message.split("");
        String encryptedMessage = "";
        int i;
        for (String character: messageArr) {
            i = Arrays.asList(alphanumeric()).indexOf(character);
            encryptedMessage += i == -1 ? "/" : morseCharacters()[i];
            encryptedMessage += " ";
        }
        encryptedMessage = encryptedMessage.trim();
//        System.out.println("Encryption with MorseCode result:\n\t" + encryptedMessage);   //testline
        return encryptedMessage;
    }

    @Override
    public String decrypt(String message) {
        String[] messageArr = message.split(" ");
        String decryptedMessage = "";
        int i;
        for (String character: messageArr) {
            i = Arrays.asList(morseCharacters()).indexOf(character);
            decryptedMessage += i == -1 ? " " : alphanumeric()[i];
        }
//        System.out.println("Decryption with MorseCode:\n\t" + decryptedMessage);   //testline
        return decryptedMessage;
    }

    public static String[] alphanumeric(){
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".split("");
    }
    public static String[] morseCharacters(){
        return new String[]{".-", "-...", "-.-.", "-..",
                            ".", "..-.", "--.", "....",
                            "..", ".---", "-.-", ".-..",
                            "--", "-.", "---", ".--.",
                            "--.-", ".-.", "...", "-",
                            "..-", "...-", ".--", "-..-",
                            "-.--", "--..", ".----", "..---",
                            "...--", "....-", ".....", "-....",
                            "--...", "---..", "----.", "-----"};
    }
}


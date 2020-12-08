package com.codecool.enigma;

class Rot13 implements Cipher {

    String base =  "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String coded = "nopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklm";

    @Override
    public String encrypt(String message) {
        String[] messageArr = message.split("");
        String encryptedMessage = "";
        int i;
        for (String character: messageArr) {
            i = base.indexOf(character);
            encryptedMessage += i == -1 ? character : coded.substring(i, i+1);
        }
//        System.out.println("Encryption with Rot13 result:\n\t" + encryptedMessage);   //testline
        return encryptedMessage;
    }

    @Override
    public String decrypt(String message){
        String[] messageArr = message.split("");;
        String decryptedMessage = "";
        int i;
        for (String character: messageArr) {
            i = coded.indexOf(character);
            decryptedMessage += i == -1 ? character : base.substring(i, i+1);
        }
//        System.out.println("Decryption with Rot13 result:\n\t" + decryptedMessage);   //testline
        return decryptedMessage;
    }
/*
        // unnecessary methods
    private char encryptLetter(char letter) { return letter; }
    private char decryptLetter(char letter) { return letter; }
*/
}




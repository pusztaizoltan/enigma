package com.codecool.enigma;

class Rot13 implements Cipher {

//    abcdefghijklm nopqrstuvwxyz ABCDEFGHIJKLM NOPQRSTUVWXYZ
//    nopqrstuvwxyz ABCDEFGHIJKLM NOPQRSTUVWXYZ abcdefghijklm

    @Override
    public String encrypt(String message) {
        String[] base = "abcdefghijklm nopqrstuvwxyz ABCDEFGHIJKLM NOPQRSTUVWXYZ".split("");
        String[] coded = "nopqrstuvwxyz ABCDEFGHIJKLM NOPQRSTUVWXYZ abcdefghijklm".split("");
        String encryptedMessage = "";
        for (int i = 0; i < base.length; i++) {
            encryptedMessage = message.replaceAll(base[i], coded[i]);
        }
        return encryptedMessage;
    }

    @Override
    public String decrypt(String message){
        String[] coded = "abcdefghijklm nopqrstuvwxyz ABCDEFGHIJKLM NOPQRSTUVWXYZ".split("");
        String[] base = "nopqrstuvwxyz ABCDEFGHIJKLM NOPQRSTUVWXYZ abcdefghijklm".split("");
        String decryptedMessage = "";
        for(int i = 0; i<base.length;i++){
            decryptedMessage = message.replaceAll(base[i], coded[i]);
        }
        return decryptedMessage;
    }
/*
        // unnecessary methods
    private char encryptLetter(char letter) { return letter; }
    private char decryptLetter(char letter) { return letter; }
*/
}




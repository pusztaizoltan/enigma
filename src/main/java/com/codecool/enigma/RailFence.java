package com.codecool.enigma;

import java.util.Arrays;

class RailFence implements Cipher {

    @Override
    public String encrypt(String message){

        int key = ArgsParser.getKey();
        int cycle = (key-1) *2;

        String[] messageArr = message.split("");
        String[] tempHolder = new String[key];
        Arrays.fill(tempHolder, "");

        int holderIndex;
        for (int i = 0; i < messageArr.length; i++){
            holderIndex = i%cycle < key ? i%cycle : cycle-i%cycle;
            tempHolder[holderIndex] += messageArr[i];
        }
//        for (String i: tempHolder){ System.out.println("tempHolder = " + i + " " + i.length()); } //testline
        String encryptedMessage = "";
        for (String i: tempHolder){
            encryptedMessage += i;
        }
//        System.out.println("Encryption with RailFence result:\n\t" + encryptedMessage);   //testline
        return encryptedMessage;
    }

    @Override
    public String decrypt(String message) {
        int key = ArgsParser.getKey();
        int cycle = (key-1) *2;
        int messagelength = message.length();

        String[] tempHolder = new String[key];
        int[] partLengths = new int[key];
        Arrays.fill(partLengths, 0);
        int partLengthsIndex;
        for (int i = 0; i<message.length(); i++){
            partLengthsIndex = i%cycle < key ? i%cycle : cycle-i%cycle;
            partLengths[partLengthsIndex] +=1;
        }
        for (int i = 0;  i < key; i++){
            tempHolder[i] = message.substring(0, partLengths[i]);
            message = message.substring(partLengths[i]);
        }
        int holderIndex;
        String decryptedMessage = "";
        for (int i = 0; i < messagelength; i++) {
            holderIndex = (i%cycle < key) ? (i % cycle) : (cycle - i % cycle);
            decryptedMessage += tempHolder[holderIndex].substring(0, 1);
            tempHolder[holderIndex] = tempHolder[holderIndex].substring(1);
        }
//        System.out.println("Decryption with RailFence result:\n\t" + decryptedMessage);   //testline
        return decryptedMessage;
    }
}

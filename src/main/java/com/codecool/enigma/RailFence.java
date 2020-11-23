package com.codecool.enigma;

class RailFence implements Cipher {

    @Override
    public String encrypt(String message){
        String[] messageArr = message.split("");
        String[] tempHolder = new String[]{"", "", ""};
        int holderIndex = 0;
        for (int i = 0; i < messageArr.length; i++){
            holderIndex = i%4 < 3 ? i%4 : 1;
            tempHolder[holderIndex] += messageArr[i];
        }
        return tempHolder[0] + tempHolder[1] + tempHolder[2];
    }
    @Override
    public String decrypt(String message) {
        int length = message.length();
        int part1Length = (int) (length-1)/4;
        int part2Length = (int) length/2;
        int part3Length = (int) (length+1)/4;

        String[] tempHolder = new String[3];
        tempHolder[0] = message.substring(0, part1Length);
        message = message.substring(part1Length);
        tempHolder[1] = message.substring(0, part2Length);
        message = message.substring(part2Length);
        tempHolder[2] = message.substring(0, part3Length);

        int holderIndex = 0;
        String decryptedMessage = "";
        for (int i = 0; i < length; i++) {
            holderIndex = i%4 < 3 ? i%4 : 1;
            decryptedMessage += tempHolder[holderIndex].substring(0, 1);
            tempHolder[holderIndex] = tempHolder[holderIndex].substring(1);
        }
        return decryptedMessage;
    }
}

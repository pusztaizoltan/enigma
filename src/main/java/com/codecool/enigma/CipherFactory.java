package com.codecool.enigma;

import java.util.Arrays;

class CipherFactory {

    private static String[]  ValidCipherName = {"rot13", "rail-fence", "morse"};

    static boolean isCipherAvailable(String cipherName) {
            return Arrays.asList(ValidCipherName).contains(cipherName);
        }


    static Cipher getCipherForArgs(ArgsParser args) throws EnigmaException {
        if (!isCipherAvailable(args.cipher)) {
            throw new EnigmaException();
        } else {
            switch (args.cipher) {
                case "rot13":
                    return new Rot13();
                case "rail-fence":
                    return new RailFence();
                case "morse":
                    return new MorseCode();
                default:
                    return null;
            }
        }
    }
}

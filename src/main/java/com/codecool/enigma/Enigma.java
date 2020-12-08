package com.codecool.enigma;

class Enigma {

    private static String MENU = "Enigma Manual\n" +
            "Run options: [-h | -e | -d] {CipherName} {FileName} {EncryptionKey}\n" +
            "   -h : displays this menu; other arguments are ignored.\n" +
            "   -e : encrypt and display\n" +
            "   -d : decrypt and display\n" +
            "   CipherName      : cipher to use when encrypting/decrypting; [rot13, rail-fence, morse]\n" +
            "   FileName        : path to file to encrypt/decrypt\n" +
            "   EncryptionKey   : Optional -> must be provided if cipher requires a key";

    public static void main(String[] args) throws EnigmaException {
//        args = new String[]{"-h"};    //testline
//        args = new String[]{"-d", "morse", "more.txt"};    //testline
//        args = new String[]{"-d", "morse", "morse.txt"};    //testline
        args = new String[]{"-d", "rail-fence", "railfence10.txt", "10"};    //testline

        ArgsParser argsParser = new ArgsParser(args);
        if (argsParser.option == "-h" || argsParser.option == null) {
            System.out.print(MENU);
        } else {
//##################################################################
            System.out.println("option " + argsParser.option);
            System.out.println("cipher " + argsParser.cipher);
            System.out.println("file " + argsParser.file);
            System.out.println("key " + argsParser.key);
            System.out.println("filecontent " + argsParser.fileContent);
//##################################################################

            handleCipherOperation(argsParser);
        }
    }

    private static void handleCipherOperation(ArgsParser argsParser) {
        Cipher cipher = null;
        String message;
        try {
            cipher = CipherFactory.getCipherForArgs(argsParser);
        } catch (EnigmaException e) {
            e.printStackTrace();
        }
        switch(argsParser.option){
            case "-h":
                System.out.print(MENU);
                break;
            case "-e":
                message = cipher.encrypt(argsParser.fileContent);
                System.out.print("\nprocessed: " + message);
                break;
            case "-d":
                message = cipher.decrypt(argsParser.fileContent);
                System.out.print("\nprocessed: " + message);
                break;
            default:
                System.out.print(MENU);
        }
    }
}

package com.codecool.enigma;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class ArgsParser {

    String option = null;
    String cipher = null;
    String file = null;
    static String key = null;
    String fileContent = null;

    String[] validOptions = {"-h", "-e", "-d"};
    String[]  ValidCipherName = {"rot13", "rail-fence", "morse"};

    public static int getKey(){
        int k = Integer.parseInt(key);
        return k;
    }
    private boolean validateOptions(String[] args) {
        return (args.length >= 1) && Arrays.asList(validOptions).contains(args[0]);
    }

    private boolean validateCipherName(String[] args){
        return (args.length >= 2) && Arrays.asList(ValidCipherName).contains(args[1]);
    }

    private boolean validateFile(String[] args) {
        return (args.length >= 3) && (option.equals(validOptions[1]) || option.equals(validOptions[2]));
    }

    private boolean validateKey(String[] args) {
        return (args.length >= 4) && (cipher.equals(ValidCipherName[1]));
    }

        ArgsParser(String[] args) throws EnigmaException {
            if (!validateOptions(args)) throw new EnigmaException("invalid option");
            option = validateOptions(args) ? args[0] : null;
            cipher = validateCipherName(args) ? args[1] : null;
            if ((option == "-d" || option == "-e") && cipher.equals(null)) throw new EnigmaException("missing or erroneous cypher");
            file = validateFile(args) ? args[2] : null;
            if (!cipher.equals(null) && args.length < 3) throw new EnigmaException("missing filepath");
            key = validateKey(args) ? args[3] : null;
            fileContent = validateFile(args) ? readLine() : null;
            if (args.length >= 3 && fileContent.length() == 0) throw new EnigmaException("invalid file path");
    }
    
    private String readLine() {
        File fileObject = new File(file);
        String line = new String();
        try {
            Scanner fileReader = new Scanner(fileObject);
            while (fileReader.hasNextLine()) {
                line += fileReader.nextLine() + " ";
            }
            fileReader.close();
        } catch (IOException e) {
//            return new String[0];
        }
        return line.trim();
    }
}


# Enigma

## Story

Hackerman, we need your help. We intercepted correspondence between "the bad guys". We need an app able to both decrypt and encrypt files using ROT13 cipher, Morse code and Rail-fence cipher.

## What are you going to learn?

You'll have to:

- think in algorithms,
- handle edge cases and exceptions,
- read from files,
- use multidimensional arrays.

## Tasks

1. In `Enigma` we use `ArgsParser` class to encapsulate passed parameters.
Finish implementation of `ArgsParser`.
    - Data is extracted from the given string array
    - Fields in `ArgsParser` are `null` if no value was provided
    - The fields in this class are not modifiable

2. Implement the `CipherFactory` class with a factory method that provides `Cipher` implementations.
It must work for all ciphers (ROT13, Rail-fence and Morse code).
    - Method `isCipherAvailable()` returns `true` if passed name of a supported cipher, `false` otherwise
    - Method `getCipherForArgs()` returns proper `Cipher` instance. If not possible, or invalid key for specific cipher was provided, `EnigmaException` is thrown

3. Implement execution engine in `Enigma` that interprets and executes meaningful commands and displays messages for all cases
    - App prints help menu when passed no arguments, or when the first one is `'-h'`
    - Providing mode different than `'-h'`, `'-e'`, or `'-d'` leads to `EnigmaException`
    - Providing too few arguments leads to `EnigmaException`. Notice that using `'-h'` doesn't need any further arguments
    - Providing a not supported cipher name leads to `EnigmaException`
    - Providing non-existent file path leads to `EnigmaException`
    - All `EnigmaException`s are caught and their messages are printed to the standard output
    - Method `handleCipherOperation()` encrypts/decrypts file content using the cipher provided by `CipherFactory`, and prints the result

4. Implement ROT13 cipher encrypt and decrypt methods. Upper case letters should appear AFTER lower case ones (see examples below). Create functions `encryptLetter(char)` and `decryptLetter(char)` that will do the mapping of single characters. Methods `encrypt(String)` and `decrypt(String)` will map entire texts.
Examples:
```{{prog_lang}}
encryptLetter('a') -> 'n'
encryptLetter('l') -> 'y'
encryptLetter('m') -> 'z'
encryptLetter('n') -> 'A'
encryptLetter('o') -> 'B'
decryptLetter('C') -> 'p'
decryptLetter('D') -> 'q'
```
    - All alphabetic characters are encrypted
    - All alphabetic characters are decrypted
    - Non-alphabetic characters are unchanged

5. Implement Morse code encryption and decryption. Implementation must support 26 English letters `A` through `Z` and Arabic numerals `0` to `9`. Convert spaces into word separators (`'/'`). Every other symbol has to be omitted.
```{{prog_lang}}
encode("Hello, World!") -> ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
decode(".... . .-.. .-.. --- / .-- --- .-. .-.. -..") -> "HELLO WORLD"
```
    - Message gets encrypted into Morse code using word separators
    - Non-alphanumeric characters are omitted from the encrypted message
    - Message gets decrypted using uppercase letters

6. Implement Rail-fence cipher encryption and decryption. Encrypted message should contain all non alphanumeric characters, letters must stay the same (don't change the case)
```{{prog_lang}}
encrypt("Hello World!") -> "Horel ol!lWd" // key = 3
decrypt("Horel ol!lWd") -> "Hello World!"
```
    - Message gets encrypted
    - Letter cases are unchanged
    - Message gets decrypted

## General requirements

None

## Hints

- When implementing Morse code, you might be interested in using the Java version of the abstract data type map / dictionary (called `Map` in Java, check out the Background materials section for more information). Or you can choose to use arrays only.


## Starting your project



## Background materials

- <i class="far fa-exclamation"></i> [ROT13 cipher](http://practicalcryptography.com/ciphers/classical-era/rot13/)
- <i class="far fa-exclamation"></i> [Morse code](https://en.wikipedia.org/wiki/Morse_code)
- <i class="far fa-exclamation"></i> [Rail-fence cipher](http://practicalcryptography.com/ciphers/classical-era/rail-fence/)
- <i class="far fa-exclamation"></i> [Design patterns](project/curriculum/materials/pages/general/design-patterns.md)
- <i class="far fa-exclamation"></i> [Factory pattern](project/curriculum/materials/pages/java/factory.md)
- <i class="far fa-exclamation"></i> [`@Override` annotation](https://beginnersbook.com/2014/07/override-annotation-in-java/)
- <i class="far fa-exclamation"></i> [Exceptions in Java](https://www.dummies.com/programming/java/what-you-need-to-know-about-exceptions-in-java/)
- [Dictionaries: moving from Python to Java](https://stackoverflow.com/questions/36068991/what-is-the-java-equivalent-of-a-python-dictionary?noredirect=1&lq=1)


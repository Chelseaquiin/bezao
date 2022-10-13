package codeCracker;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {

        // Task two - Code cracker

        static final char[] ALPHABETS       = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        static final char[] DECRYPTION_KEYS = {'£','*','%','&','>','<','!',')','"','(','@','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o'};

        static LinkedHashMap<Character, Character> encryptionKeys = new LinkedHashMap<Character, Character>();
        static LinkedHashMap<Character, Character> decryptionKeys = new LinkedHashMap<Character, Character>();

        public static void main(String[] args) {

            init();

            System.out.println(decryptionKeys.keySet());
            System.out.println(decryptionKeys.values());


            Scanner scanner = new Scanner(System.in);
            int userInput;

            do {
                System.out.println("Select the action to perform.");

                System.out.print("1. Encrypt a message");
                System.out.println("2. Decrypt a message");


                System.out.print("Enter your option (1 or 2) : ");

                userInput = Integer.parseInt(scanner.nextLine());

                switch (userInput) {
                    case 1:
                        System.out.println("Enter the word/sentence to encrypt : ");
                        break;
                    case 2:
                        System.out.println("Enter the word/sentence to decrypt : ");
                        break;
                    default:
                        System.out.println("Invalid option selected!");
                }

            } while (userInput > 2 || userInput < 1);

            String wordToEncryptOrDecrypt = scanner.nextLine();
            String finalOutput;

            if (userInput == 1) {
                finalOutput = encrypt(wordToEncryptOrDecrypt);
                System.out.println("Your encrypted word/sentence: " + finalOutput);
            } else {
                finalOutput = decrypt(wordToEncryptOrDecrypt);
                System.out.println("Your decrypted word/sentence: " + finalOutput);
            }
        }

        public static void init() {
            for (int i = 0; i < 26; i++) {
                encryptionKeys.put(ALPHABETS[i], DECRYPTION_KEYS[i]);
            }

            for (int i = 0; i < 26; i++) {
                decryptionKeys.put(DECRYPTION_KEYS[i], ALPHABETS[i]);
            }
        }

        public static String encrypt(String word) {
            String encryptedWord = word;

            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                char replacementChar = (encryptionKeys.get(currentChar) != null) ? encryptionKeys.get(currentChar) : currentChar;

                encryptedWord = encryptedWord.replace(currentChar, replacementChar);
            }

            return encryptedWord;
        }

        public static String decrypt(String word) {
            String decryptedWord = word;

            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                char replacementChar = (decryptionKeys.get(currentChar) != null) ? decryptionKeys.get(currentChar) : currentChar;

                decryptedWord = decryptedWord.replace(currentChar, replacementChar);
            }

            return decryptedWord;
        }

    }



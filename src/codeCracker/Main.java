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

            LinkedHashMap<Character, Character> map = new LinkedHashMap<Character, Character>();
            map.put('a', '£'); map.put('b','*'); map.put('c','%'); map.put('d','&'); map.put('e','>'); map.put('f','<');
            map.put('g','!'); map.put('h',')'); map.put('i','"'); map.put('j','('); map.put('k','@'); map.put('l','a');
            map.put('m','b'); map.put('n','c'); map.put('o','d'); map.put('p','e'); map.put('q','f'); map.put('r','g');
            map.put('s','h'); map.put('t','i'); map.put('u','j'); map.put('v','k'); map.put('w','l'); map.put('x','m');
            map.put('y','n'); map.put('z','o');
            for (int i = 0; i < 26; i++) {
                encryptionKeys.put(ALPHABETS[i], DECRYPTION_KEYS[i]);
            }

            LinkedHashMap<Character, Character> map1 = new LinkedHashMap<Character, Character>();
            map1.put('£', 'a'); map1.put('*','b'); map1.put('%','c'); map1.put('&','d'); map1.put('>','e'); map1.put('<','f');
            map1.put('!','g'); map1.put(')','h'); map1.put('"','i'); map1.put('(','j'); map1.put('@','k'); map1.put('a','l');
            map1.put('b','m'); map1.put('c','n'); map1.put('d','o'); map1.put('e','p'); map1.put('f','q'); map1.put('g','r');
            map1.put('h','s'); map1.put('i','t'); map1.put('j','u'); map1.put('k','v'); map1.put('l','w'); map1.put('m','x');
            map1.put('n','y'); map1.put('o','z');


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



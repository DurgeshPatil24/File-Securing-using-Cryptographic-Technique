package Cryptography;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class VigenereCipher {

    public static String message;
    public static String mappedKey;
    public static Scanner in;

    public static void main(String[] args) throws Exception{
    	
    	in = new Scanner(System.in);
    	
    	vigenere();
       }
    
    public static void vigenere() throws Exception
    {
    	System.out.println("\n**** Vigenere Cipher ****\n");
    	msgAndKey();
    	
		System.out.println();
    	String encryptedData=cipherEncryption(message,mappedKey);
    	cipherDecryption(encryptedData,mappedKey);
    }

    private static void cipherDecryption(String message, String mappedKey) {
        int[][] table = createVigenereTable();
        String decryptedText = "";

        for (int i = 0; i < message.length(); i++) {
            if(message.charAt(i) == (char)32 && mappedKey.charAt(i) == (char)32){
                decryptedText += " ";
            } else {
                decryptedText += (char)(65 + itrCount((int)mappedKey.charAt(i), (int)message.charAt(i)));
            }
        }
        
        JOptionPane.showMessageDialog(null,"Decrypted Data "+"\n"+decryptedText);

        System.out.println("\nDecrypted Text: \n\n" + decryptedText);
    }

    private static int itrCount(int key, int msg) {
    	
        int counter = 0;
        String result = "";
        for (int i = 0; i < 26; i++) {
            if(key+i > 90){
                //90 being ASCII of Z
                result += (char)(key+(i-26));

            } else {
                result += (char)(key+i);
            }
        }

        //counting from key's letter to cipher letter in vigenere table
        for (int i = 0; i < result.length(); i++) {
            if(result.charAt(i) == msg){
                break; // letter found
            } else {
                counter++;
            }
        }
        return counter;
    }

    private static String cipherEncryption(String message, String mappedKey) {
        int[][] table = createVigenereTable();
        String encryptedText = "";
        for (int i = 0; i < message.length(); i++) {
            if(message.charAt(i) == (char)32 && mappedKey.charAt(i) == (char)32){
                encryptedText += " ";
            } else {
                //accessing element at table[i][j] position to replace it with letter in message
                encryptedText += (char)table[(int)message.charAt(i)-65][(int)mappedKey.charAt(i)-65];
            }
        }
        
        JOptionPane.showMessageDialog(null,"Encrypted Data "+"\n"+encryptedText);

        System.out.println("\nEncrypted Text: \n\n" + encryptedText);
        System.out.println();
        return encryptedText;
    }
    
 // creating 26x26 table containing alphabets 
    private static int[][] createVigenereTable() {
        
        int[][] tableArr = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                int temp;
                if((i+65)+j > 90){
                    temp = ((i+65)+j) -26;
                    tableArr[i][j] = temp;
                } else {
                    temp = (i+65)+j;
                    tableArr[i][j] = temp;
                }
            }
        }

        //printing table to check if its correct
        
        System.out.println();
       for (int i = 0; i < 26; i++) {
    	   System.out.print(i+" ");
            for (int j = 0; j < 26; j++) {
            	
            System.out.print((char)tableArr[i][j] + " ");
           }
           System.out.println();
      }

        return tableArr;
    }

    private static void msgAndKey() throws Exception {
        System.out.println(" *** Message and key should be alphabetic *** ");
        
        JOptionPane.showMessageDialog(null,"***Message and key should be alphabetic***");
        
        //message input
        //String msg=JOptionPane.showInputDialog(null,"Enter message to encrypt: ");
        String msg=OpenFile2.pickFile();
        
        System.out.println("\nOriginal Message: \n\n"+msg);
        
        msg = msg.toUpperCase();

        //key input
        String key=JOptionPane.showInputDialog(null,"Enter key: ");
        
        key = key.toUpperCase();

        //mapping key to message
        String keyMap = "";
        for (int i = 0, j = 0; i < msg.length(); i++) 
        {
            if(msg.charAt(i) == (char)32)
            {
               keyMap += (char)32; //ignoring space
            }
            else 
            {
                
                if(j < key.length()){
                    keyMap += key.charAt(j);
                    j++;
                } else {
                    //restarting the key from beginning once its length is complete
                    // and its still not mapped to message
                    j = 0;
                    keyMap += key.charAt(j);
                    j++; //without incrementing here, key's first letter will be mapped twice

                }
            }
        }
        message = msg;
        mappedKey = keyMap;

System.out.println("\nMapped Key: "+mappedKey);
    }

}


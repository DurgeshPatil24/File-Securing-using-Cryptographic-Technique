package Cryptography;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Caesar {
	public static void main(String arg[]) throws Exception
	{
		caesar();
	}
	public static void caesar() throws Exception 
	{
		Scanner kb=new Scanner(System.in);
		System.out.println("\n**** Caesar Cipher ****\n");
		
		//String str=JOptionPane.showInputDialog(null,"Enter message to encrypt: ");
		String str=OpenFile.pickFile(); 
		
		System.out.println("Original Message: "+str);
		System.out.println();
		int key=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Key value: "));
		
		System.out.println("Key value: "+key);
		
		String cipherText = encryption(str, key);
		JOptionPane.showMessageDialog(null,"Encrypted Data "+"\n"+cipherText);
	    System.out.println("\nEncrypted message:"+cipherText);
	    
	    String decipherText = Decryption(cipherText, key);
	    JOptionPane.showMessageDialog(null,"Decrypted Data "+"\n"+decipherText);
	    System.out.println("\nDecrypted message:"+decipherText);
	}
	
	private static String encryption(String str, int key) 
	{
		byte b[]=str.getBytes();
		
		String result = "";	
		
		for(int i = 0; i <b.length; i++)
		b[i] =(byte)(b[i] + key); //the key for encryption is added to ASCII value
		
	    result=new String(b);
	    
	    return result;
	}
	
	private static String Decryption(String str, int key) 
	{
		byte b[]=str.getBytes();
		
		String result = "";	
		
		for(int i = 0; i <b.length; i++)
		b[i] =(byte)(b[i] - key); //the key for decryption is subtracted from ASCII value
		
	    result=new String(b);
	    
	    return result;
	}
		 

}

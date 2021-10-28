package Cryptography;

//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//import java.util.Arrays;

//import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
//import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
//import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;



public class des_crypto {
	public static void main(String args[]) throws Exception 
	{
		des();
	}
	public static void des()throws Exception
	{
		System.out.println("\n**** DES Cipher ****\n");
	
	KeyGenerator Mygenerator =KeyGenerator.getInstance("DES");
	SecretKey myDesKey = Mygenerator.generateKey();
	
	Cipher desCipher = Cipher.getInstance("DES");
	
	desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
	
	String str=OpenFile.pickFile();
	
	byte[] mybytes = str.getBytes();
	
    String s1=new String(mybytes);
	System.out.println("Before Encryption:-");
    System.out.println(s1);
	
	byte[] myEncryptedBytes = desCipher.doFinal(mybytes);
	
    s1=new String(myEncryptedBytes);
    
    JOptionPane.showMessageDialog(null,"Encrypted Message "+"\n"+s1);
    
	System.out.println("\nAfter Encryption:-");
    System.out.println(s1);
	
	
    desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
	
	
	byte[] mydecryptedBytes = desCipher.doFinal(myEncryptedBytes);
	
	String s = new String(mydecryptedBytes);
	
	 JOptionPane.showMessageDialog(null,"Decrypted Data "+"\n"+s);
	
	System.out.println("\nAfter Decryption:-");
	System.out.println(s);
	
	}
}


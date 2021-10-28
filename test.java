package Cryptography;

import java.awt.event.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;



public class test
{
	String [] items={"Caesar cipher","Transposition cipher","Vinegere cipher","DES Cipher"};
	
	JComboBox c= new JComboBox(items);
	
	JButton b= new JButton("OK");
	
	
	public test()
	{
		frame();
	}
	public void frame()
	{
		JFrame f=new JFrame();
		f.setVisible(true);
		f.setSize(400, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p=new JPanel();
		p.add(c);
		p.add(b);
		
		
		f.add(p);
		
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String s= c.getSelectedItem().toString();
				if(s.equalsIgnoreCase("Caesar cipher"))
				{
					
					Caesar.caesar();//calls caesar() method of caesar cipher algorithm
				}
				else if(s.equalsIgnoreCase("Transposition cipher"))
				{
					
					Crypto.Run();//Calls Run() method of Transposition cipher algorithm
				}
				else if(s.equalsIgnoreCase("Vinegere cipher"))
				{
					VigenereCipher.vigenere();//calls vigenere() method of vigenere cipher algorithm
				}
				else if(s.equalsIgnoreCase("DES Cipher"))
				{
					
					try {
						des_crypto.des();//Calls des() method of DES cipher algorithm
					} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
							| IllegalBlockSizeException | BadPaddingException e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});
	}
	
	public static void main(String arg[])
	{
		
		 new test();
	}
}

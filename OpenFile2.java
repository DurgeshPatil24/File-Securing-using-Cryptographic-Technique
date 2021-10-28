package Cryptography;

import java.io.File;
//import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class OpenFile2 {
	
	//JFileChooser filechooser=new JFileChooser();
	//StringBuilder sb=new StringBuilder();
	
	public static String pickFile() throws Exception
	{ 
		JFileChooser filechooser=new JFileChooser();
		StringBuilder sb=new StringBuilder();
		String Data="";
		if(filechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			File file = filechooser.getSelectedFile(); //get the file
			
			Scanner input= new Scanner(file);
			
			while(input.hasNext())
			{
				//Data+=input.nextLine();
				//System.out.println(input.nextLine());
				sb.append(input.nextLine());
				sb.append("");
			}
			input.close();
		}
		else{
			sb.append("No file was selected");
		}
		return sb.toString();
	}

}


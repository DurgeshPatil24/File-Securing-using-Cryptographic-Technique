package Cryptography;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Crypto {

	public static void main(String arg[]) throws Exception 
	{
		Run();	
	}

	public static void Run() throws Exception 
	{
	  Scanner kb=new Scanner(System.in);

	  System.out.println("\n***** RailFenceCipher *****");
	  System.out.println();
		

	 // String clearText=JOptionPane.showInputDialog(null,"Enter message to encrypt:");
     
	  String clearText=OpenFile.pickFile();
	  
	  System.out.println("Original Text: \n\n" + clearText);
      System.out.println();
	  
	  int key=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Key value: "));
	  System.out.println("Key value: "+key);

      String cipherText = Cipher(clearText, key);
      JOptionPane.showMessageDialog(null,"Encrypted Data "+"\n"+cipherText);
      System.out.println("\nEncrypted message: \n\n"+cipherText);

      String decipherText = Decipher(cipherText, key);
      JOptionPane.showMessageDialog(null,"Decrypted Data "+"\n"+decipherText);
      System.out.println("\nDecrypted message: \n\n"+decipherText);
	}

	private static char[][] buildCleanMatrix(int rows, int cols) {

		char[][] result = new char[rows][];

		for (int row = 0; row < result.length; row++) {

			result[row] = new char[cols];
		}

		return result;
	}

  private static String buildStringFromMatrix(char[][] matrix)
  {
      String result = "";

      for (int row = 0; row < matrix.length; row++)
      {
          for (int col = 0; col < matrix[row].length; col++)
          {
              if (matrix[row][col] != '\0')
              {
                  result += matrix[row][col];
              }
          }
      }

      return result;
  }

  private static char[][] transpose(char[][] matrix)
  {
      char[][] result =
          buildCleanMatrix(matrix[0].length, matrix.length);

      for (int row = 0; row < matrix.length; row++)
      {
          for (int col = 0; col < matrix[row].length; col++)
          {
              result[col][row] = matrix[row][col];
          }
      }

      return result;
  }

	private static String Cipher(String clearText, int key) {

      String result = "";

      char[][] matrix = buildCleanMatrix(key, clearText.length());

      int rowIncrement = 1;
      for (int row = 0, col = 0; col < matrix[row].length; col++) {

      	if (
      		row + rowIncrement == matrix.length ||
      		row + rowIncrement == -1
  			)
      	{
      		rowIncrement *= -1;
      	}

      	matrix[row][col] = clearText.charAt(col);

      	row += rowIncrement;
      }

      result = buildStringFromMatrix(matrix);

      return result;
	}

	private static String Decipher(String cipherText, int key) {

      String result = "";

      char[][] matrix = buildCleanMatrix(key, cipherText.length());

      int rowIncrement = 1;
      int textIdx = 0;

      for (
      	int selectedRow = 0;
      	selectedRow < matrix.length;
      	selectedRow++
  		)
      {
      	for (
      		int row = 0, col = 0;
      		col < matrix[row].length;
      		col++
  			)
      	{
      		if (
      			row + rowIncrement == matrix.length ||
      			row + rowIncrement == -1
  				)
      		{
      			rowIncrement *= -1;
      		}

      		if (row == selectedRow) {

      			matrix[row][col] = cipherText.charAt(textIdx++);
      		}

      		row += rowIncrement;
      	}
      }

      matrix = transpose(matrix);
      result = buildStringFromMatrix(matrix);

      return result;
	}
}
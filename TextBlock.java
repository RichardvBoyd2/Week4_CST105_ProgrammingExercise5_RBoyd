/** Program: TextBlock
 * File: TextBlock.java
 * Summary: Reads .txt into 20x45 array, then outputs the columns of the array in a string
 * Author: Richard Boyd
 * Date: December 24th, 2017
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
public class TextBlock {

	public static void main(String[] args) throws IOException {
		String[][] block = new String[20][45];  //creates 2D array and fills it with "@"
		for (String[] row : block)
			Arrays.fill(row, "@");
		String input = new String(Files.readAllBytes(Paths.get("input.txt")));  //reads the .txt file into a string
		String[] split = input.split(""); //splits .txt into characters
		int length = split.length;
		int splitCount = 0, rowCount = 0, colCount = 0, mixCount =0;
		
		while (rowCount != 20) {  //loop fills each spot in 2D array with characters from .txt
			while (colCount != 45 && splitCount != length) {
				block[rowCount][colCount] = split[splitCount];
				colCount++;
				splitCount++;
			}
			colCount = 0;
			rowCount++;
		}
		
		rowCount = 0;  //sets up for the next loop
		String[] mix = new String[900];
		String out = new String();
		
		while (colCount != 45) {  //loop that fills new 1D array with characters from 2D array in a new order 
			while (rowCount !=20) {
				mix[mixCount] = block[rowCount][colCount];
				rowCount++;
				mixCount++;
			}
			rowCount = 0;
			colCount++;
		}
		
		mixCount = 0;  //sets up for the next loop
		out = mix[mixCount];
		mixCount++;
		
		while (mixCount != 900) {  //loop that turns 1D array into one single string
			out = out + mix[mixCount];
			mixCount++;
		}
		
		System.out.println(out);  //prints final string
	}
}

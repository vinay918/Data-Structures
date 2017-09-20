/**
 * The purpose of this class is to abstract the writing of information to flat files
 * The fileWrite method takes in 2 arguments, the fileName and content both as strings
 * and writed the data to flat files accordingly.
 * @author Vinay
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Writer {
	
	/**
	 * Method that takes in a fileName and content, and writes that content to a file that is named according to fileName
	 * This method specifically writes it to the specified directory as the first input argument
	 * @author Vinay
	 */
	public static void fileWrite(String mainDirectory, String fileName, String content){

		try {
			fileName=fileName.trim().replaceAll(" +", " ");
			fileName=fileName.trim().replaceAll(" +", " ");
			fileName=fileName.replaceAll("(\\r|\\n)", " ");
			fileName=fileName+".txt";
			content=content.trim().replaceAll(" +", " ");
			System.out.println(fileName);
			BufferedWriter writer = new BufferedWriter(new FileWriter(mainDirectory+fileName+".txt",true)); 
			writer.write(content);
			writer.newLine();
			writer.close();
		}catch (IOException e) {
			System.out.println(fileName);
			Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, e);
		}
	
	}
	
	/**
	 * Same as the other fileWrite method in taking in a fileName and content but this also allows you to write 
	 * the data to a text file within a directory.
	 * For example, if you would like to write to file 'text.txt' in a non-existent directory 'Bachman' within a non-existent 
	 * directory 'CSCE 155N', all withing your User directory in your C drive, you would call the method in the following way: 
	 * fileWrite("C:\\User\\","fileName","something to write","CSCE 155N","Bachman");
	 * Note: the method also works for pre-existing directories
	 */
	public static void fileWrite(String mainDirectory, String fileName, String content, String directoryGroup, String directoryAuthor){

		File directory = new File(directoryGroup);
		if (! directory.exists()){
		directory.mkdir();
		}
		File innerDirectory = new File(directoryGroup+"/"+directoryAuthor);
		if (! innerDirectory.exists()){
        innerDirectory.mkdir();
		}
	
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(mainDirectory+directoryGroup+"/"+directoryAuthor+"/"+fileName+".txt",true));
			writer.write(content);
			writer.newLine();
			writer.close();
		}catch (IOException e) {
			Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, e);
		}
	
	}

	
}

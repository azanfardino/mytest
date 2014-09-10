package test.file.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import test.file.FileManagerException;
import test.file.FileManagerInterface;

public class FileManagerImpl implements FileManagerInterface{
	
	File file;
	
	public FileManagerImpl(String path) {
		file = new File(path);
	}
	
	

	public void writeFile(String content) throws FileManagerException{
		try {

			if (!file.exists()) {
				
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(content);
			
			bw.close();			
			
			System.out.println("Content successfull write on file : " + file.getAbsolutePath());
 
		} catch (IOException e) {
			throw new FileManagerException("Error writing file ", e);
		}
		
	}

}

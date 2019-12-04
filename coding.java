package TextEditor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;


public class coding 
{
	JFileChooser fileChooser = new JFileChooser() ; 
	StringBuilder sb = new StringBuilder() ; 
	
	public void fileReader() throws Exception
	{
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			java.io.File file = fileChooser.getSelectedFile();
			Scanner input = new Scanner(file);
			BufferedReader br = null;
			
			while(input.hasNext())
			{
				sb.append(input.nextLine());
				sb.append("\n") ; 
			}
			input.close();
			
			String st = ""; 
		    try {
				while ((st = br.readLine()) != null) 
				{
					st += st + "\n";
				}
			} 
		    catch (IOException e) 
		    {
				e.printStackTrace();
			}
		    
		}
		else
		{
			sb.append("No file was selected") ; 
		}
		
	} 
	
	
}


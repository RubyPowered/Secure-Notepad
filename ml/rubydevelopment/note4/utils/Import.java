package ml.rubydevelopment.note4.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class Import {

	File file;
	int response;
	
	JFileChooser chooser = new JFileChooser();
	
	
	
	public Import(JTextArea area) throws IOException {
		response = chooser.showOpenDialog(null);
		
		if(response==chooser.APPROVE_OPTION) {
			this.file = chooser.getSelectedFile();
		}
		
		Scanner scanner = new Scanner(file);
		
		while(scanner.hasNextLine()) {
			String scanned = scanner.nextLine();
			area.append(scanned);
		}
		
		
	}
	public static void headlessImport(File fileToImport, JTextArea area) throws IOException{
		Scanner scanner = new Scanner(fileToImport);

		while(scanner.hasNextLine()) {
			String scanned = scanner.nextLine();
			area.append(scanned);
		}
	}
	
	
}

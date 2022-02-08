package ml.rubydevelopment.note4.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class Export {
	
	JFileChooser chooser = new JFileChooser();
	
	File file;
	int response;
	
	public Export(JTextArea area) throws IOException {
		
		response = chooser.showOpenDialog(null);
		
		chooser.setApproveButtonText("Save");
		
		if(response==chooser.APPROVE_OPTION) {
			this.file = chooser.getSelectedFile();
		}
		
		Scanner scanner = new Scanner(area.getText());
		FileWriter writer = new FileWriter(file);
		
		while(scanner.hasNextLine()) {
			String scanned = scanner.nextLine();
			System.out.println(scanned);
			writer.append(scanned.toString());
		}
		writer.flush();
		writer.close();
		
	}
	
}

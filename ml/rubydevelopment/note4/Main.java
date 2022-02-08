package ml.rubydevelopment.note4;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ml.rubydevelopment.note4.gui.MainWindow;
import ml.rubydevelopment.note4.utils.Import;

import java.io.File;
import java.io.IOException;

public class Main {

	public static String arguments;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(args.length==0){
			System.out.println("Nothing to import");
		}else{
			System.out.println("Attempting import of file");
			arguments  = args[0];
			try{
				Import.headlessImport(new File(arguments), MainWindow.area);
			}catch(IOException e){e.printStackTrace();}
		}

		System.out.println(args.length);
		new MainWindow();
	}

}

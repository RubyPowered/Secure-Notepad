package ml.rubydevelopment.note4.gui;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

import ml.rubydevelopment.note4.utils.Export;
import ml.rubydevelopment.note4.utils.Import;

public class MainWindow extends JFrame implements ActionListener{

	private JPanel p = new JPanel();
	
	public static JTextArea area = new JTextArea();
	private JScrollPane spane = new JScrollPane(area);
	
	private JButton up = new JButton("++");
	private JButton down = new JButton("-- --");
	private JButton apply = new JButton("Apply");
	
	private JButton imports = new JButton("Import");
	private JButton export = new JButton("Export");
	
	private TextField size = new TextField("12");
	private TextField font = new TextField("Arial");
	private TextField style = new TextField("plain");
	
	public MainWindow() {
		super("Ruby Development Notepad+");
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(1000,700);
		this.setResizable(false);
		this.setDefaultCloseOperation(3);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		p.setVisible(true);
		p.setLayout(null);
		p.setBounds(0, 0, 1000, 45);
		p.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		
		spane.setVisible(true);
		spane.setBounds(0, 45, 1000, 615);
		
		area.setFont(new Font("Arial", Font.PLAIN, 12));
		area.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		up.setVisible(true);
		up.setFocusable(false);
		up.addActionListener(this);
		up.setBounds(215, 7, 100, 30);
		
		down.setVisible(true);
		down.setFocusable(false);
		down.addActionListener(this);
		down.setBounds(325, 7, 100, 30);
		
		imports.setVisible(true);
		imports.setFocusable(false);
		imports.addActionListener(this);
		imports.setBounds(560, 7, 100, 30);
		
		export.setVisible(true);
		export.setFocusable(false);
		export.addActionListener(this);
		export.setBounds(670, 7, 100, 30);
		
		apply.setVisible(true);
		apply.setFocusable(false);
		apply.addActionListener(this);
		apply.setBounds(435, 7, 100, 30);
		
		font.setVisible(true);
		font.setBounds(10, 7, 100, 30);
		
		size.setVisible(true);
		size.setBounds(110, 7, 100, 30);
		
		this.add(p);
		this.add(spane);
		
		p.add(up);
		p.add(down);
		p.add(font);
		p.add(size);
		p.add(apply);
		p.add(imports);
		p.add(export);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==imports) {
			try {
				new Import(area);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(area, "Hmm... This file doesn't appear to be a file containing text!", e1.toString(), JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}
		if(e.getSource()==export) {
			try {
				new Export(area);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==up) {
			int s = Integer.parseInt(size.getText());
			size.setText(String.valueOf(s+=2));
		}
		if(e.getSource()==down) {
			int s = Integer.parseInt(size.getText());
			size.setText(String.valueOf(s-=2));
		}
		if(e.getSource()==apply) {
			String f = font.getText();
			int s = Integer.parseInt(size.getText());
			area.setFont(new Font(f, Font.PLAIN, s));
		}
		
	}

}

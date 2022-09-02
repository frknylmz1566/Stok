package Controller;

import java.awt.*;


import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Command.GeneralAction;
import Command.StokDeleteCommand;
import Command.StokGetData;
import Command.StokSaveCommand;
import Command.StokSearchCommand;
import Command.StokUpdateCommand;
import Model.stockModel;
import View.GUI;

public class stockController {
	GUI frame;
		
	public void setListener() {
		frame.btnEkle.addActionListener(new GeneralAction(new StokSaveCommand(frame)));
		frame.btnSil.addActionListener(new GeneralAction(new StokDeleteCommand(frame)));
		frame.btnGüncelle.addActionListener(new GeneralAction(new StokUpdateCommand(frame)));
		frame.btnAra.addActionListener(new GeneralAction(new StokSearchCommand(frame)));
		frame.btnGetData.addActionListener(new GeneralAction(new StokGetData(frame)));
	}
	public void execute() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new GUI();			
					setListener();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
		
		
	}
}

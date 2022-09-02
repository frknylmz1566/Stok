package View;


import Controller.stockController;
import Model.stockModel;

import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;



public class GUI extends JFrame {

	stockModel stockmodel;
	public JPanel contentPane;				
	public JTextField TF_Stok_Kodu;
	public JTextField TF_Stok_Adi;
	public JTextField TF_Barkod;
	public JTable table;
	public JTextField TF_Ara;
	public JButton btnEkle;
	public JButton btnSil;
	public JComboBox CB_Stok_Tipi;
	public JComboBox CB_Stok_Birim;
	public JComboBox CB_Kdv_Tipi;
	public JTextArea TA_Aciklama;
	public JFormattedTextField FTF_Tarih;
	public JButton btnGüncelle;
	public JButton btnAra;
	public JButton btnGetData;
	
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		    
		
		JLabel lblNewLabel = new JLabel("Stok Kodu");
		
		TF_Stok_Kodu = new JTextField();
		TF_Stok_Kodu.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Stok Adı");
		
		TF_Stok_Adi = new JTextField();
		TF_Stok_Adi.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Stok Tipi");
		
		JLabel lblNewLabel_3 = new JLabel("Stok Birim");
		
		JLabel lblNewLabel_4 = new JLabel("Barkod");
		
		TF_Barkod = new JTextField();
		TF_Barkod.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Kdv");
		
		JLabel lblNewLabel_6 = new JLabel("Açıklama");
		
		JLabel lblNewLabel_7 = new JLabel("Tarih");
		
		
		
		
	    CB_Stok_Tipi = new JComboBox();
		CB_Stok_Tipi.setModel(new DefaultComboBoxModel(new String[] {"11", "12", "13", "14", "15"}));
		
		 CB_Stok_Birim = new JComboBox();
		CB_Stok_Birim.setModel(new DefaultComboBoxModel(new String[] {"Birim1", "Birim2", "Birim3", "Birim4"}));
		
		 CB_Kdv_Tipi = new JComboBox();
		CB_Kdv_Tipi.setModel(new DefaultComboBoxModel(new String[] {"08", "18", "30"}));
		
		TA_Aciklama = new JTextArea();
		FTF_Tarih = new JFormattedTextField();
		
		
		table = new JTable();
		
								
		btnEkle = new JButton("Ekle");			
		btnSil = new JButton("Sil");
				
		
		btnGetData = new JButton("Get Data");
		
		
		btnGüncelle = new JButton("Güncelle");
		
		
		TF_Ara = new JTextField();	
		
		btnAra = new JButton("Ara");
					
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_6)
						.addComponent(lblNewLabel_7))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnGüncelle, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnEkle, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSil, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
						.addComponent(CB_Kdv_Tipi, 0, 194, Short.MAX_VALUE)
						.addComponent(TF_Barkod, 194, 194, Short.MAX_VALUE)
						.addComponent(CB_Stok_Birim, 0, 194, Short.MAX_VALUE)
						.addComponent(CB_Stok_Tipi, 0, 194, Short.MAX_VALUE)
						.addComponent(TF_Stok_Adi, 194, 194, Short.MAX_VALUE)
						.addComponent(TF_Stok_Kodu, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
						.addComponent(FTF_Tarih, 194, 194, Short.MAX_VALUE)
						.addComponent(TA_Aciklama, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(table, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(TF_Ara, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAra, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
							.addComponent(btnGetData)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(10))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(TF_Stok_Kodu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(TF_Stok_Adi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(CB_Stok_Tipi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(CB_Stok_Birim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(TF_Barkod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5)
								.addComponent(CB_Kdv_Tipi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_6)
								.addComponent(TA_Aciklama, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_7)
								.addComponent(FTF_Tarih, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnEkle, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSil, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
							.addGap(8)
							.addComponent(btnGüncelle, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addComponent(table, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(TF_Ara, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
						.addComponent(btnAra, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(btnGetData, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
					.addGap(73))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

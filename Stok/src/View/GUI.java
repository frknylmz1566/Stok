package View;


import Controller.stockController;

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

	private JPanel contentPane;				
	private JTextField TF_Stok_Kodu;
	private JTextField TF_Stok_Adi;
	private JTextField TF_Barkod;
	private JTable table;
	
	
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
	    stockController<?> controller = new stockController();
		
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
		
		
		
		
		JComboBox CB_Stok_Tipi = new JComboBox();
		CB_Stok_Tipi.setModel(new DefaultComboBoxModel(new String[] {"11", "12", "13", "14", "15"}));
		
		JComboBox CB_Stok_Birim = new JComboBox();
		CB_Stok_Birim.setModel(new DefaultComboBoxModel(new String[] {"Birim1", "Birim2", "Birim3", "Birim4"}));
		
		JComboBox CB_Kdv_Tipi = new JComboBox();
		CB_Kdv_Tipi.setModel(new DefaultComboBoxModel(new String[] {"08", "18", "30"}));
		
		JTextArea TA_Aciklama = new JTextArea();
		JFormattedTextField FTF_Tarih = new JFormattedTextField();
		
		table = new JTable();
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.DataWrite(table,TF_Stok_Kodu,TF_Stok_Adi,CB_Stok_Tipi,CB_Stok_Birim,TF_Barkod,CB_Kdv_Tipi,TA_Aciklama,FTF_Tarih);
			}
		});
		
		JButton btn_Ekle = new JButton("Ekle");
		btn_Ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {						
				 controller.Add(
						 TF_Stok_Kodu.getText(),
						 TF_Stok_Adi.getText(),
						 Integer.parseInt(CB_Stok_Tipi.getSelectedItem().toString()),
						 CB_Stok_Birim.getSelectedItem().toString(),
						 TF_Barkod.getText(),
						 Double.parseDouble(CB_Kdv_Tipi.getSelectedItem().toString()),
						 TA_Aciklama.getText(),
						 FTF_Tarih.getText()
						);								 		 				
			}
			
		});
		
		
		JButton btn_Sil = new JButton("Sil");
		btn_Sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.Delete(TF_Stok_Kodu.getText());
				
			}
		});
		
	
		
		
		JButton btn_Get_Data = new JButton("Get Data");
		btn_Get_Data.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				model.setColumnCount(0);
				controller.GetData(table);	
				
			}
		});
		
		JButton btnNewButton = new JButton("Güncelle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Update(TF_Stok_Kodu,TF_Stok_Adi,CB_Stok_Tipi,CB_Stok_Birim,TF_Barkod,CB_Kdv_Tipi,TA_Aciklama,FTF_Tarih);
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
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
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btn_Ekle, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btn_Sil, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
								.addComponent(CB_Kdv_Tipi, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(TF_Barkod)
								.addComponent(CB_Stok_Birim, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(CB_Stok_Tipi, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(TF_Stok_Adi)
								.addComponent(TF_Stok_Kodu, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
								.addComponent(FTF_Tarih)
								.addComponent(TA_Aciklama))
							.addGap(31)
							.addComponent(table, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE))
						.addComponent(btn_Get_Data, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
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
								.addComponent(btn_Ekle, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_Sil, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
							.addGap(8)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btn_Get_Data, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

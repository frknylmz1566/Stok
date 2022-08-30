package Controller;

import java.awt.*;


import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.stockModel;
import View.GUI;

public class stockController<E> {
	
	public static void main(String[] args) {
					    	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});				
		}
	
	public void Add(String stok_Kodu,String stok_Adi,Integer stok_Tipi,String stok_Birim,String stok_Barkod,Double kdv_Tipi,String aciklama,String tarih) {	
		stockModel<E> model= new stockModel<>();
		model.set_stokKodu(stok_Kodu);
		model.set_StokAdi(stok_Adi);
		model.set_stokTipi(stok_Tipi);
		model.set_birim(stok_Birim);
		model.set_barkod(stok_Barkod);
		model.set_kdvTipi(kdv_Tipi);
		model.set_aciklama(aciklama);
		model.set_tarih(tarih);
	    model.DataAdd(model.get_stokKodu(), model.get_StokAdi(),model.get_stokTipi(),model.get_birim(),model.get_barkod(),model.get_kdvTipi(),model.get_aciklama(),model.get_tarih());
		
	}
	public void Delete(String stok_Kodu) {
		stockModel<E> model= new stockModel<>();
		model.set_stokKodu(stok_Kodu);
		model.DataDelete(model.get_stokKodu());
		
		
	}	
	public void Update(JTextField tf_stokKodu,JTextField tf_stokAdi,JComboBox<E> cb_stokTipi,JComboBox<E> cb_stokBirim,JTextField tf_barkod,JComboBox<E> cb_kdvTipi,JTextArea ta_aciklama,JFormattedTextField ft_tarih) {
		stockModel<E> model = new stockModel<>();
		model.set_stokKodu(tf_stokKodu.getText());
		model.set_StokAdi(tf_stokAdi.getText());
		model.set_stokTipi(Integer.parseInt(cb_stokTipi.getSelectedItem().toString()));
		model.set_birim(cb_stokBirim.getSelectedItem().toString());
		model.set_barkod(tf_barkod.getText());
		model.set_kdvTipi(Double.parseDouble(cb_kdvTipi.getSelectedItem().toString()));
		model.set_aciklama(ta_aciklama.getText());
		model.set_tarih(ft_tarih.getText());
		
		model.DataUpdate(model.get_stokKodu(), model.get_StokAdi(),model.get_stokTipi(),model.get_birim(),model.get_barkod(),model.get_kdvTipi(),model.get_aciklama(),model.get_tarih());
	}
	public void GetData(JTable table) {
		stockModel<E> model= new stockModel<>();
		model.GetData(table);
						
	}
	public void DataWrite(JTable table,JTextField tf_stokKodu,JTextField tf_stokAdi,JComboBox<E> cb_stokTipi,JComboBox<E> cb_stokBirim,JTextField tf_barkod,JComboBox<E> cb_kdvTipi,JTextArea ta_aciklama,JFormattedTextField ft_tarih) {		
		DefaultTableModel tablemodel=(DefaultTableModel) table.getModel();
		int selectedRowindex=table.getSelectedRow();
		

		tf_stokKodu.setText(tablemodel.getValueAt(selectedRowindex,0).toString());
		tf_stokAdi.setText(tablemodel.getValueAt(selectedRowindex,1).toString());
		cb_stokTipi.getModel().setSelectedItem(tablemodel.getValueAt(selectedRowindex,2).toString());
		cb_stokBirim.getModel().setSelectedItem(tablemodel.getValueAt(selectedRowindex,3).toString());
		tf_barkod.setText(tablemodel.getValueAt(selectedRowindex,4).toString());
		cb_kdvTipi.getModel().setSelectedItem(tablemodel.getValueAt(selectedRowindex,5).toString());
		ta_aciklama.setText(tablemodel.getValueAt(selectedRowindex,6).toString());
		ft_tarih.setText(tablemodel.getValueAt(selectedRowindex, 7).toString());
					
	}
	
}

package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import View.GUI;

public class DBConnect {
	public GUI gui;
    public void Connection(String sql) {
    	try  {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stok","root","1234");			
			PreparedStatement statement=connection.prepareStatement(sql);
			
			statement.executeUpdate();
			statement.close();
			connection.close();
			
		    System.out.println("Database connected!");
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
    }
    
    public void TableConnection(String sql) {
        gui = new GUI();    
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stok","root","1234");		
			java.sql.Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
			DefaultTableModel tablemodel= (DefaultTableModel) gui.table.getModel();	
		
			
			int cols=rsmd.getColumnCount();
			String[] colName=new String[cols];	
			for(int i=0;i<cols;i++) {
			  colName[i]=rsmd.getColumnName(i+1);					
			}
			tablemodel.setColumnIdentifiers(colName);
			
			String skodu,sadi,stipi,birim,barkod,kdv,aciklama,tarih;
			while(rs.next()) {
				
				skodu=rs.getString(1);
				sadi=rs.getString(2);
				stipi=rs.getString(3);
				birim=rs.getString(4);
				barkod=rs.getString(5);
				kdv=rs.getString(6);
				aciklama=rs.getString(7);
				tarih=rs.getString(8);
				String row[]= {skodu,sadi,stipi,birim,barkod,kdv,aciklama,tarih};	
				
				tablemodel.addRow(row);
				
			}
			
			System.out.println("Connected");					
			st.close();
			connection.close();
			
		} catch (SQLException e) {
			System.out.println("hata");
			e.printStackTrace();
		}
		
		
    	
    }
}

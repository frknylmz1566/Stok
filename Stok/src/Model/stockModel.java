package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;



import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

public class stockModel<E> {
	
	private String _stokKodu;
	private String _stokAdi;
	private Integer _stokTipi;
	private String _birim;
	private String _barkod;
	private Double _kdvTipi; 
	private String _aciklama;
	private String _tarih;
	
	public String get_stokKodu() {
		return _stokKodu;
	}
	public void set_stokKodu(String _stokKodu) {
		this._stokKodu = _stokKodu;
	}
	public String get_StokAdi() {
		return _stokAdi;
	}
	public void set_StokAdi(String _stokAdi) {
		this._stokAdi = _stokAdi;
	}
	public Integer get_stokTipi() {
		return _stokTipi;
	}
	public void set_stokTipi(Integer _stokTipi) {
		this._stokTipi = _stokTipi;
	}
	public String get_birim() {
		return _birim;
	}
	public void set_birim(String _birim) {
		this._birim = _birim;
	}
	public String get_barkod() {
		return _barkod;
	}
	public void set_barkod(String _barkod) {
		this._barkod = _barkod;
	}
	public Double get_kdvTipi() {
		return _kdvTipi;
	}
	public void set_kdvTipi(Double _kdvTipi) {
		this._kdvTipi = _kdvTipi;
	}
	public String get_aciklama() {
		return _aciklama;
	}
	public void set_aciklama(String _aciklama) {
		this._aciklama = _aciklama;
	}
	public String get_tarih() {
		return _tarih;
	}
	public void set_tarih(String tarih) {
		this._tarih = tarih;
	}	
	public void DataAdd(String stok_Kodu,String stok_Adi,Integer stok_Tipi,String stok_Birim,String stok_Barkod,Double kdv_Tipi,String aciklama,String tarih ) {
		
		String sql="INSERT INTO stokkarti (Stok_Kodu,Stok_Adi,Stok_Tipi,Birim,Barkod,KdvTipi,Aciklama,Olusturma_Tarih) values ('"+stok_Kodu+"','"+stok_Adi+"','"+stok_Tipi+"','"+stok_Birim+"','"+stok_Barkod+"','"+kdv_Tipi+"','"+aciklama+"','"+tarih+"')";		
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
	public void DataDelete(String stok_Kodu) {
		String sql="DELETE from stokkarti where Stok_Kodu='"+stok_Kodu+"'";
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
	public void DataUpdate(String stok_Kodu,String stok_Adi,Integer stok_Tipi,String stok_Birim,String stok_Barkod,Double kdv_Tipi,String aciklama,String tarih ) {
		String sql="Update stokkarti set  Stok_Kodu='"+stok_Kodu+"', Stok_Adi='"+stok_Adi+"',Stok_Tipi='"+stok_Tipi+"',"
				+ "Birim='"+stok_Birim+"',Barkod='"+stok_Barkod+"',KdvTipi='"+kdv_Tipi+"',"
				+ " Aciklama='"+aciklama+"',Olusturma_Tarih='"+tarih+"'"
				+ "where Stok_Kodu= '"+stok_Kodu+"'";
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
	public void GetData(JTable table) {
		String sql="select * from stokkarti order by Stok_Kodu asc";
		
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stok","root","1234");		
			java.sql.Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
			DefaultTableModel tablemodel= (DefaultTableModel) table.getModel();	
		       
			
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
			
			
			st.close();
			connection.close();
			
		} catch (SQLException e) {
			System.out.println("hata");
			e.printStackTrace();
		}
	}
	
}

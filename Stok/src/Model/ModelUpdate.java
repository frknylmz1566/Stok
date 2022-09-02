package Model;

public class ModelUpdate implements IModel {
	public stockModel model;
	public DBConnect Connection;
	
	public ModelUpdate(stockModel model) {
		this.model=model;
	}
	
	@Override
	public void ModelWritter() {
					
		String sql="Update stokkarti set  Stok_Kodu='"+model.get_stokKodu()+"', Stok_Adi='"+model.get_StokAdi()+"',Stok_Tipi='"+model.get_stokTipi()+"',"
				+ "Birim='"+model.get_birim()+"',Barkod='"+model.get_barkod()+"',KdvTipi='"+model.get_kdvTipi()+"',"
				+ " Aciklama='"+model.get_aciklama()+"',Olusturma_Tarih='"+model.get_tarih()+"'"
				+ "where Stok_Kodu= '"+model.get_stokKodu()+"'";	
		Connection = new DBConnect();
    	Connection.Connection(sql);
		
	}

}

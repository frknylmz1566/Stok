package Model;

public class ModelAdd implements IModel {
	public stockModel model;
	public DBConnect Connection;
	
	public ModelAdd(stockModel model) {
		this.model=model;
	}
	@Override
	public void ModelWritter() {
					
		String sql="INSERT INTO stokkarti (Stok_Kodu,Stok_Adi,Stok_Tipi,Birim,Barkod,KdvTipi,Aciklama,Olusturma_Tarih) values "
    			+ "('"+model.get_stokKodu()+"','"+model.get_StokAdi()+"','"+model.get_stokTipi()+"','"+model.get_birim()+"','"+model.get_barkod()+"','"+model.get_kdvTipi()+"','"+model.get_aciklama()+"','"+model.get_tarih()+"')";	       
    	Connection = new DBConnect();
    	Connection.Connection(sql);
		
	}

}

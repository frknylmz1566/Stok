package Model;

public class ModelDelete implements IModel {
	public stockModel model;
	public DBConnect Connection;
	
	public ModelDelete(stockModel model) {
		this.model=model;
	}
	@Override
	public void ModelWritter() {
					
		String sql="DELETE from stokkarti where Stok_Kodu='"+model.get_stokKodu()+"'";		
		Connection = new DBConnect();
    	Connection.Connection(sql);
		
	}

}

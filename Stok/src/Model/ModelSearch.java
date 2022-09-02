package Model;

public class ModelSearch implements IModel {
	public stockModel model;
	public DBConnect Connection;
	
	public ModelSearch(stockModel model) {
		this.model=model;
	}

	@Override
	public void ModelWritter() {
		String sql="select * from stokkarti where Stok_Kodu='"+model.get_stokKodu()+"'";		
		Connection = new DBConnect();
    	Connection.TableConnection(sql);
	}

}

package Model;

public class ModelGetData implements IModel {
	public stockModel model;
	public DBConnect Connection;
	
	public ModelGetData(stockModel model) {
		this.model=model;
	}

	@Override
	public void ModelWritter() {
		String sql="select * from stokkarti";
		Connection = new DBConnect();
		Connection.Connection(sql);
		
	}
}

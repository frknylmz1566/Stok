package Model;

public class ModelAction implements IModel{
	public IModel model;
	public ModelAction(IModel model) {
		this.model=model;
	}
	@Override
	public void ModelWritter() {
		model.ModelWritter();
		
	}

}

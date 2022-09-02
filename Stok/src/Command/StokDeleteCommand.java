package Command;

import Model.ModelDelete;
import Model.stockModel;
import View.GUI;

public class StokDeleteCommand implements ICommand {
	public GUI gui;
	public stockModel model;
	public ModelDelete delete;
	public StokDeleteCommand(GUI gui) {
		this.gui=gui;
	}
	
	public void execute() {	
		delete = new ModelDelete(new stockModel(gui.TF_Stok_Kodu.getText()));
		delete.ModelWritter();
	}
	
}

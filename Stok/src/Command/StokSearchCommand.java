package Command;

import Model.ModelSearch;
import Model.ModelUpdate;
import Model.stockModel;
import View.GUI;

public class StokSearchCommand implements ICommand {
	
	public GUI gui;
	public stockModel model;
	public ModelSearch search;
	public StokSearchCommand(GUI gui) {
		this.gui=gui;
	}

	@Override
	public void execute() {		
		search = new ModelSearch(new stockModel(gui.TF_Ara.getText().toString()));
		search.ModelWritter();
		
	}

}

package Command;

import Model.ModelAdd;
import Model.stockModel;
import View.GUI;

public class StokSaveCommand implements ICommand{
	public GUI gui;
	public stockModel model;
	public ModelAdd add;
	public StokSaveCommand(GUI gui) {
		this.gui=gui;
	}
	
	@Override
	public void execute() {				
		add= new ModelAdd(new stockModel(gui.TF_Stok_Kodu.getText(),
				gui.TF_Stok_Adi.getText(),
				Integer.parseInt(gui.CB_Stok_Tipi.getSelectedItem().toString()),
				gui.CB_Stok_Birim.getSelectedItem().toString(),	
				gui.TF_Barkod.getText(),
				Double.parseDouble(gui.CB_Kdv_Tipi.getSelectedItem().toString()),
				gui.TA_Aciklama.getText(),
				gui.FTF_Tarih.getText()));
	    add.ModelWritter();
		
	}
    
}


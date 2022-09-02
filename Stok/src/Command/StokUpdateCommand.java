package Command;


import Model.ModelUpdate;
import Model.stockModel;
import View.GUI;

public class StokUpdateCommand implements ICommand {
	public GUI gui;
	public stockModel model;
	public ModelUpdate update;
	public StokUpdateCommand(GUI gui) {
		this.gui=gui;
	}
	@Override
	public void execute() {		
		update = new ModelUpdate(new stockModel(gui.TF_Stok_Kodu.getText(),
				gui.TF_Stok_Adi.getText(),
				Integer.parseInt(gui.CB_Stok_Tipi.getSelectedItem().toString()),
				gui.CB_Stok_Birim.getSelectedItem().toString(),	
				gui.TF_Barkod.getText(),
				Double.parseDouble(gui.CB_Kdv_Tipi.getSelectedItem().toString()),
				gui.TA_Aciklama.getText(),
				gui.FTF_Tarih.getText()));
		update.ModelWritter();
		
	}
	

}

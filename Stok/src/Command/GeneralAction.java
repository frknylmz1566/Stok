package Command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralAction implements ActionListener{
    private ICommand command;
    
    public GeneralAction( ICommand command) {
    	this.command=command;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		command.execute();
		
	}

}

package Client.Design.maindesigncomponents;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Client.Core.socket.SendMessage;
import Client.Core.GameController;

public class Yellowbtn extends JButton {
	
	private Brush brush;
	
	public Yellowbtn(){
		setBounds(242, 415, 48, 40);
		setBackground(Color.YELLOW);
	}
	private void makeEvent() {
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GameController.turnflag==true) {
					SendMessage.send.println("Color:YELLOW");
					SendMessage.send.flush();
					brush.setColor(Color.YELLOW);
				}
			}
		});
	}
	
	public void setBrush(Brush brush) {
		this.brush = brush;
		makeEvent();
	}
}
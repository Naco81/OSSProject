package Client.Design.maindesigncomponents;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Client.Core.socket.SendMessage;
import Client.Core.GameController;

public class Eraserbtn extends JButton {
	
	private Brush brush;
	
	public Eraserbtn(){
		super("지우개");
		setBounds(360, 415, 60, 40);
		setFont(getFont().deriveFont(8.4f));
		setBackground(Color.WHITE);
	}
	private void makeEvent() {
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GameController.turnflag==true) {
					SendMessage.send.println("Color:WHITE");
					SendMessage.send.flush();
					brush.setColor(Color.WHITE);
				}
			}
		});
	}
	
	public void setBrush(Brush brush) {
		this.brush = brush;
		makeEvent();
	}
}
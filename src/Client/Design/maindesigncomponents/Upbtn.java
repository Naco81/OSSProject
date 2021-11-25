package Client.Design.maindesigncomponents;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Client.Core.socket.SendMessage;
import Client.Core.GameController;

public class Upbtn extends JButton {
	private Brush brush;
	public Upbtn(){
		super("+");
		setBounds(300, 415, 48, 20);
		setFont(getFont().deriveFont(8.4f));
		setBackground(Color.GRAY);
	}
	private void makeEvent() {
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GameController.turnflag==true) {
					SendMessage.send.println("SIZE:UP");
					SendMessage.send.flush();
				}
			}
		});
	}
	
	public void setBrush(Brush brush) {
		this.brush = brush;
		makeEvent();
	}
}
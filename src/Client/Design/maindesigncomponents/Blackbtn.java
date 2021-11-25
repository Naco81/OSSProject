package Client.Design.maindesigncomponents;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Client.Core.socket.SendMessage;
import Client.Core.GameController;

public class Blackbtn extends JButton{
	private Brush brush;
	public Blackbtn(){
		setBounds(10, 415, 48, 40);
		setBackground(Color.BLACK);
	}
	private void makeEvent() {
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GameController.turnflag==true) {
					SendMessage.send.println("Color:BLACK");
					SendMessage.send.flush();
					brush.setColor(Color.BLACK);
				}
			}
		});
	}
	
	public void setBrush(Brush brush) {
		this.brush = brush;
		makeEvent();
	}
}

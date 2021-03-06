package Client.Design.maindesigncomponents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

import Client.Core.socket.SendMessage;

public class Brush extends JLabel {

	private int x;
	private int y;
	private int size = 10;
	public boolean flag = false;
	public Color color = Color.black;

	@Override
	public void paint(Graphics g) {
		if(flag==true) {
			g.setColor(color);
			g.fillOval(x - size, y - size, size, size);
		}
		else if(flag==false) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 1000, 1000);
			flag = true;
		}
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public void setSizeUp() {
		this.size += 2;
	}
	
	public void setSizeDown() {
		this.size-= 2;
		if (this.size < 0) { this.size = 0; }
	}
}
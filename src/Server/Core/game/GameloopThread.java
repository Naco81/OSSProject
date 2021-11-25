package Server.Core.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.Timer;

import Server.Core.socket.ServerController;

public class GameloopThread extends Thread implements ActionListener {

	private JTextArea screen;
	
	Timer mTimer = new Timer(1000, this);
	int mTime = 60;
	
	@Override
	public void run() {
		super.run();
		Game game = new Game();
		String answer;
		int index = 0;
		game.start();
		GameController.firstStart();
		while(game.hasMoreAnswer()) {
			answer = game.getAnswer();
			GameController.answer = answer;
			System.out.println(answer);
			GameController.gameflag = true;
			GameController.answerflag = false;
			GameController.ID = ServerController.List.get(index).getUserID();
			GameController.allUserMsg("CHAT:[알림] " + GameController.ID +"user turn.");
			GameController.allUserMsg("CHAT:[알림] " + "제한시간은 60초입니다.");
			screen.append("[알림] " + GameController.ID +" user turn.\n");
			ServerController.List.get(index).sendMessage("SET:TRUE");
			ServerController.List.get(index).sendMessage("CHAT:[알림] " + "당신차례입니다.");
			ServerController.List.get(index).sendMessage("CHAT:[알림] " + "정답은  " + answer +" 입니다.");
			ServerController.List.get(index).sendMessage("CHAT:[알림] " + "정답을 잘 설명해보세요!!!");
			ServerController.List.get(index).sendMessage("ANSWER:"+answer);
			while(true) {
				if(GameController.answerflag == true) {
					mTime = 60;
					break;
				}
				else {
					mTimer.start();
					try {
						Thread.sleep(3000);
					} catch(InterruptedException e) {
						
					}
				}
			}
			ServerController.List.get(index).sendMessage("ANSWER:"+" ");
			GameController.allUserPermissionFalse();
			++index;
			if(index == ServerController.List.size()) {
				index = 0;
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(mTimer == arg0.getSource()) {
			mTime--;
			if(mTime == 0) {
				mTimer.stop();
				mTime = 60;
				GameController.allUserMsg("CHAT:[알림] TimeOver입니다.");
				GameController.answerflag = true;
			}
			else if(mTime % 10 == 0) {
				GameController.allUserMsg("CHAT:[알림] " + mTime + "초 남았습니다.");
			}
		}
	}
	
	public void setScreen(JTextArea screen) {
		this.screen = screen;
	}
	
}

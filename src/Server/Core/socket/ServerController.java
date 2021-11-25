package Server.Core.socket;

import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import java.util.ArrayList;

import Server.Core.User;
import Server.Core.game.Game;
import Server.Core.game.EditKeyword;
import Server.Core.game.GameController;
import Server.Core.game.GameloopThread;
import Server.Core.socket.ServerThread;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class ServerController {

	private int port = 0;
	private ServerSocket Server;
	private Socket Client;
	private User user;
	public static ArrayList<User> List;
	private JTextArea screen;
	private JTextField join;
	private JButton startbtn;
	private JButton keywordbtn;
	private Game game;
	private EditKeyword edit;
	private String answer;

	public void start() {
		if (port != 0) {
			List = new ArrayList<User>();
			makeServerSocket();
			makeClientSocket();
			StartEvent();
			EditKeyword();
			acceptClient();
		} else
			System.out.println("set server port");
	}

	public void setPort(int port) {
		this.port = port;
	}

	private void makeServerSocket() {
		try {
			Server = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void makeClientSocket() {
		Client = new Socket();
	}

	private void acceptClient() {
		while (true) {
			try {
				Client = Server.accept();
				ServerThread th = new ServerThread();
				user = new User();
				user.setSocket(Client);
				user.makeWriter();
				th.setUser(user);
				th.setJoinField(join);
				th.setScreen(screen);
				List.add(user);
				th.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void StartEvent() {
		startbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkStart()) {
					screen.append("[ERROR] 2명 이상의 사용자가 참가해야 게임을 시작할 수 있습니다.\n");
					screen.setCaretPosition(screen.getDocument().getLength());
				} 
				else {
					gamestart();
				}
			}
		});
	}
	
	private void EditKeyword() {
		keywordbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.append("Edit Keywords.\n");
				editkeywords();
			}
		});
	}

	private void editkeywords() {
		EditKeyword edit = new EditKeyword();
		edit.edit();
	}
	
	private boolean	checkStart() {
		if(List.size()>1) return false;
		else return true;
	}
	
	private void gamestart() {
		screen.append("[SERVER] Start the game.\n");
		screen.setCaretPosition(screen.getDocument().getLength());
		GameloopThread game = new GameloopThread();
		game.setScreen(screen);
		game.start();
	}
	
	public void edit() {
		edit.edit();
	}
	
	public void setScreen(JTextArea screen) {
		this.screen = screen;
	}

	public void setJoinField(JTextField join) {
		this.join = join;
	}

	public void setStartButton(JButton startbtn) {
		this.startbtn = startbtn;
	}
	
	public void setKeywordButton(JButton keywordbtn) {
		this.keywordbtn = keywordbtn;
	}
}

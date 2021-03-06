package Server;

import Server.Core.socket.ServerController;
import Server.design.MainDesign;

public class Main {
	static public void main(String[] args) {
		ServerController server = new ServerController();
		MainDesign design = new MainDesign();
		design.makeFrame();
		server.setStartButton(design.getButton());
		server.setKeywordButton(design.getKeywordButton());
		server.setJoinField(design.getJoinField());
		server.setScreen(design.getScreen());
		server.setPort(8888);
		server.start();
	}
}
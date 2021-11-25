package Server.Core.game;

//import java.util.LinkedHashMap;

import Server.Core.socket.ServerController;

public class GameController {
	static public String answer;
	static public boolean answerflag = false;
	static public boolean gameflag = false;
	static public String ID;
//	static LinkedHashMap<String, Integer> clientScore = new LinkedHashMap<String, Integer>();
	
	final static String[] CHO = {"ㄱ","ㄲ","ㄴ","ㄷ","ㄸ","ㄹ","ㅁ","ㅂ","ㅃ", "ㅅ","ㅆ","ㅇ","ㅈ","ㅉ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ"};
	static public void firstStart() {
		for (int i = 0; i < ServerController.List.size(); i++) {
			ServerController.List.get(i).sendMessage("CHAT:[SERVER] " + "게임을 시작합니다.");
			ServerController.List.get(i).sendMessage("SET:FALSE");
			ServerController.List.get(i).sendMessage("MODE:CLEAR");
			
		}
	}
	
	static public void allUserPermissionFalse() {
		for (int i = 0; i < ServerController.List.size(); i++) {
			ServerController.List.get(i).sendMessage("SET:FALSE");
			ServerController.List.get(i).sendMessage("MODE:CLEAR");
		}
	}
	
	static public void rightAnswer(String id) {
		answerflag = true;
		answer = "aaaaaaaaaaa";
		for (int i = 0; i < ServerController.List.size(); i++) {
			ServerController.List.get(i).sendMessage("CHAT:[알림] " + id +" 님이 맞추셨습니다.");
//			clientScore.put(id, clientScore.get(id) + 1); //타이머 구현 전, 시간 별 가산점 구현X
		}
			
	}
	
	static public void allUserMsg(String msg) {
		for (int i = 0; i < ServerController.List.size(); i++) {
			ServerController.List.get(i).sendMessage(msg);
		}
	}
	
	static public void showHint(String text) {
		String hint = "";
		for(int i = 0; i < text.length(); i++) { 
			char uniVal = text.charAt(i);
			if(uniVal >= 0xAC00) { 
				uniVal = (char)(uniVal - 0xAC00); 
				char cho = (char)(uniVal/28/21); 
				hint += CHO[cho];
			}
		}
		for (int i = 0; i < ServerController.List.size(); i++) {
			ServerController.List.get(i).sendMessage("CHAT:[알림] 초성힌트는 " + hint);
		}
	}
}

/*

package Server.Core.game;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Rank extends JFrame {
	
	//게임 종료 시 랭킹창 나오도록(게임 종료도 구현이 안돼있음)
	
	private JFrame frame = new JFrame();
	JButton b1 = new JButton("종료");

	public void Rank() {
		this.setLayout(new FlowLayout());
		this.add(b1);
		this.setSize(520, 500);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void rank(int sc) {
		
		// 파일에서 점수 가져와서 sc에 저장 (구현X)
		
		int[] score = new int[4];
		int[] rank = new int[4];
		
		for(int i = 0; i < 4; i++) {
			rank[i] = 1;
		}
		
		for(int i = 0; i < 4; i++) {
			score[i] = sc.nextInt();
		}
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(score[i] < score[j])
					rank[i] = rank[i] +1;
			}
		}
		
	}
}

*/
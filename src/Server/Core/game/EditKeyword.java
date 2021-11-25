package Server.Core.game;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import Server.Core.game.FileRead;

public class EditKeyword extends JFrame{
	private FileRead file = new FileRead();
	private ArrayList<String> answerList;
	private String dir = file.getDir();
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	
    public void edit() { 
    	JTextArea ta = new JTextArea(25, 28);
    	JScrollPane sp = new JScrollPane(ta);
    	JButton button = new JButton();
    	
    	file.read();
    	answerList = file.getAnswer();
    	
		button.setText("저장");
		button.setBounds(10, 415, 310, 40);
		
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO : 저장
				BufferedWriter out = null;
		          File file = new File(dir);
		          try {
		             out = new BufferedWriter(new FileWriter(file));
		             out.write(ta.getText());
		             setTitle(file.getName());
		             out.close();
		          }
		          catch(IOException e1) {
		             e1.printStackTrace();
		          }
		          JOptionPane.showMessageDialog(null, "저장되었습니다.\n게임을 다시 실행시켜주시기 바랍니다.");
			}
		};
		
		button.addActionListener(listener);
        frame.add(button);
        
        ta.setBounds(10, 10, 680, 390);
        for(String s: answerList) {
        	ta.append(s+"\n");
        }
        
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panel.add(sp);
        
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        
 		frame.setSize(350, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("키워드 편집");
    }
}
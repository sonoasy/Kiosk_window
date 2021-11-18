package kiosk_window;
import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import javax.swing.border.Border;
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.swing.ImageIcon; 
import javax.swing.JFrame;
import javax.swing.JLabel; 
import javax.swing.JPanel;

import javax.sound.sampled.AudioSystem;

import javax.sound.sampled.AudioInputStream;
public class page1 extends JFrame { //swing이 들어옴
    //키오스크 안내 자막
	public static JLabel kiosk=new JLabel();
	
	public static int takeoutchoice=0;
	public  page1() {
		
		//가격 추가하기
		
		setTitle("맥도날드 키오스크");
		setSize(1000,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(null);
     
        JLabel alarm=new JLabel("원하시는 메뉴를 터치하시거나 아래처럼 말씀해 주세요");
        alarm.setFont(new Font("고딕체", Font.BOLD, 15));
        alarm.setBounds(300,10,400,300);
        //이미지 크기 맞추기
        //매장식사 이미지
        ImageIcon setmenu=new ImageIcon("C:\\Users\\AhnSeoYeon\\Desktop\\workspace\\ch09\\src\\ch09\\setmenu.PNG");
        Image setmenuimg =setmenu.getImage();
        Image newsetmenuimg=setmenuimg.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newsetmenu=new ImageIcon(newsetmenuimg);
        JLabel setmenus=new JLabel(newsetmenu,JLabel.CENTER);
        //포장 이미지
        ImageIcon take=new ImageIcon("C:\\Users\\AhnSeoYeon\\Desktop\\workspace\\ch09\\src\\ch09\\takeout.PNG");
        Image takeoutf =take.getImage();
        Image takeoutimg=takeoutf.getScaledInstance(180, 200, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newtakeout=new ImageIcon(takeoutimg);
        JLabel takeouts=new JLabel(newtakeout,JLabel.CENTER);
        
        
        
		JButton takein=new JButton("매장에서 식사");
		takein.setLayout(new BorderLayout());
		takein.add(setmenus,BorderLayout.CENTER);
		takein.setVerticalAlignment(SwingConstants.BOTTOM);
		takein.setBounds(150,200,300,300);
		takein.setForeground(Color.RED);
        takein.setBackground(Color.WHITE);
        takein.setFont(new Font("고딕체", Font.BOLD, 25));
		takein.addActionListener(new takeoutListener());


		JButton takeout=new JButton("테이크 아웃");
		takeout.setLayout(new BorderLayout());
		takeout.add(takeouts,BorderLayout.CENTER);
		takeout.setVerticalAlignment(SwingConstants.BOTTOM);
		takeout.setBounds(500,200,300,300);
		takeout.setForeground(Color.RED);
		takeout.setBackground(Color.WHITE);
		takeout.setFont(new Font("고딕체", Font.BOLD, 25));
		takeout.addActionListener(new takeoutListener());
		
		//키오스크 안내 자막
		
		kiosk.setText("지금 듣고 있어요.");
		kiosk.setBounds(200,700,600,50);   //x,y, 가로,세로
		kiosk.setOpaque(true);
		kiosk.setHorizontalAlignment(JLabel.CENTER);
        kiosk.setFont(new Font("고딕체", Font.BOLD, 40));
        kiosk.setForeground(Color.WHITE);
        kiosk.setBackground(Color.BLACK);
       
        c.add(alarm);
		c.add(takein);
		c.add(takeout);
		c.add(kiosk);
		setVisible(true);
		
        //포장 or 테이크아웃 인텐트와 쳇봇 답변, 답변을 음성으로 바꾼 tts를 입력받으면 실행
        
        //1. 인텐트 입력과 checklist의 포장여부 값에 따라 버튼 눌리게함
          //1이 매장, 2가 포장이라 가정
       // takeoutchoice;
        if(takeoutchoice==1) {
        	kiosk.setText("매장에서 식사 선택하였습니다.맞습니까?");
        	
        	
        	
        	//정보는 챗봇에서 넘어왔므로 화면 전환하는거 실행하기
        	
        	
        }
        else if(takeoutchoice==2) {
        
        	kiosk.setText("테이크 아웃 하시겠습니까?");
        }
        
        
        
        
        
        
        
        //2. JLabel kiosk에 답변 글씨가 나타나도록 함 
        
        
        
        //3. 음성을 틀음
        
        JButton end =new JButton("다음");
        end.setBounds(840,10,100,30);
        end.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new page2();
			    setVisible(false);
			}
		
        });
        c.add(end);
	}    
    private class takeoutListener implements ActionListener{
       public void actionPerformed(ActionEvent e) {
           JButton choice=(JButton)e.getSource();
           
           if(choice.getText().equals("매장에서 식사")) {
        	   page1.this.kiosk.setText("매장에서 식사 선택하였습니다.맞습니까?");
           }
           else if(choice.getText().equals("테이크 아웃")) {
        	   takeoutchoice=2;
        	   
        	   page1.this.kiosk.setText("테이크 아웃 하시겠습니까?");
        	   
           }
       }
        	
        	
        	
    }
	   

	//테두리 둥글게
	
	public static void main(String[] args) {
		
		page1 frame=new page1();
		
			try { File file = new File("C:\\Users\\AhnSeoYeon\\Desktop\\takeoutt.wav");//voicebooking-speech.wav
			     TimeUnit.SECONDS.sleep(2);
			    Clip clip = AudioSystem.getClip(); 
			   clip.open(AudioSystem.getAudioInputStream(file));
			//clip.start(); 
			TimeUnit.SECONDS.sleep(3);
			//kiosk.setText("테이크 아웃 하시겠습니까?");
			
			}
			catch (Exception e) { System.err.println("Put the music.wav file in the sound folder if you want to play background music, only optional!");
			} 
			
		
 	   
		

	}

}





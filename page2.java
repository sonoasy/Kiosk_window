package kiosk_window;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import kiosk_window.page2.MymouseListener;

class page2_two extends JPanel{
	//세트 메뉴판
	
	public static JButton[] setno1=new JButton[16];
     public page2_two(){

         setLayout(null);
         
	    //loop문으로 바꾸기
	    String setmenu[]= {"1955 버거 세트","더블 불고기 버거 세트","더블 치즈버거 세트","더블 쿼터파운더 치즈 세트","더블 필레오피쉬 세트","맥시파이시 상하이 버거 세트","맥치킨 모짜렐라 세트","맥치킨 세트","베이컨 토마토 디럭스 세트","불고기 버거 세트","빅맥 세트","슈비 버거 세트","슈슈 버거 세트","에그 불고기 버거 세트","창녕 갈릭 버거 세트","치즈버거 세트"};
	    for(int i=0;i<setmenu.length;i++) {
		//버튼 당 쓸 이미지 
		  ImageIcon drink1=new ImageIcon("C:\\Users\\AhnSeoYeon\\Desktop\\workspace\\ch09\\src\\ch09\\"+setmenu[i]+".PNG"); //깃허브 menu 폴더의 경로를 설정해주어야 합니다.
          Image set1img =drink1.getImage();
          Image newset1=set1img.getScaledInstance(180, 100, java.awt.Image.SCALE_SMOOTH);
          ImageIcon newnewset1=new ImageIcon(newset1);
          JLabel set_1=new JLabel(newnewset1,JLabel.CENTER);
		
		  //이미지 버튼에 추가하기
          setno1[i]=new JButton(setmenu[i]);
          MymouseListener listener = new MymouseListener();
          
 
          setno1[i].setLayout(new BorderLayout());
          setno1[i].add(set_1,BorderLayout.CENTER);
          setno1[i].setVerticalAlignment(SwingConstants.BOTTOM);
          if(i<4) {
        	  setno1[i].setBounds(10+(i)*200,20,200,200);
          }
          else if(i>=4 &&i<8) {
        	  setno1[i].setBounds(10+(i-4)*200,220,200,200);
          }
          else if(i>=8 &&i<12){
        	  setno1[i].setBounds(10+(i-8)*200,420,200,200);
          }
          else {
        	  setno1[i].setBounds(10+(i-12)*200,620,200,200);
          }
          setno1[i].setForeground(Color.BLACK);
          setno1[i].setBackground(Color.WHITE);
          setno1[i].setFont(new Font("고딕체", Font.BOLD, 15));
          setno1[i].setBorderPainted(false);
        
		add(setno1[i]);
		add(page2.kiosk);
		setVisible(true);
		
	}
    }
     public void addRecord(int tmpt) {
 		DefaultTableModel model=(DefaultTableModel)page2.table.getModel();
 		DefaultTableModel model2=(DefaultTableModel)page2.buylist.getModel();
 		String []record=new String[4];
 		String []setprice= {"7200","5500","5700","8400","6000","5900","6200","5100","7000","4000","5900","7000","5800","4600","7500","4500"};

 		record[0]=setno1[tmpt].getText();
 		record[1]="1";
 		record[2]=setprice[tmpt];//burgerprice[tmpt];
 		page2.prices+=Integer.parseInt(record[2]);
 		
 		page2.list+=record[0]+"   "+record[1]+"   "+record[2]+"원\n";
 		
 		page2.kiosk.setText(record[0]+" "+record[1]+"개 주문하셨습니다.");
 		model.addRow(record);
 		model2.addRow(record);
 	}
     class MymouseListener implements MouseListener,KeyListener{	
 		@Override
 		public void keyTyped(KeyEvent e) {}
 		@Override
 		public void keyPressed(KeyEvent e) {}
 		@Override
 		public void keyReleased(KeyEvent e) {
 			// TODO Auto-generated method stub
 			
 		}
 		@Override
 		public void mouseClicked(MouseEvent e) {
 			Object src=e.getSource();
 			for(int i=0;i<16;i++) {
 				if(src==setno1[i]) {
 					JButton tmp=(JButton)src;
 				    //String tmpt=tmp.getText();
 					addRecord(i);	
 				}
 				
 			}
 		}
 		@Override
 		public void mousePressed(MouseEvent e) {}
 		@Override
 		public void mouseReleased(MouseEvent e) {}
 		@Override
 		public void mouseEntered(MouseEvent e) {}
 		@Override
 		public void mouseExited(MouseEvent e) {}

 	}    
 	
	
	
}
class page2_three extends JPanel{
	//음료 커피 메뉴판
	//public JTable table;
	public static JButton[] drinkno1=new JButton[16];
    public page2_three(){
		
         setLayout(null);
	    
	    //loop문으로 바꾸기
	    String drinkmenu[]= {"드립 커피","디카페인 아메리카노","디카페인 아이스 아메리카노","디카페인 아이스 카페라떼","디카페인 에스프레소","디카페인 카페라떼","디카페인 카푸치노","딸기 쉐이크 Medium","배 칠러","바닐라 쉐이크 Medium","배 칠러","생수","스프라이트","아메리카노","아이스 드립 커피","아이스 아메리카노"};
	    for(int i=0;i<drinkmenu.length;i++) {
		//버튼 당 쓸 이미지 
		  ImageIcon drink1=new ImageIcon("C:\\Users\\AhnSeoYeon\\Desktop\\workspace\\ch09\\src\\ch09\\"+drinkmenu[i]+".PNG"); //깃허브 menu폴더를 다운받아 경로를 설정해주어야 합니다
          Image drink1img =drink1.getImage();
          Image newdrink1=drink1img.getScaledInstance(180, 100, java.awt.Image.SCALE_SMOOTH);
          ImageIcon newnewdrink1=new ImageIcon(newdrink1);
          JLabel drink_1=new JLabel(newnewdrink1,JLabel.CENTER);
		
		  //이미지 버튼에 추가하기
          drinkno1[i]=new JButton(drinkmenu[i]);
          MymouseListener listener = new MymouseListener();
          drinkno1[i].addMouseListener(listener);
 
          drinkno1[i].setLayout(new BorderLayout());
          drinkno1[i].add(drink_1,BorderLayout.CENTER);
          drinkno1[i].setVerticalAlignment(SwingConstants.BOTTOM);
          if(i<4) {
        	  drinkno1[i].setBounds(10+(i)*200,20,200,200);
          }
          else if(i>=4 &&i<8) {
        	  drinkno1[i].setBounds(10+(i-4)*200,220,200,200);
          }
          else if(i>=8 &&i<12){
        	  drinkno1[i].setBounds(10+(i-8)*200,420,200,200);
          }
          else {
        	  drinkno1[i].setBounds(10+(i-12)*200,620,200,200);
          }
          drinkno1[i].setForeground(Color.BLACK);
          drinkno1[i].setBackground(Color.WHITE);
          drinkno1[i].setFont(new Font("고딕체", Font.BOLD, 15));
          drinkno1[i].setBorderPainted(false);
        
		add(drinkno1[i]);
		
		
	}
	    add(page2.kiosk);
        setVisible(true);
    }
    public void addRecord(int tmpt) {
		DefaultTableModel model=(DefaultTableModel)page2.table.getModel();
		DefaultTableModel model2=(DefaultTableModel)page2.buylist.getModel();
		String []record=new String[4];
		String []drinkprice= {"1500","2300","2300","2800","1600","2600","2600","2500","2700","2500","2700","1200","1300","1500","1000","1500"};

		record[0]=drinkno1[tmpt].getText();
		record[1]="1";
		record[2]=drinkprice[tmpt];//burgerprice[tmpt];
		
		page2.kiosk.setText("네, "+record[0]+" "+record[1]+"잔 드리겠습니다.");
		page2.prices+=Integer.parseInt(record[2]);
		page2.list+=record[0]+"   "+record[1]+"   "+record[2]+"원\n";
		model.addRow(record);
		model2.addRow(record);
		
		ImageIcon kimg= new ImageIcon("C:\\Users\\AhnSeoYeon\\Desktop\\kioya.png"); //가상 ai점원 이미지로 깃허브에서 kioya.png를 다운받아 경로를 설정해 주어야 합니다. 
		Image kkimg =kimg.getImage();
        Image kkkimg=kkimg.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        ImageIcon kkkkimg=new ImageIcon(kkkimg);
        JLabel img_1=new JLabel(kkkkimg,JLabel.CENTER);
		JFrame f = new JFrame("키오야");        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setSize(300,300);
        f.add(img_1);
        f.setVisible(true);            
          
        File file = new File("C:\\Users\\AhnSeoYeon\\Desktop\\sample_audio.wav");
        System.out.println(file.exists()); //true
        
        try {
            
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
            
        } catch(Exception e) {
            
            e.printStackTrace();
        }

		
		
		
	}
    class MymouseListener implements MouseListener,KeyListener{	
		@Override
		public void keyTyped(KeyEvent e) {}
		@Override
		public void keyPressed(KeyEvent e) {}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			Object src=e.getSource();
			for(int i=0;i<16;i++) {
				if(src==drinkno1[i]) {
					JButton tmp=(JButton)src;
				    //String tmpt=tmp.getText();
					addRecord(i);	
				}
				
			}
		}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}

	}    
	
}

//장바구니 클래스 
class buylist extends JPanel{
	
	public buylist() {
		
		setLayout(null);
		//장바구니 칸 , 총합계는 마지막에
		String rows[][] = { {} };
		    // 항목 값
		String headers[] = { "상품명","수량","단가"};
		JTable table = new JTable(new DefaultTableModel(rows, headers));
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
		//pack();
		
	
		setVisible(true);
		
		
		
		
		
	}
	
}


public class page2 extends JFrame {
	public static JTable table;	
	public static JTable buylist;
	public static String list="";
	public static int prices=0;
	public static JLabel kiosk=new JLabel();
	public JButton [] burgerno1=new JButton[16];
	public String burgerprice[]= {"5700","4400","4400","7000","5000","4600","4800","3300","5500","2200","4600","5500","4500","3200","6100","2000"};
    
	public static String text="";
	class page2_one extends JPanel{
		//단품 메뉴판
		
		
		public page2_one(){
			
		    setLayout(null);
		    
		    
		    
		    //loop문으로 바꾸기
		    String burgermenu[]= {"1955 버거","더블 불고기 버거","더블 치즈버거","더블 쿼터파운더 치즈버거","더블 필레오피쉬버거","맥스파이시 상하이 버거","맥치킨 모짜렐라 버거","맥치킨 버거","베이컨 토마토 디럭스 버거","불고기 버거","빅맥 버거","슈비 버거","슈슈 버거","에그 불고기 버거","창녕 갈릭 버거","치즈버거"};
		    for(int i=0;i<burgermenu.length;i++) {
			//버튼 당 쓸 이미지 
			  ImageIcon burger1=new ImageIcon("C:\\Users\\AhnSeoYeon\\Desktop\\workspace\\ch09\\src\\ch09\\"+burgermenu[i]+".PNG"); //깃허브 menu에서 다운받은 이미지들의 경로를 지정해주어야 합니다
	          Image burger1img =burger1.getImage();
	          Image newburger1=burger1img.getScaledInstance(180, 100, java.awt.Image.SCALE_SMOOTH);
	          ImageIcon newnewburger1=new ImageIcon(newburger1);
	          JLabel burger_1=new JLabel(newnewburger1,JLabel.CENTER);
			
			  //이미지 버튼에 추가하기
	          burgerno1[i]=new JButton(burgermenu[i]);
	          MymouseListener listener = new MymouseListener();
	          burgerno1[i].addMouseListener(listener);
	          burgerno1[i].setLayout(new BorderLayout());
	          burgerno1[i].add(burger_1,BorderLayout.CENTER);
	          burgerno1[i].setVerticalAlignment(SwingConstants.BOTTOM);
	          if(i<4) {
	           burgerno1[i].setBounds(10+(i)*200,20,200,200);
	          }
	          else if(i>=4 &&i<8) {
	        	  burgerno1[i].setBounds(10+(i-4)*200,220,200,200);
	          }
	          else if(i>=8 &&i<12){
	        	  burgerno1[i].setBounds(10+(i-8)*200,420,200,200);
	          }
	          else {
	        	  burgerno1[i].setBounds(10+(i-12)*200,620,200,200);
	          }
	          burgerno1[i].setForeground(Color.BLACK);
	          burgerno1[i].setBackground(Color.WHITE);
	          burgerno1[i].setFont(new Font("고딕체", Font.BOLD, 15));
			  burgerno1[i].setBorderPainted(false);
			
			add(burgerno1[i]);
			
			
			setVisible(true);
			
		    }		
			
		}
	
		
		
		
	}
	public page2() {
		
		setTitle("맥도날드 키오스크");
		setSize(1300,1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        
		
		JTable leftside=new JTable();
		JTable rightside=new JTable();
		
		page2_one one=new page2_one();

		page2_two two=new page2_two();
		page2_three three=new page2_three();
		JTabbedPane menutab=new JTabbedPane(JTabbedPane.TOP);
	    //메뉴탭으로 하지말고 버튼으로 바꾸자
		menutab.addTab("단품",one);
		menutab.addTab("세트",two);
		menutab.addTab("음료/커피",three);
	

		String rows[][] = { {} };
	    // 항목 값
		//장바구니 테이블 형태로 화면에 추가하는 부분
	    String headers[] = { "상품명","수량","단가"};
	    table = new JTable(new DefaultTableModel(headers,0));
	    //table.setFont(new Font("Serif", Font.BOLD, 15));
	    JScrollPane scrollPane = new JScrollPane(table);
	  	//cartEx cart=new cartEx("");    
		JSplitPane split=new JSplitPane();
		split.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		split.setLeftComponent(menutab);
		//테이블 추가 부분 
		Container right=new Container();
		right.setLayout(new BorderLayout(10,10));
		
		JButton addBtn=new JButton("상품 추가");
		addBtn.setPreferredSize(new Dimension(90, 55));
		JButton delBtn=new JButton("상품 삭제");
		delBtn.setPreferredSize(new Dimension(90, 55));
		right.add(scrollPane);
		
		JPanel btns=new JPanel();
		btns.setLayout(new BorderLayout());
		right.add("South",btns);
		split.setRightComponent(right);
		
	
		buylist = new JTable(new DefaultTableModel(headers,0));
		JScrollPane scrollPane2 = new JScrollPane(buylist);
		JPanel buy_list=new JPanel();
		buy_list.setLayout(new BorderLayout());
		buy_list.add("North",scrollPane2);
		
		JLabel price_total=new JLabel();
		price_total.setText("총 주문 금액:  "+prices);
		
		buy_list.add("South",price_total);
		
		
		
		//주문내역창 팝업으로 설정하기 
		
	
		Dimension d= split.getSize();
	    split.setDividerLocation(830);
		
	    JSplitPane split2=new JSplitPane();
	    split2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		split2.setTopComponent(split);
		
		JLabel r=new JLabel();
		r.setLayout(new BorderLayout());
		r.setSize(1300,50);
		JButton before=new JButton("  이전  ");
		before.setSize(150,50);
		
		JButton end=new JButton("주문 완료");
		end.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				JOptionPane.showMessageDialog(null,"************주문내역************\n"+list+"총 주문 금액:  "+prices+"원");
				
			}
		});
	
		end.setSize(150,50);
		
	    r.add(before,BorderLayout.WEST);
	    r.add(end,BorderLayout.EAST);
		split2.setBottomComponent(r);
		split2.setDividerLocation(900);
		
		
		kiosk.setBounds(120,830,700,50);   //x,y, 가로,세로
		kiosk.setOpaque(true);
		kiosk.setHorizontalAlignment(JLabel.CENTER);
        kiosk.setFont(new Font("고딕체", Font.BOLD, 30));
        kiosk.setForeground(Color.WHITE);
        kiosk.setBackground(Color.BLACK);
        
		add(split2);
		
		
		setVisible(true);
		
	}
	public void addRecord(int tmpt) {
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		DefaultTableModel model2=(DefaultTableModel)page2.buylist.getModel();
		String []record=new String[4];
		
		record[0]=burgerno1[tmpt].getText();
		
		record[1]="1";
		text=record[0]+" "+record[1]+"개 주문하셨습니다.";
		page2.kiosk.setText(text);
		record[2]=burgerprice[tmpt];
		page2.prices+=Integer.parseInt(record[2]);
		page2.list+=record[0]+"   "+record[1]+"   "+record[2]+"원\n";
		model.addRow(record);
		model2.addRow(record);
	}
	public static void main(String[] args) {
		
		page2 frame=new page2();
		
		
	}
	class MymouseListener implements MouseListener,KeyListener{	
		@Override
		public void keyTyped(KeyEvent e) {}
		@Override
		public void keyPressed(KeyEvent e) {}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			Object src=e.getSource();
			for(int i=0;i<16;i++) {
				if(src==burgerno1[i]) {
					JButton tmp=(JButton)src;
				    //String tmpt=tmp.getText();
					addRecord(i);	
				}
				
			}
		}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}

	}    
}

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class AdventurePanel extends JPanel implements MouseListener {
	private BufferedImage c1,c2,c3, c4, tem, sub, blank, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16,diver1,diver2,diver3,diver4,marker,diverflip1,diverflip2,diverflip3,diverflip4,dice1,dice2,dice3;
	private ArrayList<chip> boardChips = new ArrayList<chip>();
	private ArrayList<chip> chipSto = new ArrayList<chip>();
	private ArrayList<Integer> ran = new ArrayList<>();
	private ArrayList<Integer> ran1 = new ArrayList<>();
	private ArrayList<Integer> ran2 = new ArrayList<>();
	private ArrayList<Integer> ran3 = new ArrayList<>();
	private diver one,two,three,four;
	private int order,breath,idk,lol,roll1,roll2,move;



	
	public AdventurePanel()
	{
		try {
			c1 = ImageIO.read(Adventure.class.getResource("/image/chip1.png"));
			c2 = ImageIO.read(Adventure.class.getResource("/image/chip2.png"));
			c3 = ImageIO.read(Adventure.class.getResource("/image/chip3.png"));
			c4 = ImageIO.read(Adventure.class.getResource("/image/chip4.png"));
			blank = ImageIO.read(Adventure.class.getResource("/image/blank.png"));
			sub = ImageIO.read(Adventure.class.getResource("/image/sub.png"));
			p1 = ImageIO.read(Adventure.class.getResource("/image/pchip1.png"));
			p2 = ImageIO.read(Adventure.class.getResource("/image/pchip2.png"));
			p3 = ImageIO.read(Adventure.class.getResource("/image/pchip3.png"));
			p4 = ImageIO.read(Adventure.class.getResource("/image/pchip4.png"));
			p5 = ImageIO.read(Adventure.class.getResource("/image/pchip5.png"));
			p6 = ImageIO.read(Adventure.class.getResource("/image/pchip6.png"));
			p7 = ImageIO.read(Adventure.class.getResource("/image/pchip7.png"));
			p8 = ImageIO.read(Adventure.class.getResource("/image/pchip8.png"));
			p9 = ImageIO.read(Adventure.class.getResource("/image/pchip9.png"));
			p10 = ImageIO.read(Adventure.class.getResource("/image/pchip10.png"));
			p11 = ImageIO.read(Adventure.class.getResource("/image/pchip11.png"));
			p12 = ImageIO.read(Adventure.class.getResource("/image/pchip12.png"));
			p13 = ImageIO.read(Adventure.class.getResource("/image/pchip13.png"));
			p14 = ImageIO.read(Adventure.class.getResource("/image/pchip14.png"));
			p15 = ImageIO.read(Adventure.class.getResource("/image/pchip15.png"));
			p16 = ImageIO.read(Adventure.class.getResource("/image/pchip16.png"));
			diver1= ImageIO.read(Adventure.class.getResource("/image/diver.png"));
			diver2= ImageIO.read(Adventure.class.getResource("/image/diver2.png"));
			diver3= ImageIO.read(Adventure.class.getResource("/image/diver3.png"));
			diver4= ImageIO.read(Adventure.class.getResource("/image/diver4.png"));
			marker=ImageIO.read(Adventure.class.getResource("/image/marker.png"));
			diverflip1=ImageIO.read(Adventure.class.getResource("/image/diverflip.png"));
			diverflip2=ImageIO.read(Adventure.class.getResource("/image/diver2flip.png"));
			diverflip3=ImageIO.read(Adventure.class.getResource("/image/diver3flip.png"));
			diverflip4=ImageIO.read(Adventure.class.getResource("/image/diver4flip.png"));
			dice1=ImageIO.read(Adventure.class.getResource("/image/dice1.png"));
			dice2=ImageIO.read(Adventure.class.getResource("/image/dice2.png"));
			dice3=ImageIO.read(Adventure.class.getResource("/image/dice3.png"));
			
		}
		catch(Exception E) {
			System.out.println("Exception Error");
			return;
		}
		addMouseListener(this);
		
		one = new diver(0, 1, new ArrayList<chip>() , diver1,true);
		two = new diver(0, 2, new ArrayList<chip>() , diver2,true);
		three = new diver(0, 3, new ArrayList<chip>() , diver3,true);
		four = new diver(0, 4, new ArrayList<chip>() , diver4,true);
		
		breath=25;
		order=-1;
		lol=1;
		for(int i=0;i<4;i++) {
			ran.add(i);
			ran.add(i);
			ran1.add(i);
			ran1.add(i);
			ran2.add(i);
			ran2.add(i);
			ran3.add(i);
			ran3.add(i);
		}
		
		int cx = 50, cy = 560;
		int random;
		idk=0;
		chip c = new chip(0,0, cx, cy, true, blank, blank);
		boardChips.add(c);
		for(int i = 0; i < 32; i++) {
		
			if(i < 8) {
				random=(int)(Math.random()*ran.size());
				int t = ran.get(random);
				ran.remove(random);
				if(t == 0) { tem = p1; }
				if(t == 1) { tem = p2; }
				if(t == 2) { tem = p3; }
				if(t == 3) { tem = p4; }
				chip temp = new chip(1, t, cx, cy, false, c1,tem);
				boardChips.add(temp);
				cx += 45;
			}
			else if(i < 16) {
				random=(int)(Math.random()*ran1.size());
				int t = ran1.get(random);
				ran1.remove(random);
				if(t == 0) { tem = p5; }
				if(t == 1) { tem = p6; }
				if(t == 2) { tem = p7; }
				if(t == 3) { tem = p8; }
				chip temp = new chip(2,t+4, cx, cy, false, c2, tem);
				boardChips.add(temp);
				cx += 45;

			}
			else if(i < 24) {
				random=(int)(Math.random()*ran2.size());
				int t = ran2.get(random);
				ran2.remove(random);
				if(t == 0) { tem = p9; }
				if(t == 1) { tem = p10; }
				if(t == 2) { tem = p11; }
				if(t == 3) { tem = p12; }
				chip temp = new chip(3,t+8, cx, cy, false, c3, tem);
				boardChips.add(temp);
				cx += 45;

			}
			else if(i < 32) {
				random=(int)(Math.random()*ran3.size());
				int t = ran3.get(random);
				ran3.remove(random);
				if(t == 0) { tem = p13; }
				if(t == 1) { tem = p14; }
				if(t == 2) { tem = p15; }
				if(t == 3) { tem = p16; }
				chip temp = new chip(4,t+12, cx, cy, false, c4, tem);
				boardChips.add(temp);
				cx += 45;

			}
			
		}
		cx = 5; 
		cy = 560;
		for( int i = 0; i < 33; i++) {
			chip b = new chip(0,0, cx, cy, true, blank, blank);
			chipSto.add(b);
			cx += 45;
		}
		
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		if(idk>20) {
			idk=10;
		}
		
		if(idk!=0&&one.getIndex()==0&&two.getIndex()==0&&three.getIndex()==0&&four.getIndex()==0)
			idk=25;
		
		g.setColor(new Color(210, 216, 230)); 
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(sub, getWidth()/3, getHeight()/20*2, getWidth()/3, getHeight()/3, null);
		g.drawImage(sub, 5, getHeight()/25*13, getWidth()/40, getHeight()/30, null);
		if(idk!=25&&breath>-1) {
			g.drawImage(four.getImage(), 5+four.getIndex()*45, getHeight()/25*13, getWidth()/40, getHeight()/30, null);
			g.drawImage(three.getImage(), 5+three.getIndex()*45, getHeight()/25*13, getWidth()/40, getHeight()/30, null);
			g.drawImage(two.getImage(), 5+two.getIndex()*45, getHeight()/25*13, getWidth()/40, getHeight()/30, null);
			g.drawImage(one.getImage(), 5+one.getIndex()*45, getHeight()/25*13, getWidth()/40, getHeight()/30, null);
		}
		
		
		if(breath==25) 
		g.drawImage(marker, (int)(getWidth()/100*35.8), getHeight()/100*23, getWidth()/40, getHeight()/30, null);
		if(breath==24)
		g.drawImage(marker, (int)(getWidth()/100*38.8), getHeight()/100*23, getWidth()/40, getHeight()/30, null);
		if(breath==23)
		g.drawImage(marker, (int)(getWidth()/100*41.8), getHeight()/100*23, getWidth()/40, getHeight()/30, null);
		if(breath==22)
		g.drawImage(marker, (int)(getWidth()/100*44.8), getHeight()/100*23, getWidth()/40, getHeight()/30, null);
		if(breath==21)
		g.drawImage(marker, (int)(getWidth()/100*47.9), getHeight()/100*23, getWidth()/40, getHeight()/30, null);
		if(breath==20)
		g.drawImage(marker, (int)(getWidth()/100*51.0), getHeight()/100*23, getWidth()/40, getHeight()/30, null);
		if(breath==19)
		g.drawImage(marker, (int)(getWidth()/100*53.6), (int)(getHeight()/100*22.9), getWidth()/40, getHeight()/30, null);
		if(breath==18)
		g.drawImage(marker, (int)(getWidth()/100*56.7), (int)(getHeight()/100*22.8), getWidth()/40, getHeight()/30, null);
		if(breath==17)
		g.drawImage(marker, (int)(getWidth()/100*59.9), (int)(getHeight()/100*22.7), getWidth()/40, getHeight()/30, null);
		if(breath==16)
		g.drawImage(marker, getWidth()/100*63, (int)(getHeight()/100*22.6), getWidth()/40, getHeight()/30, null);
		if(breath==15)
		g.drawImage(marker, (int)(getWidth()/100*61.3), (int)(getHeight()/100*27.8), getWidth()/40, getHeight()/30, null);
		if(breath==14)
		g.drawImage(marker, getWidth()/100*58, (int)(getHeight()/100*28.0), getWidth()/40, getHeight()/30, null);
		if(breath==13)
		g.drawImage(marker, getWidth()/100*55, (int)(getHeight()/100*28.0), getWidth()/40, getHeight()/30, null);
		if(breath==12)
		g.drawImage(marker, getWidth()/100*52, (int)(getHeight()/100*28.0), getWidth()/40, getHeight()/30, null);
		if(breath==11)
		g.drawImage(marker, getWidth()/100*49, (int)(getHeight()/100*28.0), getWidth()/40, getHeight()/30, null);
		if(breath==10)
		g.drawImage(marker, (int)(getWidth()/100*45.9), (int)(getHeight()/100*28.0), getWidth()/40, getHeight()/30, null);
		if(breath==9)
		g.drawImage(marker, (int)(getWidth()/100*42.8), (int)(getHeight()/100*28.0), getWidth()/40, getHeight()/30, null);
		if(breath==8)
		g.drawImage(marker, (int)(getWidth()/100*39.9), (int)(getHeight()/100*28.0), getWidth()/40, getHeight()/30, null);
		if(breath==7)
		g.drawImage(marker, (int)(getWidth()/100*36.8), (int)(getHeight()/100*28.0), getWidth()/40, getHeight()/30, null);
		if(breath==6)
		g.drawImage(marker, (int)(getWidth()/100*41.1), (int)(getHeight()/100*33.0), getWidth()/40, getHeight()/30, null);
		if(breath==5)
		g.drawImage(marker, (int)(getWidth()/100*44.3), (int)(getHeight()/100*33.0), getWidth()/40, getHeight()/30, null);
		if(breath==4)
		g.drawImage(marker, (int)(getWidth()/100*47.4), (int)(getHeight()/100*33.0), getWidth()/40, getHeight()/30, null);
		if(breath==3)
		g.drawImage(marker, (int)(getWidth()/100*50.6), (int)(getHeight()/100*33.0), getWidth()/40, getHeight()/30, null);
		if(breath==2)
		g.drawImage(marker, (int)(getWidth()/100*53.6), (int)(getHeight()/100*33.0), getWidth()/40, getHeight()/30, null);
		if(breath==1)
		g.drawImage(marker, (int)(getWidth()/100*56.6), (int)(getHeight()/100*33.0), getWidth()/40, getHeight()/30, null);
		if(breath==0)
		g.drawImage(marker, (int)(getWidth()/100*48.9), (int)(getHeight()/100*38.4), getWidth()/40, getHeight()/30, null);

		
		//score keeper
		g.drawImage(diver1, getWidth()/4*0, getHeight()/25*24, getWidth()/40, getHeight()/30, null);
		g.drawImage(diver2, getWidth()/4*1, getHeight()/25*24, getWidth()/40, getHeight()/30, null);
		g.drawImage(diver3, getWidth()/4*2, getHeight()/25*24, getWidth()/40, getHeight()/30, null);
		g.drawImage(diver4, getWidth()/4*3, getHeight()/25*24, getWidth()/40, getHeight()/30, null);
		
		//buttons
		g.setColor(Color.red); 
		g.fillRect(getWidth()/28*1, getHeight()/25*15, getWidth()/28*8, getHeight()/25*6);
		g.setColor(Color.blue); 
		g.fillRect(getWidth()/28*10, getHeight()/25*15, getWidth()/28*8, getHeight()/25*6);
		g.setColor(Color.green); 
		g.fillRect(getWidth()/28*19, getHeight()/25*15, getWidth()/28*8, getHeight()/25*6);
		g.setColor(Color.black); 
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		g.drawString("ROLL DICE", getWidth()/52*6, getHeight()/25*18);
		g.drawString("TURN BACK", getWidth()/52*23, getHeight()/25*18);
		g.drawString("PICK UP/\nPLACE DOWN", getWidth()/52*37, getHeight()/25*18);
		
		
		if(idk!=0&&idk!=25&&breath>-1)
		g.drawString("MOVE " +move, getWidth()/52*8, getHeight()/25*8);
		
		if(roll1==1&&idk!=25&&breath>-1) {
			g.drawImage(dice1, getWidth()/10, getHeight()/20*3, getWidth()/10, getHeight()/10, null);
		}
		if (roll1==2&&idk!=25&&breath>-1) {
			g.drawImage(dice2, getWidth()/10, getHeight()/20*3, getWidth()/10, getHeight()/10, null);
		}
		if (roll1==3&&idk!=25&&breath>-1) {
			g.drawImage(dice3, getWidth()/10, getHeight()/20*3, getWidth()/10, getHeight()/10, null);
		}
			
		if (roll2==1&&idk!=25&&breath>-1) {
			g.drawImage(dice1, getWidth()/10*2, getHeight()/20*3, getWidth()/10, getHeight()/10, null);
		}
		if (roll2==2&&idk!=25&&breath>-1) {
			g.drawImage(dice2, getWidth()/10*2, getHeight()/20*3, getWidth()/10, getHeight()/10, null);
		}
		if (roll2==3&&idk!=25&&breath>-1) {
			g.drawImage(dice3, getWidth()/10*2, getHeight()/20*3, getWidth()/10, getHeight()/10, null);
		}
		
		if(order==0&&idk!=25&&breath>-1)
		g.drawString("PLAYER ONE", getWidth()/52*7, getHeight()/25*2);
		if(order==1&&idk!=25&&breath>-1)
		g.drawString("PLAYER TWO" , getWidth()/52*7, getHeight()/25*2);
		if(order==2&&idk!=25&&breath>-1)
		g.drawString("PLAYER THREE" , getWidth()/52*7, getHeight()/25*2);
		if(order==3&&idk!=25&&breath>-1)
		g.drawString("PLAYER FOUR" , getWidth()/52*7, getHeight()/25*2);


		
		if(lol==0)
			g.drawString("CLICK ON WHAT YOU WANT TO DROP", getWidth()/52*17, (int)(getHeight()/25*2));



		int xValue = 50;
		if(idk!=25&&breath>-1) {
			for(int i=1;i<boardChips.size();i++) {
					g.drawImage(boardChips.get(i).getTPicture(), boardChips.get(i).getxVal(), boardChips.get(i).getyVal(), getWidth()/40, getHeight()/30, null);
			}
		}
		if(idk==25||breath<0) {
			for(int i=1;i<boardChips.size();i++) {
				if(boardChips.get(i).getTier()==0) {
					boardChips.remove(i);
					i--;
					
				}
			}
			
			for(int x=1;x<boardChips.size();x++) {
				boardChips.get(x).changeX(xValue);
				g.drawImage(boardChips.get(x).getTPicture(), boardChips.get(x).getxVal(), boardChips.get(x).getyVal(), getWidth()/40, getHeight()/30, null);
				//System.out.println("lol");
				xValue+=45;
			}
			
			
			
		}
			
		if(one.getAL().size()>0) {
			for(int i=0;i<one.getAL().size();i++) {
				g.drawImage(one.getAL().get(i).getTPicture(), getWidth()/4*0+i*45+45, getHeight()/25*24, getWidth()/40, getHeight()/30, null);
			}
		}
		 if(two.getAL().size()>0) {
			for(int i=0;i<two.getAL().size();i++) {
				g.drawImage(two.getAL().get(i).getTPicture(), getWidth()/4*1+i*45+45, getHeight()/25*24, getWidth()/40, getHeight()/30, null);
			}
		 }
		 if(three.getAL().size()>0) {
			for(int i=0;i<three.getAL().size();i++) {
				g.drawImage(three.getAL().get(i).getTPicture(), getWidth()/4*2+i*45+45, getHeight()/25*24, getWidth()/40, getHeight()/30, null);
			}
		 }
		 if(four.getAL().size()>0) {
			for(int i=0;i<four.getAL().size();i++) {
				g.drawImage(four.getAL().get(i).getTPicture(), getWidth()/4*3+i*45+45, getHeight()/25*24, getWidth()/40, getHeight()/30, null);
			}
		 }
		 if(idk==0)
				g.drawString("PLEASE CLICK FULLSCREEN", getWidth()/52*20, getHeight()/25*2);

		 if(breath<0||(one.getIndex()==0&&two.getIndex()==0&&three.getIndex()==0&&four.getIndex()==0&&idk>0)) {
			g.setColor(new Color(192, 192, 192));
			g.fillRect(getWidth()/28*19, getHeight()/25*2, getWidth()/28*8, getHeight()/25*10);
			g.setColor(Color.black); 
			g.drawString("ROUND RESULTS", getWidth()/52*38, getHeight()/25*3);
			
			g.drawImage(diver1, getWidth()/28*19, getHeight()/25*4, getWidth()/40, getHeight()/30, null);
			g.drawImage(diver2, getWidth()/28*19, getHeight()/25*6, getWidth()/40, getHeight()/30, null);
			g.drawImage(diver3, getWidth()/28*19, getHeight()/25*8, getWidth()/40, getHeight()/30, null);
			g.drawImage(diver4, getWidth()/28*19, getHeight()/25*10, getWidth()/40, getHeight()/30, null);
			
			
			if(one.getAL().size()>0&&one.getIndex()==0) {
				for(int i=0;i<one.getAL().size();i++) {
					g.drawImage(one.getAL().get(i).getPPicture(), getWidth()/28*19+i*45+45, getHeight()/25*4, getWidth()/40, getHeight()/30, null);
				}
				g.drawString(one.getTotal()+"", getWidth()/52*49, (int)(getHeight()/25*4.8));
			}
			 if(two.getAL().size()>0&&two.getIndex()==0) {
				for(int i=0;i<two.getAL().size();i++) {
					g.drawImage(two.getAL().get(i).getPPicture(), getWidth()/28*19+i*45+45, getHeight()/25*6, getWidth()/40, getHeight()/30, null);
				}
				g.drawString(two.getTotal()+"", getWidth()/52*49, (int)(getHeight()/25*6.8));
			 }
			 if(three.getAL().size()>0&&three.getIndex()==0) {
				for(int i=0;i<three.getAL().size();i++) {
					g.drawImage(three.getAL().get(i).getPPicture(), getWidth()/28*19+i*45+45, getHeight()/25*8, getWidth()/40, getHeight()/30, null);
				}
				g.drawString(three.getTotal()+"", getWidth()/52*49, (int)(getHeight()/25*8.8));
			 }
			 if(four.getAL().size()>0&&four.getIndex()==0) {
				for(int i=0;i<four.getAL().size();i++) {
					g.drawImage(four.getAL().get(i).getPPicture(), getWidth()/28*19+i*45+45, getHeight()/25*10, getWidth()/40, getHeight()/30, null);
				}
				g.drawString(four.getTotal()+"", getWidth()/52*49, (int)(getHeight()/25*10.8));
			 }
			 
			 if(one.getIndex()!=0||one.getAL().size()==0) {
				g.drawString(0+"", getWidth()/52*49, (int)(getHeight()/25*4.8));

			 }
			 if(two.getIndex()!=0||two.getAL().size()==0) {
					g.drawString(0+"", getWidth()/52*49, (int)(getHeight()/25*6.8));

				 }
			 if(three.getIndex()!=0||three.getAL().size()==0) {
					g.drawString(0+"", getWidth()/52*49, (int)(getHeight()/25*8.8));

				 }
			 if(four.getIndex()!=0||four.getAL().size()==0) {
					g.drawString(0+"", getWidth()/52*49, (int)(getHeight()/25*10.8));

				 }
			one = new diver(0, 1, new ArrayList<chip>() , diver1,true);
			two = new diver(0, 2, new ArrayList<chip>() , diver2,true);
			three = new diver(0, 3, new ArrayList<chip>() , diver3,true);
			four = new diver(0, 4, new ArrayList<chip>() , diver4,true);
		 	g.drawImage(four.getImage(), 5+four.getIndex()*45, getHeight()/25*13, getWidth()/40, getHeight()/30, null);
	 		g.drawImage(three.getImage(), 5+three.getIndex()*45, getHeight()/25*13, getWidth()/40, getHeight()/30, null);
			g.drawImage(two.getImage(), 5+two.getIndex()*45, getHeight()/25*13, getWidth()/40, getHeight()/30, null);
			g.drawImage(one.getImage(), 5+one.getIndex()*45, getHeight()/25*13, getWidth()/40, getHeight()/30, null);
			breath=25;
			order--;
			idk=0;
			}
			 
		 
		 
		
	}
	public void mouseClicked(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		// Check if the mouse click is within the bounds of the first rectangle
		if (mouseX >= getWidth()/28*1 && mouseX <= getWidth()/28*9 &&
		    mouseY >= getHeight()/25*15 && mouseY <= getHeight()/25*21) {
			idk++;
			if(breath>-1) {
				
				roll1=(int)(Math.random()*3)+1;
				roll2=(int)(Math.random()*3)+1;
				
			    int random =roll1+roll2;
			    System.out.println(random);
			    int x=1;	
			    order++;
			    if(order>3) {
			    	order=0;
			    }
			    
			    
			    if(idk>4&&order==0&&one.getIndex()==0) {
			    	order++;
			    }
			    if(idk>4&&order==1&&two.getIndex()==0) {
			    	order++;
			    }
			    if(idk>4&&order==2&&three.getIndex()==0) {
			    	order++;
			    }
			    if(idk>4&&order==3&&four.getIndex()==0) {
			    	order=0;
			    }
			    if(idk>4&&order==0&&one.getIndex()==0) {
			    	order++;
			    }
			    
			    if(idk>4&&four.getIndex()==0&&one.getIndex()==0&&two.getIndex()==0&&three.getIndex()!=0) {
			    	order=2;
			    }
			    if(idk>4&&four.getIndex()==0&&one.getIndex()==0&&three.getIndex()==0&&two.getIndex()!=0) {
			    	order=1;
			    }
			    System.out.println("idk "+order);
			    if(order==0) {
			    	breath=breath-one.getAL().size();
			    }
			    else if(order==1) {
			    	breath=breath-two.getAL().size();
			    }
			    else if(order==2) {
			    	breath=breath-three.getAL().size();
			    }
			    else  {
			    	breath=breath-four.getAL().size();
			    }
			  
			    
			    if(order==0) {
			    	random=random-one.getAL().size();
			    	if(random<0) {
			    		random=0;
			    	}
			    	move=random;
			    	if(one.getIndex()!=0)
			    		boardChips.get(one.getIndex()).setStatus(false);
			    	if(one.getDir()==true) {
			    		while(x<random+1&&(one.getIndex()+x)!=0&&(one.getIndex()+x)<33) {
					    	if(boardChips.get(one.getIndex()+x).getStatus()==true) {
					    		random++;
					    		System.out.print("index"+x);
					    	}
					    	x++;
					    }
			    		one.changeIndex(one.getIndex()+random);
			    		boardChips.get(one.getIndex()).setStatus(true);
			    	}
			    	else {
			    		while(x<random+1&&(one.getIndex()-x)>=0&&(one.getIndex()-x)<34) {
					    	if(boardChips.get(one.getIndex()-x).getStatus()==true) {
					    		random++;
					    		System.out.print("index"+x);
					    	}
					    	x++;
					    }
			    		one.changeImage(diverflip1);
			    		one.changeIndex(one.getIndex()-random);
			    		if(one.getIndex()!=0)
			    			boardChips.get(one.getIndex()).setStatus(true);
			    	}
			    }
			 
			    else if(order==1) {
			    	random=random-two.getAL().size();
			    	if(random<0) {
			    		random=0;
			    	}
			    	move=random;
			    	if(two.getIndex()!=0)
			    		boardChips.get(two.getIndex()).setStatus(false);
			    	if(two.getDir()==true) {
			    		while(x<random+1&&(two.getIndex()+x)!=0&&(two.getIndex()+x)<33) {
					    	if(boardChips.get(two.getIndex()+x).getStatus()==true) {
					    		random++;
					    		System.out.print("index"+x);
					    	}
					    	x++;
					    }
			    		two.changeIndex(two.getIndex()+random);
			    		boardChips.get(two.getIndex()).setStatus(true);
			    	}
			    	else {
			    		while(x<random+1&&(two.getIndex()-x)>=0&&(two.getIndex()-x)<34) {
					    	if(boardChips.get(two.getIndex()-x).getStatus()==true) {
					    		random++;
					    		System.out.print("index"+x);
					    	}
					    	x++;
					    }
			    		two.changeImage(diverflip2);
			    		two.changeIndex(two.getIndex()-random);
			    		if(two.getIndex()!=0)
			    			boardChips.get(two.getIndex()).setStatus(true);
			    	}
			    }
			    
			    else if(order==2) {
			    	random=random-three.getAL().size();
			    	if(random<0) {
			    		random=0;
			    	}
			    	move=random;
			    	if(three.getIndex()!=0)
			    		boardChips.get(three.getIndex()).setStatus(false);
			    	if(three.getDir()==true) {
			    		while(x<random+1&&(three.getIndex()+x)!=0&&(three.getIndex()+x)<33) {
					    	if(boardChips.get(three.getIndex()+x).getStatus()==true) {
					    		random++;
					    		System.out.print("index"+x);
					    	}
					    	x++;
					    }
			    		three.changeIndex(three.getIndex()+random);
			    		boardChips.get(three.getIndex()).setStatus(true);
			    	}
			    	else {
			    		while(x<random+1&&(three.getIndex()-x)>=0&&(three.getIndex()-x)<34) {
					    	if(boardChips.get(three.getIndex()-x).getStatus()==true) {
					    		random++;
					    		System.out.print("index"+x);
					    	}
					    	x++;
					    }
			    		three.changeImage(diverflip3);
			    		three.changeIndex(three.getIndex()-random);
			    		if(three.getIndex()!=0)
			    			boardChips.get(three.getIndex()).setStatus(true);
			    	}
			    }
			    else  {
		    		random=random-four.getAL().size();
		    		if(random<0) {
			    		random=0;
			    	}
		    		move=random;
			    	if(four.getIndex()!=0)
			    		boardChips.get(four.getIndex()).setStatus(false);
			    	if(four.getDir()==true) {
			    		while(x<random+1&&(four.getIndex()+x)!=0&&(four.getIndex()+x)<33) {
					    	if(boardChips.get(four.getIndex()+x).getStatus()==true) {
					    		random++;
					    		System.out.print("index"+x);
					    	}
					    	x++;
			    		}
			    		four.changeIndex(four.getIndex()+random);
			    		boardChips.get(four.getIndex()).setStatus(true);
			    	}
			    	else {
			    		while(x<random+1&&(four.getIndex()-x)>=0&&(four.getIndex()-x)<34) {
					    	if(boardChips.get(four.getIndex()-x).getStatus()==true) {
					    		random++;
					    		System.out.print("index"+x);
					    	}
					    	x++;
					    }
			    		four.changeImage(diverflip4);
			    		four.changeIndex(four.getIndex()-random);
			    		if(four.getIndex()!=0)
			    			boardChips.get(four.getIndex()).setStatus(true);
			    	}
			    }
			}
			
		    
		    
		}

		// Check if the mouse click is within the bounds of the second rectangle
		if (mouseX >= getWidth()/28*10 && mouseX <= getWidth()/28*18 &&
		    mouseY >= getHeight()/25*15 && mouseY <= getHeight()/25*21) {
			order++;
			System.out.print(order);
			if(order>3) {
				order=0;
			}
			if(order==0) {
		    	one.changeDir();
		    	one.changeImage(diverflip1);
		    }
		    else if(order==1) {
		    	two.changeDir();
		    	two.changeImage(diverflip2);
		    }
		    else if(order==2) {
		    	three.changeDir();
		    	three.changeImage(diverflip3);
		    }
		    else  {
		    	four.changeDir();
		    	four.changeImage(diverflip4);
		    }
			order--;
			if(order<0) {
				order=3;
			}
		}

		// Check if the mouse click is within the bounds of the third rectangle
		if (mouseX >= getWidth()/28*19 && mouseX <= getWidth()/28*27 &&
		    mouseY >= getHeight()/25*15 && mouseY <= getHeight()/25*21) {
			if(order==0) {
		    	if(boardChips.get(one.getIndex()).getTier()!=0) {
		    		one.addChip(boardChips.get(one.getIndex()));
		    		boardChips.set(one.getIndex(), chipSto.get(one.getIndex()));
		    		System.out.println(one.getAL().get(0).getPoints());
		    	}
		    	else {
		    		if(one.getAL().size()>0) {
		    			//one.getAL().get(0).changeX(boardChips.get(one.getIndex()).getxVal());
		    			//boardChips.set(one.getIndex(), one.getAL().get(0));
		    			//one.removeChip(0);
		    			lol=0;
		    		}
		    		
		    	}
		    }
		    else if(order==1) {
		    	if(boardChips.get(two.getIndex()).getTier()!=0) {
		    		two.addChip(boardChips.get(two.getIndex()));
		    		boardChips.set(two.getIndex(), chipSto.get(two.getIndex()));
		    	}
		    	else {
		    		if(two.getAL().size()>0) {
		    			//two.getAL().get(0).changeX(boardChips.get(two.getIndex()).getxVal());
		    			//boardChips.set(two.getIndex(), two.getAL().get(0));
		    			//two.removeChip(0);
		    			lol=0;
		    		}
		    		
		    	}
		    }
		    else if(order==2) {
		    	if(boardChips.get(three.getIndex()).getTier()!=0) {
		    		three.addChip(boardChips.get(three.getIndex()));
		    		boardChips.set(three.getIndex(), chipSto.get(three.getIndex()));
		    	}
		    	else{
		    		if(three.getAL().size()>0) {
		    			//three.getAL().get(0).changeX(boardChips.get(three.getIndex()).getxVal());
		    			//boardChips.set(three.getIndex(), three.getAL().get(0));
		    			//three.removeChip(0);
		    			lol=0;
		    		}
		    		
		    	}
		    }
		    else  {
		    	if(boardChips.get(four.getIndex()).getTier()!=0) {
		    		four.addChip(boardChips.get(four.getIndex()));
		    		boardChips.set(four.getIndex(), chipSto.get(four.getIndex()));
		    	}
		    	else {
		    		if(four.getAL().size()>0) {
		    			//four.getAL().get(0).changeX(boardChips.get(four.getIndex()).getxVal());
		    			//boardChips.set(four.getIndex(), four.getAL().get(0));
		    			//four.removeChip(0);
		    			lol=0;
		    		}
		    		
		    	}
		    }
		}
		
		if(one.getAL().size()>0&&lol==0) {
			for(int i=0;i<one.getAL().size();i++) {
				if((mouseX >= getWidth()/4*0+i*45+45 && mouseX <= getWidth()/4*0+i*45+90 &&mouseY >= getHeight()/25*24 && mouseY <= getHeight()/25*25)) {
					one.getAL().get(i).changeX(boardChips.get(one.getIndex()).getxVal());
					boardChips.set(one.getIndex(), one.getAL().get(i));
		    		one.removeChip(i);
		    		lol=1;
				}
			}
		}
		if(two.getAL().size()>0&&lol==0) {
			for(int i=0;i<two.getAL().size();i++) {
				if((mouseX >= getWidth()/4*1+i*45+45 && mouseX <= getWidth()/4*1+i*45+90 &&mouseY >= getHeight()/25*24 && mouseY <= getHeight()/25*25)) {
					two.getAL().get(i).changeX(boardChips.get(two.getIndex()).getxVal());
	    			boardChips.set(two.getIndex(), two.getAL().get(i));
	    			two.removeChip(i);
	    			lol=1;
				}
			}
		}
		if(three.getAL().size()>0&&lol==0) {
			for(int i=0;i<three.getAL().size();i++) {
				if((mouseX >= getWidth()/4*2+i*45+45 && mouseX <= getWidth()/4*2+i*45+90 &&mouseY >= getHeight()/25*24 && mouseY <= getHeight()/25*25)) {
					three.getAL().get(i).changeX(boardChips.get(three.getIndex()).getxVal());
	    			boardChips.set(three.getIndex(), three.getAL().get(i));
	    			three.removeChip(i);
		    		lol=1;
				}
			}
		}
		if(four.getAL().size()>0&&lol==0) {
			for(int i=0;i<four.getAL().size();i++) {
				if((mouseX >= getWidth()/4*3+i*45+45 && mouseX <= getWidth()/4*3+i*45+90 &&mouseY >= getHeight()/25*24 && mouseY <= getHeight()/25*25)) {
					four.getAL().get(i).changeX(boardChips.get(four.getIndex()).getxVal());
	    			boardChips.set(four.getIndex(), four.getAL().get(i));
	    			four.removeChip(i);
	    			lol=1;
	    		}
			}
		} 
		    	
		    	
		
		repaint();
		
	}

	public void mousePressed(MouseEvent e) {	}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
}




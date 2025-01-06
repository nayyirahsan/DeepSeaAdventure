import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class dsRuinsPanel extends JPanel implements MouseListener {
	private BufferedImage c1,c2,c3, c4, tem, sub, blank, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16;
	private BufferedImage choice;
	private ArrayList<chip> boardChips = new ArrayList<chip>();
	private ArrayList<chip> chipSto = new ArrayList<chip>();


	
	public dsRuinsPanel()
	{
		try {
			c1 = ImageIO.read(dsRuins.class.getResource("/image/chip1.png"));
			c2 = ImageIO.read(dsRuins.class.getResource("/image/chip2.png"));
			c3 = ImageIO.read(dsRuins.class.getResource("/image/chip3.png"));
			c4 = ImageIO.read(dsRuins.class.getResource("/image/chip4.png"));
			blank = ImageIO.read(dsRuins.class.getResource("/image/blank.png"));
			sub = ImageIO.read(dsRuins.class.getResource("/image/sub.png"));
			p1 = ImageIO.read(dsRuins.class.getResource("/image/pchip1.png"));
			p2 = ImageIO.read(dsRuins.class.getResource("/image/pchip2.png"));
			p3 = ImageIO.read(dsRuins.class.getResource("/image/pchip3.png"));
			p4 = ImageIO.read(dsRuins.class.getResource("/image/pchip4.png"));
			p5 = ImageIO.read(dsRuins.class.getResource("/image/pchip5.png"));
			p6 = ImageIO.read(dsRuins.class.getResource("/image/pchip6.png"));
			p7 = ImageIO.read(dsRuins.class.getResource("/image/pchip7.png"));
			p8 = ImageIO.read(dsRuins.class.getResource("/image/pchip8.png"));
			p9 = ImageIO.read(dsRuins.class.getResource("/image/pchip9.png"));
			p10 = ImageIO.read(dsRuins.class.getResource("/image/pchip10.png"));
			p11 = ImageIO.read(dsRuins.class.getResource("/image/pchip11.png"));
			p12 = ImageIO.read(dsRuins.class.getResource("/image/pchip12.png"));
			p13 = ImageIO.read(dsRuins.class.getResource("/image/pchip13.png"));
			p14 = ImageIO.read(dsRuins.class.getResource("/image/pchip14.png"));
			p15 = ImageIO.read(dsRuins.class.getResource("/image/pchip15.png"));
			p16 = ImageIO.read(dsRuins.class.getResource("/image/pchip16.png"));
		}
		catch(Exception E) {
			System.out.println("Exception Error");
			return;
		}
		addMouseListener(this);
		
		int cx = 320, cy = 390;
		for(int i = 0; i < 8; i++) {
		
			if(i < 2) {
				int t = (int)(Math.random()*4);
				if(t == 0) { tem = p1; }
				if(t == 1) { tem = p2; }
				if(t == 2) { tem = p3; }
				if(t == 3) { tem = p4; }
				chip temp = new chip(1, t, cx, cy, false, c1,tem);
				boardChips.add(temp);
				cx += 70;
			}
			else if(i < 4) {
				int t = (int)(Math.random()*4)+4;
				if(t == 4) { tem = p5; }
				if(t == 5) { tem = p6; }
				if(t == 6) { tem = p7; }
				if(t == 7) { tem = p8; }
				chip temp = new chip(2,t, cx, cy, false, c2, tem);
				boardChips.add(temp);
				cx += 70;

			}
			else if(i < 6) {
				int t = (int)(Math.random()*4)+8;
				if(t == 8) { tem = p9; }
				if(t == 9) { tem = p10; }
				if(t == 10) { tem = p11; }
				if(t == 11) { tem = p12; }
				chip temp = new chip(3,t, cx, cy, false, c3, tem);
				boardChips.add(temp);
				cx += 70;

			}
			else if(i < 8) {
				int t = (int)(Math.random()*4)+12;
				if(t == 12) { tem = p13; }
				if(t == 13) { tem = p14; }
				if(t == 14) { tem = p15; }
				if(t == 15) { tem = p16; }
				chip temp = new chip(4,t, cx, cy, false, c4, tem);
				boardChips.add(temp);
				cx += 70;

			}
		}
		cx = 320; 
		cy = 800;
		for( int i = 0; i < 8; i++) {
			chip b = new chip(0,0, cx, cy, true, blank, blank);
			chipSto.add(b);
			cx += 70;
		}
		
		
	}
	
	public void paint(Graphics g) {
		//g.setColor(new Color(200, 216, 230)); 
		//g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(sub, 0, getHeight()/3, getWidth()/10, getHeight()/6, null);
		
		for(chip c : boardChips) {
			if(c.getStatus() == false) {
				//int i = boardChips.indexOf(c);
				g.drawImage(c.getTPicture(), c.getxVal(), c.getyVal(), getWidth()/40, getHeight()/30, null);
				//-+g.drawImage(chipSto.get(i).getPPicture(), c.getxVal(), chipSto.get(i).getyVal(), getWidth()/40, getHeight()/30, null);
				
				
			}
			else {
				int i = boardChips.indexOf(c);
				chipSto.get(i).setStatus(false);
				chip temp = c;
				boardChips.set(i, chipSto.get(i));
				chipSto.set(i, temp);
				boardChips.get(i).changeY(390);
				chipSto.get(i).changeY(750);
				g.drawImage(boardChips.get(i).getTPicture(), c.getxVal(), boardChips.get(i).getyVal(), getWidth()/40, getHeight()/30, null);
				g.drawImage(chipSto.get(i).getPPicture(), c.getxVal(), chipSto.get(i).getyVal(), getWidth()/40, getHeight()/30, null);
				
			}
		}
		
	}
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		for(chip c: boardChips) {
			if(x>= c.getxVal() && x<= c.getxVal()+40 && y>= c.getyVal() && y<= c.getyVal()+30) {
				//c.changeY(getHeight()-100);
				c.setStatus(true);
				//boardChips.remove(boardChips.indexOf(c));
			}
		}
		repaint();
		
	}

	public void mousePressed(MouseEvent e) {	}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
}




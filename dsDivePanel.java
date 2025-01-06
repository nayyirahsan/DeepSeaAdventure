import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class dsDivePanel extends JPanel implements MouseListener{
	private BufferedImage sub, blank, diver, diverflip;
	private int cx,cy;
	private int dx, dy, index = 0;
	boolean back = false;
	boolean forward = true;
	private ArrayList<chip> chipSto = new ArrayList<chip>();
	
	public dsDivePanel() {
		try {
			blank = ImageIO.read(dsDive.class.getResource("/image/blank.png"));
			sub = ImageIO.read(dsDive.class.getResource("/image/sub.png"));
			diver = ImageIO.read(dsDive.class.getResource("/image/diver.png"));
			diverflip=ImageIO.read(dsDive.class.getResource("/image/diverflip.png"));
			
		}
		catch(Exception E) {
			System.out.println("Exception Error");
			return;
		}
		addMouseListener(this);
		
		cx = 320; 
		cy = 300;
		for( int i = 0; i < 10; i++) {
			chip b = new chip(0,0, cx, cy, false, blank, blank);
			chipSto.add(b);
			cx += 100;
		}
		dx = 0;
		dy = 350;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(new Color(173, 216, 230)); 
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLUE);
		g.fillRect(getWidth()/4, getHeight()/3*2, getWidth()/4, getHeight()/4);
		g.drawImage(sub, 0, getHeight()/4, getWidth()/10, getHeight()/6, null);
		g.setColor(Color.BLUE);
		g.fillRect(getWidth()/4, getHeight()/3*2, getWidth()/4, getHeight()/4);
		g.setColor(Color.RED);
		g.fillRect(getWidth()/2, getHeight()/3*2, getWidth()/4, getHeight()/4);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.PLAIN, 50));
		g.drawString("GO", getWidth()/14*5, getHeight()/10*8);
		g.drawString("TURN BACK", getWidth()/15*8, getHeight()/10*8);
		//g.setColor(Color.BLACK);
		//g.drawString("CURRENT POS: " + index, getWidth()/5*2, getHeight()/10);

		
		for (chip c: chipSto) {
			if(c.getStatus() == false) {
				g.drawImage(c.getTPicture(), c.getxVal(), c.getyVal(), getWidth()/32, getHeight()/24, null);
			}
		}
		if(forward==false) {
			g.drawImage(diverflip, dx, dy, getWidth()/10, getHeight()/6, null);
		}
		else g.drawImage(diver, dx, dy, getWidth()/10, getHeight()/6, null);

	}

	public void mouseClicked(MouseEvent e) {	
		int x = e.getX();
		int y = e.getY();
		
		if(!back)
		{
			if(x>getWidth()/4 && y > getHeight()/3*2 && x < getWidth()/4+getWidth()/4 && y < getHeight()/3*2 + getHeight()/4 && forward)
			{
				
				
				int rand = (int)(Math.random()*5 + 2);
				index += rand;
				if (index >= 10) {
					index = 10;
					forward = false;
				}
				dx = (chipSto.get(index-1).getxVal()-50);
				System.out.println(index);
			}
			
			else if(x>getWidth()/4 && y > getHeight()/3*2 && x < getWidth()/4+getWidth()/4 && y < getHeight()/3*2 + getHeight()/4 && !forward)
			{
				
				
				int rand = (int)(Math.random()*5 + 2);
				index -= rand;
				if (index <= 0) {
					index = 0;
					forward = false;
					dx = 0;
				}
				else {
					
					dx = (chipSto.get(index-1).getxVal()-50);
				}
				System.out.println(index);
			}
			
			else if(x>getWidth()/2 && y > getHeight()/3*2 && x < getWidth()/2+getWidth()/4 && y < getHeight()/3*2 + getHeight()/4)
			{
				if (forward == false) {
					forward = true;
				}
				else if(forward == true) {
					forward = false;
				}
			}
			
		}
		repaint();
		
	}
	public void mousePressed(MouseEvent e) {
		
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	public void mouseEntered(MouseEvent e) {
		
	}
	public void mouseExited(MouseEvent e) {
		
	}
	
	
	
}

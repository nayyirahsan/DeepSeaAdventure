import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class diver {
	private ArrayList<chip> tbag = new ArrayList<chip>();
	private int index, turn;
	private BufferedImage image;
	private boolean dir;
	
	public diver(int i, int t, ArrayList<chip> tb, BufferedImage img, boolean face)
	{
		index = i;
		turn = t;
		tbag = tb;
		image=img;
		dir=face;
		
	}
	public int getTotal() {
		int v=0;
		for(int i=0;i<tbag.size();i++) {
			v=v+tbag.get(i).getPoints();
		}
		return v;
	}
	
	public int getIndex() {
		return index;
	}
	
	public ArrayList<chip> getAL(){
		return tbag;
	}
	
	public void addChip(chip c) {
		tbag.add(c);
	}
	
	public void removeChip(int n) {
		tbag.remove(n);
	}
	
	public void changeIndex(int n) {
		if(n>=32) {
			n=32;
			dir=false;
			index = n;
		}
		else if(n<0) {
			n=0;
			index = n;
		}
		else
			index = n;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void changeImage(BufferedImage idk) {
		image=idk;
	}
	public boolean getDir() {
		return dir;
	}
	public void changeDir() {
		dir=false;
	}
	
}

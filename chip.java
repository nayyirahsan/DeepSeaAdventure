import java.awt.image.BufferedImage;
public class chip {
	private int tier, points, xVal, yVal;
	private boolean status;
	private BufferedImage tpicture, ppicture;
	public chip(int t, int p, int valx, int valy, boolean s, BufferedImage tpic, BufferedImage ppic) {
		tier = t;
		points = p;
		xVal = valx;
		yVal = valy;
		status = s;
		tpicture = tpic;
		ppicture = ppic;
	}
	
	public int getTier() {
		return tier;
	}
	public int getPoints() {
		return points;
	}
	public int getxVal() {
		return xVal;
	}
	public void changeX(int c) {
		xVal = c;
	}
	public void changeY(int c) {
		yVal = c;
	}
	public int getyVal() {
		return yVal;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean x) {
		status = x;
	}
	public BufferedImage getTPicture() {
		return tpicture;
	}
	public BufferedImage getPPicture() {
		return ppicture;
	}
}

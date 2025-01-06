import javax.swing.JFrame;
public class dsDive extends JFrame{
	private static final int WIDTH = 1600;
	private static final int HEIGHT = 900;
	
	public dsDive(String title) {
		super(title);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new dsDivePanel());
		setVisible(true);
	}
}

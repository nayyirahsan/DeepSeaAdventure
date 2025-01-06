import javax.swing.JFrame;
public class Adventure extends JFrame {
	private static final int WIDTH = 1920;
	private static final int HEIGHT = 1080;
	
	public Adventure(String title) {
		super(title);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new AdventurePanel());
		setVisible(true);
	}
}

import javax.swing.JFrame;
public class dsRuins extends JFrame {
	private static final int WIDTH = 1600;
	private static final int HEIGHT = 900;
	
	public dsRuins(String title) {
		super(title);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new dsRuinsPanel());
		setVisible(true);
	}
}

import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
		
		Window w = new Window("Java Calculator");
		w.setVisible(true);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setResizable(false);
		w.setSize(200, 240);
		w.setLocationRelativeTo(null);
	}
	
}

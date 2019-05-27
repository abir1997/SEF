package qrCode;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AppFrame extends JFrame {

	private static final long serialVersionUID = 4563266193219858943L;

	public AppFrame() {
		super("QR Code");
		setBounds(100, 100, 1200, 890);
		ImageIcon icon = new ImageIcon("code.png");
		JLabel img = new JLabel(icon);
		add(img);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AppFrame();
	}
}

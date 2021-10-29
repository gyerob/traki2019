package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Splash extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3220037858791064240L;
	private ImageIcon image;
	private JLabel label;
	private Dimension screen;
	private JLayeredPane contentPane;
	private JTextField txtKezdszveg;

	/**
	 * Create the frame.
	 */
	public Splash() {
		screen = Toolkit.getDefaultToolkit().getScreenSize();
		image = new ImageIcon(getClass().getResource("/Images/traktorverseny_splash.jpg"));
		int w = image.getIconWidth();
		int h = image.getIconHeight();
		System.out.println(image.getIconWidth());
		System.out.println(image.getIconHeight());
		
		setBounds((screen.width-w)/2, (screen.height-h)/2, w, h);
		contentPane = new JLayeredPane();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		label = new JLabel(image);
		label.setBounds(0, 0, w, h);
		contentPane.add(label);
		
		txtKezdszveg = new JTextField();
		txtKezdszveg.setEditable(false);
		txtKezdszveg.setBorder(null);
		txtKezdszveg.setHorizontalAlignment(SwingConstants.CENTER);
		txtKezdszveg.setText("Kezd\u0151sz\u00F6veg");
		txtKezdszveg.setOpaque(false);
		contentPane.setLayer(txtKezdszveg, 1);
		txtKezdszveg.setBounds(0, 0, w, 28);
		contentPane.add(txtKezdszveg);
		txtKezdszveg.setColumns(10);
	}

	public void setMessage(String text){
		txtKezdszveg.setText(text);
	}
}

package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class KijelzoPanel extends JLayeredPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5659978707819022279L;
	private JTextField textIdo1;
	private JTextField textIdo2;
	private JTextField textKovB1;
	private JTextField textKovA1;
	private JTextField textKovA2;
	private JTextField textKovB2;

	private JLabel lblLamp1;
	private JLabel lblLamp2;
	private JLabel lblLamp3;

	/**
	 * Create the panel.
	 */
	public KijelzoPanel() {
		setOpaque(true);
		setBackground(new Color(0, 100, 0));
		setLayout(null);

		textIdo1 = new JTextField();
		setLayer(textIdo1, 1);
		textIdo1.setEditable(false);
		textIdo1.setFont(new Font("Tahoma", Font.BOLD, 36));
		textIdo1.setHorizontalAlignment(SwingConstants.CENTER);
		textIdo1.setForeground(new Color(255, 0, 0));
		textIdo1.setBounds(53, 42, 198, 65);
		add(textIdo1);
		textIdo1.setColumns(10);

		textIdo2 = new JTextField();
		setLayer(textIdo2, 1);
		textIdo2.setEditable(false);
		textIdo2.setFont(new Font("Tahoma", Font.BOLD, 36));
		textIdo2.setHorizontalAlignment(SwingConstants.CENTER);
		textIdo2.setForeground(new Color(255, 0, 0));
		textIdo2.setBounds(53, 118, 198, 65);
		add(textIdo2);
		textIdo2.setColumns(10);

		textKovB1 = new JTextField();
		setLayer(textKovB1, 1);
		textKovB1.setEditable(false);
		textKovB1.setFont(new Font("Tahoma", Font.BOLD, 50));
		textKovB1.setForeground(new Color(255, 0, 0));
		textKovB1.setHorizontalAlignment(SwingConstants.CENTER);
		textKovB1.setColumns(10);
		textKovB1.setBounds(397, 42, 86, 65);
		add(textKovB1);

		textKovA1 = new JTextField();
		setLayer(textKovA1, 1);
		textKovA1.setEditable(false);
		textKovA1.setFont(new Font("Tahoma", Font.BOLD, 50));
		textKovA1.setForeground(new Color(255, 0, 0));
		textKovA1.setHorizontalAlignment(SwingConstants.CENTER);
		textKovA1.setColumns(10);
		textKovA1.setBounds(301, 42, 86, 65);
		add(textKovA1);

		textKovA2 = new JTextField();
		setLayer(textKovA2, 1);
		textKovA2.setEditable(false);
		textKovA2.setFont(new Font("Tahoma", Font.BOLD, 50));
		textKovA2.setForeground(new Color(255, 0, 0));
		textKovA2.setHorizontalAlignment(SwingConstants.CENTER);
		textKovA2.setColumns(10);
		textKovA2.setBounds(301, 118, 86, 65);
		add(textKovA2);

		textKovB2 = new JTextField();
		setLayer(textKovB2, 1);
		textKovB2.setEditable(false);
		textKovB2.setFont(new Font("Tahoma", Font.BOLD, 50));
		textKovB2.setForeground(new Color(255, 0, 0));
		textKovB2.setHorizontalAlignment(SwingConstants.CENTER);
		textKovB2.setColumns(10);
		textKovB2.setBounds(397, 118, 86, 65);
		add(textKovB2);

		JLabel lblLblidohatter = new JLabel("");
		lblLblidohatter.setOpaque(true);
		lblLblidohatter.setBackground(Color.BLACK);
		lblLblidohatter.setBounds(47, 35, 210, 156);
		add(lblLblidohatter);

		JLabel lblLblkovhatter = new JLabel("");
		lblLblkovhatter.setBackground(Color.BLACK);
		lblLblkovhatter.setOpaque(true);
		lblLblkovhatter.setBounds(295, 35, 194, 156);
		add(lblLblkovhatter);

		JLabel lblA = new JLabel("A");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblA.setForeground(Color.WHITE);
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setBounds(10, 42, 36, 65);
		add(lblA);

		JLabel lblB = new JLabel("B");
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblB.setForeground(Color.WHITE);
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		lblB.setBounds(10, 118, 36, 65);
		add(lblB);

		JLabel lblA_1 = new JLabel("A");
		lblA_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblA_1.setForeground(Color.WHITE);
		lblA_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblA_1.setBounds(301, 0, 86, 31);
		add(lblA_1);

		JLabel lblB_1 = new JLabel("B");
		lblB_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblB_1.setForeground(Color.WHITE);
		lblB_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblB_1.setBounds(397, 0, 86, 31);
		add(lblB_1);

		lblLamp1 = new JLabel("");
		lblLamp1.setOpaque(true);
		lblLamp1.setBounds(527, 42, 30, 30);
		add(lblLamp1);

		lblLamp2 = new JLabel("");
		lblLamp2.setOpaque(true);
		lblLamp2.setBounds(527, 84, 30, 30);
		add(lblLamp2);

		lblLamp3 = new JLabel("");
		lblLamp3.setOpaque(true);
		lblLamp3.setBounds(527, 126, 30, 30);
		add(lblLamp3);

	}

	public void setTime(String ido, int track) {
		if (track == 1) {
			textIdo1.setText(ido);
		} else if (track == 2) {
			textIdo2.setText(ido);
		}
	}

	public void setNext(int A1, int B1, int A2, int B2) {
		if (A1 > 0) {
			textKovA1.setText(Integer.toString(A1));
		} else {
			textKovA1.setText("");
		}
		if (A2 > 0) {
			textKovA2.setText(Integer.toString(A2));
		} else {
			textKovA2.setText("");
		}
		if (B1 > 0) {
			textKovB1.setText(Integer.toString(B1));
		} else {
			textKovB1.setText("");
		}
		if (B2 > 0) {
			textKovB2.setText(Integer.toString(B2));
		} else {
			textKovB2.setText("");
		}
	}

	public void setLampColor(int state) {
		switch(state) {
		case 0:{
			lblLamp1.setBackground(Color.green);
			lblLamp2.setBackground(Color.green);
			lblLamp3.setBackground(Color.green);
			break;
		}
		case 1:{
			lblLamp1.setBackground(Color.red);
			break;
		}
		case 2:{
			lblLamp2.setBackground(Color.red);			
			break;
		}
		case 3:{
			lblLamp3.setBackground(Color.red);			
			break;
		}
		}
	}
}

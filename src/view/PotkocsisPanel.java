package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.table.DefaultTableModel;

import datastorage.DbConstants;
import datastorage.DbFunctions;
import pojo.Potkocsi;
import timing.Lamp;
import traktoros.Main;

public class PotkocsisPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4408897710735280971L;
	private JTextField txtRajtszm;
	private JTextField txtId;
	private JTextField txtHiba;
	private JTextField txtVglegesId;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField textRajt1;
	private JTextField textIdo1;
	private JTextField textHiba1;
	private JTextField textVido1;
	private JTextField textRajt2;
	private JTextField textIdo2;
	private JTextField textHiba2;
	private JTextField textVido2;

	private DefaultTableModel tableModel;
	private String[] oszlopok;
	private int sorok;

	private MainFrame mainFrame;

	private boolean earlyA = false;
	private boolean earlyB = false;
	private JButton btnMentes;
	private JButton btnListaz;
	private JButton btnRajt;

	private final ButtonGroup buttonGroup = new ButtonGroup();

	private int selectedcategory = 0;
	private JRadioButton noi;
	private JRadioButton veteran;
	private JRadioButton loerofelett;
	private JRadioButton loeroalatt;
	private JTextField txtElindult;
	private JLabel lblElindultA;
	private JLabel lblElindultB;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;

	/**
	 * Create the panel.
	 */
	public PotkocsisPanel(JTabbedPane panel, MainFrame mf) {
		panel.setUI(new BasicTabbedPaneUI() {
			@Override
			protected void installDefaults() {
				super.installDefaults();

				highlight = Color.lightGray;
				lightHighlight = Color.white;

				shadow = Color.gray;
				darkShadow = Color.darkGray;

				// Active tab background is white
				// so set the focus color to white
				// to hide the active tab focus
				// marker seeing that we want the
				// active tab backgound to be different
				focus = Color.black;
			}
		});

		UIManager.put("TabbedPane.selected", Color.green);

		UIManager.put("TabbedPane.unselectedTabBackground", Color.black);

		oszlopok = new String[] { "Rajtszám", "Név", "Kategória", "Idõ", "Hiba", "Végleges idõ" };

		mainFrame = mf;

		setForeground(new Color(255, 255, 255));
		setBackground(new Color(0, 100, 0));
		setLayout(null);

		txtRajtszm = new JTextField();
		txtRajtszm.setBorder(null);
		txtRajtszm.setForeground(new Color(255, 255, 255));
		txtRajtszm.setBackground(new Color(0, 100, 0));
		txtRajtszm.setText("Rajtsz\u00E1m:");
		txtRajtszm.setEditable(false);
		txtRajtszm.setBounds(10, 52, 86, 20);
		add(txtRajtszm);
		txtRajtszm.setColumns(10);

		txtId = new JTextField();
		txtId.setBorder(null);
		txtId.setForeground(new Color(255, 255, 255));
		txtId.setBackground(new Color(0, 100, 0));
		txtId.setText("Id\u0151:");
		txtId.setEditable(false);
		txtId.setBounds(10, 83, 86, 20);
		add(txtId);
		txtId.setColumns(10);

		txtHiba = new JTextField();
		txtHiba.setBorder(null);
		txtHiba.setForeground(new Color(255, 255, 255));
		txtHiba.setBackground(new Color(0, 100, 0));
		txtHiba.setText("Hiba:");
		txtHiba.setEditable(false);
		txtHiba.setBounds(10, 114, 86, 20);
		add(txtHiba);
		txtHiba.setColumns(10);

		txtVglegesId = new JTextField();
		txtVglegesId.setBorder(null);
		txtVglegesId.setForeground(new Color(255, 255, 255));
		txtVglegesId.setBackground(new Color(0, 100, 0));
		txtVglegesId.setText("V\u00E9gleges id\u0151:");
		txtVglegesId.setEditable(false);
		txtVglegesId.setBounds(10, 145, 86, 20);
		add(txtVglegesId);
		txtVglegesId.setColumns(10);

		txtA = new JTextField();
		txtA.setBorder(null);
		txtA.setForeground(new Color(255, 255, 255));
		txtA.setBackground(new Color(0, 100, 0));
		txtA.setHorizontalAlignment(SwingConstants.CENTER);
		txtA.setText("A p\u00E1lya");
		txtA.setEditable(false);
		txtA.setBounds(146, 11, 86, 20);
		add(txtA);
		txtA.setColumns(10);

		txtB = new JTextField();
		txtB.setBorder(null);
		txtB.setForeground(new Color(255, 255, 255));
		txtB.setBackground(new Color(0, 100, 0));
		txtB.setHorizontalAlignment(SwingConstants.CENTER);
		txtB.setText("B p\u00E1lya");
		txtB.setEditable(false);
		txtB.setBounds(299, 11, 86, 20);
		add(txtB);
		txtB.setColumns(10);

		textRajt1 = new JTextField();
		textRajt1.setBounds(146, 52, 86, 20);
		add(textRajt1);
		textRajt1.setColumns(10);

		textIdo1 = new JTextField();
		textIdo1.setBounds(146, 83, 86, 20);
		add(textIdo1);
		textIdo1.setColumns(10);
		textIdo1.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// textChanged(textIdo1, textHiba1, textVido1);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				textChanged(textIdo1, textHiba1, textVido1);
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				textChanged(textIdo1, textHiba1, textVido1);
			}
		});

		textHiba1 = new JTextField();
		textHiba1.setBounds(146, 114, 86, 20);
		add(textHiba1);
		textHiba1.setColumns(10);
		textHiba1.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// textChanged(textIdo1, textHiba1, textVido1);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				textChanged(textIdo1, textHiba1, textVido1);
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				textChanged(textIdo1, textHiba1, textVido1);
			}
		});

		textVido1 = new JTextField();
		textVido1.setBounds(146, 145, 86, 20);
		add(textVido1);
		textVido1.setColumns(10);

		textRajt2 = new JTextField();
		textRajt2.setBounds(299, 52, 86, 20);
		add(textRajt2);
		textRajt2.setColumns(10);

		textIdo2 = new JTextField();
		textIdo2.setBounds(299, 83, 86, 20);
		add(textIdo2);
		textIdo2.setColumns(10);
		textIdo2.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// textChanged(textIdo2, textHiba2, textVido2);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				textChanged(textIdo2, textHiba2, textVido2);
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				textChanged(textIdo2, textHiba2, textVido2);
			}
		});

		textHiba2 = new JTextField();
		textHiba2.setBounds(299, 114, 86, 20);
		add(textHiba2);
		textHiba2.setColumns(10);
		textHiba2.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// textChanged(textIdo2, textHiba2, textVido2);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				textChanged(textIdo2, textHiba2, textVido2);
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				textChanged(textIdo2, textHiba2, textVido2);
			}
		});

		textVido2 = new JTextField();
		textVido2.setBounds(299, 145, 86, 20);
		add(textVido2);
		textVido2.setColumns(10);

		btnMentes = new JButton("Ment\u00E9s");
		btnMentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ment();
			}
		});
		btnMentes.setBounds(452, 83, 89, 23);
		add(btnMentes);

		btnListaz = new JButton("List\u00E1z");
		btnListaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatelist();
			}
		});
		btnListaz.setBounds(452, 52, 89, 23);
		add(btnListaz);

		btnRajt = new JButton("Rajt");
		btnRajt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rajt();
			}
		});
		btnRajt.setBounds(452, 145, 89, 23);
		add(btnRajt);

		loeroalatt = new JRadioButton("150 L\u00F3er\u0151 alatt");
		loeroalatt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				selectedcategory = 0;
				updatelist();
			}
		});
		loeroalatt.setSelected(true);
		loeroalatt.setOpaque(false);
		buttonGroup.add(loeroalatt);
		loeroalatt.setForeground(Color.WHITE);
		loeroalatt.setBounds(630, 52, 125, 23);
		add(loeroalatt);

		loerofelett = new JRadioButton("150 L\u00F3er\u0151 felett");
		loerofelett.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				selectedcategory = 1;
				updatelist();
			}
		});
		loerofelett.setOpaque(false);
		buttonGroup.add(loerofelett);
		loerofelett.setForeground(Color.WHITE);
		loerofelett.setBounds(630, 84, 125, 23);
		add(loerofelett);

		veteran = new JRadioButton("Veter\u00E1n");
		veteran.setVisible(false);
		veteran.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				selectedcategory = 2;
				updatelist();
			}
		});
		veteran.setOpaque(false);
		buttonGroup.add(veteran);
		veteran.setForeground(Color.WHITE);
		veteran.setBounds(630, 116, 125, 23);
		add(veteran);

		noi = new JRadioButton("N\u0151i");
		noi.setVisible(false);
		noi.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				selectedcategory = 3;
				updatelist();
			}
		});
		noi.setOpaque(false);
		buttonGroup.add(noi);
		noi.setForeground(Color.WHITE);
		noi.setBounds(630, 148, 125, 23);
		add(noi);

		//TODO
		JButton kizarA = new JButton("Kiz\u00E1r");
		kizarA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textHiba1.setText("1");
				textIdo1.setText("09:59:999");
				textVido1.setText("09:59:999");
				earlyA = true;
				try {
					Main.sn.sendmsg("AK\n", Main.sn.getDisplay());
					mainFrame.setDisplayTime("-:--:---", 1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.out.println("kizarA");
				System.out.println(earlyA);
			}
		});
		kizarA.setBounds(146, 176, 86, 23);
		add(kizarA);

		JButton kizarB = new JButton("Kiz\u00E1r");
		kizarB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textHiba2.setText("1");
				textIdo2.setText("09:59:999");
				textVido2.setText("09:59:999");
				earlyB = true;
				try {
					Main.sn.sendmsg("BK\n", Main.sn.getDisplay());
					mainFrame.setDisplayTime("-:--:---", 2);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		kizarB.setBounds(299, 176, 86, 23);
		add(kizarB);

		txtElindult = new JTextField();
		txtElindult.setForeground(new Color(255, 255, 255));
		txtElindult.setBackground(new Color(0, 100, 0));
		txtElindult.setEditable(false);
		txtElindult.setBorder(null);
		txtElindult.setText("Elindult:");
		txtElindult.setBounds(10, 207, 86, 23);
		add(txtElindult);
		txtElindult.setColumns(10);

		lblElindultA = new JLabel("  ");
		lblElindultA.setBackground(new Color(204, 0, 0));
		lblElindultA.setOpaque(true);
		lblElindultA.setBounds(146, 207, 86, 23);
		add(lblElindultA);

		lblElindultB = new JLabel("  ");
		lblElindultB.setBackground(new Color(204, 0, 0));
		lblElindultB.setOpaque(true);
		lblElindultB.setBounds(299, 207, 86, 23);
		add(lblElindultB);

		JButton button = new JButton("+");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hibapontozasA(1);
			}
		});
		button.setBorder(null);
		button.setSize(new Dimension(30, 23));
		button.setPreferredSize(new Dimension(30, 23));
		button.setBounds(232, 114, 25, 20);
		add(button);

		button_1 = new JButton("-");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				hibapontozasA(-1);
			}
		});
		button_1.setSize(new Dimension(30, 23));
		button_1.setPreferredSize(new Dimension(30, 23));
		button_1.setBorder(null);
		button_1.setBounds(121, 114, 25, 20);
		add(button_1);

		button_2 = new JButton("+");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hibapontozasB(1);
			}
		});
		button_2.setSize(new Dimension(30, 23));
		button_2.setPreferredSize(new Dimension(30, 23));
		button_2.setBorder(null);
		button_2.setBounds(385, 114, 25, 20);
		add(button_2);

		button_3 = new JButton("-");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hibapontozasB(-1);
			}
		});
		button_3.setActionCommand("-");
		button_3.setSize(new Dimension(30, 23));
		button_3.setPreferredSize(new Dimension(30, 23));
		button_3.setBorder(null);
		button_3.setBounds(274, 114, 25, 20);
		add(button_3);

		updatelist();
	}

	public void textChanged(JTextField field, JTextField error, JTextField finalfield) {
		int perc, masod, ezred, hiba;
		String ido="", p, m, ez;
		String[] split;

		if (!field.getText().equals("") && field.getText().length() > 7) {
			ido = field.getText();
			split = ido.split(":");
			perc = Integer.parseInt(split[0]);
			masod = Integer.parseInt(split[1]);
			ezred = Integer.parseInt(split[2]);
		} else {
			perc = 0;
			masod = 0;
			ezred = 0;
		}

		if (!error.getText().equals("")) {
			hiba = Integer.parseInt(error.getText());
		} else {
			hiba = 0;
		}

		if (hiba > 0) {
			masod += hiba * 5;
			while (masod > 59) {
				perc++;
				masod -= 60;
			}
		}
		
		//System.out.println(ido+" " +perc+" "+masod+" "+ezred);

		p = String.format("%02d", perc);
		m = String.format("%02d", masod);
		ez = String.format("%03d", ezred);

		ido = p + ":" + m + ":" + ez;

		finalfield.setText(ido);
		ment();
	}

	public void updatelist() {
		sorok = new DbFunctions().count(DbConstants.Potkocsis.Database_Table);
		tableModel = new DefaultTableModel(oszlopok, sorok);

		String kategoria = "150a";
		switch (selectedcategory) {
		case 0:
			kategoria = "150a";
			break;
		case 1:
			kategoria = "150f";
			break;
		case 2:
			kategoria = "veteran";
			break;
		case 3:
			kategoria = "No";
			break;
		}

		ArrayList<Potkocsi> lista = new DbFunctions().selectPotkocsis();
		Potkocsi p;
		int j = 0;

		for (int i = 0; i < lista.size(); i++) {
			p = lista.get(i);
			if (selectedcategory < 3 && p.getKategoria().equals(kategoria) && p.getNeme().equals("Ferfi")) {
				tableModel.setValueAt(p.getRajt(), j, 0);
				tableModel.setValueAt(p.getNev(), j, 1);
				tableModel.setValueAt(p.getKategoria(), j, 2);
				tableModel.setValueAt(p.getIdo(), j, 3);
				tableModel.setValueAt(p.getHiba(), j, 4);
				tableModel.setValueAt(p.getVido(), j, 5);
				j++;
			} else if (p.getNeme().equals(kategoria)) {
				tableModel.setValueAt(p.getRajt(), j, 0);
				tableModel.setValueAt(p.getNev(), j, 1);
				tableModel.setValueAt(p.getKategoria(), j, 2);
				tableModel.setValueAt(p.getIdo(), j, 3);
				tableModel.setValueAt(p.getHiba(), j, 4);
				tableModel.setValueAt(p.getVido(), j, 5);
				j++;
			}
		}

		while (tableModel.getRowCount() > j) {
			tableModel.removeRow(tableModel.getRowCount() - 1);
		}

		refresh();
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	private void rajt() {
		earlyA = false;
		earlyB = false;
		textIdo1.setText("");
		textIdo2.setText("");
		textHiba1.setText("0");
		textHiba2.setText("0");
		textVido1.setText("");
		textVido2.setText("");
		mainFrame.clearDisplay();
		new Lamp().start();
		// System.out.println("startgomb");
	}

	public void setNext(int A, int B) {
		if (A > 0)
			textRajt1.setText(Integer.toString(A));
		else 
			textRajt1.setText("");
		if (B > 0)
			textRajt2.setText(Integer.toString(B));
		else
			textRajt2.setText("");
	}

	//TODO
	public void setTime(long min, long sec, long milli, int track) {
		String ido, /* finaltime, */ perc, masodperc, ezred;

		if (min > 10) {
			perc = "09";
			masodperc = "59";
			ezred = "999";
		} else {
			perc = String.format("%02d", min);// Long.toString(min);
			masodperc = String.format("%02d", sec);
			ezred = String.format("%03d", milli);
		}

		ido = perc + ":" + masodperc + ":" + ezred;
		// finaltime = ido;

		if (track == 1) {
			System.out.println(earlyA);
			if (!earlyA) {
				textIdo1.setText(ido);
				// textVido1.setText(finaltime);
			}
		} else if (track == 2) {
			if (!earlyB) {
				textIdo2.setText(ido);
				// textVido2.setText(finaltime);
			}
		}
	}

	public void earlyStart(int track) {
		//System.out.println("korai" + track);
		
		if (track == 1) {
			textHiba1.setText("2");

			textIdo1.setText("09:59:999");
			textVido1.setText("09:59:999");
			earlyA = true;

		} else if (track == 2) {
			textHiba2.setText("2");

			textIdo2.setText("09:59:999");
			textVido2.setText("09:59:999");
			earlyB = true;

		}
	}

	public void refresh() {
		mainFrame.refreshtable();
	}

	public void displayTime() {
		if (earlyA)
			mainFrame.setDisplayTime("-:--:---", 1);
		else
			mainFrame.setDisplayTime(textVido1.getText(), 1);

		if (earlyB)
			mainFrame.setDisplayTime("-:--:---", 2);
		else
			mainFrame.setDisplayTime(textVido2.getText(), 2);
	}

	public void ment() {
		String ido1, ido2;
		if (!textRajt1.getText().equals("") && !textIdo1.getText().equals("") && !textHiba1.getText().equals("")
				&& !textVido1.getText().equals("")) {

			new DbFunctions().updatePotkocsis(Integer.parseInt(textRajt1.getText()), textIdo1.getText(),
					Integer.parseInt(textHiba1.getText()), textVido1.getText());
		}

		if (!textRajt2.getText().equals("") && !textIdo2.getText().equals("") && !textHiba2.getText().equals("")
				&& !textVido2.getText().equals("")) {

			new DbFunctions().updatePotkocsis(Integer.parseInt(textRajt2.getText()), textIdo2.getText(),
					Integer.parseInt(textHiba2.getText()), textVido2.getText());
		}

		try {
			ido1 = /* "A" + */textVido1.getText();// + "\n";
			ido2 = /* "B" + */textVido2.getText();// + "\n";

			if (ido1.compareTo(ido2) < 0) {
				ido1 = "A" + ido1 + "J\n";
				ido2 = "B" + ido2 + "\n";
			} else if (ido1.compareTo(ido2) > 0) {
				ido1 = "A" + ido1 + "\n";
				ido2 = "B" + ido2 + "J\n";
			} else {
				ido1 = "A" + ido1 + "\n";
				ido2 = "B" + ido2 + "\n";
			}
			// System.out.println(ido1 + " " + ido2);

			if (earlyA)
				Main.sn.sendmsg("AK\n", Main.sn.getDisplay());
			else
				Main.sn.sendmsg(ido1, Main.sn.getDisplay());

			if (earlyB)
				Main.sn.sendmsg("BK\n", Main.sn.getDisplay());
			else
				Main.sn.sendmsg(ido2, Main.sn.getDisplay());
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		//earlyA = false;
		//earlyB = false;

		updatelist();
		displayTime();
	}

	public int getCategory() {
		if (loeroalatt.isSelected())
			return 0;
		else
			return 1;
	}

	public void setElindult(int track, int state) {
		Color szin = Color.red;
		switch (state) {
		case 0: {
			szin = Color.red;
			break;
		}
		case 1: {
			szin = Color.yellow;
			break;
		}
		case 2: {
			szin = Color.green;
			break;
		}
		}
		if (track == 1) {
			lblElindultA.setBackground(szin);
		} else if (track == 2) {
			lblElindultB.setBackground(szin);
		}
	}

	private void hibapontozasA(int irany) {
		int pont;
		if (textHiba1.getText().equals("")) {
			pont = 0;
		} else {
			pont = Integer.parseInt(textHiba1.getText());
		}
		if (irany == 1) {
			pont++;
			textHiba1.setText(Integer.toString(pont));
		} else if (irany == -1) {
			if (pont > 0) {
				pont--;
			}
			textHiba1.setText(Integer.toString(pont));
		}
	}

	private void hibapontozasB(int irany) {
		int pont;
		if (textHiba2.getText().equals("")) {
			pont = 0;
		} else {
			pont = Integer.parseInt(textHiba2.getText());
		}
		if (irany == 1) {
			pont++;
			textHiba2.setText(Integer.toString(pont));
		} else if (irany == -1) {
			if (pont > 0) {
				pont--;
			}
			textHiba2.setText(Integer.toString(pont));
		}
	}
}

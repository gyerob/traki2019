package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import pojo.Gyorsulas;
import timing.Display;
import timing.Lamp;

public class GyorsulasPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3624936852358827018L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textRajt1;
	private JTextField textIdo1;
	private JTextField textRajt2;
	private JTextField textIdo2;
	private JCheckBox chckbxKor;

	private DefaultTableModel tableModel;
	private String[] oszlopok;
	private int sorok;

	private MainFrame mainFrame;

	private boolean earlyA = false;
	private boolean earlyB = false;
	private JRadioButton loeroalatt;
	private JRadioButton loerofelett;
	private JRadioButton veteran;
	private JRadioButton noi;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private int selectedcategory = 0;
	private JButton kizarA;
	private JButton kizarB;
	private JTextField textField_2;
	private JLabel lblElindultA;
	private JLabel lblElindultB;

	/**
	 * Create the panel.
	 */
	public GyorsulasPanel(JTabbedPane panel, MainFrame mf) {
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

		oszlopok = new String[] { "Rajtszám", "Név", "Kategória", "Idõ1", "Idõ2", "Legjobb idõ" };

		mainFrame = mf;

		setForeground(new Color(255, 255, 255));
		setBackground(new Color(0, 100, 0));
		setLayout(null);

		textField = new JTextField();
		textField.setBorder(null);
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(0, 100, 0));
		textField.setText("Rajtsz\u00E1m:");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(10, 52, 86, 20);
		add(textField);

		textField_1 = new JTextField();
		textField_1.setBorder(null);
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setBackground(new Color(0, 100, 0));
		textField_1.setText("Id\u0151:");
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(10, 83, 86, 20);
		add(textField_1);

		textField_4 = new JTextField();
		textField_4.setBorder(null);
		textField_4.setForeground(new Color(255, 255, 255));
		textField_4.setBackground(new Color(0, 100, 0));
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setText("A p\u00E1lya");
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(146, 11, 86, 20);
		add(textField_4);

		textField_5 = new JTextField();
		textField_5.setBorder(null);
		textField_5.setForeground(new Color(255, 255, 255));
		textField_5.setBackground(new Color(0, 100, 0));
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setText("B p\u00E1lya");
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(299, 11, 86, 20);
		add(textField_5);

		textRajt1 = new JTextField();
		textRajt1.setColumns(10);
		textRajt1.setBounds(146, 52, 86, 20);
		add(textRajt1);

		textIdo1 = new JTextField();
		textIdo1.setColumns(10);
		textIdo1.setBounds(146, 83, 86, 20);
		add(textIdo1);
		textIdo1.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// textChanged();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				textChanged();
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				textChanged();
			}
		});

		textRajt2 = new JTextField();
		textRajt2.setColumns(10);
		textRajt2.setBounds(299, 52, 86, 20);
		add(textRajt2);

		textIdo2 = new JTextField();
		textIdo2.setColumns(10);
		textIdo2.setBounds(299, 83, 86, 20);
		add(textIdo2);
		textIdo2.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// textChanged();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				textChanged();
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				textChanged();
			}
		});

		JButton btnMentes = new JButton("Ment\u00E9s");
		btnMentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ment();
			}
		});
		btnMentes.setBounds(452, 83, 89, 23);
		add(btnMentes);

		JButton btnListaz = new JButton("List\u00E1z");
		btnListaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatelist();
			}
		});
		btnListaz.setBounds(452, 52, 89, 23);
		add(btnListaz);

		JButton btnRajt = new JButton("Rajt");
		btnRajt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rajt();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRajt.setBounds(452, 145, 89, 23);
		add(btnRajt);

		JButton btnDonto = new JButton("D\u00F6nt\u0151");
		btnDonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaztop10();
			}
		});
		btnDonto.setBounds(452, 114, 89, 23);
		add(btnDonto);

		chckbxKor = new JCheckBox("1. k\u00F6r");
		chckbxKor.setForeground(new Color(255, 255, 255));
		chckbxKor.setBackground(new Color(0, 100, 0));
		chckbxKor.setBounds(10, 110, 97, 23);
		add(chckbxKor);

		loeroalatt = new JRadioButton("150 L\u00F3er\u0151 alatt");
		loeroalatt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				selectedcategory = 0;
				updatelist();
			}
		});
		buttonGroup.add(loeroalatt);
		loeroalatt.setSelected(true);
		loeroalatt.setOpaque(false);
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
		buttonGroup.add(loerofelett);
		loerofelett.setOpaque(false);
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
		buttonGroup.add(veteran);
		veteran.setOpaque(false);
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
		buttonGroup.add(noi);
		noi.setOpaque(false);
		noi.setForeground(Color.WHITE);
		noi.setBounds(630, 148, 125, 23);
		add(noi);

		kizarA = new JButton("Kiz\u00E1r");
		kizarA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				earlyA = true;
				textIdo1.setText("09:59:999");
				/*
				 * try { System.out.println("kizargomb"); Main.sn.sendmsg("AK",
				 * Main.sn.getDisplay()); mainFrame.setDisplayTime("-:--:---",
				 * 1); System.out.println("kizargomb"); } catch (IOException e1)
				 * { e1.printStackTrace(); }
				 */
			}
		});
		kizarA.setBounds(146, 114, 86, 23);
		add(kizarA);

		kizarB = new JButton("Kiz\u00E1r");
		kizarB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				earlyB = true;
				textIdo2.setText("09:59:999");
				/*
				 * try { System.out.println("kizargomb"); Main.sn.sendmsg("BK",
				 * Main.sn.getDisplay()); mainFrame.setDisplayTime("-:--:---",
				 * 2); System.out.println("kizargomb"); } catch (IOException e1)
				 * { e1.printStackTrace(); }
				 */
			}
		});
		kizarB.setBounds(299, 114, 86, 23);
		add(kizarB);

		textField_2 = new JTextField();
		textField_2.setText("Elindult:");
		textField_2.setForeground(Color.WHITE);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(0, 100, 0));
		textField_2.setBounds(10, 145, 86, 23);
		add(textField_2);

		lblElindultA = new JLabel("  ");
		lblElindultA.setOpaque(true);
		lblElindultA.setBackground(new Color(204, 0, 0));
		lblElindultA.setBounds(146, 145, 86, 23);
		add(lblElindultA);

		lblElindultB = new JLabel("  ");
		lblElindultB.setOpaque(true);
		lblElindultB.setBackground(new Color(204, 0, 0));
		lblElindultB.setBounds(299, 145, 86, 23);
		add(lblElindultB);

		updatelist();
	}

	private void textChanged() {
		ment();
	}

	public void updatelist() {
		sorok = new DbFunctions().count(DbConstants.Gyorsulas.Database_Table);
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

		ArrayList<Gyorsulas> lista = new DbFunctions().selectGyorsulas();
		Gyorsulas g;
		int j = 0;

		for (int i = 0; i < lista.size(); i++) {
			g = lista.get(i);
			if (selectedcategory < 3 && g.getKategoria().equals(kategoria) && g.getNeme().equals("Ferfi")) {
				tableModel.setValueAt(g.getRajt(), j, 0);
				tableModel.setValueAt(g.getNev(), j, 1);
				tableModel.setValueAt(g.getKategoria(), j, 2);
				tableModel.setValueAt(g.getIdo1(), j, 3);
				tableModel.setValueAt(g.getIdo2(), j, 4);
				tableModel.setValueAt(g.getLido(), j, 5);
				j++;
			} else if (g.getNeme().equals(kategoria)) {
				tableModel.setValueAt(g.getRajt(), j, 0);
				tableModel.setValueAt(g.getNev(), j, 1);
				tableModel.setValueAt(g.getKategoria(), j, 2);
				tableModel.setValueAt(g.getIdo1(), j, 3);
				tableModel.setValueAt(g.getIdo2(), j, 4);
				tableModel.setValueAt(g.getLido(), j, 5);
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

	private void listaztop10() {
		new DbFunctions().sortGyorsulas150aDonto();
		new DbFunctions().sortGyorsulas150fDonto();
		mainFrame.refreshlists();
	}

	public void setTime(String ido, int track) {
		System.out.println(ido);
		if (ido.charAt(0) == 'A' && !earlyA) {
			textIdo1.setText(ido);

		} else if (ido.charAt(0) == 'B' && !earlyB) {
			textIdo2.setText(ido);

		}
	}

	public void setTime(long min, long sec, long milli, int track) {
		String perc, ido, masodperc, ezred;// , finaltime;

		if (min > 10) {
			perc = "09";
			masodperc = "59";
			ezred = "999";
		} else {
			perc = String.format("%02d", min);
			masodperc = String.format("%02d", sec);
			ezred = String.format("%03d", milli);
		}

		ido = perc + ":" + masodperc + ":" + ezred;
		// finaltime = ido;
		// System.out.println(ido);

		if (track == 1) {
			if (!earlyA) {
				textIdo1.setText(ido);
			}
		} else if (track == 2) {
			if (!earlyB) {
				textIdo2.setText(ido);
			}
		}
	}

	public void earlyStart(int track) {
		// try {
		if (track == 1) {
			earlyA = true;
			textIdo1.setText("09:59:999");
			// Main.sn.sendmsg("AK", Main.sn.getDisplay());
		} else if (track == 2) {
			earlyB = true;
			textIdo2.setText("09:59:999");
			// Main.sn.sendmsg("BK", Main.sn.getDisplay());
		}
		/*
		 * } catch (IOException e) { e.printStackTrace(); }
		 */
	}

	public void displayTime() {
		if (earlyA)
			mainFrame.setDisplayTime("-:--:---", 1);
		else
			mainFrame.setDisplayTime(textIdo1.getText(), 1);

		if (earlyB)
			mainFrame.setDisplayTime("-:--:---", 2);
		else
			mainFrame.setDisplayTime(textIdo2.getText(), 2);
	}

	public void listaz(boolean sorted) {
		updatelist();
	}

	public void rajt() throws IOException {
		textIdo1.setText("");
		textIdo2.setText("");
		earlyA = false;
		earlyB = false;
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

	public void ment() {
		String ido1 = "", ido2 = "", legjobb;
		Gyorsulas g;

		if (!textRajt1.getText().equals("") && !textIdo1.getText().equals("")) {
			g = new DbFunctions().selectOneDrag(Integer.parseInt(textRajt1.getText()));

			if (chckbxKor.isSelected()) {
				ido1 = textIdo1.getText();
				ido2 = g.getIdo2();
			} else {
				ido1 = g.getIdo1();
				ido2 = textIdo1.getText();
			}

			if (ido1.compareTo(ido2) < 0) {
				legjobb = ido1;
			} else {
				legjobb = ido2;
			}

			new DbFunctions().updateGyorsulas(Integer.parseInt(textRajt1.getText()), ido1, ido2, legjobb);
		}

		if (!textRajt2.getText().equals("") && !textIdo2.getText().equals("")) {
			g = new DbFunctions().selectOneDrag(Integer.parseInt(textRajt2.getText()));

			if (chckbxKor.isSelected()) {
				ido1 = textIdo2.getText();
				ido2 = g.getIdo2();
			} else {
				ido1 = g.getIdo1();
				ido2 = textIdo2.getText();
			}

			if (ido1.compareTo(ido2) < 0) {
				legjobb = ido1;
			} else {
				legjobb = ido2;
			}

			new DbFunctions().updateGyorsulas(Integer.parseInt(textRajt2.getText()), ido1, ido2, legjobb);
		}

		// try {
		ido1 = /* "A" + */textIdo1.getText();// + "\n";
		ido2 = /* "B" + */textIdo2.getText();// + "\n";

		if (ido1.compareTo(ido2) < 0) {
			ido1 = "A" + ido1 + "J\n";
			ido2 = "B" + ido2 + "\n";
			System.out.println("ajobb");
		} else if (ido1.compareTo(ido2) > 0) {
			ido1 = "A" + ido1 + "\n";
			ido2 = "B" + ido2 + "J\n";
			System.out.println("bjobb");
		} else {
			ido1 = "A" + ido1 + "\n";
			ido2 = "B" + ido2 + "\n";
			System.out.println("egyenlõ");
		}
		// System.out.println(ido1 + " " + ido2);
		/*
		 * if (earlyA) { Main.sn.sendmsg("AK", Main.sn.getDisplay()); } else {
		 * Main.sn.sendmsg(ido1, Main.sn.getDisplay()); } if (earlyB) {
		 * Main.sn.sendmsg("BK", Main.sn.getDisplay()); } else {
		 * Main.sn.sendmsg(ido2, Main.sn.getDisplay()); }
		 */
		if (earlyA) {
			System.out.println("koraia");
		}
		if (earlyB) {
			System.out.println("koraib");
		}
		new Display(ido1, ido2, earlyA, earlyB).start();
		/*
		 * } catch (IOException e1) { e1.printStackTrace(); }
		 */
		/*
		 * earlyA = false; earlyB = false;
		 */
		updatelist();
		displayTime();
	}

	public void refresh() {
		mainFrame.refreshtable();
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
}

package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.table.DefaultTableModel;

import datastorage.DbConstants;
import datastorage.DbFunctions;
import pojo.Versenyzo;

public class RegPanel extends JPanel {
	private static final long serialVersionUID = 7700281845817905093L;
	private JTextField txtRajt;
	private JTextField txtNev;
	private JTextField txtVaros;
	private JTextField txtRendszam;
	private JRadioButton rdbtn150f;
	private JRadioButton rdbtnVeteran;
	private JCheckBox chckbxPotkocsisTolatas;
	private JCheckBox chckbxGyorsulas;
	private JCheckBox chckbxSzlalom;
	private JCheckBox chckbxErhzs;
	private JRadioButton rdbtn150a;
	private JCheckBox chckbxWoman;
	private JButton btnListaz;
	private JButton btnRajtlista;
	private JButton btnMentes;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textRajt;
	private JTextField textNev;
	private JTextField textVaros;
	private JTextField textRendszam;

	private DefaultTableModel tableModel;
	private String[] oszlopok;
	private int sorok;

	private MainFrame mainFrame;

	public static int pot150a = 0;
	public static int pot150f = 0;
	public static int szl150a = 0;
	public static int szl150f = 0;
	public static int szlvet = 0;
	public static int gy150a = 0;
	public static int gy150f = 0;
	public static int eh = 0;

	private int erohuzas = 0;

	/**
	 * Create the panel.
	 */
	public RegPanel(JTabbedPane panel, MainFrame mf) {
		panel.setUI(new BasicTabbedPaneUI() {
			@Override
			protected void installDefaults() {
				super.installDefaults();

				highlight = Color.lightGray;
				lightHighlight = Color.white;

				shadow = Color.gray;
				darkShadow = Color.darkGray;

				focus = Color.black;
			}
		});

		UIManager.put("TabbedPane.selected", Color.green);
		UIManager.put("TabbedPane.unselectedTabBackground", Color.black);

		setBorder(null);
		setBackground(new Color(0, 100, 0));

		oszlopok = new String[] { "Rajtszám", "Név", "Város", "Nem", "Osztozik", "Kategória", "Pótkocsis", "Szlalom",
				"Gyorsulás", "Erõhúzás" };

		mainFrame = mf;

		txtRajt = new JTextField();
		txtRajt.setBorder(null);
		txtRajt.setForeground(new Color(255, 255, 255));
		txtRajt.setBackground(new Color(0, 100, 0));
		txtRajt.setBounds(10, 11, 86, 20);
		txtRajt.setEditable(false);
		txtRajt.setText("Rajtsz\u00E1m:");
		txtRajt.setColumns(10);

		chckbxSzlalom = new JCheckBox("Szlalom");
		chckbxSzlalom.setForeground(new Color(255, 255, 255));
		chckbxSzlalom.setBackground(new Color(0, 100, 0));
		chckbxSzlalom.setBounds(10, 157, 97, 23);

		chckbxGyorsulas = new JCheckBox("Gyorsul\u00E1s");
		chckbxGyorsulas.setForeground(new Color(255, 255, 255));
		chckbxGyorsulas.setBackground(new Color(0, 100, 0));
		chckbxGyorsulas.setBounds(10, 183, 97, 23);

		rdbtn150a = new JRadioButton("150 L\u00F3er\u0151 alatt");
		rdbtn150a.setSelected(true);
		rdbtn150a.setBackground(new Color(0, 100, 0));
		rdbtn150a.setForeground(new Color(255, 255, 255));
		rdbtn150a.setBounds(252, 11, 150, 23);
		buttonGroup.add(rdbtn150a);

		chckbxWoman = new JCheckBox("N\u0151");
		chckbxWoman.setBackground(new Color(0, 100, 0));
		chckbxWoman.setForeground(new Color(255, 255, 255));
		chckbxWoman.setBounds(198, 41, 52, 23);

		textRajt = new JTextField();
		textRajt.setBounds(106, 11, 86, 20);
		textRajt.setColumns(10);
		textRajt.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				betolt();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				betolt();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				betolt();
			}
		});

		textNev = new JTextField();
		textNev.setBounds(106, 42, 86, 20);
		textNev.setColumns(10);

		btnListaz = new JButton("List\u00E1z");
		btnListaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatelist();
			}
		});
		btnListaz.setBounds(252, 165, 89, 23);

		btnRajtlista = new JButton("Rajtlista");
		btnRajtlista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rajtlistaz();
			}
		});
		btnRajtlista.setBounds(252, 199, 89, 23);
		setLayout(null);
		add(txtRajt);

		txtNev = new JTextField();
		txtNev.setBorder(null);
		txtNev.setForeground(new Color(255, 255, 255));
		txtNev.setBackground(new Color(0, 100, 0));
		txtNev.setBounds(10, 42, 86, 20);
		txtNev.setToolTipText("");
		txtNev.setText("N\u00E9v:");
		txtNev.setEditable(false);
		txtNev.setColumns(10);
		add(txtNev);

		txtVaros = new JTextField();
		txtVaros.setBorder(null);
		txtVaros.setForeground(new Color(255, 255, 255));
		txtVaros.setBackground(new Color(0, 100, 0));
		txtVaros.setBounds(10, 73, 86, 20);
		txtVaros.setEditable(false);
		txtVaros.setText("V\u00E1ros:");
		txtVaros.setColumns(10);
		add(txtVaros);

		txtRendszam = new JTextField();
		txtRendszam.setBorder(null);
		txtRendszam.setForeground(new Color(255, 255, 255));
		txtRendszam.setBackground(new Color(0, 100, 0));
		txtRendszam.setBounds(10, 104, 86, 20);
		txtRendszam.setEditable(false);
		txtRendszam.setText("Rendsz\u00E1m:");
		txtRendszam.setColumns(10);
		add(txtRendszam);
		add(textRajt);
		add(textNev);

		textVaros = new JTextField();
		textVaros.setBounds(106, 73, 86, 20);
		textVaros.setColumns(10);
		add(textVaros);

		textRendszam = new JTextField();
		textRendszam.setBounds(106, 104, 86, 20);
		textRendszam.setColumns(10);
		add(textRendszam);
		add(chckbxWoman);

		rdbtn150f = new JRadioButton("150 L\u00F3er\u0151 felett");
		rdbtn150f.setBackground(new Color(0, 100, 0));
		rdbtn150f.setForeground(new Color(255, 255, 255));
		rdbtn150f.setBounds(252, 42, 150, 23);
		buttonGroup.add(rdbtn150f);
		add(rdbtn150f);
		add(rdbtn150a);

		rdbtnVeteran = new JRadioButton("Veter\u00E1n");
		rdbtnVeteran.setBackground(new Color(0, 100, 0));
		rdbtnVeteran.setForeground(new Color(255, 255, 255));
		rdbtnVeteran.setBounds(252, 73, 150, 23);
		buttonGroup.add(rdbtnVeteran);
		add(rdbtnVeteran);

		chckbxPotkocsisTolatas = new JCheckBox("P\u00F3tkocsis tolat\u00E1s");
		chckbxPotkocsisTolatas.setForeground(new Color(255, 255, 255));
		chckbxPotkocsisTolatas.setBackground(new Color(0, 100, 0));
		chckbxPotkocsisTolatas.setBounds(10, 131, 150, 23);
		add(chckbxPotkocsisTolatas);
		add(chckbxSzlalom);
		add(chckbxGyorsulas);

		btnMentes = new JButton("Ment");
		btnMentes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ment();
			}
		});
		btnMentes.setOpaque(true);
		btnMentes.setBounds(252, 131, 89, 23);
		add(btnMentes);
		add(btnListaz);
		add(btnRajtlista);

		JButton btnTorol = new JButton("T\u00F6rl\u00E9s");
		btnTorol.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (textRajt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Hiányzó rajtszám!");
				} else {
					UIManager.put("OptionPane.yesButtonText", "Igen");
					UIManager.put("OptionPane.noButtonText", "Nem");
					int response = JOptionPane.showConfirmDialog(null,
							"Biztos törölni szeretnéd a " + textRajt.getText() + "-s számú versenyzõt?", "Törlés",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (response == JOptionPane.YES_OPTION) {
						new DbFunctions().deleteAdat(Integer.parseInt(textRajt.getText()));
						updatelist();
						mainFrame.refreshlists();
					}
				}
			}
		});
		btnTorol.setBounds(351, 131, 89, 23);
		add(btnTorol);

		JButton btnNewButton = new JButton("\u00DCr\u00EDt\u00E9s");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UIManager.put("OptionPane.yesButtonText", "Igen");
				UIManager.put("OptionPane.noButtonText", "Nem");
				int response = JOptionPane.showConfirmDialog(null, "Biztos üríteni szeretnéd az adatbázist?", "Ürítés",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.YES_OPTION) {
					new DbFunctions().emptyDB();
					updatelist();
				}
			}
		});
		btnNewButton.setBounds(351, 165, 89, 23);
		add(btnNewButton);

		chckbxErhzs = new JCheckBox("Er\u0151h\u00FAz\u00E1s");
		chckbxErhzs.setForeground(Color.WHITE);
		chckbxErhzs.setBackground(new Color(0, 100, 0));
		chckbxErhzs.setBounds(10, 209, 97, 23);
		add(chckbxErhzs);

		updatelist();
	}

	private void betolt() {
		// System.out.println("tölt");
		int rajtszam = 0;
		if (!textRajt.getText().equals("")) {
			rajtszam = Integer.parseInt(textRajt.getText());
		}
		Versenyzo v = new DbFunctions().selectVerenyzo(rajtszam);
		if (v != null) {
			textNev.setText(v.getNev());
			textVaros.setText(v.getVaros());
			textRendszam.setText(v.getOsztozik());

			if (v.getNeme().equals("No")) {
				chckbxWoman.setSelected(true);
			} else {
				chckbxWoman.setSelected(false);
			}

			if (v.getKategoria().equals("150a")) {
				rdbtn150a.setSelected(true);
			} else if (v.getKategoria().equals("150f")) {
				rdbtn150f.setSelected(true);
			} else if (v.getKategoria().equals("veteran")) {
				rdbtnVeteran.setSelected(true);
			}

			if (v.getPotkocsis().equals("true")) {
				chckbxPotkocsisTolatas.setSelected(true);
			} else {
				chckbxPotkocsisTolatas.setSelected(false);
			}
			if (v.getSzlalom().equals("true")) {
				chckbxSzlalom.setSelected(true);
			} else {
				chckbxSzlalom.setSelected(false);
			}
			if (v.getGyorsulas().equals("true")) {
				chckbxGyorsulas.setSelected(true);
			} else {
				chckbxGyorsulas.setSelected(false);
			}
			if (v.getErohuzas().equals("true")) {
				chckbxErhzs.setSelected(true);
			} else {
				chckbxErhzs.setSelected(false);
			}
		}
	}

	private void ment() {
		if (!textNev.getText().equals("") && !textRajt.getText().equals("") && !textRajt.getText().equals("")
				&& !textVaros.getText().equals("") && !textRendszam.getText().equals("")) {

			String neme, potk = "false", szl, gy, kat, eh = "false";

			if (chckbxWoman.isSelected()) {
				neme = "No";
			} else
				neme = "Ferfi";

			if (rdbtn150f.isSelected()) {
				kat = "150f";
			} else if (rdbtn150a.isSelected()) {
				kat = "150a";
			} else {
				kat = "veteran";
			}

			if (chckbxPotkocsisTolatas.isSelected()) {

				// Main.functions.insertTrailer(Integer.parseInt(textRajt.getText()),
				// "9:59:999", 99, "9:59:999", kat);

				potk = "true";
				new DbFunctions().insert_or_update_Potkocsis(Integer.parseInt(textRajt.getText()), "9:59:999", 99,
						"9:59:999");
				if (kat.equals("150a")) {
					pot150a++;
				} else if (kat.equals("150f")) {
					pot150f++;
				}

			} else {
				potk = "false";
				new DbFunctions().delete(DbConstants.Potkocsis.Database_Table, Integer.parseInt(textRajt.getText()));
				if (kat.equals("150a")) {
					pot150a--;
				} else if (kat.equals("150f")) {
					pot150f--;
				}
			}
			if (chckbxErhzs.isSelected()) {

				// Main.functions.insertTrailer(Integer.parseInt(textRajt.getText()),
				// "9:59:999", 99, "9:59:999", kat);

				erohuzas = new DbFunctions().count("erohuzas");
				System.out.println("erõthúznak: " + erohuzas);
				if (erohuzas < 12) {
					eh = "true";
					new DbFunctions().insert_or_update_Erohuzas(Integer.parseInt(textRajt.getText()), "9:59:999", 99,
							"9:59:999");

				} else {
					JOptionPane.showMessageDialog(null, "sokan húznak már", "sok a húzó", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				eh = "false";
				new DbFunctions().delete(DbConstants.Erohuzas.Database_Table, Integer.parseInt(textRajt.getText()));

			}
			if (chckbxSzlalom.isSelected()) {
				szl = "true";
				// Main.functions.insertSlalom(Integer.parseInt(textRajt.getText()),
				// "9:59:999", 99, "9:59:999", kat);
				new DbFunctions().insert_or_update_Szlalom(Integer.parseInt(textRajt.getText()), "9:59:999", 99,
						"9:59:999");
				if (kat.equals("150a")) {
					szl150a++;
				} else if (kat.equals("150f")) {
					szl150f++;
				}
			} else {
				szl = "false";
				new DbFunctions().delete(DbConstants.Szlalom.Database_Table, Integer.parseInt(textRajt.getText()));
				if (kat.equals("150a")) {
					szl150a--;
				} else if (kat.equals("150f")) {
					szl150f--;
				}
			}
			if (chckbxGyorsulas.isSelected()) {
				gy = "true";
				// Main.functions.insertDrag(Integer.parseInt(textRajt.getText()),
				// "9:59:999", "9:59:999", "9:59:999", kat);
				new DbFunctions().insert_or_update_Gyorsulas(Integer.parseInt(textRajt.getText()), "9:59:999",
						"9:59:999", "9:59:999");
				if (kat.equals("150a")) {
					gy150a++;
				} else if (kat.equals("150f")) {
					gy150f++;
				}
			} else {
				gy = "false";
				new DbFunctions().delete(DbConstants.Gyorsulas.Database_Table, Integer.parseInt(textRajt.getText()));
				if (kat.equals("150a")) {
					gy150a--;
				} else if (kat.equals("150f")) {
					gy150f--;
				}
			}

			// Main.functions.insertData(Integer.parseInt(textRajt.getText()),
			// textNev.getText(), textVaros.getText(), textRendszam.getText(),
			// neme, kat, potk, szl, gy);
			new DbFunctions().insert_or_update_Adat(Integer.parseInt(textRajt.getText()), textNev.getText(),
					textVaros.getText(), textRendszam.getText(), neme, kat, potk, szl, gy, eh);
			if (neme.equals("Ferfi") && (kat.equals("150a") || kat.equals("150f"))) {
				// Main.functions.insertAbsolut(Integer.parseInt(textRajt.getText()),
				// textNev.getText(), kat, 0, 0, 0);
				new DbFunctions().insert_or_update_Abszolut(Integer.parseInt(textRajt.getText()), textNev.getText(),
						kat, 0, 0, 0);
			}
			updatelist();
			mainFrame.generateRajtlista(false);
		} else {
			String msg = "Hiányzó adat(ok):\n";
			if (textRajt.getText().equals("")) {
				msg += "   Rajtszám\n";
			}
			if (textNev.getText().equals("")) {
				msg += "   Név\n";
			}
			if (textVaros.getText().equals("")) {
				msg += "   Város\n";
			}
			if (textRendszam.getText().equals("")) {
				msg += "   Rendszám\n";
			}
			JOptionPane.showMessageDialog(this, msg);
		}
		mainFrame.refreshlists();
	}

	private void rajtlistaz() {
		mainFrame.generateRajtlista(true);
		// System.out.println("rajtlistagomb");
	}

	public void refresh() {
		mainFrame.refreshtable();
	}

	public void updatelist() {
		pot150a = 0;
		pot150f = 0;
		szl150a = 0;
		szl150f = 0;
		szlvet = 0;
		gy150a = 0;
		gy150f = 0;
		eh = 0;

		sorok = new DbFunctions().count(DbConstants.Versenyzo.Database_Table);
		tableModel = new DefaultTableModel(oszlopok, sorok);
		ArrayList<Versenyzo> lista = new DbFunctions().selectAdat();
		Versenyzo v;

		for (int i = 0; i < lista.size(); i++) {
			v = lista.get(i);

			tableModel.setValueAt(v.getRajt(), i, 0);
			tableModel.setValueAt(v.getNev(), i, 1);
			tableModel.setValueAt(v.getVaros(), i, 2);
			tableModel.setValueAt(v.getNeme(), i, 3);
			tableModel.setValueAt(v.getOsztozik(), i, 4);
			tableModel.setValueAt(v.getKategoria(), i, 5);
			tableModel.setValueAt(v.getPotkocsis(), i, 6);
			tableModel.setValueAt(v.getSzlalom(), i, 7);
			tableModel.setValueAt(v.getGyorsulas(), i, 8);
			tableModel.setValueAt(v.getErohuzas(), i, 9);

			if (v.getNeme().equals("Ferfi")) {
				if (v.getKategoria().equals("150a")) {
					if (v.getPotkocsis().equals("true")) {
						pot150a++;
					}
					if (v.getSzlalom().equals("true")) {
						szl150a++;
					}
					if (v.getGyorsulas().equals("true")) {
						gy150a++;
					}
				} else if (v.getKategoria().equals("150f")) {
					if (v.getPotkocsis().equals("true")) {
						pot150f++;
					}
					if (v.getSzlalom().equals("true")) {
						szl150f++;
					}
					if (v.getGyorsulas().equals("true")) {
						gy150f++;
					}
				} else if (v.getKategoria().equals("veteran")) {
					szlvet++;
				}
			}
		}

		refresh();
		mainFrame.hideRajlista();
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}
}

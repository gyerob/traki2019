package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import timing.Lamp;
import traktoros.Main;

import javax.swing.JLabel;
import java.awt.Dimension;

public class DontoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8607398464107989789L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtVido;
	private JTextField txtHiba;
	private JTextField txttIdo;
	private JTextField txtRajt;
	private JTextField textField_4;
	private JTextField textRajt1;
	private JTextField textIdo1;
	private JTextField textHiba1;
	private JTextField textVido1;
	private JTextField textVido2;
	private JTextField textHiba2;
	private JTextField textIdo2;
	private JTextField textRajt2;
	private JTextField textField_13;
	private FinalsPanel finalsPanel;
	private JRadioButton rdbtnGyorsulasA;
	private JRadioButton rdbtnGyorsulasF;
	private JRadioButton rdbtnSzlalomA;
	private JRadioButton rdbtnSzlalomF;
	private JRadioButton rdbtnSzlalomVeteran;

	private boolean earlyA = false;
	private boolean earlyB = false;

	private MainFrame mainFrame;
	private JTextField textField;
	private JLabel lblElindultA;
	private JLabel lblElindultB;

	private int dropdownindex;

	private JButton hibaAminusz;
	private JButton hibaAplusz;
	private JButton hibaBminusz;
	private JButton hibaBplusz;
	
	private DontoPanel dp;

	public DontoPanel(JTabbedPane panel, MainFrame mf) {
		dp = this;
		setBorder(null);
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

		double w = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getWidth();
		double h = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getHeight();
		// System.out.println("méret" + w + " " + h);

		setBackground(new Color(0, 100, 0));
		setLayout(null);

		mainFrame = mf;

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		scrollPane.setBackground(new Color(0, 100, 0));
		scrollPane.setBounds(10, 250, (int) w - 20, (int) h - 310);
		add(scrollPane);

		//finalsPanel = new FinalsPanel10man(0.0, 0.0, this);

		if(RegPanel.szl150a>9){
			finalsPanel = new FinalsPanel10man(0, 0, dp);
		} else if(RegPanel.szl150a>7){
			finalsPanel = new FinalsPanel8man(0, 0, dp);
		} else if(RegPanel.szl150a>5){
			finalsPanel = new FinalsPanel6man(0, 0, dp);
		} else {
			finalsPanel = new FinalsPanel4man(0, 0, dp);
		}
		
		scrollPane.setViewportView(finalsPanel);
		finalsPanel.loaddata(0);

		rdbtnSzlalomF = new JRadioButton("Szlalom 150 l\u00F3er\u0151 felett");
		rdbtnSzlalomF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (rdbtnSzlalomF.isSelected()) {
					setDropDownIndex(1);
					txtHiba.setVisible(true);
					txtVido.setVisible(true);
					textHiba1.setVisible(true);
					textHiba2.setVisible(true);
					textVido1.setVisible(true);
					textVido2.setVisible(true);
					hibaAminusz.setVisible(true);
					hibaAplusz.setVisible(true);
					hibaBminusz.setVisible(true);
					hibaBplusz.setVisible(true);
					if(RegPanel.szl150f>9){
						finalsPanel = new FinalsPanel10man(0, 0, dp);
					} else if(RegPanel.szl150f>7){
						finalsPanel = new FinalsPanel8man(0, 0, dp);
					} else if(RegPanel.szl150f>5){
						finalsPanel = new FinalsPanel6man(0, 0, dp);
					} else {
						finalsPanel = new FinalsPanel4man(0, 0, dp);
					}
					scrollPane.setViewportView(finalsPanel);
					finalsPanel.loaddata(1);
				}
			}
		});
		rdbtnSzlalomF.setBackground(new Color(0, 100, 0));
		rdbtnSzlalomF.setForeground(new Color(255, 255, 255));
		buttonGroup.add(rdbtnSzlalomF);
		rdbtnSzlalomF.setBounds(630, 84, 180, 23);
		add(rdbtnSzlalomF);

		rdbtnSzlalomA = new JRadioButton("Szlalom 150 l\u00F3er\u0151 alatt");
		rdbtnSzlalomA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnSzlalomA.isSelected()) {
					setDropDownIndex(0);
					txtHiba.setVisible(true);
					txtVido.setVisible(true);
					textHiba1.setVisible(true);
					textHiba2.setVisible(true);
					textVido1.setVisible(true);
					textVido2.setVisible(true);
					hibaAminusz.setVisible(true);
					hibaAplusz.setVisible(true);
					hibaBminusz.setVisible(true);
					hibaBplusz.setVisible(true);
					if(RegPanel.szl150a>9){
						finalsPanel = new FinalsPanel10man(0, 0, dp);
					} else if(RegPanel.szl150a>7){
						finalsPanel = new FinalsPanel8man(0, 0, dp);
					} else if(RegPanel.szl150a>5){
						finalsPanel = new FinalsPanel6man(0, 0, dp);
					} else {
						finalsPanel = new FinalsPanel4man(0, 0, dp);
					}
					scrollPane.setViewportView(finalsPanel);
					finalsPanel.loaddata(0);
				}
			}
		});
		rdbtnSzlalomA.setSelected(true);
		rdbtnSzlalomA.setBackground(new Color(0, 100, 0));
		rdbtnSzlalomA.setForeground(new Color(255, 255, 255));
		buttonGroup.add(rdbtnSzlalomA);
		rdbtnSzlalomA.setBounds(630, 52, 180, 23);
		add(rdbtnSzlalomA);
		setDropDownIndex(0);

		rdbtnGyorsulasF = new JRadioButton("Gyorsul\u00E1s 150 l\u00F3er\u0151 felett");
		rdbtnGyorsulasF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnGyorsulasF.isSelected()) {
					setDropDownIndex(3);
					txtHiba.setVisible(false);
					txtVido.setVisible(false);
					textHiba1.setVisible(false);
					textHiba2.setVisible(false);
					textVido1.setVisible(false);
					textVido2.setVisible(false);
					hibaAminusz.setVisible(false);
					hibaAplusz.setVisible(false);
					hibaBminusz.setVisible(false);
					hibaBplusz.setVisible(false);
					if(RegPanel.gy150f>9){
						finalsPanel = new FinalsPanel10man(0, 0, dp);
					} else if(RegPanel.gy150f>7){
						finalsPanel = new FinalsPanel8man(0, 0, dp);
					} else if(RegPanel.gy150f>5){
						finalsPanel = new FinalsPanel6man(0, 0, dp);
					} else {
						finalsPanel = new FinalsPanel4man(0, 0, dp);
					}
					scrollPane.setViewportView(finalsPanel);
					finalsPanel.loaddata(3);
				}
			}
		});
		rdbtnGyorsulasF.setBackground(new Color(0, 100, 0));
		rdbtnGyorsulasF.setForeground(new Color(255, 255, 255));
		buttonGroup.add(rdbtnGyorsulasF);
		rdbtnGyorsulasF.setBounds(630, 180, 180, 23);
		add(rdbtnGyorsulasF);

		rdbtnGyorsulasA = new JRadioButton("Gyorsul\u00E1s 150 l\u00F3er\u0151 alatt");
		rdbtnGyorsulasA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnGyorsulasA.isSelected()) {
					setDropDownIndex(2);
					txtHiba.setVisible(false);
					txtVido.setVisible(false);
					textHiba1.setVisible(false);
					textHiba2.setVisible(false);
					textVido1.setVisible(false);
					textVido2.setVisible(false);
					hibaAminusz.setVisible(false);
					hibaAplusz.setVisible(false);
					hibaBminusz.setVisible(false);
					hibaBplusz.setVisible(false);
					if(RegPanel.gy150a>9){
						finalsPanel = new FinalsPanel10man(0, 0, dp);
					} else if(RegPanel.gy150a>7){
						finalsPanel = new FinalsPanel8man(0, 0, dp);
					} else if(RegPanel.gy150a>5){
						finalsPanel = new FinalsPanel6man(0, 0, dp);
					} else {
						finalsPanel = new FinalsPanel4man(0, 0, dp);
					}
					scrollPane.setViewportView(finalsPanel);
					finalsPanel.loaddata(2);
				}
			}
		});
		rdbtnGyorsulasA.setBackground(new Color(0, 100, 0));
		rdbtnGyorsulasA.setForeground(new Color(255, 255, 255));
		buttonGroup.add(rdbtnGyorsulasA);
		rdbtnGyorsulasA.setBounds(630, 148, 180, 23);
		add(rdbtnGyorsulasA);

		txtVido = new JTextField();
		txtVido.setBorder(null);
		txtVido.setText("V\u00E9gleges id\u0151:");
		txtVido.setForeground(Color.WHITE);
		txtVido.setEditable(false);
		txtVido.setColumns(10);
		txtVido.setBackground(new Color(0, 100, 0));
		txtVido.setBounds(10, 145, 86, 20);
		add(txtVido);

		txtHiba = new JTextField();
		txtHiba.setBorder(null);
		txtHiba.setText("Hiba:");
		txtHiba.setForeground(Color.WHITE);
		txtHiba.setEditable(false);
		txtHiba.setColumns(10);
		txtHiba.setBackground(new Color(0, 100, 0));
		txtHiba.setBounds(10, 114, 86, 20);
		add(txtHiba);

		txttIdo = new JTextField();
		txttIdo.setBorder(null);
		txttIdo.setText("Id\u0151:");
		txttIdo.setForeground(Color.WHITE);
		txttIdo.setEditable(false);
		txttIdo.setColumns(10);
		txttIdo.setBackground(new Color(0, 100, 0));
		txttIdo.setBounds(10, 83, 86, 20);
		add(txttIdo);

		txtRajt = new JTextField();
		txtRajt.setBorder(null);
		txtRajt.setText("Rajtsz\u00E1m:");
		txtRajt.setForeground(Color.WHITE);
		txtRajt.setEditable(false);
		txtRajt.setColumns(10);
		txtRajt.setBackground(new Color(0, 100, 0));
		txtRajt.setBounds(10, 52, 86, 20);
		add(txtRajt);

		textField_4 = new JTextField();
		textField_4.setBorder(null);
		textField_4.setText("A p\u00E1lya");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setForeground(Color.WHITE);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(0, 100, 0));
		textField_4.setBounds(146, 11, 86, 20);
		add(textField_4);

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
		textHiba1.setColumns(10);
		textHiba1.setBounds(146, 114, 86, 20);
		add(textHiba1);
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
		textVido1.setColumns(10);
		textVido1.setBounds(146, 145, 86, 20);
		add(textVido1);

		textVido2 = new JTextField();
		textVido2.setColumns(10);
		textVido2.setBounds(299, 145, 86, 20);
		add(textVido2);

		textHiba2 = new JTextField();
		textHiba2.setColumns(10);
		textHiba2.setBounds(299, 114, 86, 20);
		add(textHiba2);
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

		textIdo2 = new JTextField();
		textIdo2.setColumns(10);
		textIdo2.setBounds(299, 83, 86, 20);
		add(textIdo2);
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

		textRajt2 = new JTextField();
		textRajt2.setColumns(10);
		textRajt2.setBounds(299, 52, 86, 20);
		add(textRajt2);

		textField_13 = new JTextField();
		textField_13.setBorder(null);
		textField_13.setText("B p\u00E1lya");
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setForeground(Color.WHITE);
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBackground(new Color(0, 100, 0));
		textField_13.setBounds(299, 11, 86, 20);
		add(textField_13);

		JButton button = new JButton("Rajt");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rajt();
			}
		});
		button.setBounds(452, 145, 89, 23);
		add(button);

		rdbtnSzlalomVeteran = new JRadioButton("Szlalom veter\u00E1n");
		rdbtnSzlalomVeteran.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnSzlalomVeteran.isSelected()) {
					setDropDownIndex(4);
					txtHiba.setVisible(true);
					txtVido.setVisible(true);
					textHiba1.setVisible(true);
					textHiba2.setVisible(true);
					textVido1.setVisible(true);
					textVido2.setVisible(true);
					hibaAminusz.setVisible(true);
					hibaAplusz.setVisible(true);
					hibaBminusz.setVisible(true);
					hibaBplusz.setVisible(true);
					System.out.println(RegPanel.szlvet);
					if(RegPanel.szlvet>9){
						finalsPanel = new FinalsPanel10man(0, 0, dp);
					} else if(RegPanel.szlvet>7){
						finalsPanel = new FinalsPanel8man(0, 0, dp);
					} else if(RegPanel.szlvet>5){
						finalsPanel = new FinalsPanel6man(0, 0, dp);
					} else {
						finalsPanel = new FinalsPanel4man(0, 0, dp);
					}
					scrollPane.setViewportView(finalsPanel);
					finalsPanel.loaddata(4);
				}
			}
		});
		rdbtnSzlalomVeteran.setForeground(Color.WHITE);
		rdbtnSzlalomVeteran.setBackground(new Color(0, 100, 0));
		rdbtnSzlalomVeteran.setBounds(630, 116, 180, 23);
		buttonGroup.add(rdbtnSzlalomVeteran);
		add(rdbtnSzlalomVeteran);

		textField = new JTextField();
		textField.setText("Elindult:");
		textField.setForeground(Color.WHITE);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(0, 100, 0));
		textField.setBounds(10, 176, 86, 23);
		add(textField);

		lblElindultA = new JLabel("  ");
		lblElindultA.setOpaque(true);
		lblElindultA.setBackground(new Color(204, 0, 0));
		lblElindultA.setBounds(146, 176, 86, 23);
		add(lblElindultA);

		lblElindultB = new JLabel("  ");
		lblElindultB.setOpaque(true);
		lblElindultB.setBackground(new Color(204, 0, 0));
		lblElindultB.setBounds(299, 176, 86, 23);
		add(lblElindultB);

		hibaAminusz = new JButton("-");
		hibaAminusz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				hibapontozasA(-1);
			}
		});
		hibaAminusz.setSize(new Dimension(30, 23));
		hibaAminusz.setPreferredSize(new Dimension(30, 23));
		hibaAminusz.setBorder(null);
		hibaAminusz.setBounds(121, 114, 25, 20);
		add(hibaAminusz);

		hibaAplusz = new JButton("+");
		hibaAplusz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hibapontozasA(1);
			}
		});
		hibaAplusz.setSize(new Dimension(30, 23));
		hibaAplusz.setPreferredSize(new Dimension(30, 23));
		hibaAplusz.setBorder(null);
		hibaAplusz.setBounds(232, 114, 25, 20);
		add(hibaAplusz);

		hibaBminusz = new JButton("-");
		hibaBminusz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hibapontozasB(-1);
			}
		});
		hibaBminusz.setSize(new Dimension(30, 23));
		hibaBminusz.setPreferredSize(new Dimension(30, 23));
		hibaBminusz.setBorder(null);
		hibaBminusz.setActionCommand("-");
		hibaBminusz.setBounds(274, 114, 25, 20);
		add(hibaBminusz);

		hibaBplusz = new JButton("+");
		hibaBplusz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hibapontozasB(1);
			}
		});
		hibaBplusz.setSize(new Dimension(30, 23));
		hibaBplusz.setPreferredSize(new Dimension(30, 23));
		hibaBplusz.setBorder(null);
		hibaBplusz.setBounds(385, 114, 25, 20);
		add(hibaBplusz);
	}

	public void switchNumbers() {
		String text = textRajt1.getText();
		textRajt1.setText(textRajt2.getText());
		textRajt2.setText(text);
	}

	public void setTime(long min, long sec, long milli, int track) {
		String ido, /* finaltime, */ perc, masodperc, ezred;

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

		if (track == 1) {
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
		System.out.println("Koraidonto");
		try {
			if (track == 1) {
				//if (dropdownindex == 0 || dropdownindex == 1 || dropdownindex == 4) {
					textHiba1.setText("2");
				//} else {
					textIdo1.setText("09:59:999");
					earlyA = true;
					Main.sn.sendmsg("AK", Main.sn.getDisplay());
				//}
			} else if (track == 2) {
				//if (dropdownindex == 0 || dropdownindex == 1 || dropdownindex == 4) {
					textHiba2.setText("2");
				//} else {
					textIdo2.setText("09:59:999");
					earlyB = true;
					Main.sn.sendmsg("BK", Main.sn.getDisplay());
				//}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void rajt() {
		textIdo1.setText("");
		textIdo2.setText("");
		textHiba1.setText("0");
		textHiba2.setText("0");
		textVido1.setText("");
		textVido2.setText("");
		mainFrame.clearDisplay();
		new Lamp().start();
		earlyA = false;
		earlyB = false;
		// System.out.println("startgomb");
	}

	public void updatelist() {
		finalsPanel.loaddata();
	}

	public void setNum(int a, int b) {
		textRajt1.setText(Integer.toString(a));
		textRajt2.setText(Integer.toString(b));
	}

	public void print() {
		PrinterJob printjob = PrinterJob.getPrinterJob();
		printjob.setJobName(" personal card ");

		printjob.setPrintable(new Printable() {
			public int print(Graphics pg, PageFormat pf, int pageNum) {

				pf.setOrientation(PageFormat.PORTRAIT);

				if (pageNum > 0) {
					return Printable.NO_SUCH_PAGE;
				}

				Graphics2D g2 = (Graphics2D) pg;
				g2.translate(pf.getImageableX(), pf.getImageableY());
				g2.translate(0f, 0f);
				g2.scale(0.35, 0.35);
				finalsPanel.paint(g2);

				return Printable.PAGE_EXISTS;
			}
		});

		if (printjob.printDialog() == false)
			return;

		try {
			printjob.print();
		} catch (PrinterException ex) {
			System.out.println("NO PAGE FOUND." + ex);
		}
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

	public void setDropDownIndex(int i) {
		Main.sn.setDropdownIndex(i);
		dropdownindex = i;
		// System.out.println(dropdownindex);
	}

	public void textChanged(JTextField field, JTextField error, JTextField finalfield) {
		int perc, masod, ezred, hiba;
		String ido, p, m, ez;
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

		p = String.format("%02d", perc);
		m = String.format("%02d", masod);
		ez = String.format("%-3s", ezred).replace(' ', '0');

		ido = p + ":" + m + ":" + ez;

		finalfield.setText(ido);
		ment();

	}

	private void ment() {
		try {
			String ido1, ido2;

			if (dropdownindex == 0 || dropdownindex == 1 || dropdownindex == 4) {
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

				if (earlyA) {
					mainFrame.setDisplayTime("-:--:---", 1);
					Main.sn.sendmsg("AK", Main.sn.getDisplay());
				} else {
					mainFrame.setDisplayTime(textIdo1.getText(), 1);
					Main.sn.sendmsg(ido1, Main.sn.getDisplay());
				}
				if (earlyB) {
					mainFrame.setDisplayTime("-:--:---", 2);
					Main.sn.sendmsg("BK", Main.sn.getDisplay());
				} else {
					mainFrame.setDisplayTime(textIdo2.getText(), 2);
					Main.sn.sendmsg(ido2, Main.sn.getDisplay());
				}
			} else if (dropdownindex == 2 || dropdownindex == 3) {
				ido1 = /* "A" + */textIdo1.getText();// + "\n";
				ido2 = /* "B" + */textIdo2.getText();// + "\n";

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

				if (earlyA) {
					mainFrame.setDisplayTime("-:--:---", 1);
					Main.sn.sendmsg("AK", Main.sn.getDisplay());
				} else {
					mainFrame.setDisplayTime(textIdo1.getText(), 1);
					Main.sn.sendmsg(ido1, Main.sn.getDisplay());
				}
				if (earlyB) {
					mainFrame.setDisplayTime("-:--:---", 2);
					Main.sn.sendmsg("BK", Main.sn.getDisplay());
				} else {
					mainFrame.setDisplayTime(textIdo2.getText(), 2);
					Main.sn.sendmsg(ido2, Main.sn.getDisplay());
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
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

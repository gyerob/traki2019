package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import datastorage.DbConstants;
import datastorage.DbFunctions;
import pojo.Versenyzo;
import timing.NextDisplay;
import traktoros.Main;

public class MainFrame extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8062640377601157344L;
	private JLayeredPane contentPane;
	private JTable table;
	private JTabbedPane tabbedPane;
	private KijelzoPanel kijelzoPanel;
	private JScrollPane scrollPane;
	private RegPanel regPanel;
	private PotkocsisPanel potkocsisPanel;
	private SzlalomPanel szlalomPanel;
	private GyorsulasPanel gyorsulasPanel;
	private DontoPanel dontoPanel;
	private RajtlistaPanel rajtlistapanel;
	private OsszesitettPanel osszesitettpanel;

	private JLabel lblX;
	private JLabel lbl_;
	private JLabel lblPrintData;

	private JLabel lblRange1;
	private JLabel lblRange2;
	private JLabel lblRange3;
	private JLabel lblRange4;

	private BoolRenderer renderer;

	private ArrayList<Versenyzo> sortedsza;
	private ArrayList<Versenyzo> sortedszf;
	private ArrayList<Versenyzo> sortedgyf;
	private ArrayList<Versenyzo> sortedgya;
	private ArrayList<Versenyzo> sortedpka;
	private ArrayList<Versenyzo> sortedpkf;
	private ArrayList<Versenyzo> sortednoi;
	private ArrayList<Versenyzo> sortedvet;

	private ArrayList<Versenyzo> sza;
	private ArrayList<Versenyzo> szf;
	private ArrayList<Versenyzo> gya;
	private ArrayList<Versenyzo> gyf;
	private ArrayList<Versenyzo> pka;
	private ArrayList<Versenyzo> pkf;
	private ArrayList<Versenyzo> noi;
	private ArrayList<Versenyzo> vet;
	private ArrayList<Versenyzo> eh;

	private ArrayList<Versenyzo> temp;

	private ArrayList<Versenyzo> paros;
	private ArrayList<Versenyzo> paratlan;

	int indexPKA = 0, indexPKF = 0, indexSZA = 0, indexSZF = 0, indexGYF = 0, indexGYA = 0, indexNOI = 0, indexVET = 0;
	private JButton btnNext;

	private boolean firstload = true;
	private JButton btnOpenDB;
	private JButton btnSaveDB;
	private JTextField textDBName;
	private JTextField txtDBName;
	private JButton btna;
	private JButton btna_1;
	private JButton btnb;
	private JButton btnb_1;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setBackground(new Color(0, 100, 0));

		double w = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getWidth();
		double h = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getHeight();

		setMinimumSize(new Dimension((int) w, (int) h));
		setMaximumSize(new Dimension((int) w, (int) h));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 596);
		setLocation(0, 0);
		contentPane = new JLayeredPane();
		contentPane.setOpaque(false);
		contentPane.setBackground(new Color(0, 100, 0));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println("keytyped");

			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("keypressed" + e.getKeyChar());

			}

			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("keyreleased");

			}
		});
		contentPane.setFocusable(true);

		lblX = new JLabel("X");
		contentPane.setLayer(lblX, 4);
		lblX.setOpaque(true);
		lblX.setBackground(new Color(0, 100, 0));
		lblX.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setBackground(new Color(0, 200, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setBackground(new Color(0, 100, 0));
			}
		});
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds((int) w - 27, 0, 27, 23);
		contentPane.add(lblX);

		lbl_ = new JLabel("_");
		contentPane.setLayer(lbl_, 4);
		lbl_.setOpaque(true);
		lbl_.setBackground(new Color(0, 100, 0));
		lbl_.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setState(MainFrame.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_.setBackground(new Color(0, 200, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lbl_.setBackground(new Color(0, 100, 0));
			}
		});
		lbl_.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_.setForeground(Color.WHITE);
		lbl_.setBounds((int) w - 54, 0, 27, 23);
		contentPane.add(lbl_);

		lblPrintData = new JLabel("Nyomtat\u00E1s");
		contentPane.setLayer(lblPrintData, 4);
		lblPrintData.setForeground(new Color(255, 255, 255));
		lblPrintData.setBackground(new Color(0, 100, 0));
		lblPrintData.setOpaque(true);
		lblPrintData.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrintData.setBounds((int) w - 124, 0, 70, 23);
		lblPrintData.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					int index = tabbedPane.getSelectedIndex();
					if (index < 4) {
						if (rajtlistapanel.isVisible()) {
							rajtlistapanel.printing();
						} else
							table.print(PrintMode.FIT_WIDTH);
					} else if (index == 4) {
						dontoPanel.print();
					} else if (index == 5) {
						osszesitettpanel.print();
					}
				} catch (PrinterException pe) {
					pe.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblPrintData.setBackground(new Color(0, 200, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblPrintData.setBackground(new Color(0, 100, 0));
			}
		});
		contentPane.add(lblPrintData);

		lblRange1 = new JLabel("");
		contentPane.setLayer(lblRange1, 3);
		lblRange1.setOpaque(true);
		lblRange1.setBackground(Color.GREEN);
		lblRange1.setBounds(0, (int) h - 15, (int) w / 4, 15);
		contentPane.add(lblRange1);

		lblRange2 = new JLabel("");
		contentPane.setLayer(lblRange2, 3);
		lblRange2.setOpaque(true);
		lblRange2.setBackground(Color.GREEN);
		lblRange2.setBounds((int) w / 4, (int) h - 15, (int) w / 4, 15);
		contentPane.add(lblRange2);

		lblRange3 = new JLabel("");
		contentPane.setLayer(lblRange3, 3);
		lblRange3.setOpaque(true);
		lblRange3.setBackground(Color.GREEN);
		lblRange3.setBounds((int) w / 2, (int) h - 15, (int) w / 4, 15);
		contentPane.add(lblRange3);

		lblRange4 = new JLabel("");
		contentPane.setLayer(lblRange4, 3);
		lblRange4.setOpaque(true);
		lblRange4.setBackground(Color.GREEN);
		lblRange4.setBounds((int) (w - w / 4), (int) h - 15, (int) w / 4, 15);
		contentPane.add(lblRange4);

		kijelzoPanel = new KijelzoPanel();
		contentPane.setLayer(kijelzoPanel, 2);
		kijelzoPanel.setFocusTraversalKeysEnabled(false);
		kijelzoPanel.setBorder(null);
		kijelzoPanel.setBounds((int) w - 600, 40, 550, 200);
		contentPane.add(kijelzoPanel);

		rajtlistapanel = new RajtlistaPanel();
		rajtlistapanel.setVisible(false);
		contentPane.setLayer(rajtlistapanel, 2);
		rajtlistapanel.setBounds(10, 270, (int) w - 20, (int) h - 300);
		contentPane.add(rajtlistapanel);

		scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(255, 255, 255));
		contentPane.setLayer(scrollPane, 2);
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		scrollPane.setBackground(new Color(0, 100, 0));
		scrollPane.setBounds(10, 270, (int) w - 20, (int) h - 300);
		contentPane.add(scrollPane);

		Color row2 = new Color(0, 150, 0);

		renderer = new BoolRenderer();

		table = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2407600333534540084L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);

				if (!isRowSelected(row)) {
					c.setBackground(row % 2 == 0 ? getBackground() : row2);
				}
				return c;
			}
		};
		table.setFont(new Font("Tahoma", Font.PLAIN, 40));
		table.setForeground(new Color(255, 255, 255));
		table.setOpaque(false);
		table.setRowHeight(60);
		table.setBackground(new Color(0, 100, 0));
		table.setBorder(null);
		scrollPane.setViewportView(table);
		scrollPane.getViewport().setOpaque(false);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.setLayer(tabbedPane, 1);
		tabbedPane.setOpaque(true);
		tabbedPane.setBorder(null);
		tabbedPane.setForeground(new Color(255, 255, 255));
		tabbedPane.setBackground(new Color(0, 100, 0));
		tabbedPane.setBounds(0, 5, (int) w, (int) h - 5);
		contentPane.add(tabbedPane);

		regPanel = new RegPanel(tabbedPane, this);
		regPanel.setBackground(new Color(0, 100, 0));
		regPanel.setBorder(null);
		tabbedPane.addTab("Lista", null, regPanel, null);
		regPanel.setLayout(null);
		table.setModel(regPanel.getTableModel());
		table.getColumnModel().getColumn(0).setMaxWidth(120);
		table.getColumnModel().getColumn(1).setMinWidth(400);
		table.getColumnModel().getColumn(6).setCellRenderer(renderer);
		table.getColumnModel().getColumn(7).setCellRenderer(renderer);
		table.getColumnModel().getColumn(8).setCellRenderer(renderer);

		potkocsisPanel = new PotkocsisPanel(tabbedPane, this);
		tabbedPane.addTab("P\u00F3tkocsis tolat\u00E1s", null, potkocsisPanel, null);

		szlalomPanel = new SzlalomPanel(tabbedPane, this);
		tabbedPane.addTab("Szlalom", null, szlalomPanel, null);

		gyorsulasPanel = new GyorsulasPanel(tabbedPane, this);
		gyorsulasPanel.setName("Gyorsulas");
		tabbedPane.addTab("Gyorsulas", null, gyorsulasPanel, null);

		dontoPanel = new DontoPanel(tabbedPane, this);
		tabbedPane.addTab("D\u00F6nt\u0151", null, dontoPanel, null);
		dontoPanel.setLayout(new BorderLayout(0, 0));

		osszesitettpanel = new OsszesitettPanel();
		tabbedPane.addTab("Összesített", null, osszesitettpanel, null);

		btnNext = new JButton("K\u00F6vetkez\u0151");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kovetkezo();
			}
		});
		btnNext.setVisible(false);
		btnNext.setMargin(new Insets(2, 2, 2, 2));
		contentPane.setLayer(btnNext, 3);
		btnNext.setBounds(454, 206, 89, 23);
		contentPane.add(btnNext);

		btnOpenDB = new JButton("<html>Adatb\u00E1zis<br />  megnyit\u00E1sa</html>");
		btnOpenDB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("FileChooser.acceptAllFileFilterText", "Minden fájl");
				UIManager.put("FileChooser.lookInLabelText", "Hely");
				UIManager.put("FileChooser.cancelButtonText", "Mégse");
				UIManager.put("FileChooser.cancelButtonToolTipText", "Mégse");
				UIManager.put("FileChooser.openButtonText", "Megnyitás");
				UIManager.put("FileChooser.openButtonToolTipText", "Kiválasztott fájl megnyitása");
				UIManager.put("FileChooser.filesOfTypeLabelText", "Típus");
				UIManager.put("FileChooser.fileNameLabelText", "Fájl");
				UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
				UIManager.put("FileChooser.listViewButtonAccessibleName", "Lista");
				UIManager.put("FileChooser.detailsViewButtonToolTipText", "Részletek");
				UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Részletek");
				UIManager.put("FileChooser.upFolderToolTipText", "Egy szinttel feljebb");
				UIManager.put("FileChooser.upFolderAccessibleName", "Egy szinttel feljebb");
				UIManager.put("FileChooser.homeFolderToolTipText", "Asztal");
				UIManager.put("FileChooser.newFolderToolTipText", "Új mappa");
				UIManager.put("FileChooser.openDialogTitleText", "Adatbázis kiválasztása");
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("DB fájl", "db");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(Main.mf);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					System.out.println("You chose to open this file: " + chooser.getSelectedFile().getParent());
					DbConstants.Database_Name = chooser.getSelectedFile().getName();
					// DbConstants.Database_Path =
					// chooser.getSelectedFile().getParent();
					textDBName.setText(DbConstants.Database_Name);
					refreshlists();
				}
			}
		});
		btnOpenDB.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.setLayer(btnOpenDB, 3);
		btnOpenDB.setBounds(600, 100, 100, 50);
		contentPane.add(btnOpenDB);

		btnSaveDB = new JButton("<html>Adatb\u00E1zis<br />  ment\u00E9se</html>");
		btnSaveDB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("FileChooser.acceptAllFileFilterText", "Minden fájl");
				UIManager.put("FileChooser.lookInLabelText", "Hely");
				UIManager.put("FileChooser.cancelButtonText", "Mégse");
				UIManager.put("FileChooser.cancelButtonToolTipText", "Mégse");
				UIManager.put("FileChooser.openButtonText", "Mentés");
				UIManager.put("FileChooser.openButtonToolTipText", "Mentés");
				UIManager.put("FileChooser.filesOfTypeLabelText", "Típus");
				UIManager.put("FileChooser.fileNameLabelText", "Fájl");
				UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
				UIManager.put("FileChooser.listViewButtonAccessibleName", "Lista");
				UIManager.put("FileChooser.detailsViewButtonToolTipText", "Részletek");
				UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Részletek");
				UIManager.put("FileChooser.upFolderToolTipText", "Egy szinttel feljebb");
				UIManager.put("FileChooser.upFolderAccessibleName", "Egy szinttel feljebb");
				UIManager.put("FileChooser.homeFolderToolTipText", "Asztal");
				UIManager.put("FileChooser.newFolderToolTipText", "Új mappa");
				UIManager.put("FileChooser.openDialogTitleText", "Adatbázis archiválása");
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("DB fájl", "db");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(Main.mf);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File fnew = chooser.getSelectedFile();
					if (!fnew.getName().substring(fnew.getName().length() - 2).equals("db")) {
						fnew = new File(fnew.getParent(), fnew.getName() + ".db");
					}
					File fold = new File(DbConstants.Database_Name);
					Path pold, pnew;
					pold = Paths.get(fold.getAbsolutePath());
					pnew = Paths.get(fnew.getAbsolutePath());
					try {
						Files.copy(pold, pnew, StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnSaveDB.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.setLayer(btnSaveDB, 3);
		btnSaveDB.setBounds(750, 100, 100, 50);
		contentPane.add(btnSaveDB);

		textDBName = new JTextField(DbConstants.Database_Name);
		textDBName.setEditable(false);
		contentPane.setLayer(textDBName, 3);
		// txtDBName.setText(DbConstants.Database_Name);
		textDBName.setBounds(630, 7, 130, 20);
		contentPane.add(textDBName);
		textDBName.setColumns(10);

		txtDBName = new JTextField();
		txtDBName.setBorder(null);
		txtDBName.setForeground(Color.WHITE);
		txtDBName.setOpaque(false);
		txtDBName.setEditable(false);
		contentPane.setLayer(txtDBName, 3);
		txtDBName.setText("Kiv\u00E1lasztott adatb\u00E1zis:");
		txtDBName.setBounds(500, 7, 130, 20);
		contentPane.add(txtDBName);
		txtDBName.setColumns(10);

		btna = new JButton("1A");
		btna.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Main.sn.setread("1A");
			}
		});
		contentPane.setLayer(btna, 10);
		btna.setBounds(600, 180, 89, 23);
		contentPane.add(btna);

		btna_1 = new JButton("2A");
		btna_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.sn.setread("2A");
			}
		});
		contentPane.setLayer(btna_1, 10);
		btna_1.setBounds(600, 210, 89, 23);
		contentPane.add(btna_1);

		btnb = new JButton("1B");
		btnb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.sn.setread("1B");
			}
		});
		contentPane.setLayer(btnb, 10);
		btnb.setBounds(700, 180, 89, 23);
		contentPane.add(btnb);

		btnb_1 = new JButton("2B");
		btnb_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.sn.setread("2B");
			}
		});
		contentPane.setLayer(btnb_1, 10);
		btnb_1.setBounds(700, 210, 89, 23);
		contentPane.add(btnb_1);

		tabbedPane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				refreshtable();
				hideRajlista();
			}
		});

		firstload = !firstload;

		sortedgya = new ArrayList<>();
		sortedgyf = new ArrayList<>();
		sortedsza = new ArrayList<>();
		sortedszf = new ArrayList<>();
		sortedpka = new ArrayList<>();
		sortedpkf = new ArrayList<>();

		btna.setVisible(false);
		btna_1.setVisible(false);
		btnb.setVisible(false);
		btnb_1.setVisible(false);
	}

	private class BoolRenderer extends DefaultTableCellRenderer {
		/**
		 * 
		 */
		private static final long serialVersionUID = -6263451317417292443L;

		JLabel icon = new JLabel();
		ImageIcon crossimage = new ImageIcon(getClass().getResource("/Images/x.png"));
		ImageIcon checkimage = new ImageIcon(getClass().getResource("/Images/p.png"));
		String text;

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			text = (String) value;
			// System.out.println(text);
			if (text.equals("true")) {
				icon.setIcon(checkimage);
			} else {
				icon.setIcon(crossimage);
			}
			icon.setHorizontalAlignment(SwingConstants.CENTER);
			icon.setOpaque(true);
			return icon;
		}
	}

	public void kovetkezo() {
		int index = tabbedPane.getSelectedIndex();
		int a1 = 0, b1 = 0, a2 = 0, b2 = 0;
		switch (index) {
		case 1: {
			int cat = potkocsisPanel.getCategory();
			if (cat == 0) {
				if (indexPKA < sortedpka.size())
					a1 = sortedpka.get(indexPKA).getRajt();
				if (indexPKA + 1 < sortedpka.size())
					b1 = sortedpka.get(indexPKA + 1).getRajt();
				if (indexPKA + 2 < sortedpka.size())
					a2 = sortedpka.get(indexPKA + 2).getRajt();
				if (indexPKA + 3 < sortedpka.size())
					b2 = sortedpka.get(indexPKA + 3).getRajt();

				indexPKA += 2;
				if (indexPKA > sortedpka.size() + 1) {
					indexPKA = 0;
				}
			} else {
				if (indexPKF < sortedpkf.size())
					a1 = sortedpkf.get(indexPKF).getRajt();
				if (indexPKF + 1 < sortedpkf.size())
					b1 = sortedpkf.get(indexPKF + 1).getRajt();
				if (indexPKF + 2 < sortedpkf.size())
					a2 = sortedpkf.get(indexPKF + 2).getRajt();
				if (indexPKF + 3 < sortedpkf.size())
					b2 = sortedpkf.get(indexPKF + 3).getRajt();

				indexPKF += 2;
				if (indexPKF > sortedpka.size() + 1) {
					indexPKF = 0;
				}
			}
			potkocsisPanel.setNext(a1, b1);
			setDisplayNext(a1, a2, b1, b2);
			break;
		}
		case 2: {
			int cat = szlalomPanel.getCategory();
			System.out.println(cat);
			if (cat == 0) {
				if (indexSZA < sortedsza.size())
					a1 = sortedsza.get(indexSZA).getRajt();
				if (indexSZA + 1 < sortedsza.size())
					b1 = sortedsza.get(indexSZA + 1).getRajt();
				if (indexSZA + 2 < sortedsza.size())
					a2 = sortedsza.get(indexSZA + 2).getRajt();
				if (indexSZA + 3 < sortedsza.size())
					b2 = sortedsza.get(indexSZA + 3).getRajt();

				indexSZA += 2;
				if (indexSZA > sortedsza.size() + 1) {
					indexSZA = 0;
				}
			} else if (cat == 1) {
				if (indexSZF < sortedszf.size())
					a1 = sortedszf.get(indexSZF).getRajt();
				if (indexSZF + 1 < sortedszf.size())
					b1 = sortedszf.get(indexSZF + 1).getRajt();
				if (indexSZF + 2 < sortedszf.size())
					a2 = sortedszf.get(indexSZF + 2).getRajt();
				if (indexSZF + 3 < sortedszf.size())
					b2 = sortedszf.get(indexSZF + 3).getRajt();

				indexSZF += 2;
				if (indexSZF > sortedszf.size() + 1) {
					indexSZF = 0;
				}
			} else if (cat == 2) {
				if (indexVET < sortedvet.size())
					a1 = sortedvet.get(indexVET).getRajt();
				if (indexVET + 1 < sortedvet.size())
					b1 = sortedvet.get(indexVET + 1).getRajt();
				if (indexVET + 2 < sortedvet.size())
					a2 = sortedvet.get(indexVET + 2).getRajt();
				if (indexVET + 3 < sortedvet.size())
					b2 = sortedvet.get(indexVET + 3).getRajt();

				indexVET += 2;
				if (indexVET > sortedvet.size() + 1) {
					indexVET = 0;
				}
			} else {
				if (indexNOI < sortednoi.size())
					a1 = sortednoi.get(indexNOI).getRajt();
				if (indexNOI + 1 < sortednoi.size())
					b1 = sortednoi.get(indexNOI + 1).getRajt();
				if (indexNOI + 2 < sortednoi.size())
					a2 = sortednoi.get(indexNOI + 2).getRajt();
				if (indexNOI + 3 < sortednoi.size())
					b2 = sortednoi.get(indexNOI + 3).getRajt();

				indexNOI += 2;
				if (indexNOI > sortednoi.size() + 1) {
					indexNOI = 0;
				}
			}
			szlalomPanel.setNext(a1, b1);
			setDisplayNext(a1, a2, b1, b2);
			break;
		}
		case 3: {
			int cat = gyorsulasPanel.getCategory();
			if (cat == 0) {
				if (indexGYA < sortedgya.size())
					a1 = sortedgya.get(indexGYA).getRajt();
				if (indexGYA + 1 < sortedgya.size())
					b1 = sortedgya.get(indexGYA + 1).getRajt();
				if (indexGYA + 2 < sortedgya.size())
					a2 = sortedgya.get(indexGYA + 2).getRajt();
				if (indexGYA + 3 < sortedgya.size())
					b2 = sortedgya.get(indexGYA + 3).getRajt();

				indexGYA += 2;
				if (indexGYA > sortedgya.size() + 1) {
					indexGYA = 0;
				}
			} else {
				if (indexGYF < sortedgyf.size())
					a1 = sortedgyf.get(indexGYF).getRajt();
				if (indexGYF + 1 < sortedgyf.size())
					b1 = sortedgyf.get(indexGYF + 1).getRajt();
				if (indexGYF + 2 < sortedgyf.size())
					a2 = sortedgyf.get(indexGYF + 2).getRajt();
				if (indexGYF + 3 < sortedgyf.size())
					b2 = sortedgyf.get(indexGYF + 3).getRajt();

				indexGYF += 2;
				if (indexGYF > sortedgyf.size() + 1) {
					indexGYF = 0;
				}
			}
			gyorsulasPanel.setNext(a1, b1);
			setDisplayNext(a1, a2, b1, b2);
			break;
		}
		case 4: {

			break;
		}
		}
	}

	public void refreshlists() {
		regPanel.updatelist();
		potkocsisPanel.updatelist();
		szlalomPanel.updatelist();
		gyorsulasPanel.updatelist();
		osszesitettpanel.updatelist();
		dontoPanel.updatelist();
	}

	public void refreshtable() {
		int page = tabbedPane.getSelectedIndex();
		Main.sn.setPageIndex(page);

		switch (page) {
		case 0: {
			table.setModel(regPanel.getTableModel());
			table.getColumnModel().getColumn(0).setMaxWidth(160);
			table.getColumnModel().getColumn(1).setMinWidth(400);
			table.getColumnModel().getColumn(6).setCellRenderer(renderer);
			table.getColumnModel().getColumn(7).setCellRenderer(renderer);
			table.getColumnModel().getColumn(8).setCellRenderer(renderer);
			table.getColumnModel().getColumn(9).setCellRenderer(renderer);
			break;
		}
		case 1: {
			table.setModel(potkocsisPanel.getTableModel());
			table.getColumnModel().getColumn(0).setMaxWidth(160);
			table.getColumnModel().getColumn(1).setMinWidth(400);
			break;
		}
		case 2: {
			table.setModel(szlalomPanel.getTableModel());
			table.getColumnModel().getColumn(0).setMaxWidth(160);
			table.getColumnModel().getColumn(1).setMinWidth(400);
			break;
		}
		case 3: {
			table.setModel(gyorsulasPanel.getTableModel());
			table.getColumnModel().getColumn(0).setMaxWidth(160);
			table.getColumnModel().getColumn(1).setMinWidth(400);
			break;
		}
		case 5: {
			osszesitettpanel.updatelist();
			break;
		}
		}
		if (!firstload) {
			if (page > 0) {
				btnOpenDB.setVisible(false);
				btnSaveDB.setVisible(false);
			} else {
				btnOpenDB.setVisible(true);
				btnSaveDB.setVisible(true);
			}
			if (page == 5 || page == 0) {
				btnNext.setVisible(false);
			} else {
				btnNext.setVisible(true);
			}
		}

		if (page == 4) {
			scrollPane.setVisible(false);
			kijelzoPanel.setVisible(true);
			// btnNext.setVisible(true);
		} else if (page == 5) {
			scrollPane.setVisible(false);
			kijelzoPanel.setVisible(false);
			// btnNext.setVisible(false);
		} else if (!scrollPane.isVisible()) {
			scrollPane.setVisible(true);
			kijelzoPanel.setVisible(true);
			// btnNext.setVisible(true);
		}

	}

	public void setColor(int rect, Color c) {
		try {
			switch (rect) {
			case 0: {
				lblRange1.setOpaque(true);
				lblRange1.setBackground(c);
				break;
			}
			case 1: {
				lblRange2.setOpaque(true);
				lblRange2.setBackground(c);
				break;
			}
			case 2: {
				lblRange3.setOpaque(true);
				lblRange3.setBackground(c);
				break;
			}
			case 3: {
				lblRange4.setOpaque(true);
				lblRange4.setBackground(c);
				break;
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void earlyStart(int track) {
		/* try { */
		int page = tabbedPane.getSelectedIndex();
		if (page == 1) {
			potkocsisPanel.earlyStart(track);
		} else if (page == 2) {
			szlalomPanel.earlyStart(track);
		} else if (page == 3) {
			gyorsulasPanel.earlyStart(track);
		} else if (page == 4) {
			dontoPanel.earlyStart(track);
		}
		/*
		 * } catch (IOException e) { e.printStackTrace(); }
		 */
	}

	public void setTime(long start, long end, int track, boolean fault) {
		long time = end - start;
		long min = time / 60000000000L;
		long marad = time % 60000000000L;
		long sec = marad / 1000000000L;
		marad = marad % 1000000000L;
		long millis = marad / 1000000L;

		int page = tabbedPane.getSelectedIndex();
		if (page == 1) {
			potkocsisPanel.setTime(min, sec, millis, track);
		} else if (page == 2) {
			szlalomPanel.setTime(min, sec, millis, track);
		} else if (page == 3) {
			gyorsulasPanel.setTime(min, sec, millis, track);
		} else if (page == 4) {
			dontoPanel.setTime(min, sec, millis, track);
		}
	}

	public void clearDisplay() {
		kijelzoPanel.setTime("", 1);
		kijelzoPanel.setTime("", 2);
		try {
			Main.sn.sendmsg("CLEAR", Main.sn.getDisplay());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setDisplayTime(String ido, int track) {
		kijelzoPanel.setTime(ido, track);
	}

	public void setDisplayNext(int A1, int A2, int B1, int B2) {
		kijelzoPanel.setNext(A1, B1, A2, B2);
		/*
		 * String a1, b1, a2, b2; a1 = String.format("%02d", A1 % 100); b1 =
		 * String.format("%02d", B1 % 100); a2 = String.format("%02d", A2 % 100); b2 =
		 * String.format("%02d", B2 % 100); try { Main.sn.sendmsg("A" + a1 + "\n",
		 * Main.sn.getNextdisplay()); Main.sn.sendmsg("B" + b1 + "\n",
		 * Main.sn.getNextdisplay()); Main.sn.sendmsg("C" + a2 + "\n",
		 * Main.sn.getNextdisplay()); Main.sn.sendmsg("D" + b2 + "\n",
		 * Main.sn.getNextdisplay()); } catch (IOException e) { e.printStackTrace(); }
		 */

		NextDisplay szal = new NextDisplay();
		szal.setNumbers(A1, B1, A2, B2);
		szal.start();
	}

	public int getSelectedPage() {
		return tabbedPane.getSelectedIndex();
	}

	public void hideRajlista() {
		rajtlistapanel.setVisible(false);
	}

	public void generateRajtlista(boolean button) {
		ArrayList<Versenyzo> lista = new DbFunctions().selectAdat();
		sza = new ArrayList<Versenyzo>();
		szf = new ArrayList<Versenyzo>();
		gya = new ArrayList<Versenyzo>();
		gyf = new ArrayList<Versenyzo>();
		pka = new ArrayList<Versenyzo>();
		pkf = new ArrayList<Versenyzo>();
		noi = new ArrayList<Versenyzo>();
		vet = new ArrayList<Versenyzo>();
		eh = new ArrayList<Versenyzo>();

		sortedsza = new ArrayList<Versenyzo>();
		sortedszf = new ArrayList<Versenyzo>();
		sortedgyf = new ArrayList<Versenyzo>();
		sortedgya = new ArrayList<Versenyzo>();
		sortedpka = new ArrayList<Versenyzo>();
		sortedpkf = new ArrayList<Versenyzo>();
		sortednoi = new ArrayList<Versenyzo>();
		sortedvet = new ArrayList<Versenyzo>();

		Versenyzo v;

		for (int i = 0; i < lista.size(); i++) {
			v = lista.get(i);

			if (v.getNeme().equals("No")) {
				noi.add(v);
			} else if (v.getKategoria().equals("veteran")) {
				vet.add(v);
			} else if (v.getKategoria().equals("150a")) {
				System.out.println(v.getRajt());
				if (v.getPotkocsis().equals("true"))
					pka.add(v);
				if (v.getSzlalom().equals("true"))
					sza.add(v);
				if (v.getGyorsulas().equals("true"))
					gya.add(v);
			} else {
				if (v.getPotkocsis().equals("true"))
					pkf.add(v);
				if (v.getSzlalom().equals("true"))
					szf.add(v);
				if (v.getGyorsulas().equals("true"))
					gyf.add(v);
			}
			if (v.getErohuzas().equals("true"))
				eh.add(v);

			/*
			 * if (v.getNeme().equals("No") || v.getKategoria().equals("150a") ||
			 * v.getKategoria().equals("veteran")) { if (v.getPotkocsis().equals("true"))
			 * pka.add(v); if (v.getSzlalom().equals("true")) sza.add(v); if
			 * (v.getGyorsulas().equals("true")) gya.add(v); } else { if
			 * (v.getPotkocsis().equals("true")) pkf.add(v); if
			 * (v.getSzlalom().equals("true")) szf.add(v); if
			 * (v.getGyorsulas().equals("true")) gyf.add(v); }
			 */
		}

		sortedpka = merger(pka);
		sortedpkf = merger(pkf);
		sortedsza = merger(sza);
		sortedszf = merger(szf);
		sortedgya = /* gya; */ merger(gya);
		sortedgyf = /* gyf; */ merger(gyf);

		sortednoi = merger(noi);
		sortedvet = merger(vet);

		v = new Versenyzo();
		ArrayList<Versenyzo> sza = new ArrayList<Versenyzo>();

		for (int i = 0; i < sortedsza.size(); i++) {
			sza.add(sortedsza.get(i));
		}

		if (sza.size() % 2 == 1) {
			sza.add(v);
		}
		sza.add(v);
		sza.add(v);

		for (int i = 0; i < sortednoi.size(); i++) {
			sza.add(sortednoi.get(i));
		}
		if (sortednoi.size() % 2 == 1) {
			sza.add(v);
		}
		sza.add(v);
		sza.add(v);

		for (int i = 0; i < sortedvet.size(); i++) {
			sza.add(sortedvet.get(i));
		}
		if (sortedvet.size() % 2 == 1) {
			sza.add(v);
		}

		if (sortedpka.size() % 2 == 1) {
			sortedpka.add(v);
		}
		if (sortedpkf.size() % 2 == 1) {
			sortedpkf.add(v);
		}
		if (sortedszf.size() % 2 == 1) {
			sortedszf.add(v);
		}
		if (sortedgya.size() % 2 == 1) {
			sortedgya.add(v);
		}
		if (sortedgyf.size() % 2 == 1) {
			sortedgyf.add(v);
		}

		// rajtlistapanel.setData(sortedpka, sortedpkf, sortedsza, sortedszf, sortedgya,
		// sortedgyf);
		rajtlistapanel.setData(sortedpka, sortedpkf, sza, sortedszf, sortedgya, sortedgyf, eh);
		if (button) {
			rajtlistapanel.setVisible(true);
		}
	}

	public ArrayList<Versenyzo> merger(ArrayList<Versenyzo> lista) {
		temp = new ArrayList<Versenyzo>();

		paros = new ArrayList<Versenyzo>();
		paratlan = new ArrayList<Versenyzo>();

		Versenyzo ures = new Versenyzo("senki", 0, "", "");

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getRajt() % 2 == 0) {
				paros.add(lista.get(i));
			} else {
				paratlan.add(lista.get(i));
			}
		}

		boolean stop = false;
		int j = 1;
		while (!stop) {
			if (j % 2 == 0) {
				if (paros.size() > 0) {
					temp.add(paros.get(0));
					paros.remove(0);
				} else {
					// temp.add(ures);
					if (paratlan.size() > 0) {
						temp.add(paratlan.get(0));
						paratlan.remove(0);
					} else {
						temp.add(ures);
					}

				}
			} else {
				if (paratlan.size() > 0) {
					temp.add(paratlan.get(0));
					paratlan.remove(0);
				} else {
					// temp.add(ures);
					if (paros.size() > 0) {
						temp.add(paros.get(0));
						paros.remove(0);
					} else {
						temp.add(ures);
					}

				}
			}

			j++;

			if (paros.size() == 0 && paratlan.size() == 0) {
				stop = true;
			}
		}

		return temp;
	}

	public void setElindult(int track, int state) {
		int page = tabbedPane.getSelectedIndex();

		switch (page) {
		case 1: {
			potkocsisPanel.setElindult(track, state);
			break;
		}
		case 2: {
			szlalomPanel.setElindult(track, state);
			break;
		}
		case 3: {
			gyorsulasPanel.setElindult(track, state);
			break;
		}
		case 4: {
			dontoPanel.setElindult(track, state);
			break;
		}
		}
	}

	public void setLampColor(int state) {
		kijelzoPanel.setLampColor(state);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("keytyped");

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("keypressed");

	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyreleased");

	}
}

package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTable.PrintMode;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import datastorage.DbConstants;
import datastorage.DbFunctions;
import pojo.Abszolut;

public class OsszesitettPanel extends JPanel {
	private static final long serialVersionUID = -1822655166431630031L;

	private JScrollPane scrollPane;

	private JTable table;

	private DefaultTableModel tableModel;

	private JTextField txtLerAlatt;
	private JTextField txtLerFelett;
	private JTextField nump150a;
	private JTextField nums150a;
	private JTextField nump150f;
	private JTextField nums150f;
	private JTextField txtPtkocsis;
	private JTextField txtSzlalom;
	private JTextField txtGyorsuls;
	private JTextField numg150a;
	private JTextField numg150f;

	private JButton btnRendezs;
	private JButton btnListzs;

	//private DbFunctions2 dbf;

	/**
	 * Create the panel.
	 */
	public OsszesitettPanel() {
		//dbf = new DbFunctions2();
		setBackground(new Color(0, 100, 0));
		double w = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getWidth();
		double h = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getHeight() - 45.0;

		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(0, 100, 0));
		scrollPane.setBounds(0, 100, (int) w, (int) h - 100);
		add(scrollPane);

		table = new JTable() {
			private static final long serialVersionUID = -2407600333534540084L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);

				if (!isRowSelected(row)) {
					c.setBackground(row % 2 == 0 ? getBackground() : new Color(0, 150, 0));
				}
				return c;
			}

		};
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setRowHeight(60);
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(0, 100, 0));
		scrollPane.setViewportView(table);

		btnRendezs = new JButton("Rendez\u00E9s");
		btnRendezs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new DbFunctions().calcAbszolut();
				//dbf.calcAbszolut();
			}
		});
		btnRendezs.setBounds(10, 23, 89, 23);
		add(btnRendezs);

		btnListzs = new JButton("List\u00E1z\u00E1s");
		btnListzs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updatelist();
			}
		});
		btnListzs.setBounds(123, 23, 89, 23);
		add(btnListzs);

		txtLerAlatt = new JTextField();
		txtLerAlatt.setText("150 l\u00F3er\u0151 alatt");
		txtLerAlatt.setEditable(false);
		txtLerAlatt.setBounds(320, 40, 86, 20);
		add(txtLerAlatt);
		txtLerAlatt.setColumns(10);

		txtLerFelett = new JTextField();
		txtLerFelett.setText("150 l\u00F3er\u0151 felett");
		txtLerFelett.setEditable(false);
		txtLerFelett.setBounds(320, 70, 86, 20);
		add(txtLerFelett);
		txtLerFelett.setColumns(10);

		nump150a = new JTextField();
		nump150a.setEditable(false);
		nump150a.setBounds(440, 40, 86, 20);
		add(nump150a);
		nump150a.setColumns(10);

		nums150a = new JTextField();
		nums150a.setEditable(false);
		nums150a.setBounds(550, 40, 86, 20);
		add(nums150a);
		nums150a.setColumns(10);

		nump150f = new JTextField();
		nump150f.setEditable(false);
		nump150f.setBounds(440, 70, 86, 20);
		add(nump150f);
		nump150f.setColumns(10);

		nums150f = new JTextField();
		nums150f.setEditable(false);
		nums150f.setBounds(550, 70, 86, 20);
		add(nums150f);
		nums150f.setColumns(10);

		txtPtkocsis = new JTextField();
		txtPtkocsis.setText("P\u00F3tkocsis");
		txtPtkocsis.setEditable(false);
		txtPtkocsis.setBounds(440, 10, 86, 20);
		add(txtPtkocsis);
		txtPtkocsis.setColumns(10);

		txtSzlalom = new JTextField();
		txtSzlalom.setText("Szlalom");
		txtSzlalom.setEditable(false);
		txtSzlalom.setBounds(550, 10, 86, 20);
		add(txtSzlalom);
		txtSzlalom.setColumns(10);

		txtGyorsuls = new JTextField();
		txtGyorsuls.setText("Gyorsul\u00E1s");
		txtGyorsuls.setEditable(false);
		txtGyorsuls.setBounds(660, 10, 86, 20);
		add(txtGyorsuls);
		txtGyorsuls.setColumns(10);

		numg150a = new JTextField();
		numg150a.setEditable(false);
		numg150a.setBounds(660, 40, 86, 20);
		add(numg150a);
		numg150a.setColumns(10);

		numg150f = new JTextField();
		numg150f.setEditable(false);
		numg150f.setBounds(660, 70, 86, 20);
		add(numg150f);
		numg150f.setColumns(10);

		scrollPane.getViewport().setOpaque(false);
		updatelist();
	}

	public void updatelist() {
		nump150a.setText(Integer.toString(RegPanel.pot150a));
		nump150f.setText(Integer.toString(RegPanel.pot150f));
		nums150a.setText(Integer.toString(RegPanel.szl150a));
		nums150f.setText(Integer.toString(RegPanel.szl150f));
		numg150a.setText(Integer.toString(RegPanel.gy150a));
		numg150f.setText(Integer.toString(RegPanel.gy150f));
		// new DbFunctions2().calcAbszolut();
		String[] oszlopok = { "Rajt", "Név", "Kategória", "Pótkocsis tolatás", "Szlalom", "Gyorsulás", "Összesített" };

		int sorok = new DbFunctions().count(DbConstants.Abszolut.Database_Table);
		tableModel = new DefaultTableModel(oszlopok, sorok);

		ArrayList<Abszolut> lista = new DbFunctions().selectAbsolut();
		Abszolut a;

		for (int i = 0; i < lista.size(); i++) {
			a = lista.get(i);

			tableModel.setValueAt(a.getRajt(), i, 0);
			tableModel.setValueAt(a.getNev(), i, 1);
			tableModel.setValueAt(a.getKategoria(), i, 2);
			tableModel.setValueAt(a.getPotkocsis(), i, 3);
			tableModel.setValueAt(a.getSzlalom(), i, 4);
			tableModel.setValueAt(a.getGyorsulas(), i, 5);
			tableModel.setValueAt(a.getOsszes(), i, 6);
		}

		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setMaxWidth(40);
		table.getColumnModel().getColumn(1).setMinWidth(150);
	}

	public void print(){
		try {
			table.print(PrintMode.FIT_WIDTH);
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}
}

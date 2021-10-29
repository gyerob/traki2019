package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.print.PrinterException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import pojo.Versenyzo;

public class RajtlistaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1822655166431630031L;

	private JScrollPane scrollPKA;
	private JScrollPane scrollPKF;
	private JScrollPane scrollSZA;
	private JScrollPane scrollSZF;
	private JScrollPane scrollGYA;
	private JScrollPane scrollGYF;
	private JScrollPane scrollEH;

	private JTable tablepka;
	private JTable tablepkf;
	private JTable tablesza;
	private JTable tableszf;
	private JTable tablegya;
	private JTable tablegyf;
	private JTable tableeh;

	private DefaultTableModel tableModel;
	private JTextField txtpka;
	private JTextField txtpkf;
	private JTextField txtsza;
	private JTextField txtszf;
	private JTextField txtgya;
	private JTextField txtgyf;
	private JTextField txteh;

	private int oszlopszam = 7;

	/**
	 * Create the panel.
	 */
	public RajtlistaPanel() {
		setBackground(new Color(0, 100, 0));
		double w = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getWidth() - 20.0;
		double h = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getHeight() - 300.0;

		setLayout(null);

		txtpka = new JTextField();
		txtpka.setHorizontalAlignment(SwingConstants.CENTER);
		txtpka.setBorder(null);
		txtpka.setForeground(Color.WHITE);
		txtpka.setOpaque(false);
		txtpka.setText("P\u00F3tkocsis tolat\u00E1s 150 alatt");
		txtpka.setEditable(false);
		txtpka.setBounds((int) (0 * w) / oszlopszam, 0, (int) w / oszlopszam, 50);
		add(txtpka);
		txtpka.setColumns(10);

		txtpkf = new JTextField();
		txtpkf.setHorizontalAlignment(SwingConstants.CENTER);
		txtpkf.setBorder(null);
		txtpkf.setForeground(Color.WHITE);
		txtpkf.setOpaque(false);
		txtpkf.setText("P\u00F3tkocsis tolat\u00E1s 150 felett");
		txtpkf.setEditable(false);
		txtpkf.setBounds((int) (1 * w) / oszlopszam, 0, (int) w / oszlopszam, 50);
		add(txtpkf);
		txtpkf.setColumns(10);

		txtsza = new JTextField();
		txtsza.setHorizontalAlignment(SwingConstants.CENTER);
		txtsza.setBorder(null);
		txtsza.setForeground(Color.WHITE);
		txtsza.setOpaque(false);
		txtsza.setText("Szlalom 150 alatt");
		txtsza.setEditable(false);
		txtsza.setBounds((int) (2 * w) / oszlopszam, 0, (int) w / oszlopszam, 50);
		add(txtsza);
		txtsza.setColumns(10);

		txtszf = new JTextField();
		txtszf.setHorizontalAlignment(SwingConstants.CENTER);
		txtszf.setBorder(null);
		txtszf.setForeground(Color.WHITE);
		txtszf.setOpaque(false);
		txtszf.setText("Szlalom 150 felett");
		txtszf.setEditable(false);
		txtszf.setBounds((int) (3 * w) / oszlopszam, 0, (int) w / oszlopszam, 50);
		add(txtszf);
		txtszf.setColumns(10);

		txtgya = new JTextField();
		txtgya.setHorizontalAlignment(SwingConstants.CENTER);
		txtgya.setBorder(null);
		txtgya.setForeground(Color.WHITE);
		txtgya.setOpaque(false);
		txtgya.setText("Gyorsul\u00E1s 150 alatt");
		txtgya.setEditable(false);
		txtgya.setBounds((int) (4 * w) / oszlopszam, 0, (int) w / oszlopszam, 50);
		add(txtgya);
		txtgya.setColumns(10);

		txtgyf = new JTextField();
		txtgyf.setHorizontalAlignment(SwingConstants.CENTER);
		txtgyf.setBorder(null);
		txtgyf.setForeground(Color.WHITE);
		txtgyf.setOpaque(false);
		txtgyf.setText("Gyorsul\u00E1s 150 felett");
		txtgyf.setEditable(false);
		txtgyf.setBounds((int) (5 * w) / oszlopszam, 0, (int) w / oszlopszam, 50);
		add(txtgyf);
		txtgyf.setColumns(10);

		txteh = new JTextField();
		txteh.setHorizontalAlignment(SwingConstants.CENTER);
		txteh.setBorder(null);
		txteh.setForeground(Color.WHITE);
		txteh.setOpaque(false);
		txteh.setText("Er\u0151h\u00FAz\u00E1s");
		txteh.setEditable(false);
		txteh.setBounds((int) (6 * w) / oszlopszam, 0, (int) w / oszlopszam, 50);
		add(txteh);
		txteh.setColumns(10);
		
		scrollPKA = new JScrollPane();
		scrollPKA.setBackground(new Color(0, 100, 0));
		scrollPKA.setBounds(0, 50, (int) w / oszlopszam, (int) h - 50);
		add(scrollPKA);

		scrollPKF = new JScrollPane();
		scrollPKF.setBackground(new Color(0, 100, 0));
		scrollPKF.setBounds((int) w / oszlopszam, 50, (int) w / oszlopszam, (int) h - 50);
		add(scrollPKF);

		scrollSZA = new JScrollPane();
		scrollSZA.setBackground(new Color(0, 100, 0));
		scrollSZA.setBounds((int) (2 * w) / oszlopszam, 50, (int) w / oszlopszam, (int) h - 50);
		add(scrollSZA);

		scrollSZF = new JScrollPane();
		scrollSZF.setBackground(new Color(0, 100, 0));
		scrollSZF.setBounds((int) (3 * w) / oszlopszam, 50, (int) w / oszlopszam, (int) h - 50);
		add(scrollSZF);

		scrollGYA = new JScrollPane();
		scrollGYA.setBackground(new Color(0, 100, 0));
		scrollGYA.setBounds((int) (4 * w) / oszlopszam, 50, (int) w / oszlopszam, (int) h - 50);
		add(scrollGYA);

		scrollGYF = new JScrollPane();
		scrollGYF.setBackground(new Color(0, 100, 0));
		scrollGYF.setBounds((int) (5 * w) / oszlopszam, 50, (int) w / oszlopszam, (int) h - 50);
		add(scrollGYF);
		
		scrollEH = new JScrollPane();
		scrollEH.setBackground(new Color(0, 100, 0));
		scrollEH.setBounds((int) (6 * w) / oszlopszam, 50, (int) w / oszlopszam, (int) h - 50);
		add(scrollEH);

		tablepka = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2407600333534540084L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);

				if (!isRowSelected(row)) {
					c.setBackground(row % 2 == 0 ? getBackground() : new Color(0, 150, 0));
				}
				return c;
			}

		};
		tablepka.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tablepka.setRowHeight(60);
		tablepka.setForeground(new Color(255, 255, 255));
		tablepka.setBackground(new Color(0, 100, 0));
		scrollPKA.setViewportView(tablepka);

		tablepkf = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2407600333534540084L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);

				if (!isRowSelected(row)) {
					c.setBackground(row % 2 == 0 ? getBackground() : new Color(0, 150, 0));
				}
				return c;
			}

		};
		tablepkf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tablepkf.setRowHeight(60);
		tablepkf.setForeground(new Color(255, 255, 255));
		tablepkf.setBackground(new Color(0, 100, 0));
		scrollPKF.setViewportView(tablepkf);

		tablesza = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2407600333534540084L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);

				if (!isRowSelected(row)) {
					c.setBackground(row % 2 == 0 ? getBackground() : new Color(0, 150, 0));
				}
				return c;
			}

		};
		tablesza.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tablesza.setRowHeight(60);
		tablesza.setForeground(new Color(255, 255, 255));
		tablesza.setBackground(new Color(0, 100, 0));
		scrollSZA.setViewportView(tablesza);

		tableszf = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2407600333534540084L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);

				if (!isRowSelected(row)) {
					c.setBackground(row % 2 == 0 ? getBackground() : new Color(0, 150, 0));
				}
				return c;
			}

		};
		tableszf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tableszf.setRowHeight(60);
		tableszf.setForeground(new Color(255, 255, 255));
		tableszf.setBackground(new Color(0, 100, 0));
		scrollSZF.setViewportView(tableszf);

		tablegya = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2407600333534540084L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);

				if (!isRowSelected(row)) {
					c.setBackground(row % 2 == 0 ? getBackground() : new Color(0, 150, 0));
				}
				return c;
			}

		};
		tablegya.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tablegya.setRowHeight(60);
		tablegya.setForeground(new Color(255, 255, 255));
		tablegya.setBackground(new Color(0, 100, 0));
		scrollGYA.setViewportView(tablegya);

		tablegyf = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2407600333534540084L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);

				if (!isRowSelected(row)) {
					c.setBackground(row % 2 == 0 ? getBackground() : new Color(0, 150, 0));
				}
				return c;
			}

		};
		tablegyf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tablegyf.setRowHeight(60);
		tablegyf.setForeground(new Color(255, 255, 255));
		tablegyf.setBackground(new Color(0, 100, 0));
		scrollGYF.setViewportView(tablegyf);
		
		tableeh = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2407600333534540084L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);

				if (!isRowSelected(row)) {
					c.setBackground(row % 2 == 0 ? getBackground() : new Color(0, 150, 0));
				}
				return c;
			}

		};
		tableeh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tableeh.setRowHeight(60);
		tableeh.setForeground(new Color(255, 255, 255));
		tableeh.setBackground(new Color(0, 100, 0));
		scrollEH.setViewportView(tableeh);

		scrollPKA.getViewport().setOpaque(false);
		scrollPKF.getViewport().setOpaque(false);
		scrollSZA.getViewport().setOpaque(false);
		scrollSZF.getViewport().setOpaque(false);
		scrollGYA.getViewport().setOpaque(false);
		scrollGYF.getViewport().setOpaque(false);
		scrollEH.getViewport().setOpaque(false);
	}

	public void setData(ArrayList<Versenyzo> pka, ArrayList<Versenyzo> pkf, ArrayList<Versenyzo> sza,
			ArrayList<Versenyzo> szf, ArrayList<Versenyzo> gya, ArrayList<Versenyzo> gyf, ArrayList<Versenyzo> eh) {

		String[] oszlopok = { "Rajtszám", "Név", "Rendszám" };

		oszlopszam = 0;
		if (pka.size() > 0)
			oszlopszam++;
		if (pkf.size() > 0)
			oszlopszam++;
		if (sza.size() > 0)
			oszlopszam++;
		if (szf.size() > 0)
			oszlopszam++;
		if (gya.size() > 0)
			oszlopszam++;
		if (gyf.size() > 0)
			oszlopszam++;
		if (eh.size() > 0)
			oszlopszam++;

		tableModel = new DefaultTableModel(oszlopok, pka.size());
		for (int i = 0; i < pka.size(); i++) {
			tableModel.setValueAt(pka.get(i).getRajt(), i, 0);
			tableModel.setValueAt(pka.get(i).getNev(), i, 1);
			tableModel.setValueAt(pka.get(i).getOsztozik(), i, 2);
		}
		tablepka.setModel(tableModel);
		tablepka.getColumnModel().getColumn(0).setMinWidth(40);
		tablepka.getColumnModel().getColumn(0).setMaxWidth(40);
		tablepka.getColumnModel().getColumn(1).setMinWidth(150);

		tableModel = new DefaultTableModel(oszlopok, pkf.size());
		for (int i = 0; i < pkf.size(); i++) {
			tableModel.setValueAt(pkf.get(i).getRajt(), i, 0);
			tableModel.setValueAt(pkf.get(i).getNev(), i, 1);
			tableModel.setValueAt(pkf.get(i).getOsztozik(), i, 2);
		}
		tablepkf.setModel(tableModel);
		tablepkf.getColumnModel().getColumn(0).setMinWidth(40);
		tablepkf.getColumnModel().getColumn(0).setMaxWidth(40);
		tablepkf.getColumnModel().getColumn(1).setMinWidth(150);

		tableModel = new DefaultTableModel(oszlopok, sza.size());
		for (int i = 0; i < sza.size(); i++) {
			tableModel.setValueAt(sza.get(i).getRajt(), i, 0);
			tableModel.setValueAt(sza.get(i).getNev(), i, 1);
			tableModel.setValueAt(sza.get(i).getOsztozik(), i, 2);
		}
		tablesza.setModel(tableModel);
		tablesza.getColumnModel().getColumn(0).setMinWidth(40);
		tablesza.getColumnModel().getColumn(0).setMaxWidth(40);
		tablesza.getColumnModel().getColumn(1).setMinWidth(150);

		tableModel = new DefaultTableModel(oszlopok, szf.size());
		for (int i = 0; i < szf.size(); i++) {
			tableModel.setValueAt(szf.get(i).getRajt(), i, 0);
			tableModel.setValueAt(szf.get(i).getNev(), i, 1);
			tableModel.setValueAt(szf.get(i).getOsztozik(), i, 2);
		}
		tableszf.setModel(tableModel);
		tableszf.getColumnModel().getColumn(0).setMinWidth(40);
		tableszf.getColumnModel().getColumn(0).setMaxWidth(40);
		tableszf.getColumnModel().getColumn(1).setMinWidth(150);

		tableModel = new DefaultTableModel(oszlopok, gya.size());
		for (int i = 0; i < gya.size(); i++) {
			tableModel.setValueAt(gya.get(i).getRajt(), i, 0);
			tableModel.setValueAt(gya.get(i).getNev(), i, 1);
			tableModel.setValueAt(gya.get(i).getOsztozik(), i, 2);
		}
		tablegya.setModel(tableModel);
		tablegya.getColumnModel().getColumn(0).setMinWidth(40);
		tablegya.getColumnModel().getColumn(0).setMaxWidth(40);
		tablegya.getColumnModel().getColumn(1).setMinWidth(150);

		tableModel = new DefaultTableModel(oszlopok, gyf.size());
		for (int i = 0; i < gyf.size(); i++) {
			tableModel.setValueAt(gyf.get(i).getRajt(), i, 0);
			tableModel.setValueAt(gyf.get(i).getNev(), i, 1);
			tableModel.setValueAt(gyf.get(i).getOsztozik(), i, 2);
		}
		tablegyf.setModel(tableModel);
		tablegyf.getColumnModel().getColumn(0).setMinWidth(40);
		tablegyf.getColumnModel().getColumn(0).setMaxWidth(40);
		tablegyf.getColumnModel().getColumn(1).setMinWidth(150);
		
		tableModel = new DefaultTableModel(oszlopok, eh.size());
		for (int i = 0; i < eh.size(); i++) {
			tableModel.setValueAt(eh.get(i).getRajt(), i, 0);
			tableModel.setValueAt(eh.get(i).getNev(), i, 1);
			tableModel.setValueAt(eh.get(i).getOsztozik(), i, 2);
		}
		tableeh.setModel(tableModel);
		tableeh.getColumnModel().getColumn(0).setMinWidth(40);
		tableeh.getColumnModel().getColumn(0).setMaxWidth(40);
		tableeh.getColumnModel().getColumn(1).setMinWidth(150);
	}

	public void printing() {

		/*
		 * TableModel model = new ParallelTableModel(tablepka.getModel(),
		 * tablepkf.getModel(), tablesza.getModel(), tableszf.getModel(),
		 * tablegya.getModel(), tablegyf.getModel()); JTable totalTable = new
		 * JTable(model); try { totalTable.print(); } catch (PrinterException e) {
		 * e.printStackTrace(); }
		 */
		try {
			if (tablepka.isFocusOwner()) {
				tablepka.print();
			}
			if (tablepkf.isFocusOwner()) {
				tablepkf.print();
			}
			if (tablesza.isFocusOwner()) {
				tablesza.print();
			}
			if (tableszf.isFocusOwner()) {
				tableszf.print();
			}
			if (tablegya.isFocusOwner()) {
				tablegya.print();
			}
			if (tablegyf.isFocusOwner()) {
				tablegyf.print();
			}
		} catch (PrinterException e) {
			e.printStackTrace();
		}
		// table.print(PrintMode.FIT_WIDTH);
		/*
		 * try { tablepka.print(); tablepkf.print(); tablesza.print(); tableszf.print();
		 * tablegya.print(); tablegyf.print(); } catch (PrinterException e) {
		 * e.printStackTrace(); }
		 */
	}

	public class ParallelTableModel extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private final TableModel[] models;

		public ParallelTableModel(TableModel... models) {
			this.models = models;
		}

		@Override
		public int getRowCount() {
			return models[0].getRowCount();
		}

		@Override
		public int getColumnCount() {
			int count = 0;
			for (TableModel model : models) {
				count += model.getColumnCount();
			}
			return count;
		}

		@Override
		public String getColumnName(int columnIndex) {
			int count = 0;
			for (TableModel model : models) {
				int n = model.getColumnCount();
				System.out.println(n);
				System.out.println("columindex" + columnIndex);
				if (columnIndex < count) {
					return model.getColumnName(columnIndex - count);
				}
				count += n;
			}
			throw new IndexOutOfBoundsException();
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			int count = 0;
			for (TableModel model : models) {
				int n = model.getColumnCount();
				if (columnIndex < count) {
					return model.getColumnClass(columnIndex - count);
				}
				count += n;
			}
			throw new IndexOutOfBoundsException();
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			int count = 0;
			for (TableModel model : models) {
				int n = model.getColumnCount();
				if (columnIndex < count) {
					return model.isCellEditable(rowIndex, columnIndex - count);
				}
				count += n;
			}
			throw new IndexOutOfBoundsException();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			int count = 0;
			for (TableModel model : models) {
				int n = model.getColumnCount();
				if (columnIndex < count) {
					return model.getValueAt(rowIndex, columnIndex - count);
				}
				count += n;
			}
			throw new IndexOutOfBoundsException();
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			int count = 0;
			for (TableModel model : models) {
				int n = model.getColumnCount();
				if (columnIndex < count) {
					model.setValueAt(aValue, rowIndex, columnIndex - count);
				}
				count += n;
			}
			throw new IndexOutOfBoundsException();
		}
	}
}

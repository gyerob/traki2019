package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import datastorage.DbFunctions;
import pojo.Dontos;
import traktoros.Main;

public class FinalsPanel8man extends FinalsPanel {
	/**
	 * 
	 */

	// TODO továbbjutás

	private static final long serialVersionUID = 6836494167795442809L;
	private JTextField selejt5;
	private JTextField selejt4;
	private JTextField selejt2;
	private JTextField selejt7;
	private JTextField selejt8;
	private JTextField selejt1;
	private JTextField selejt3;
	private JTextField selejt6;
	private JTextField negyed1;
	private MyLabel negyed1gomb2;
	private JTextField negyed2;
	private JTextField negyed3;
	private JTextField negyed4;
	private JTextField donto1;
	private JTextField donto2;
	private MyLabel donto1gomb1;
	private MyLabel donto1gomb2;
	private MyLabel negyed2gomb1;
	private MyLabel negyed2gomb2;
	private MyLabel selejt4gomb1;
	private MyLabel selejt4gomb2;
	private MyLabel selejt2gomb1;
	private MyLabel selejt2gomb2;
	private MyLabel selejt7gomb1;
	private MyLabel selejt7gomb2;
	private MyLabel selejt8gomb1;
	private MyLabel selejt8gomb2;
	private MyLabel selejt1gomb1;
	private MyLabel selejt1gomb2;
	private MyLabel selejt3gomb1;
	private MyLabel selejt3gomb2;
	private MyLabel selejt6gomb1;
	private MyLabel selejt6gomb2;
	private MyLabel negyed3gomb1;
	private MyLabel negyed3gomb2;
	private MyLabel negyed4gomb1;
	private MyLabel negyed4gomb2;
	private MyLabel donto2gomb1;
	private MyLabel donto2gomb2;
	private JTextField gyoztes;
	private JTextField donto3;
	private JTextField donto4;
	private MyLabel donto3gomb1;
	private MyLabel donto3gomb2;
	private MyLabel donto4gomb1;
	private MyLabel donto4gomb2;
	private JTextField harmadik;
	private MyLabel selejt5gomb1;
	private MyLabel selejt5gomb2;
	private MyLabel negyed1gomb1;

	private double height = 0;
	private JLabel lblNyil;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JTextField selejt5Rajt;
	private JTextField selejt4Rajt;
	private JTextField selejt2Rajt;
	private JTextField selejt7Rajt;
	private JTextField selejt8Rajt;
	private JTextField selejt1Rajt;
	private JTextField selejt3Rajt;
	private JTextField selejt6Rajt;
	private JTextField negyed1Rajt;
	private JTextField negyed2Rajt;
	private JTextField negyed3Rajt;
	private JTextField negyed4Rajt;
	private JTextField donto1Rajt;
	private JTextField gyoztesRajt;
	private JTextField donto2Rajt;
	private JTextField harmadikRajt;
	private JTextField donto3Rajt;
	private JTextField donto4Rajt;
	private DontoPanel dpanel;

	private int kategoria;
	private JCheckBox chkSelejt1;
	private JCheckBox chkSelejt2;
	private JCheckBox chkNegyed1;
	private JCheckBox chkselejt1;
	private JCheckBox chkselejt2;
	private JCheckBox chkNegyed2;
	private JCheckBox chkDonto;
	private JCheckBox chkHarmadik;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public FinalsPanel8man(double w, double h, DontoPanel dp) {
		dpanel = dp;
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(new Color(0, 100, 0));
		height = h;
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0,
				0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0 };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0 };
		setLayout(gbl_contentPanel);
		{
			selejt5Rajt = new JTextField();
			selejt5Rajt.setEditable(false);
			selejt5Rajt.setBorder(null);
			selejt5Rajt.setFont(new Font("Tahoma", Font.PLAIN, 36));
			GridBagConstraints gbc_selejt5Rajt = new GridBagConstraints();
			gbc_selejt5Rajt.insets = new Insets(0, 0, 5, 5);
			gbc_selejt5Rajt.fill = GridBagConstraints.BOTH;
			gbc_selejt5Rajt.gridx = 0;
			gbc_selejt5Rajt.gridy = 0;
			add(selejt5Rajt, gbc_selejt5Rajt);
			selejt5Rajt.setColumns(3);
		}
		{
			selejt5 = new JTextField();
			selejt5.setFont(new Font("Tahoma", Font.PLAIN, 36));
			selejt5.setEditable(false);
			selejt5.setBorder(null);
			selejt5.setMaximumSize(new Dimension(200, 100));
			selejt5.setPreferredSize(new Dimension(100, 60));
			selejt5.setMinimumSize(new Dimension(10, 10));
			selejt5.setText("7");
			GridBagConstraints gbc_selejt5 = new GridBagConstraints();
			gbc_selejt5.fill = GridBagConstraints.BOTH;
			gbc_selejt5.insets = new Insets(0, 0, 5, 5);
			gbc_selejt5.ipady = (int) height / 79;
			gbc_selejt5.gridx = 1;
			gbc_selejt5.gridy = 0;
			add(selejt5, gbc_selejt5);
			selejt5.setColumns(10);
		}
		{
			selejt5gomb1 = new MyLabel("");
			selejt5gomb1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (!selejt5gomb2.isSelected()) {
						selejt5gomb1.setSelected();
						dpanel.switchNumbers();
						if (selejt5gomb1.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt5Rajt.getText()), 1);
						} else {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt5Rajt.getText()), 0);
						}
					}
				}
			});
			selejt5gomb1.setOpaque(true);
			selejt5gomb1.setBackground(Color.LIGHT_GRAY);
			selejt5gomb1.setBorder(null);
			selejt5gomb1.setMaximumSize(new Dimension(40, 80));
			selejt5gomb1.setMinimumSize(new Dimension(10, 40));
			selejt5gomb1.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_selejt5gomb1 = new GridBagConstraints();
			gbc_selejt5gomb1.fill = GridBagConstraints.BOTH;
			gbc_selejt5gomb1.insets = new Insets(0, 5, 5, 5);
			gbc_selejt5gomb1.ipady = (int) height / 79;
			gbc_selejt5gomb1.gridx = 2;
			gbc_selejt5gomb1.gridy = 0;
			add(selejt5gomb1, gbc_selejt5gomb1);
		}
		{
			selejt5gomb2 = new MyLabel("");
			selejt5gomb2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (selejt5gomb1.isSelected()) {
						selejt5gomb2.setSelected();
						if (selejt5gomb2.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt5Rajt.getText()), 2);
							new DbFunctions().nextDonto(kategoria, 2, 1, Integer.parseInt(selejt5Rajt.getText()));
							negyed1Rajt.setText(selejt5Rajt.getText());
							negyed1.setText(selejt5.getText());
						} else {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt5Rajt.getText()), 1);
						}
					}
				}
			});
			selejt5gomb2.setOpaque(true);
			selejt5gomb2.setBackground(Color.LIGHT_GRAY);
			selejt5gomb2.setBorder(null);
			selejt5gomb2.setMinimumSize(new Dimension(10, 40));
			selejt5gomb2.setMaximumSize(new Dimension(40, 80));
			selejt5gomb2.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_selejt5gomb2 = new GridBagConstraints();
			gbc_selejt5gomb2.fill = GridBagConstraints.BOTH;
			gbc_selejt5gomb2.insets = new Insets(0, 5, 5, 5);
			gbc_selejt5gomb2.ipady = (int) height / 79;
			gbc_selejt5gomb2.gridx = 3;
			gbc_selejt5gomb2.gridy = 0;
			add(selejt5gomb2, gbc_selejt5gomb2);
		}
		{
			lblNyil = new JLabel("");
			lblNyil.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblNyil.setPreferredSize(new Dimension(60, 80));
			lblNyil.setMinimumSize(new Dimension(20, 40));
			lblNyil.setMaximumSize(new Dimension(60, 120));
			lblNyil.setIcon(new ImageIcon("src/Images/nyil2.png"));
			GridBagConstraints gbc_lblNyil = new GridBagConstraints();
			gbc_lblNyil.fill = GridBagConstraints.BOTH;
			gbc_lblNyil.gridheight = 3;
			gbc_lblNyil.insets = new Insets(0, 0, 5, 5);
			gbc_lblNyil.anchor = GridBagConstraints.EAST;
			gbc_lblNyil.gridx = 4;
			gbc_lblNyil.gridy = 0;
			add(lblNyil, gbc_lblNyil);
		}
		{
			chkSelejt1 = new JCheckBox("");
			buttonGroup.add(chkSelejt1);
			chkSelejt1.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					if (chkSelejt1.isSelected()) {
						int a1 = 0, a2 = 0, b1 = 0, b2 = 0;
						if (!selejt5Rajt.getText().equals(""))
							a1 = Integer.parseInt(selejt5Rajt.getText());
						if (!selejt2Rajt.getText().equals(""))
							a2 = Integer.parseInt(selejt2Rajt.getText());
						if (!selejt4Rajt.getText().equals(""))
							b1 = Integer.parseInt(selejt4Rajt.getText());
						if (!selejt7Rajt.getText().equals(""))
							b2 = Integer.parseInt(selejt7Rajt.getText());
						Main.mf.setDisplayNext(a1, a2, b1, b2);
						dp.setNum(a1, b1);
					}
				}
			});
			chkSelejt1.setSelectedIcon(new ImageIcon(FinalsPanel8man.class.getResource("/Images/p.png")));
			chkSelejt1.setIcon(new ImageIcon(FinalsPanel8man.class.getResource("/Images/x.png")));
			chkSelejt1.setMaximumSize(new Dimension(40, 40));
			chkSelejt1.setMinimumSize(new Dimension(40, 40));
			chkSelejt1.setSize(new Dimension(40, 40));
			chkSelejt1.setPreferredSize(new Dimension(40, 40));
			chkSelejt1.setOpaque(false);
			GridBagConstraints gbc_chkSelejt1 = new GridBagConstraints();
			gbc_chkSelejt1.fill = GridBagConstraints.VERTICAL;
			gbc_chkSelejt1.insets = new Insets(0, 0, 5, 5);
			gbc_chkSelejt1.gridx = 1;
			gbc_chkSelejt1.gridy = 1;
			add(chkSelejt1, gbc_chkSelejt1);
		}
		{
			negyed1Rajt = new JTextField();
			negyed1Rajt.setFont(new Font("Tahoma", Font.PLAIN, 36));
			negyed1Rajt.setEditable(false);
			negyed1Rajt.setColumns(3);
			negyed1Rajt.setBorder(null);
			GridBagConstraints gbc_negyed1Rajt = new GridBagConstraints();
			gbc_negyed1Rajt.insets = new Insets(0, 0, 5, 5);
			gbc_negyed1Rajt.fill = GridBagConstraints.BOTH;
			gbc_negyed1Rajt.gridx = 5;
			gbc_negyed1Rajt.gridy = 1;
			add(negyed1Rajt, gbc_negyed1Rajt);
		}
		{
			negyed1 = new JTextField();
			negyed1.setFont(new Font("Tahoma", Font.PLAIN, 36));
			negyed1.setEditable(false);
			negyed1.setBorder(null);
			negyed1.setMaximumSize(new Dimension(200, 100));
			negyed1.setMinimumSize(new Dimension(10, 10));
			negyed1.setPreferredSize(new Dimension(100, 60));
			GridBagConstraints gbc_negyed1 = new GridBagConstraints();
			gbc_negyed1.fill = GridBagConstraints.BOTH;
			gbc_negyed1.insets = new Insets(0, 0, 5, 5);
			gbc_negyed1.ipady = (int) height / 79;
			gbc_negyed1.gridx = 6;
			gbc_negyed1.gridy = 1;
			add(negyed1, gbc_negyed1);
			negyed1.setColumns(10);
		}
		{
			negyed1gomb1 = new MyLabel("");
			negyed1gomb1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (!negyed1gomb2.isSelected()) {
						negyed1gomb1.setSelected();
						dpanel.switchNumbers();
						if (negyed1gomb1.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 2, Integer.parseInt(negyed1Rajt.getText()), 1);
						} else {
							new DbFunctions().updateDonto(kategoria, 2, Integer.parseInt(negyed1Rajt.getText()), 0);
						}
					}
				}
			});
			negyed1gomb1.setOpaque(true);
			negyed1gomb1.setBackground(Color.LIGHT_GRAY);
			negyed1gomb1.setBorder(null);
			negyed1gomb1.setMinimumSize(new Dimension(10, 40));
			negyed1gomb1.setMaximumSize(new Dimension(40, 80));
			negyed1gomb1.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_negyed1gomb1 = new GridBagConstraints();
			gbc_negyed1gomb1.fill = GridBagConstraints.BOTH;
			gbc_negyed1gomb1.insets = new Insets(0, 5, 5, 5);
			gbc_negyed1gomb1.ipady = (int) height / 79;
			gbc_negyed1gomb1.gridx = 7;
			gbc_negyed1gomb1.gridy = 1;
			add(negyed1gomb1, gbc_negyed1gomb1);
		}
		{
			negyed1gomb2 = new MyLabel("");
			negyed1gomb2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (negyed1gomb1.isSelected()) {
						negyed1gomb2.setSelected();
						if (negyed1gomb2.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 2, Integer.parseInt(negyed1Rajt.getText()), 2);
							new DbFunctions().nextDonto(kategoria, 3, 1, Integer.parseInt(negyed1Rajt.getText()));
							donto1Rajt.setText(negyed1Rajt.getText());
							donto1.setText(negyed1.getText());

							new DbFunctions().nextDonto(kategoria, 3, 3, Integer.parseInt(negyed2Rajt.getText()));
							donto3Rajt.setText(negyed2Rajt.getText());
							donto3.setText(negyed2.getText());
						} else {
							new DbFunctions().updateDonto(kategoria, 2, Integer.parseInt(negyed1Rajt.getText()), 1);
						}
					}
				}
			});
			negyed1gomb2.setOpaque(true);
			negyed1gomb2.setBackground(Color.LIGHT_GRAY);
			negyed1gomb2.setBorder(null);
			negyed1gomb2.setMinimumSize(new Dimension(10, 40));
			negyed1gomb2.setMaximumSize(new Dimension(40, 80));
			negyed1gomb2.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_negyed1gomb2 = new GridBagConstraints();
			gbc_negyed1gomb2.fill = GridBagConstraints.BOTH;
			gbc_negyed1gomb2.insets = new Insets(0, 5, 5, 5);
			gbc_negyed1gomb2.ipady = (int) height / 79;
			gbc_negyed1gomb2.gridx = 8;
			gbc_negyed1gomb2.gridy = 1;
			add(negyed1gomb2, gbc_negyed1gomb2);
		}
		{
			selejt4Rajt = new JTextField();
			selejt4Rajt.setFont(new Font("Tahoma", Font.PLAIN, 36));
			selejt4Rajt.setEditable(false);
			selejt4Rajt.setColumns(3);
			selejt4Rajt.setBorder(null);
			GridBagConstraints gbc_selejt4Rajt = new GridBagConstraints();
			gbc_selejt4Rajt.insets = new Insets(0, 0, 5, 5);
			gbc_selejt4Rajt.fill = GridBagConstraints.BOTH;
			gbc_selejt4Rajt.gridx = 0;
			gbc_selejt4Rajt.gridy = 2;
			add(selejt4Rajt, gbc_selejt4Rajt);
		}
		{
			selejt4 = new JTextField();
			selejt4.setFont(new Font("Tahoma", Font.PLAIN, 36));
			selejt4.setEditable(false);
			selejt4.setBorder(null);
			selejt4.setMaximumSize(new Dimension(200, 100));
			selejt4.setMinimumSize(new Dimension(10, 10));
			selejt4.setPreferredSize(new Dimension(100, 60));
			selejt4.setText("6");
			GridBagConstraints gbc_selejt4 = new GridBagConstraints();
			gbc_selejt4.insets = new Insets(0, 0, 5, 5);
			gbc_selejt4.fill = GridBagConstraints.BOTH;
			gbc_selejt4.ipady = (int) height / 79;
			gbc_selejt4.gridx = 1;
			gbc_selejt4.gridy = 2;
			add(selejt4, gbc_selejt4);
			selejt4.setColumns(10);
		}
		{
			selejt4gomb1 = new MyLabel("");
			selejt4gomb1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					if (!selejt4gomb2.isSelected()) {
						selejt4gomb1.setSelected();
						dpanel.switchNumbers();
						if (selejt4gomb1.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt4Rajt.getText()), 1);
						} else {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt4Rajt.getText()), 0);
						}
					}
				}
			});
			selejt4gomb1.setOpaque(true);
			selejt4gomb1.setBackground(Color.LIGHT_GRAY);
			selejt4gomb1.setBorder(null);
			selejt4gomb1.setMinimumSize(new Dimension(10, 40));
			selejt4gomb1.setMaximumSize(new Dimension(40, 80));
			selejt4gomb1.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_selejt4gomb1 = new GridBagConstraints();
			gbc_selejt4gomb1.fill = GridBagConstraints.BOTH;
			gbc_selejt4gomb1.insets = new Insets(0, 5, 5, 5);
			gbc_selejt4gomb1.ipady = (int) height / 79;
			gbc_selejt4gomb1.gridx = 2;
			gbc_selejt4gomb1.gridy = 2;
			add(selejt4gomb1, gbc_selejt4gomb1);
		}
		{
			selejt4gomb2 = new MyLabel("");
			selejt4gomb2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (selejt4gomb1.isSelected()) {
						selejt4gomb2.setSelected();
						if (selejt4gomb2.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt4Rajt.getText()), 2);
							new DbFunctions().nextDonto(kategoria, 2, 1, Integer.parseInt(selejt4Rajt.getText()));
							negyed1Rajt.setText(selejt4Rajt.getText());
							negyed1.setText(selejt4.getText());
						} else {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt4Rajt.getText()), 1);
						}
					}
				}
			});
			selejt4gomb2.setOpaque(true);
			selejt4gomb2.setBackground(Color.LIGHT_GRAY);
			selejt4gomb2.setBorder(null);
			selejt4gomb2.setMinimumSize(new Dimension(10, 40));
			selejt4gomb2.setMaximumSize(new Dimension(40, 80));
			selejt4gomb2.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_selejt4gomb2 = new GridBagConstraints();
			gbc_selejt4gomb2.fill = GridBagConstraints.BOTH;
			gbc_selejt4gomb2.insets = new Insets(0, 5, 5, 5);
			gbc_selejt4gomb2.ipady = (int) height / 79;
			gbc_selejt4gomb2.gridx = 3;
			gbc_selejt4gomb2.gridy = 2;
			add(selejt4gomb2, gbc_selejt4gomb2);
		}
		{
			label_3 = new JLabel("");
			label_3.setAlignmentX(Component.CENTER_ALIGNMENT);
			label_3.setPreferredSize(new Dimension(60, 80));
			label_3.setMinimumSize(new Dimension(20, 40));
			label_3.setMaximumSize(new Dimension(60, 120));
			label_3.setIcon(new ImageIcon("src/Images/nyil2.png"));
			GridBagConstraints gbc_label_3 = new GridBagConstraints();
			gbc_label_3.fill = GridBagConstraints.BOTH;
			gbc_label_3.gridheight = 5;
			gbc_label_3.insets = new Insets(0, 0, 5, 5);
			gbc_label_3.gridx = 9;
			gbc_label_3.gridy = 1;
			add(label_3, gbc_label_3);
		}
		{
			chkNegyed1 = new JCheckBox("");
			buttonGroup.add(chkNegyed1);
			chkNegyed1.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					if (chkNegyed1.isSelected()) {
						int a1 = 0, a2 = 0, b1 = 0, b2 = 0;
						if (!negyed1Rajt.getText().equals(""))
							a1 = Integer.parseInt(negyed1Rajt.getText());
						if (!negyed3Rajt.getText().equals(""))
							a2 = Integer.parseInt(negyed3Rajt.getText());
						if (!negyed2Rajt.getText().equals(""))
							b1 = Integer.parseInt(negyed2Rajt.getText());
						if (!negyed4Rajt.getText().equals(""))
							b2 = Integer.parseInt(negyed4Rajt.getText());
						Main.mf.setDisplayNext(a1, a2, b1, b2);
						dp.setNum(a1, b1);
					}
				}
			});
			chkNegyed1.setSelectedIcon(new ImageIcon(FinalsPanel8man.class.getResource("/Images/p.png")));
			chkNegyed1.setIcon(new ImageIcon(FinalsPanel8man.class.getResource("/Images/x.png")));
			chkNegyed1.setSize(new Dimension(40, 40));
			chkNegyed1.setPreferredSize(new Dimension(40, 40));
			chkNegyed1.setOpaque(false);
			chkNegyed1.setMinimumSize(new Dimension(40, 40));
			chkNegyed1.setMaximumSize(new Dimension(40, 40));
			GridBagConstraints gbc_chkNegyed1 = new GridBagConstraints();
			gbc_chkNegyed1.insets = new Insets(0, 0, 5, 5);
			gbc_chkNegyed1.gridx = 6;
			gbc_chkNegyed1.gridy = 3;
			add(chkNegyed1, gbc_chkNegyed1);
		}
		{
			donto1Rajt = new JTextField();
			donto1Rajt.setFont(new Font("Tahoma", Font.PLAIN, 36));
			donto1Rajt.setEditable(false);
			donto1Rajt.setColumns(3);
			donto1Rajt.setBorder(null);
			GridBagConstraints gbc_donto1Rajt = new GridBagConstraints();
			gbc_donto1Rajt.insets = new Insets(0, 0, 5, 5);
			gbc_donto1Rajt.fill = GridBagConstraints.BOTH;
			gbc_donto1Rajt.gridx = 10;
			gbc_donto1Rajt.gridy = 4;
			add(donto1Rajt, gbc_donto1Rajt);
		}
		{
			donto1 = new JTextField();
			donto1.setFont(new Font("Tahoma", Font.PLAIN, 36));
			donto1.setEditable(false);
			donto1.setBorder(null);
			donto1.setMaximumSize(new Dimension(200, 100));
			donto1.setMinimumSize(new Dimension(10, 10));
			donto1.setPreferredSize(new Dimension(100, 60));
			GridBagConstraints gbc_donto1 = new GridBagConstraints();
			gbc_donto1.fill = GridBagConstraints.BOTH;
			gbc_donto1.insets = new Insets(0, 0, 5, 5);
			gbc_donto1.ipady = (int) height / 79;
			gbc_donto1.gridx = 11;
			gbc_donto1.gridy = 4;
			add(donto1, gbc_donto1);
			donto1.setColumns(10);
		}
		{
			donto1gomb1 = new MyLabel("");
			donto1gomb1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (!donto1gomb2.isSelected()) {
						donto1gomb1.setSelected();
						dpanel.switchNumbers();
						if (donto1gomb1.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 3, Integer.parseInt(donto1Rajt.getText()), 1);
						} else {
							new DbFunctions().updateDonto(kategoria, 3, Integer.parseInt(donto1Rajt.getText()), 0);
						}
					}
				}
			});
			donto1gomb1.setOpaque(true);
			donto1gomb1.setBackground(Color.LIGHT_GRAY);
			donto1gomb1.setBorder(null);
			donto1gomb1.setMinimumSize(new Dimension(10, 40));
			donto1gomb1.setMaximumSize(new Dimension(40, 80));
			donto1gomb1.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_donto1gomb1 = new GridBagConstraints();
			gbc_donto1gomb1.fill = GridBagConstraints.BOTH;
			gbc_donto1gomb1.insets = new Insets(0, 5, 5, 5);
			gbc_donto1gomb1.ipady = (int) height / 79;
			gbc_donto1gomb1.gridx = 12;
			gbc_donto1gomb1.gridy = 4;
			add(donto1gomb1, gbc_donto1gomb1);
		}
		{
			donto1gomb2 = new MyLabel("");
			donto1gomb2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (donto1gomb1.isSelected()) {
						donto1gomb2.setSelected();
						if (donto1gomb2.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 3, Integer.parseInt(donto1Rajt.getText()), 2);
							// new DbFunctions().nextDonto(kategoria, 3, 1,
							// Integer.parseInt(donto1Rajt.getText()));
							gyoztesRajt.setText(donto1Rajt.getText());
							gyoztes.setText(donto1.getText());
						} else {
							new DbFunctions().updateDonto(kategoria, 3, Integer.parseInt(donto1Rajt.getText()), 1);
						}
					}
				}
			});
			donto1gomb2.setOpaque(true);
			donto1gomb2.setBackground(Color.LIGHT_GRAY);
			donto1gomb2.setBorder(null);
			donto1gomb2.setMinimumSize(new Dimension(10, 40));
			donto1gomb2.setMaximumSize(new Dimension(40, 80));
			donto1gomb2.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_donto1gomb2 = new GridBagConstraints();
			gbc_donto1gomb2.fill = GridBagConstraints.BOTH;
			gbc_donto1gomb2.insets = new Insets(0, 5, 5, 5);
			gbc_donto1gomb2.ipady = (int) height / 79;
			gbc_donto1gomb2.gridx = 13;
			gbc_donto1gomb2.gridy = 4;
			add(donto1gomb2, gbc_donto1gomb2);
		}
		{
			label_5 = new JLabel("");
			label_5.setAlignmentX(Component.CENTER_ALIGNMENT);
			label_5.setPreferredSize(new Dimension(60, 80));
			label_5.setMinimumSize(new Dimension(20, 40));
			label_5.setMaximumSize(new Dimension(60, 120));
			label_5.setIcon(new ImageIcon("src/Images/nyil2.png"));
			GridBagConstraints gbc_label_5 = new GridBagConstraints();
			gbc_label_5.fill = GridBagConstraints.BOTH;
			gbc_label_5.gridheight = 3;
			gbc_label_5.insets = new Insets(0, 0, 5, 5);
			gbc_label_5.gridx = 14;
			gbc_label_5.gridy = 3;
			add(label_5, gbc_label_5);
		}
		{
			selejt2Rajt = new JTextField();
			selejt2Rajt.setFont(new Font("Tahoma", Font.PLAIN, 36));
			selejt2Rajt.setEditable(false);
			selejt2Rajt.setColumns(3);
			selejt2Rajt.setBorder(null);
			GridBagConstraints gbc_selejt2Rajt = new GridBagConstraints();
			gbc_selejt2Rajt.insets = new Insets(0, 0, 5, 5);
			gbc_selejt2Rajt.fill = GridBagConstraints.BOTH;
			gbc_selejt2Rajt.gridx = 0;
			gbc_selejt2Rajt.gridy = 4;
			add(selejt2Rajt, gbc_selejt2Rajt);
		}
		{
			selejt2 = new JTextField();
			selejt2.setFont(new Font("Tahoma", Font.PLAIN, 36));
			selejt2.setEditable(false);
			selejt2.setBorder(null);
			selejt2.setMaximumSize(new Dimension(200, 100));
			selejt2.setMinimumSize(new Dimension(10, 10));
			selejt2.setPreferredSize(new Dimension(100, 60));
			selejt2.setText("4");
			GridBagConstraints gbc_selejt2 = new GridBagConstraints();
			gbc_selejt2.insets = new Insets(0, 0, 5, 5);
			gbc_selejt2.fill = GridBagConstraints.BOTH;
			gbc_selejt2.ipady = (int) height / 79;
			gbc_selejt2.gridx = 1;
			gbc_selejt2.gridy = 4;
			add(selejt2, gbc_selejt2);
			selejt2.setColumns(10);
		}
		{
			selejt2gomb1 = new MyLabel("");
			selejt2gomb1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (!selejt2gomb2.isSelected()) {
						selejt2gomb1.setSelected();
						dpanel.switchNumbers();
						if (selejt2gomb1.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt2Rajt.getText()), 1);
						} else {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt2Rajt.getText()), 0);
						}
					}
				}
			});
			selejt2gomb1.setOpaque(true);
			selejt2gomb1.setBackground(Color.LIGHT_GRAY);
			selejt2gomb1.setBorder(null);
			selejt2gomb1.setMinimumSize(new Dimension(10, 40));
			selejt2gomb1.setMaximumSize(new Dimension(40, 80));
			selejt2gomb1.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_selejt2gomb1 = new GridBagConstraints();
			gbc_selejt2gomb1.fill = GridBagConstraints.BOTH;
			gbc_selejt2gomb1.insets = new Insets(0, 5, 5, 5);
			gbc_selejt2gomb1.ipady = (int) height / 79;
			gbc_selejt2gomb1.gridx = 2;
			gbc_selejt2gomb1.gridy = 4;
			add(selejt2gomb1, gbc_selejt2gomb1);
		}
		{
			selejt2gomb2 = new MyLabel("");
			selejt2gomb2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (selejt2gomb1.isSelected()) {
						selejt2gomb2.setSelected();
						if (selejt2gomb2.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt2Rajt.getText()), 2);
							new DbFunctions().nextDonto(kategoria, 2, 2, Integer.parseInt(selejt2Rajt.getText()));
							negyed2Rajt.setText(selejt2Rajt.getText());
							negyed2.setText(selejt2.getText());
						} else {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt2Rajt.getText()), 1);
						}
					}
				}
			});
			selejt2gomb2.setOpaque(true);
			selejt2gomb2.setBackground(Color.LIGHT_GRAY);
			selejt2gomb2.setBorder(null);
			selejt2gomb2.setMinimumSize(new Dimension(10, 40));
			selejt2gomb2.setMaximumSize(new Dimension(40, 80));
			selejt2gomb2.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_selejt2gomb2 = new GridBagConstraints();
			gbc_selejt2gomb2.fill = GridBagConstraints.BOTH;
			gbc_selejt2gomb2.insets = new Insets(0, 5, 5, 5);
			gbc_selejt2gomb2.ipady = (int) height / 79;
			gbc_selejt2gomb2.gridx = 3;
			gbc_selejt2gomb2.gridy = 4;
			add(selejt2gomb2, gbc_selejt2gomb2);
		}
		{
			label = new JLabel("");
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			label.setPreferredSize(new Dimension(60, 80));
			label.setMinimumSize(new Dimension(20, 40));
			label.setMaximumSize(new Dimension(60, 120));
			label.setIcon(new ImageIcon("src/Images/nyil2.png"));
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.fill = GridBagConstraints.BOTH;
			gbc_label.gridheight = 3;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 4;
			gbc_label.gridy = 4;
			add(label, gbc_label);
		}
		{
			label_8 = new JLabel("");
			label_8.setAlignmentX(Component.CENTER_ALIGNMENT);
			label_8.setPreferredSize(new Dimension(60, 80));
			label_8.setMinimumSize(new Dimension(20, 40));
			label_8.setMaximumSize(new Dimension(60, 120));
			label_8.setIcon(new ImageIcon("src/Images/nyil2.png"));
			GridBagConstraints gbc_label_8 = new GridBagConstraints();
			gbc_label_8.fill = GridBagConstraints.BOTH;
			gbc_label_8.gridheight = 7;
			gbc_label_8.insets = new Insets(0, 0, 5, 5);
			gbc_label_8.gridx = 19;
			gbc_label_8.gridy = 4;
			add(label_8, gbc_label_8);
		}
		{
			chkSelejt2 = new JCheckBox("");
			buttonGroup.add(chkSelejt2);
			chkSelejt2.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					if (chkSelejt2.isSelected()) {
						int a1 = 0, a2 = 0, b1 = 0, b2 = 0;
						if (!selejt2Rajt.getText().equals(""))
							a1 = Integer.parseInt(selejt2Rajt.getText());
						if (!selejt8Rajt.getText().equals(""))
							a2 = Integer.parseInt(selejt8Rajt.getText());
						if (!selejt7Rajt.getText().equals(""))
							b1 = Integer.parseInt(selejt7Rajt.getText());
						if (!selejt1Rajt.getText().equals(""))
							b2 = Integer.parseInt(selejt1Rajt.getText());
						Main.mf.setDisplayNext(a1, a2, b1, b2);
						dp.setNum(a1, b1);
					}
				}
			});
			chkSelejt2.setIcon(new ImageIcon(FinalsPanel8man.class.getResource("/Images/x.png")));
			chkSelejt2.setSelectedIcon(new ImageIcon(FinalsPanel8man.class.getResource("/Images/p.png")));
			chkSelejt2.setSize(new Dimension(40, 40));
			chkSelejt2.setPreferredSize(new Dimension(40, 40));
			chkSelejt2.setOpaque(false);
			chkSelejt2.setMinimumSize(new Dimension(40, 40));
			chkSelejt2.setMaximumSize(new Dimension(40, 40));
			GridBagConstraints gbc_chkSelejt2 = new GridBagConstraints();
			gbc_chkSelejt2.insets = new Insets(0, 0, 5, 5);
			gbc_chkSelejt2.gridx = 1;
			gbc_chkSelejt2.gridy = 5;
			add(chkSelejt2, gbc_chkSelejt2);
		}
		{
			negyed2Rajt = new JTextField();
			negyed2Rajt.setFont(new Font("Tahoma", Font.PLAIN, 36));
			negyed2Rajt.setEditable(false);
			negyed2Rajt.setColumns(3);
			negyed2Rajt.setBorder(null);
			GridBagConstraints gbc_negyed2Rajt = new GridBagConstraints();
			gbc_negyed2Rajt.insets = new Insets(0, 0, 5, 5);
			gbc_negyed2Rajt.fill = GridBagConstraints.BOTH;
			gbc_negyed2Rajt.gridx = 5;
			gbc_negyed2Rajt.gridy = 5;
			add(negyed2Rajt, gbc_negyed2Rajt);
		}
		{
			negyed2 = new JTextField();
			negyed2.setFont(new Font("Tahoma", Font.PLAIN, 36));
			negyed2.setEditable(false);
			negyed2.setBorder(null);
			negyed2.setMaximumSize(new Dimension(200, 100));
			negyed2.setMinimumSize(new Dimension(10, 10));
			negyed2.setPreferredSize(new Dimension(100, 60));
			GridBagConstraints gbc_negyed2 = new GridBagConstraints();
			gbc_negyed2.fill = GridBagConstraints.BOTH;
			gbc_negyed2.insets = new Insets(0, 0, 5, 5);
			gbc_negyed2.ipady = (int) height / 79;
			gbc_negyed2.gridx = 6;
			gbc_negyed2.gridy = 5;
			add(negyed2, gbc_negyed2);
			negyed2.setColumns(10);
		}
		{
			negyed2gomb1 = new MyLabel("");
			negyed2gomb1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (!negyed2gomb2.isSelected()) {
						negyed2gomb1.setSelected();
						dpanel.switchNumbers();
						if (negyed2gomb1.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 2, Integer.parseInt(negyed2Rajt.getText()), 1);
						} else {
							new DbFunctions().updateDonto(kategoria, 2, Integer.parseInt(negyed2Rajt.getText()), 0);
						}
					}
				}
			});
			negyed2gomb1.setOpaque(true);
			negyed2gomb1.setBackground(Color.LIGHT_GRAY);
			negyed2gomb1.setBorder(null);
			negyed2gomb1.setMinimumSize(new Dimension(10, 40));
			negyed2gomb1.setMaximumSize(new Dimension(40, 80));
			negyed2gomb1.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_negyed2gomb1 = new GridBagConstraints();
			gbc_negyed2gomb1.fill = GridBagConstraints.BOTH;
			gbc_negyed2gomb1.insets = new Insets(0, 5, 5, 5);
			gbc_negyed2gomb1.ipady = (int) height / 79;
			gbc_negyed2gomb1.gridx = 7;
			gbc_negyed2gomb1.gridy = 5;
			add(negyed2gomb1, gbc_negyed2gomb1);
		}
		{
			negyed2gomb2 = new MyLabel("");
			negyed2gomb2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (negyed2gomb1.isSelected()) {
						negyed2gomb2.setSelected();
						if (negyed2gomb2.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 2, Integer.parseInt(negyed2Rajt.getText()), 2);
							new DbFunctions().nextDonto(kategoria, 3, 1, Integer.parseInt(negyed2Rajt.getText()));
							donto1Rajt.setText(negyed2Rajt.getText());
							donto1.setText(negyed2.getText());

							new DbFunctions().nextDonto(kategoria, 3, 3, Integer.parseInt(negyed1Rajt.getText()));
							donto3Rajt.setText(negyed1Rajt.getText());
							donto3.setText(negyed1.getText());
						} else {
							new DbFunctions().updateDonto(kategoria, 2, Integer.parseInt(negyed2Rajt.getText()), 1);
						}
					}
				}
			});
			negyed2gomb2.setOpaque(true);
			negyed2gomb2.setBackground(Color.LIGHT_GRAY);
			negyed2gomb2.setBorder(null);
			negyed2gomb2.setMinimumSize(new Dimension(10, 40));
			negyed2gomb2.setMaximumSize(new Dimension(40, 80));
			negyed2gomb2.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_negyed2gomb2 = new GridBagConstraints();
			gbc_negyed2gomb2.fill = GridBagConstraints.BOTH;
			gbc_negyed2gomb2.insets = new Insets(0, 5, 5, 5);
			gbc_negyed2gomb2.ipady = (int) height / 79;
			gbc_negyed2gomb2.gridx = 8;
			gbc_negyed2gomb2.gridy = 5;
			add(negyed2gomb2, gbc_negyed2gomb2);
		}
		{
			selejt7Rajt = new JTextField();
			selejt7Rajt.setFont(new Font("Tahoma", Font.PLAIN, 36));
			selejt7Rajt.setEditable(false);
			selejt7Rajt.setColumns(3);
			selejt7Rajt.setBorder(null);
			GridBagConstraints gbc_selejt7Rajt = new GridBagConstraints();
			gbc_selejt7Rajt.insets = new Insets(0, 0, 5, 5);
			gbc_selejt7Rajt.fill = GridBagConstraints.BOTH;
			gbc_selejt7Rajt.gridx = 0;
			gbc_selejt7Rajt.gridy = 6;
			add(selejt7Rajt, gbc_selejt7Rajt);
		}
		{
			selejt7 = new JTextField();
			selejt7.setFont(new Font("Tahoma", Font.PLAIN, 36));
			selejt7.setEditable(false);
			selejt7.setBorder(null);
			selejt7.setMaximumSize(new Dimension(200, 100));
			selejt7.setMinimumSize(new Dimension(10, 10));
			selejt7.setPreferredSize(new Dimension(100, 60));
			selejt7.setText("9");
			GridBagConstraints gbc_selejt7 = new GridBagConstraints();
			gbc_selejt7.insets = new Insets(0, 0, 5, 5);
			gbc_selejt7.fill = GridBagConstraints.BOTH;
			gbc_selejt7.ipady = (int) height / 79;
			gbc_selejt7.gridx = 1;
			gbc_selejt7.gridy = 6;
			add(selejt7, gbc_selejt7);
			selejt7.setColumns(10);
		}
		{
			selejt7gomb1 = new MyLabel("");
			selejt7gomb1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (!selejt7gomb2.isSelected()) {
						selejt7gomb1.setSelected();
						dpanel.switchNumbers();
						if (selejt7gomb1.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt7Rajt.getText()), 1);
						} else {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt7Rajt.getText()), 0);
						}
					}
				}
			});
			selejt7gomb1.setOpaque(true);
			selejt7gomb1.setBackground(Color.LIGHT_GRAY);
			selejt7gomb1.setBorder(null);
			selejt7gomb1.setMinimumSize(new Dimension(10, 40));
			selejt7gomb1.setMaximumSize(new Dimension(40, 80));
			selejt7gomb1.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_selejt7gomb1 = new GridBagConstraints();
			gbc_selejt7gomb1.fill = GridBagConstraints.BOTH;
			gbc_selejt7gomb1.insets = new Insets(0, 5, 5, 5);
			gbc_selejt7gomb1.ipady = (int) height / 79;
			gbc_selejt7gomb1.gridx = 2;
			gbc_selejt7gomb1.gridy = 6;
			add(selejt7gomb1, gbc_selejt7gomb1);
		}
		{
			selejt7gomb2 = new MyLabel("");
			selejt7gomb2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (selejt7gomb1.isSelected()) {
						selejt7gomb2.setSelected();
						if (selejt7gomb2.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt7Rajt.getText()), 2);
							new DbFunctions().nextDonto(kategoria, 2, 2, Integer.parseInt(selejt7Rajt.getText()));
							negyed2Rajt.setText(selejt7Rajt.getText());
							negyed2.setText(selejt7.getText());
						} else {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt7Rajt.getText()), 1);
						}
					}
				}
			});
			selejt7gomb2.setOpaque(true);
			selejt7gomb2.setBackground(Color.LIGHT_GRAY);
			selejt7gomb2.setBorder(null);
			selejt7gomb2.setMinimumSize(new Dimension(10, 40));
			selejt7gomb2.setMaximumSize(new Dimension(40, 80));
			selejt7gomb2.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_selejt7gomb2 = new GridBagConstraints();
			gbc_selejt7gomb2.fill = GridBagConstraints.BOTH;
			gbc_selejt7gomb2.insets = new Insets(0, 5, 5, 5);
			gbc_selejt7gomb2.ipady = (int) height / 79;
			gbc_selejt7gomb2.gridx = 3;
			gbc_selejt7gomb2.gridy = 6;
			add(selejt7gomb2, gbc_selejt7gomb2);
		}
		{
			chkDonto = new JCheckBox("");
			buttonGroup.add(chkDonto);
			chkDonto.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					if (chkDonto.isSelected()) {
						int a1 = 0, a2 = 0, b1 = 0, b2 = 0;
						if (!donto1Rajt.getText().equals(""))
							a1 = Integer.parseInt(donto1Rajt.getText());
						if (!donto2Rajt.getText().equals(""))
							b1 = Integer.parseInt(donto2Rajt.getText());
						Main.mf.setDisplayNext(a1, a2, b1, b2);
						dp.setNum(a1, b1);
					}
				}
			});
			chkDonto.setSelectedIcon(new ImageIcon(FinalsPanel8man.class.getResource("/Images/p.png")));
			chkDonto.setIcon(new ImageIcon(FinalsPanel8man.class.getResource("/Images/x.png")));
			chkDonto.setSize(new Dimension(40, 40));
			chkDonto.setPreferredSize(new Dimension(40, 40));
			chkDonto.setOpaque(false);
			chkDonto.setMinimumSize(new Dimension(40, 40));
			chkDonto.setMaximumSize(new Dimension(40, 40));
			GridBagConstraints gbc_chkDonto = new GridBagConstraints();
			gbc_chkDonto.insets = new Insets(0, 0, 5, 5);
			gbc_chkDonto.gridx = 11;
			gbc_chkDonto.gridy = 7;
			add(chkDonto, gbc_chkDonto);
		}
		{
			gyoztesRajt = new JTextField();
			gyoztesRajt.setFont(new Font("Tahoma", Font.PLAIN, 36));
			gyoztesRajt.setEditable(false);
			gyoztesRajt.setColumns(3);
			gyoztesRajt.setBorder(null);
			GridBagConstraints gbc_gyoztesRajt = new GridBagConstraints();
			gbc_gyoztesRajt.insets = new Insets(0, 0, 5, 5);
			gbc_gyoztesRajt.fill = GridBagConstraints.BOTH;
			gbc_gyoztesRajt.gridx = 15;
			gbc_gyoztesRajt.gridy = 7;
			add(gyoztesRajt, gbc_gyoztesRajt);
		}
		{
			gyoztes = new JTextField();
			gyoztes.setFont(new Font("Tahoma", Font.PLAIN, 36));
			gyoztes.setEditable(false);
			gyoztes.setBorder(null);
			gyoztes.setMaximumSize(new Dimension(200, 100));
			gyoztes.setMinimumSize(new Dimension(10, 10));
			gyoztes.setPreferredSize(new Dimension(100, 60));
			gyoztes.setBackground(new Color(255, 255, 102));
			GridBagConstraints gbc_gyoztes = new GridBagConstraints();
			gbc_gyoztes.fill = GridBagConstraints.BOTH;
			gbc_gyoztes.insets = new Insets(0, 0, 5, 5);
			gbc_gyoztes.ipady = (int) height / 79;
			gbc_gyoztes.gridx = 16;
			gbc_gyoztes.gridy = 7;
			add(gyoztes, gbc_gyoztes);
			gyoztes.setColumns(10);
		}
		{
			selejt8Rajt = new JTextField();
			selejt8Rajt.setFont(new Font("Tahoma", Font.PLAIN, 36));
			selejt8Rajt.setEditable(false);
			selejt8Rajt.setColumns(3);
			selejt8Rajt.setBorder(null);
			GridBagConstraints gbc_selejt8Rajt = new GridBagConstraints();
			gbc_selejt8Rajt.insets = new Insets(0, 0, 5, 5);
			gbc_selejt8Rajt.fill = GridBagConstraints.BOTH;
			gbc_selejt8Rajt.gridx = 0;
			gbc_selejt8Rajt.gridy = 8;
			add(selejt8Rajt, gbc_selejt8Rajt);
		}
		{
			selejt8 = new JTextField();
			selejt8.setFont(new Font("Tahoma", Font.PLAIN, 36));
			selejt8.setEditable(false);
			selejt8.setBorder(null);
			selejt8.setMaximumSize(new Dimension(200, 100));
			selejt8.setMinimumSize(new Dimension(10, 10));
			selejt8.setPreferredSize(new Dimension(100, 60));
			selejt8.setText("10");
			GridBagConstraints gbc_selejt8 = new GridBagConstraints();
			gbc_selejt8.fill = GridBagConstraints.BOTH;
			gbc_selejt8.insets = new Insets(0, 0, 5, 5);
			gbc_selejt8.ipady = (int) height / 79;
			gbc_selejt8.gridx = 1;
			gbc_selejt8.gridy = 8;
			add(selejt8, gbc_selejt8);
			selejt8.setColumns(10);
		}
		{
			selejt8gomb1 = new MyLabel("");
			selejt8gomb1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (!selejt8gomb2.isSelected()) {
						selejt8gomb1.setSelected();
						dpanel.switchNumbers();
						if (selejt8gomb1.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt8Rajt.getText()), 1);
						} else {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt8Rajt.getText()), 0);
						}
					}
				}
			});
			selejt8gomb1.setOpaque(true);
			selejt8gomb1.setBackground(Color.LIGHT_GRAY);
			selejt8gomb1.setBorder(null);
			selejt8gomb1.setMinimumSize(new Dimension(10, 40));
			selejt8gomb1.setMaximumSize(new Dimension(40, 80));
			selejt8gomb1.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_selejt8gomb1 = new GridBagConstraints();
			gbc_selejt8gomb1.fill = GridBagConstraints.BOTH;
			gbc_selejt8gomb1.insets = new Insets(0, 5, 5, 5);
			gbc_selejt8gomb1.ipady = (int) height / 79;
			gbc_selejt8gomb1.gridx = 2;
			gbc_selejt8gomb1.gridy = 8;
			add(selejt8gomb1, gbc_selejt8gomb1);
		}
		{
			selejt8gomb2 = new MyLabel("");
			selejt8gomb2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (selejt8gomb1.isSelected()) {
						selejt8gomb2.setSelected();
						if (selejt8gomb2.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt8Rajt.getText()), 2);
							new DbFunctions().nextDonto(kategoria, 2, 3, Integer.parseInt(selejt8Rajt.getText()));
							negyed3Rajt.setText(selejt8Rajt.getText());
							negyed3.setText(selejt8.getText());
						} else {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt8Rajt.getText()), 1);
						}
					}
				}
			});
			selejt8gomb2.setOpaque(true);
			selejt8gomb2.setBackground(Color.LIGHT_GRAY);
			selejt8gomb2.setBorder(null);
			selejt8gomb2.setMinimumSize(new Dimension(10, 40));
			selejt8gomb2.setMaximumSize(new Dimension(40, 80));
			selejt8gomb2.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_selejt8gomb2 = new GridBagConstraints();
			gbc_selejt8gomb2.fill = GridBagConstraints.BOTH;
			gbc_selejt8gomb2.insets = new Insets(0, 5, 5, 5);
			gbc_selejt8gomb2.ipady = (int) height / 79;
			gbc_selejt8gomb2.gridx = 3;
			gbc_selejt8gomb2.gridy = 8;
			add(selejt8gomb2, gbc_selejt8gomb2);
		}
		{
			label_1 = new JLabel("");
			label_1.setAlignmentX(Component.CENTER_ALIGNMENT);
			label_1.setPreferredSize(new Dimension(60, 80));
			label_1.setMinimumSize(new Dimension(20, 40));
			label_1.setMaximumSize(new Dimension(60, 120));
			label_1.setIcon(new ImageIcon("src/Images/nyil2.png"));
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.fill = GridBagConstraints.BOTH;
			gbc_label_1.gridheight = 3;
			gbc_label_1.insets = new Insets(0, 0, 5, 5);
			gbc_label_1.gridx = 4;
			gbc_label_1.gridy = 8;
			add(label_1, gbc_label_1);
		}
		{
			chkselejt1 = new JCheckBox("");
			buttonGroup.add(chkselejt1);
			chkselejt1.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					if (chkselejt1.isSelected()) {
						int a1 = 0, a2 = 0, b1 = 0, b2 = 0;
						if (!selejt8Rajt.getText().equals(""))
							a1 = Integer.parseInt(selejt8Rajt.getText());
						if (!selejt3Rajt.getText().equals(""))
							a2 = Integer.parseInt(selejt3Rajt.getText());
						if (!selejt1Rajt.getText().equals(""))
							b1 = Integer.parseInt(selejt1Rajt.getText());
						if (!selejt6Rajt.getText().equals(""))
							b2 = Integer.parseInt(selejt6Rajt.getText());
						Main.mf.setDisplayNext(a1, a2, b1, b2);
						dp.setNum(a1, b1);
					}
				}
			});
			chkselejt1.setSelectedIcon(new ImageIcon(FinalsPanel8man.class.getResource("/Images/p.png")));
			chkselejt1.setIcon(new ImageIcon(FinalsPanel8man.class.getResource("/Images/x.png")));
			chkselejt1.setSize(new Dimension(40, 40));
			chkselejt1.setPreferredSize(new Dimension(40, 40));
			chkselejt1.setOpaque(false);
			chkselejt1.setMinimumSize(new Dimension(40, 40));
			chkselejt1.setMaximumSize(new Dimension(40, 40));
			GridBagConstraints gbc_chkselejt1 = new GridBagConstraints();
			gbc_chkselejt1.insets = new Insets(0, 0, 5, 5);
			gbc_chkselejt1.gridx = 1;
			gbc_chkselejt1.gridy = 9;
			add(chkselejt1, gbc_chkselejt1);
		}
		{
			negyed3Rajt = new JTextField();
			negyed3Rajt.setFont(new Font("Tahoma", Font.PLAIN, 36));
			negyed3Rajt.setEditable(false);
			negyed3Rajt.setColumns(3);
			negyed3Rajt.setBorder(null);
			GridBagConstraints gbc_negyed3Rajt = new GridBagConstraints();
			gbc_negyed3Rajt.insets = new Insets(0, 0, 5, 5);
			gbc_negyed3Rajt.fill = GridBagConstraints.BOTH;
			gbc_negyed3Rajt.gridx = 5;
			gbc_negyed3Rajt.gridy = 9;
			add(negyed3Rajt, gbc_negyed3Rajt);
		}
		{
			negyed3 = new JTextField();
			negyed3.setFont(new Font("Tahoma", Font.PLAIN, 36));
			negyed3.setEditable(false);
			negyed3.setBorder(null);
			negyed3.setMaximumSize(new Dimension(200, 100));
			negyed3.setMinimumSize(new Dimension(10, 10));
			negyed3.setPreferredSize(new Dimension(100, 60));
			GridBagConstraints gbc_negyed3 = new GridBagConstraints();
			gbc_negyed3.fill = GridBagConstraints.BOTH;
			gbc_negyed3.insets = new Insets(0, 0, 5, 5);
			gbc_negyed3.ipady = (int) height / 79;
			gbc_negyed3.gridx = 6;
			gbc_negyed3.gridy = 9;
			add(negyed3, gbc_negyed3);
			negyed3.setColumns(10);
		}
		{
			negyed3gomb1 = new MyLabel("");
			negyed3gomb1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (!negyed3gomb2.isSelected()) {
						negyed3gomb1.setSelected();
						dpanel.switchNumbers();
						if (negyed3gomb1.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 2, Integer.parseInt(negyed3Rajt.getText()), 1);
						} else {
							new DbFunctions().updateDonto(kategoria, 2, Integer.parseInt(negyed3Rajt.getText()), 0);
						}
					}
				}
			});
			negyed3gomb1.setOpaque(true);
			negyed3gomb1.setBackground(Color.LIGHT_GRAY);
			negyed3gomb1.setBorder(null);
			negyed3gomb1.setMinimumSize(new Dimension(10, 40));
			negyed3gomb1.setMaximumSize(new Dimension(40, 80));
			negyed3gomb1.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_negyed3gomb1 = new GridBagConstraints();
			gbc_negyed3gomb1.fill = GridBagConstraints.BOTH;
			gbc_negyed3gomb1.insets = new Insets(0, 5, 5, 5);
			gbc_negyed3gomb1.ipady = (int) height / 79;
			gbc_negyed3gomb1.gridx = 7;
			gbc_negyed3gomb1.gridy = 9;
			add(negyed3gomb1, gbc_negyed3gomb1);
		}
		{
			negyed3gomb2 = new MyLabel("");
			negyed3gomb2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (negyed3gomb1.isSelected()) {
						negyed3gomb2.setSelected();
						if (negyed3gomb2.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 2, Integer.parseInt(negyed3Rajt.getText()), 2);
							new DbFunctions().nextDonto(kategoria, 3, 2, Integer.parseInt(negyed3Rajt.getText()));
							donto2Rajt.setText(negyed3Rajt.getText());
							donto2.setText(negyed3.getText());

							new DbFunctions().nextDonto(kategoria, 3, 4, Integer.parseInt(negyed4Rajt.getText()));
							donto4Rajt.setText(negyed4Rajt.getText());
							donto4.setText(negyed4.getText());
						} else {
							new DbFunctions().updateDonto(kategoria, 2, Integer.parseInt(negyed3Rajt.getText()), 1);
						}
					}
				}
			});
			negyed3gomb2.setOpaque(true);
			negyed3gomb2.setBackground(Color.LIGHT_GRAY);
			negyed3gomb2.setBorder(null);
			negyed3gomb2.setMinimumSize(new Dimension(10, 40));
			negyed3gomb2.setMaximumSize(new Dimension(40, 80));
			negyed3gomb2.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_negyed3gomb2 = new GridBagConstraints();
			gbc_negyed3gomb2.fill = GridBagConstraints.BOTH;
			gbc_negyed3gomb2.insets = new Insets(0, 5, 5, 5);
			gbc_negyed3gomb2.ipady = (int) height / 79;
			gbc_negyed3gomb2.gridx = 8;
			gbc_negyed3gomb2.gridy = 9;
			add(negyed3gomb2, gbc_negyed3gomb2);
		}
		{
			label_4 = new JLabel("");
			label_4.setAlignmentX(Component.CENTER_ALIGNMENT);
			label_4.setPreferredSize(new Dimension(60, 80));
			label_4.setMinimumSize(new Dimension(20, 40));
			label_4.setMaximumSize(new Dimension(60, 120));
			label_4.setIcon(new ImageIcon("src/Images/nyil2.png"));
			GridBagConstraints gbc_label_4 = new GridBagConstraints();
			gbc_label_4.fill = GridBagConstraints.VERTICAL;
			gbc_label_4.gridheight = 5;
			gbc_label_4.insets = new Insets(0, 0, 5, 5);
			gbc_label_4.anchor = GridBagConstraints.EAST;
			gbc_label_4.gridx = 9;
			gbc_label_4.gridy = 9;
			add(label_4, gbc_label_4);
		}
		{
			label_6 = new JLabel("");
			label_6.setAlignmentX(Component.CENTER_ALIGNMENT);
			label_6.setPreferredSize(new Dimension(60, 80));
			label_6.setMinimumSize(new Dimension(20, 40));
			label_6.setMaximumSize(new Dimension(60, 120));
			label_6.setIcon(new ImageIcon("src/Images/nyil2.png"));
			GridBagConstraints gbc_label_6 = new GridBagConstraints();
			gbc_label_6.fill = GridBagConstraints.BOTH;
			gbc_label_6.gridheight = 3;
			gbc_label_6.insets = new Insets(0, 0, 5, 5);
			gbc_label_6.gridx = 14;
			gbc_label_6.gridy = 9;
			add(label_6, gbc_label_6);
		}
		{
			selejt1Rajt = new JTextField();
			selejt1Rajt.setFont(new Font("Tahoma", Font.PLAIN, 36));
			selejt1Rajt.setEditable(false);
			selejt1Rajt.setColumns(3);
			selejt1Rajt.setBorder(null);
			GridBagConstraints gbc_selejt1Rajt = new GridBagConstraints();
			gbc_selejt1Rajt.insets = new Insets(0, 0, 5, 5);
			gbc_selejt1Rajt.fill = GridBagConstraints.BOTH;
			gbc_selejt1Rajt.gridx = 0;
			gbc_selejt1Rajt.gridy = 10;
			add(selejt1Rajt, gbc_selejt1Rajt);
		}
		{
			selejt1 = new JTextField();
			selejt1.setFont(new Font("Tahoma", Font.PLAIN, 36));
			selejt1.setEditable(false);
			selejt1.setBorder(null);
			selejt1.setMaximumSize(new Dimension(200, 100));
			selejt1.setMinimumSize(new Dimension(10, 10));
			selejt1.setPreferredSize(new Dimension(100, 60));
			selejt1.setText("3");
			GridBagConstraints gbc_selejt1 = new GridBagConstraints();
			gbc_selejt1.fill = GridBagConstraints.BOTH;
			gbc_selejt1.insets = new Insets(0, 0, 5, 5);
			gbc_selejt1.ipady = (int) height / 79;
			gbc_selejt1.gridx = 1;
			gbc_selejt1.gridy = 10;
			add(selejt1, gbc_selejt1);
			selejt1.setColumns(10);
		}
		{
			selejt1gomb1 = new MyLabel("");
			selejt1gomb1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (!selejt1gomb2.isSelected()) {
						selejt1gomb1.setSelected();
						dpanel.switchNumbers();
						if (selejt1gomb1.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt1Rajt.getText()), 1);
						} else {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt1Rajt.getText()), 0);
						}
					}
				}
			});
			selejt1gomb1.setOpaque(true);
			selejt1gomb1.setBackground(Color.LIGHT_GRAY);
			selejt1gomb1.setBorder(null);
			selejt1gomb1.setMinimumSize(new Dimension(10, 40));
			selejt1gomb1.setMaximumSize(new Dimension(40, 80));
			selejt1gomb1.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_selejt1gomb1 = new GridBagConstraints();
			gbc_selejt1gomb1.fill = GridBagConstraints.BOTH;
			gbc_selejt1gomb1.insets = new Insets(0, 5, 5, 5);
			gbc_selejt1gomb1.ipady = (int) height / 79;
			gbc_selejt1gomb1.gridx = 2;
			gbc_selejt1gomb1.gridy = 10;
			add(selejt1gomb1, gbc_selejt1gomb1);
		}
		{
			selejt1gomb2 = new MyLabel("");
			selejt1gomb2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (selejt1gomb1.isSelected()) {
						selejt1gomb2.setSelected();
						if (selejt1gomb2.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt1Rajt.getText()), 2);
							new DbFunctions().nextDonto(kategoria, 2, 3, Integer.parseInt(selejt1Rajt.getText()));
							negyed3Rajt.setText(selejt1Rajt.getText());
							negyed3.setText(selejt1.getText());
						} else {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt1Rajt.getText()), 1);
						}
					}
				}
			});
			selejt1gomb2.setOpaque(true);
			selejt1gomb2.setBackground(Color.LIGHT_GRAY);
			selejt1gomb2.setBorder(null);
			selejt1gomb2.setMinimumSize(new Dimension(10, 40));
			selejt1gomb2.setMaximumSize(new Dimension(40, 80));
			selejt1gomb2.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_selejt1gomb2 = new GridBagConstraints();
			gbc_selejt1gomb2.fill = GridBagConstraints.BOTH;
			gbc_selejt1gomb2.insets = new Insets(0, 5, 5, 5);
			gbc_selejt1gomb2.ipady = (int) height / 79;
			gbc_selejt1gomb2.gridx = 3;
			gbc_selejt1gomb2.gridy = 10;
			add(selejt1gomb2, gbc_selejt1gomb2);
		}
		{
			chkNegyed2 = new JCheckBox("");
			buttonGroup.add(chkNegyed2);
			chkNegyed2.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					if (chkNegyed2.isSelected()) {
						int a1 = 0, a2 = 0, b1 = 0, b2 = 0;
						if (!negyed3Rajt.getText().equals(""))
							a1 = Integer.parseInt(negyed3Rajt.getText());
						if (!donto3Rajt.getText().equals(""))
							a2 = Integer.parseInt(donto3Rajt.getText());
						if (!negyed4Rajt.getText().equals(""))
							b1 = Integer.parseInt(negyed4Rajt.getText());
						if (!donto4Rajt.getText().equals(""))
							b2 = Integer.parseInt(donto4Rajt.getText());
						Main.mf.setDisplayNext(a1, a2, b1, b2);
						dp.setNum(a1, b1);
					}
				}
			});
			chkNegyed2.setSelectedIcon(new ImageIcon(FinalsPanel8man.class.getResource("/Images/p.png")));
			chkNegyed2.setIcon(new ImageIcon(FinalsPanel8man.class.getResource("/Images/x.png")));
			chkNegyed2.setSize(new Dimension(40, 40));
			chkNegyed2.setPreferredSize(new Dimension(40, 40));
			chkNegyed2.setOpaque(false);
			chkNegyed2.setMinimumSize(new Dimension(40, 40));
			chkNegyed2.setMaximumSize(new Dimension(40, 40));
			GridBagConstraints gbc_chkNegyed2 = new GridBagConstraints();
			gbc_chkNegyed2.insets = new Insets(0, 0, 5, 5);
			gbc_chkNegyed2.gridx = 6;
			gbc_chkNegyed2.gridy = 11;
			add(chkNegyed2, gbc_chkNegyed2);
		}
		{
			donto2Rajt = new JTextField();
			donto2Rajt.setFont(new Font("Tahoma", Font.PLAIN, 36));
			donto2Rajt.setEditable(false);
			donto2Rajt.setColumns(3);
			donto2Rajt.setBorder(null);
			GridBagConstraints gbc_donto2Rajt = new GridBagConstraints();
			gbc_donto2Rajt.insets = new Insets(0, 0, 5, 5);
			gbc_donto2Rajt.fill = GridBagConstraints.BOTH;
			gbc_donto2Rajt.gridx = 10;
			gbc_donto2Rajt.gridy = 10;
			add(donto2Rajt, gbc_donto2Rajt);
		}
		{
			selejt3Rajt = new JTextField();
			selejt3Rajt.setFont(new Font("Tahoma", Font.PLAIN, 36));
			selejt3Rajt.setEditable(false);
			selejt3Rajt.setColumns(3);
			selejt3Rajt.setBorder(null);
			GridBagConstraints gbc_selejt3Rajt = new GridBagConstraints();
			gbc_selejt3Rajt.insets = new Insets(0, 0, 5, 5);
			gbc_selejt3Rajt.fill = GridBagConstraints.BOTH;
			gbc_selejt3Rajt.gridx = 0;
			gbc_selejt3Rajt.gridy = 12;
			add(selejt3Rajt, gbc_selejt3Rajt);
		}
		{
			donto3Rajt = new JTextField();
			donto3Rajt.setFont(new Font("Tahoma", Font.PLAIN, 36));
			donto3Rajt.setEditable(false);
			donto3Rajt.setColumns(3);
			donto3Rajt.setBorder(null);
			GridBagConstraints gbc_donto3Rajt = new GridBagConstraints();
			gbc_donto3Rajt.insets = new Insets(0, 0, 5, 5);
			gbc_donto3Rajt.fill = GridBagConstraints.BOTH;
			gbc_donto3Rajt.gridx = 10;
			gbc_donto3Rajt.gridy = 12;
			add(donto3Rajt, gbc_donto3Rajt);
		}
		{
			label_7 = new JLabel("");
			label_7.setAlignmentX(Component.CENTER_ALIGNMENT);
			label_7.setPreferredSize(new Dimension(60, 80));
			label_7.setMinimumSize(new Dimension(20, 40));
			label_7.setMaximumSize(new Dimension(60, 120));
			label_7.setIcon(new ImageIcon("src/Images/nyil2.png"));
			GridBagConstraints gbc_label_7 = new GridBagConstraints();
			gbc_label_7.fill = GridBagConstraints.BOTH;
			gbc_label_7.gridheight = 3;
			gbc_label_7.insets = new Insets(0, 0, 0, 5);
			gbc_label_7.gridx = 19;
			gbc_label_7.gridy = 12;
			add(label_7, gbc_label_7);
		}
		{
			donto2 = new JTextField();
			donto2.setFont(new Font("Tahoma", Font.PLAIN, 36));
			donto2.setEditable(false);
			donto2.setBorder(null);
			donto2.setMaximumSize(new Dimension(200, 100));
			donto2.setMinimumSize(new Dimension(10, 10));
			donto2.setPreferredSize(new Dimension(100, 60));
			GridBagConstraints gbc_donto2 = new GridBagConstraints();
			gbc_donto2.fill = GridBagConstraints.BOTH;
			gbc_donto2.insets = new Insets(0, 0, 5, 5);
			gbc_donto2.ipady = (int) height / 79;
			gbc_donto2.gridx = 11;
			gbc_donto2.gridy = 10;
			add(donto2, gbc_donto2);
			donto2.setColumns(10);
		}
		{
			donto2gomb1 = new MyLabel("");
			donto2gomb1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (!donto2gomb2.isSelected()) {
						donto2gomb1.setSelected();
						dpanel.switchNumbers();
						if (selejt5gomb1.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 3, Integer.parseInt(donto2Rajt.getText()), 1);
						} else {
							new DbFunctions().updateDonto(kategoria, 3, Integer.parseInt(donto2Rajt.getText()), 0);
						}
					}
				}
			});
			donto2gomb1.setOpaque(true);
			donto2gomb1.setBackground(Color.LIGHT_GRAY);
			donto2gomb1.setBorder(null);
			donto2gomb1.setMinimumSize(new Dimension(10, 40));
			donto2gomb1.setMaximumSize(new Dimension(40, 80));
			donto2gomb1.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_donto2gomb1 = new GridBagConstraints();
			gbc_donto2gomb1.fill = GridBagConstraints.BOTH;
			gbc_donto2gomb1.insets = new Insets(0, 5, 5, 5);
			gbc_donto2gomb1.ipady = (int) height / 79;
			gbc_donto2gomb1.gridx = 12;
			gbc_donto2gomb1.gridy = 10;
			add(donto2gomb1, gbc_donto2gomb1);
		}
		{
			donto2gomb2 = new MyLabel("");
			donto2gomb2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (donto2gomb1.isSelected()) {
						donto2gomb2.setSelected();
						if (donto2gomb2.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 3, Integer.parseInt(donto2Rajt.getText()), 2);
							// new DbFunctions().nextDonto(kategoria, 3, 2,
							// Integer.parseInt(donto2Rajt.getText()));
							gyoztesRajt.setText(donto2Rajt.getText());
							gyoztes.setText(donto2.getText());
						} else {
							new DbFunctions().updateDonto(kategoria, 3, Integer.parseInt(donto2Rajt.getText()), 1);
						}
					}
				}
			});
			donto2gomb2.setOpaque(true);
			donto2gomb2.setBackground(Color.LIGHT_GRAY);
			donto2gomb2.setBorder(null);
			donto2gomb2.setMinimumSize(new Dimension(10, 40));
			donto2gomb2.setMaximumSize(new Dimension(40, 80));
			donto2gomb2.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_donto2gomb2 = new GridBagConstraints();
			gbc_donto2gomb2.fill = GridBagConstraints.BOTH;
			gbc_donto2gomb2.insets = new Insets(0, 5, 5, 5);
			gbc_donto2gomb2.ipady = (int) height / 79;
			gbc_donto2gomb2.gridx = 13;
			gbc_donto2gomb2.gridy = 10;
			add(donto2gomb2, gbc_donto2gomb2);
		}
		{
			selejt3 = new JTextField();
			selejt3.setFont(new Font("Tahoma", Font.PLAIN, 36));
			selejt3.setEditable(false);
			selejt3.setBorder(null);
			selejt3.setMaximumSize(new Dimension(200, 100));
			selejt3.setMinimumSize(new Dimension(10, 10));
			selejt3.setPreferredSize(new Dimension(100, 60));
			selejt3.setText("5");
			GridBagConstraints gbc_selejt3 = new GridBagConstraints();
			gbc_selejt3.fill = GridBagConstraints.BOTH;
			gbc_selejt3.anchor = GridBagConstraints.NORTH;
			gbc_selejt3.insets = new Insets(0, 0, 5, 5);
			gbc_selejt3.ipady = (int) height / 79;
			gbc_selejt3.gridx = 1;
			gbc_selejt3.gridy = 12;
			add(selejt3, gbc_selejt3);
			selejt3.setColumns(10);
		}
		{
			selejt3gomb1 = new MyLabel("");
			selejt3gomb1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (!selejt3gomb2.isSelected()) {
						selejt3gomb1.setSelected();
						dpanel.switchNumbers();
						if (selejt3gomb1.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt3Rajt.getText()), 1);
						} else {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt3Rajt.getText()), 0);
						}
					}
				}
			});
			selejt3gomb1.setOpaque(true);
			selejt3gomb1.setBackground(Color.LIGHT_GRAY);
			selejt3gomb1.setBorder(null);
			selejt3gomb1.setMinimumSize(new Dimension(10, 40));
			selejt3gomb1.setMaximumSize(new Dimension(40, 80));
			selejt3gomb1.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_selejt3gomb1 = new GridBagConstraints();
			gbc_selejt3gomb1.fill = GridBagConstraints.BOTH;
			gbc_selejt3gomb1.insets = new Insets(0, 5, 5, 5);
			gbc_selejt3gomb1.ipady = (int) height / 79;
			gbc_selejt3gomb1.gridx = 2;
			gbc_selejt3gomb1.gridy = 12;
			add(selejt3gomb1, gbc_selejt3gomb1);
		}
		{
			selejt3gomb2 = new MyLabel("");
			selejt3gomb2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (selejt3gomb1.isSelected()) {
						selejt3gomb2.setSelected();
						if (selejt3gomb2.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt3Rajt.getText()), 2);
							new DbFunctions().nextDonto(kategoria, 2, 4, Integer.parseInt(selejt3Rajt.getText()));
							negyed4Rajt.setText(selejt3Rajt.getText());
							negyed4.setText(selejt3.getText());
						} else {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt3Rajt.getText()), 1);
						}
					}
				}
			});
			selejt3gomb2.setOpaque(true);
			selejt3gomb2.setBackground(Color.LIGHT_GRAY);
			selejt3gomb2.setBorder(null);
			selejt3gomb2.setMinimumSize(new Dimension(10, 40));
			selejt3gomb2.setMaximumSize(new Dimension(40, 80));
			selejt3gomb2.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_selejt3gomb2 = new GridBagConstraints();
			gbc_selejt3gomb2.fill = GridBagConstraints.BOTH;
			gbc_selejt3gomb2.insets = new Insets(0, 5, 5, 5);
			gbc_selejt3gomb2.ipady = (int) height / 79;
			gbc_selejt3gomb2.gridx = 3;
			gbc_selejt3gomb2.gridy = 12;
			add(selejt3gomb2, gbc_selejt3gomb2);
		}
		{
			label_2 = new JLabel("");
			label_2.setAlignmentX(Component.CENTER_ALIGNMENT);
			label_2.setPreferredSize(new Dimension(60, 80));
			label_2.setMinimumSize(new Dimension(20, 40));
			label_2.setMaximumSize(new Dimension(60, 120));
			label_2.setIcon(new ImageIcon("src/Images/nyil2.png"));
			GridBagConstraints gbc_label_2 = new GridBagConstraints();
			gbc_label_2.fill = GridBagConstraints.BOTH;
			gbc_label_2.gridheight = 3;
			gbc_label_2.insets = new Insets(0, 0, 0, 5);
			gbc_label_2.gridx = 4;
			gbc_label_2.gridy = 12;
			add(label_2, gbc_label_2);
		}
		{
			donto3 = new JTextField();
			donto3.setFont(new Font("Tahoma", Font.PLAIN, 36));
			donto3.setEditable(false);
			donto3.setBorder(null);
			donto3.setMaximumSize(new Dimension(200, 100));
			donto3.setMinimumSize(new Dimension(10, 10));
			donto3.setPreferredSize(new Dimension(100, 60));
			GridBagConstraints gbc_donto3 = new GridBagConstraints();
			gbc_donto3.fill = GridBagConstraints.BOTH;
			gbc_donto3.insets = new Insets(0, 0, 5, 5);
			gbc_donto3.ipady = (int) height / 79;
			gbc_donto3.gridx = 11;
			gbc_donto3.gridy = 12;
			add(donto3, gbc_donto3);
			donto3.setColumns(10);
		}
		{
			donto3gomb1 = new MyLabel("");
			donto3gomb1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (!donto3gomb2.isSelected()) {
						donto3gomb1.setSelected();
						dpanel.switchNumbers();
						if (donto3gomb1.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 3, Integer.parseInt(donto3Rajt.getText()), 1);
						} else {
							new DbFunctions().updateDonto(kategoria, 3, Integer.parseInt(donto3Rajt.getText()), 0);
						}
					}
				}
			});
			donto3gomb1.setOpaque(true);
			donto3gomb1.setBackground(Color.LIGHT_GRAY);
			donto3gomb1.setBorder(null);
			donto3gomb1.setMinimumSize(new Dimension(10, 40));
			donto3gomb1.setMaximumSize(new Dimension(40, 80));
			donto3gomb1.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_donto3gomb1 = new GridBagConstraints();
			gbc_donto3gomb1.fill = GridBagConstraints.BOTH;
			gbc_donto3gomb1.insets = new Insets(0, 5, 5, 5);
			gbc_donto3gomb1.ipady = (int) height / 79;
			gbc_donto3gomb1.gridx = 12;
			gbc_donto3gomb1.gridy = 12;
			add(donto3gomb1, gbc_donto3gomb1);
		}
		{
			donto3gomb2 = new MyLabel("");
			donto3gomb2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (donto3gomb1.isSelected()) {
						donto3gomb2.setSelected();
						if (donto3gomb2.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 3, Integer.parseInt(donto3Rajt.getText()), 2);
							harmadikRajt.setText(donto3Rajt.getText());
							harmadik.setText(donto3.getText());
						} else {
							new DbFunctions().updateDonto(kategoria, 3, Integer.parseInt(donto3Rajt.getText()), 1);
						}
					}
				}
			});
			donto3gomb2.setOpaque(true);
			donto3gomb2.setBackground(Color.LIGHT_GRAY);
			donto3gomb2.setBorder(null);
			donto3gomb2.setMinimumSize(new Dimension(10, 40));
			donto3gomb2.setMaximumSize(new Dimension(40, 80));
			donto3gomb2.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_donto3gomb2 = new GridBagConstraints();
			gbc_donto3gomb2.fill = GridBagConstraints.BOTH;
			gbc_donto3gomb2.insets = new Insets(0, 5, 5, 5);
			gbc_donto3gomb2.ipady = (int) height / 79;
			gbc_donto3gomb2.gridx = 13;
			gbc_donto3gomb2.gridy = 12;
			add(donto3gomb2, gbc_donto3gomb2);
		}
		{
			chkselejt2 = new JCheckBox("");
			buttonGroup.add(chkselejt2);
			chkselejt2.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					if (chkselejt2.isSelected()) {
						int a1 = 0, a2 = 0, b1 = 0, b2 = 0;
						if (!selejt3Rajt.getText().equals(""))
							a1 = Integer.parseInt(selejt3Rajt.getText());
						if (!negyed1Rajt.getText().equals(""))
							a2 = Integer.parseInt(negyed1Rajt.getText());
						if (!selejt6Rajt.getText().equals(""))
							b1 = Integer.parseInt(selejt6Rajt.getText());
						if (!negyed2Rajt.getText().equals(""))
							b2 = Integer.parseInt(negyed2Rajt.getText());
						Main.mf.setDisplayNext(a1, a2, b1, b2);
						dp.setNum(a1, b1);
					}
				}
			});
			chkselejt2.setSelectedIcon(new ImageIcon(FinalsPanel8man.class.getResource("/Images/p.png")));
			chkselejt2.setIcon(new ImageIcon(FinalsPanel8man.class.getResource("/Images/x.png")));
			chkselejt2.setSize(new Dimension(40, 40));
			chkselejt2.setPreferredSize(new Dimension(40, 40));
			chkselejt2.setOpaque(false);
			chkselejt2.setMinimumSize(new Dimension(40, 40));
			chkselejt2.setMaximumSize(new Dimension(40, 40));
			GridBagConstraints gbc_chkselejt2 = new GridBagConstraints();
			gbc_chkselejt2.insets = new Insets(0, 0, 5, 5);
			gbc_chkselejt2.gridx = 1;
			gbc_chkselejt2.gridy = 13;
			add(chkselejt2, gbc_chkselejt2);
		}
		{
			negyed4Rajt = new JTextField();
			negyed4Rajt.setFont(new Font("Tahoma", Font.PLAIN, 36));
			negyed4Rajt.setEditable(false);
			negyed4Rajt.setColumns(3);
			negyed4Rajt.setBorder(null);
			GridBagConstraints gbc_negyed4Rajt = new GridBagConstraints();
			gbc_negyed4Rajt.insets = new Insets(0, 0, 5, 5);
			gbc_negyed4Rajt.fill = GridBagConstraints.BOTH;
			gbc_negyed4Rajt.gridx = 5;
			gbc_negyed4Rajt.gridy = 13;
			add(negyed4Rajt, gbc_negyed4Rajt);
		}
		{
			negyed4 = new JTextField();
			negyed4.setFont(new Font("Tahoma", Font.PLAIN, 36));
			negyed4.setEditable(false);
			negyed4.setBorder(null);
			negyed4.setMaximumSize(new Dimension(200, 100));
			negyed4.setMinimumSize(new Dimension(10, 10));
			negyed4.setPreferredSize(new Dimension(100, 60));
			GridBagConstraints gbc_negyed4 = new GridBagConstraints();
			gbc_negyed4.fill = GridBagConstraints.BOTH;
			gbc_negyed4.insets = new Insets(0, 0, 5, 5);
			gbc_negyed4.ipady = (int) height / 79;
			gbc_negyed4.gridx = 6;
			gbc_negyed4.gridy = 13;
			add(negyed4, gbc_negyed4);
			negyed4.setColumns(10);
		}
		{
			negyed4gomb1 = new MyLabel("");
			negyed4gomb1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (!negyed4gomb2.isSelected()) {
						negyed4gomb1.setSelected();
						dpanel.switchNumbers();
						if (negyed4gomb1.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 2, Integer.parseInt(negyed4Rajt.getText()), 1);
						} else {
							new DbFunctions().updateDonto(kategoria, 2, Integer.parseInt(negyed4Rajt.getText()), 0);
						}
					}
				}
			});
			negyed4gomb1.setOpaque(true);
			negyed4gomb1.setBackground(Color.LIGHT_GRAY);
			negyed4gomb1.setBorder(null);
			negyed4gomb1.setMinimumSize(new Dimension(10, 40));
			negyed4gomb1.setMaximumSize(new Dimension(40, 80));
			negyed4gomb1.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_negyed4gomb1 = new GridBagConstraints();
			gbc_negyed4gomb1.fill = GridBagConstraints.BOTH;
			gbc_negyed4gomb1.insets = new Insets(0, 5, 5, 5);
			gbc_negyed4gomb1.ipady = (int) height / 79;
			gbc_negyed4gomb1.gridx = 7;
			gbc_negyed4gomb1.gridy = 13;
			add(negyed4gomb1, gbc_negyed4gomb1);
		}
		{
			negyed4gomb2 = new MyLabel("");
			negyed4gomb2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (negyed4gomb1.isSelected()) {
						negyed4gomb2.setSelected();
						if (negyed4gomb2.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 2, Integer.parseInt(negyed4Rajt.getText()), 2);
							new DbFunctions().nextDonto(kategoria, 3, 2, Integer.parseInt(negyed4Rajt.getText()));
							donto2Rajt.setText(negyed4Rajt.getText());
							donto2.setText(negyed4.getText());

							new DbFunctions().nextDonto(kategoria, 3, 4, Integer.parseInt(negyed3Rajt.getText()));
							donto4Rajt.setText(negyed3Rajt.getText());
							donto4.setText(negyed3.getText());
						} else {
							new DbFunctions().updateDonto(kategoria, 2, Integer.parseInt(negyed4Rajt.getText()), 1);
						}
					}
				}
			});
			negyed4gomb2.setOpaque(true);
			negyed4gomb2.setBackground(Color.LIGHT_GRAY);
			negyed4gomb2.setBorder(null);
			negyed4gomb2.setMinimumSize(new Dimension(10, 40));
			negyed4gomb2.setMaximumSize(new Dimension(40, 80));
			negyed4gomb2.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_negyed4gomb2 = new GridBagConstraints();
			gbc_negyed4gomb2.fill = GridBagConstraints.BOTH;
			gbc_negyed4gomb2.insets = new Insets(0, 5, 5, 5);
			gbc_negyed4gomb2.ipady = (int) height / 79;
			gbc_negyed4gomb2.gridx = 8;
			gbc_negyed4gomb2.gridy = 13;
			add(negyed4gomb2, gbc_negyed4gomb2);
		}
		{
			chkHarmadik = new JCheckBox("");
			buttonGroup.add(chkHarmadik);
			chkHarmadik.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					if (chkHarmadik.isSelected()) {
						int a1 = 0, a2 = 0, b1 = 0, b2 = 0;
						if (!donto3Rajt.getText().equals(""))
							a1 = Integer.parseInt(donto3Rajt.getText());
						if (!donto1Rajt.getText().equals(""))
							a2 = Integer.parseInt(donto1Rajt.getText());
						if (!donto4Rajt.getText().equals(""))
							b1 = Integer.parseInt(donto4Rajt.getText());
						if (!donto2Rajt.getText().equals(""))
							b2 = Integer.parseInt(donto2Rajt.getText());
						Main.mf.setDisplayNext(a1, a2, b1, b2);
						dp.setNum(a1, b1);
					}
				}
			});
			chkHarmadik.setSelectedIcon(new ImageIcon(FinalsPanel8man.class.getResource("/Images/p.png")));
			chkHarmadik.setIcon(new ImageIcon(FinalsPanel8man.class.getResource("/Images/x.png")));
			chkHarmadik.setSize(new Dimension(40, 40));
			chkHarmadik.setPreferredSize(new Dimension(40, 40));
			chkHarmadik.setOpaque(false);
			chkHarmadik.setMinimumSize(new Dimension(40, 40));
			chkHarmadik.setMaximumSize(new Dimension(40, 40));
			GridBagConstraints gbc_chkHarmadik = new GridBagConstraints();
			gbc_chkHarmadik.insets = new Insets(0, 0, 5, 5);
			gbc_chkHarmadik.gridx = 11;
			gbc_chkHarmadik.gridy = 13;
			add(chkHarmadik, gbc_chkHarmadik);
		}
		{
			harmadikRajt = new JTextField();
			harmadikRajt.setFont(new Font("Tahoma", Font.PLAIN, 36));
			harmadikRajt.setEditable(false);
			harmadikRajt.setColumns(3);
			harmadikRajt.setBorder(null);
			GridBagConstraints gbc_harmadikRajt = new GridBagConstraints();
			gbc_harmadikRajt.insets = new Insets(0, 0, 5, 5);
			gbc_harmadikRajt.fill = GridBagConstraints.BOTH;
			gbc_harmadikRajt.gridx = 15;
			gbc_harmadikRajt.gridy = 13;
			add(harmadikRajt, gbc_harmadikRajt);
		}
		{
			harmadik = new JTextField();
			harmadik.setFont(new Font("Tahoma", Font.PLAIN, 36));
			harmadik.setEditable(false);
			harmadik.setBorder(null);
			harmadik.setMaximumSize(new Dimension(200, 100));
			harmadik.setMinimumSize(new Dimension(10, 10));
			harmadik.setPreferredSize(new Dimension(100, 60));
			GridBagConstraints gbc_harmadik = new GridBagConstraints();
			gbc_harmadik.fill = GridBagConstraints.BOTH;
			gbc_harmadik.insets = new Insets(0, 0, 5, 0);
			gbc_harmadik.ipady = (int) height / 79;
			gbc_harmadik.gridx = 16;
			gbc_harmadik.gridy = 13;
			add(harmadik, gbc_harmadik);
			harmadik.setColumns(10);
		}
		{
			selejt6Rajt = new JTextField();
			selejt6Rajt.setFont(new Font("Tahoma", Font.PLAIN, 36));
			selejt6Rajt.setEditable(false);
			selejt6Rajt.setColumns(3);
			selejt6Rajt.setBorder(null);
			GridBagConstraints gbc_selejt6Rajt = new GridBagConstraints();
			gbc_selejt6Rajt.insets = new Insets(0, 0, 0, 5);
			gbc_selejt6Rajt.fill = GridBagConstraints.BOTH;
			gbc_selejt6Rajt.gridx = 0;
			gbc_selejt6Rajt.gridy = 14;
			add(selejt6Rajt, gbc_selejt6Rajt);
		}
		{
			selejt6 = new JTextField();
			selejt6.setFont(new Font("Tahoma", Font.PLAIN, 36));
			selejt6.setEditable(false);
			selejt6.setBorder(null);
			selejt6.setMaximumSize(new Dimension(200, 100));
			selejt6.setMinimumSize(new Dimension(10, 10));
			selejt6.setPreferredSize(new Dimension(100, 60));
			selejt6.setText("8");
			GridBagConstraints gbc_selejt6 = new GridBagConstraints();
			gbc_selejt6.insets = new Insets(0, 0, 0, 5);
			gbc_selejt6.fill = GridBagConstraints.BOTH;
			gbc_selejt6.ipady = (int) height / 79;
			gbc_selejt6.gridx = 1;
			gbc_selejt6.gridy = 14;
			add(selejt6, gbc_selejt6);
			selejt6.setColumns(10);
		}
		{
			selejt6gomb1 = new MyLabel("");
			selejt6gomb1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (!selejt6gomb2.isSelected()) {
						selejt6gomb1.setSelected();
						dpanel.switchNumbers();
						if (selejt6gomb1.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt6Rajt.getText()), 1);
						} else {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt6Rajt.getText()), 0);
						}
					}
				}
			});
			selejt6gomb1.setOpaque(true);
			selejt6gomb1.setBackground(Color.LIGHT_GRAY);
			selejt6gomb1.setBorder(null);
			selejt6gomb1.setMinimumSize(new Dimension(10, 40));
			selejt6gomb1.setMaximumSize(new Dimension(40, 80));
			selejt6gomb1.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_selejt6gomb1 = new GridBagConstraints();
			gbc_selejt6gomb1.insets = new Insets(0, 5, 0, 5);
			gbc_selejt6gomb1.fill = GridBagConstraints.BOTH;
			gbc_selejt6gomb1.ipady = (int) height / 79;
			gbc_selejt6gomb1.gridx = 2;
			gbc_selejt6gomb1.gridy = 14;
			add(selejt6gomb1, gbc_selejt6gomb1);
		}
		{
			selejt6gomb2 = new MyLabel("");
			selejt6gomb2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (selejt6gomb1.isSelected()) {
						selejt6gomb2.setSelected();
						if (selejt6gomb2.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt6Rajt.getText()), 2);
							new DbFunctions().nextDonto(kategoria, 2, 4, Integer.parseInt(selejt6Rajt.getText()));
							negyed4Rajt.setText(selejt6Rajt.getText());
							negyed4.setText(selejt6.getText());
						} else {
							new DbFunctions().updateDonto(kategoria, 0, Integer.parseInt(selejt6Rajt.getText()), 1);
						}
					}
				}
			});
			selejt6gomb2.setOpaque(true);
			selejt6gomb2.setBackground(Color.LIGHT_GRAY);
			selejt6gomb2.setBorder(null);
			selejt6gomb2.setMinimumSize(new Dimension(10, 40));
			selejt6gomb2.setMaximumSize(new Dimension(40, 80));
			selejt6gomb2.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_selejt6gomb2 = new GridBagConstraints();
			gbc_selejt6gomb2.insets = new Insets(0, 5, 0, 5);
			gbc_selejt6gomb2.fill = GridBagConstraints.BOTH;
			gbc_selejt6gomb2.ipady = (int) height / 79;
			gbc_selejt6gomb2.gridx = 3;
			gbc_selejt6gomb2.gridy = 14;
			add(selejt6gomb2, gbc_selejt6gomb2);
		}
		{
			donto4Rajt = new JTextField();
			donto4Rajt.setFont(new Font("Tahoma", Font.PLAIN, 36));
			donto4Rajt.setEditable(false);
			donto4Rajt.setColumns(3);
			donto4Rajt.setBorder(null);
			GridBagConstraints gbc_donto4Rajt = new GridBagConstraints();
			gbc_donto4Rajt.insets = new Insets(0, 0, 0, 5);
			gbc_donto4Rajt.fill = GridBagConstraints.BOTH;
			gbc_donto4Rajt.gridx = 10;
			gbc_donto4Rajt.gridy = 14;
			add(donto4Rajt, gbc_donto4Rajt);
		}
		{
			donto4 = new JTextField();
			donto4.setFont(new Font("Tahoma", Font.PLAIN, 36));
			donto4.setEditable(false);
			donto4.setBorder(null);
			donto4.setMaximumSize(new Dimension(200, 100));
			donto4.setMinimumSize(new Dimension(10, 10));
			donto4.setPreferredSize(new Dimension(100, 60));
			GridBagConstraints gbc_donto4 = new GridBagConstraints();
			gbc_donto4.fill = GridBagConstraints.BOTH;
			gbc_donto4.insets = new Insets(0, 0, 0, 5);
			gbc_donto4.ipady = (int) height / 79;
			gbc_donto4.gridx = 11;
			gbc_donto4.gridy = 14;
			add(donto4, gbc_donto4);
			donto4.setColumns(10);
		}
		{
			donto4gomb1 = new MyLabel("");
			donto4gomb1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (!donto4gomb2.isSelected()) {
						donto4gomb1.setSelected();
						dpanel.switchNumbers();
						if (donto4gomb1.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 3, Integer.parseInt(donto4Rajt.getText()), 1);
						} else {
							new DbFunctions().updateDonto(kategoria, 3, Integer.parseInt(donto4Rajt.getText()), 0);
						}
					}
				}
			});
			donto4gomb1.setOpaque(true);
			donto4gomb1.setBackground(Color.LIGHT_GRAY);
			donto4gomb1.setBorder(null);
			donto4gomb1.setMinimumSize(new Dimension(10, 40));
			donto4gomb1.setMaximumSize(new Dimension(40, 80));
			donto4gomb1.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_donto4gomb1 = new GridBagConstraints();
			gbc_donto4gomb1.fill = GridBagConstraints.BOTH;
			gbc_donto4gomb1.insets = new Insets(0, 5, 0, 5);
			gbc_donto4gomb1.ipady = (int) height / 79;
			gbc_donto4gomb1.gridx = 12;
			gbc_donto4gomb1.gridy = 14;
			add(donto4gomb1, gbc_donto4gomb1);
		}
		{
			donto4gomb2 = new MyLabel("");
			donto4gomb2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (donto4gomb1.isSelected()) {
						donto4gomb2.setSelected();
						if (donto4gomb2.isSelected()) {
							new DbFunctions().updateDonto(kategoria, 3, Integer.parseInt(donto4Rajt.getText()), 2);
							harmadikRajt.setText(donto4Rajt.getText());
							harmadik.setText(donto4.getText());
						} else {
							new DbFunctions().updateDonto(kategoria, 3, Integer.parseInt(donto4Rajt.getText()), 1);
						}
					}
				}
			});
			donto4gomb2.setOpaque(true);
			donto4gomb2.setBackground(Color.LIGHT_GRAY);
			donto4gomb2.setBorder(null);
			donto4gomb2.setMinimumSize(new Dimension(10, 40));
			donto4gomb2.setMaximumSize(new Dimension(40, 80));
			donto4gomb2.setPreferredSize(new Dimension(20, 60));
			GridBagConstraints gbc_donto4gomb2 = new GridBagConstraints();
			gbc_donto4gomb2.fill = GridBagConstraints.BOTH;
			gbc_donto4gomb2.insets = new Insets(0, 5, 0, 5);
			gbc_donto4gomb2.ipady = (int) height / 79;
			gbc_donto4gomb2.gridx = 13;
			gbc_donto4gomb2.gridy = 14;
			add(donto4gomb2, gbc_donto4gomb2);
		}

		loaddata(0);
	}

	public void loaddata() {
		loaddata(kategoria);
	}

	public void loaddata(int category) {
		kategoria = category;
		Dontos d;
		selejt1.setText("");
		selejt2.setText("");
		selejt3.setText("");
		selejt4.setText("");
		selejt5.setText("");
		selejt6.setText("");
		selejt7.setText("");
		selejt8.setText("");
		negyed1.setText("");
		negyed2.setText("");
		negyed3.setText("");
		negyed4.setText("");
		donto1.setText("");
		donto2.setText("");
		donto3.setText("");
		donto4.setText("");
		gyoztes.setText("");
		harmadik.setText("");
		selejt1Rajt.setText("");
		selejt2Rajt.setText("");
		selejt3Rajt.setText("");
		selejt4Rajt.setText("");
		selejt5Rajt.setText("");
		selejt6Rajt.setText("");
		selejt7Rajt.setText("");
		selejt8Rajt.setText("");
		negyed1Rajt.setText("");
		negyed2Rajt.setText("");
		negyed3Rajt.setText("");
		negyed4Rajt.setText("");
		donto1Rajt.setText("");
		donto2Rajt.setText("");
		donto3Rajt.setText("");
		donto4Rajt.setText("");
		gyoztesRajt.setText("");
		harmadikRajt.setText("");
		selejt1gomb1.setSelected(false);
		selejt1gomb2.setSelected(false);
		selejt2gomb1.setSelected(false);
		selejt2gomb2.setSelected(false);
		selejt3gomb1.setSelected(false);
		selejt3gomb2.setSelected(false);
		selejt4gomb1.setSelected(false);
		selejt4gomb2.setSelected(false);
		selejt5gomb1.setSelected(false);
		selejt5gomb2.setSelected(false);
		selejt6gomb1.setSelected(false);
		selejt6gomb2.setSelected(false);
		selejt7gomb1.setSelected(false);
		selejt7gomb2.setSelected(false);
		selejt8gomb1.setSelected(false);
		selejt8gomb2.setSelected(false);

		negyed1gomb1.setSelected(false);
		negyed1gomb2.setSelected(false);
		negyed2gomb1.setSelected(false);
		negyed2gomb2.setSelected(false);
		negyed3gomb1.setSelected(false);
		negyed3gomb2.setSelected(false);
		negyed4gomb1.setSelected(false);
		negyed4gomb2.setSelected(false);

		donto1gomb1.setSelected(false);
		donto1gomb2.setSelected(false);
		donto2gomb1.setSelected(false);
		donto2gomb2.setSelected(false);
		donto3gomb1.setSelected(false);
		donto3gomb2.setSelected(false);
		donto4gomb1.setSelected(false);
		donto4gomb2.setSelected(false);

		ArrayList<Dontos> lista = new DbFunctions().selectDonto(kategoria, 0);
		for (int i = 0; i < lista.size(); i++) {
			d = lista.get(i);
			switch (i) {
			case 0: {
				selejt5Rajt.setText(Integer.toString(d.getRajt()));
				selejt5.setText(d.getNev());
				if (d.getNyert() > 1) {
					selejt5gomb2.setSelected(true);
					selejt5gomb1.setSelected(true);
				} else if (d.getNyert() > 0) {
					selejt5gomb2.setSelected(false);
					selejt5gomb1.setSelected(true);
				} else {
					selejt5gomb2.setSelected(false);
					selejt5gomb1.setSelected(false);
				}
				break;
			}
			case 1: {
				selejt4Rajt.setText(Integer.toString(d.getRajt()));
				selejt4.setText(d.getNev());
				if (d.getNyert() > 1) {
					selejt4gomb2.setSelected(true);
					selejt4gomb1.setSelected(true);
				} else if (d.getNyert() > 0) {
					selejt4gomb2.setSelected(false);
					selejt4gomb1.setSelected(true);
				} else {
					selejt4gomb2.setSelected(false);
					selejt4gomb1.setSelected(false);
				}
				break;
			}
			case 2: {
				selejt2Rajt.setText(Integer.toString(d.getRajt()));
				selejt2.setText(d.getNev());
				if (d.getNyert() > 1) {
					selejt2gomb2.setSelected(true);
					selejt2gomb1.setSelected(true);
				} else if (d.getNyert() > 0) {
					selejt2gomb2.setSelected(false);
					selejt2gomb1.setSelected(true);
				} else {
					selejt2gomb2.setSelected(false);
					selejt2gomb1.setSelected(false);
				}
				break;
			}
			case 3: {
				selejt7Rajt.setText(Integer.toString(d.getRajt()));
				selejt7.setText(d.getNev());
				if (d.getNyert() > 1) {
					selejt7gomb2.setSelected(true);
					selejt7gomb1.setSelected(true);
				} else if (d.getNyert() > 0) {
					selejt7gomb2.setSelected(false);
					selejt7gomb1.setSelected(true);
				} else {
					selejt7gomb2.setSelected(false);
					selejt7gomb1.setSelected(false);
				}
				break;
			}
			case 4: {
				selejt8Rajt.setText(Integer.toString(d.getRajt()));
				selejt8.setText(d.getNev());
				if (d.getNyert() > 1) {
					selejt8gomb2.setSelected(true);
					selejt8gomb1.setSelected(true);
				} else if (d.getNyert() > 0) {
					selejt8gomb2.setSelected(false);
					selejt8gomb1.setSelected(true);
				} else {
					selejt8gomb2.setSelected(false);
					selejt8gomb1.setSelected(false);
				}
				break;
			}
			case 5: {
				selejt1Rajt.setText(Integer.toString(d.getRajt()));
				selejt1.setText(d.getNev());
				if (d.getNyert() > 1) {
					selejt1gomb2.setSelected(true);
					selejt1gomb1.setSelected(true);
				} else if (d.getNyert() > 0) {
					selejt1gomb2.setSelected(false);
					selejt1gomb1.setSelected(true);
				} else {
					selejt1gomb2.setSelected(false);
					selejt1gomb1.setSelected(false);
				}
				break;
			}
			case 6: {
				selejt3Rajt.setText(Integer.toString(d.getRajt()));
				selejt3.setText(d.getNev());
				if (d.getNyert() > 1) {
					selejt3gomb2.setSelected(true);
					selejt3gomb1.setSelected(true);
				} else if (d.getNyert() > 0) {
					selejt3gomb2.setSelected(false);
					selejt3gomb1.setSelected(true);
				} else {
					selejt3gomb2.setSelected(false);
					selejt3gomb1.setSelected(false);
				}
				break;
			}
			case 7: {
				selejt6Rajt.setText(Integer.toString(d.getRajt()));
				selejt6.setText(d.getNev());
				if (d.getNyert() > 1) {
					selejt6gomb2.setSelected(true);
					selejt6gomb1.setSelected(true);
				} else if (d.getNyert() > 0) {
					selejt6gomb2.setSelected(false);
					selejt6gomb1.setSelected(true);
				} else {
					selejt6gomb2.setSelected(false);
					selejt6gomb1.setSelected(false);
				}
				break;
			}
			}
		}

		lista = new DbFunctions().selectDonto(kategoria, 2);

		for (int i = 0; i < lista.size(); i++) {
			d = lista.get(i);
			switch (i) {
			case 0: {
				negyed1Rajt.setText(Integer.toString(d.getRajt()));
				negyed1.setText(d.getNev());
				if (d.getNyert() > 1) {
					negyed1gomb2.setSelected(true);
					negyed1gomb1.setSelected(true);
				} else if (d.getNyert() > 0) {
					negyed1gomb2.setSelected(false);
					negyed1gomb1.setSelected(true);
				} else {
					negyed1gomb2.setSelected(false);
					negyed1gomb1.setSelected(false);
				}
				break;
			}
			case 1: {
				negyed2Rajt.setText(Integer.toString(d.getRajt()));
				negyed2.setText(d.getNev());
				if (d.getNyert() > 1) {
					negyed2gomb2.setSelected(true);
					negyed2gomb1.setSelected(true);
				} else if (d.getNyert() > 0) {
					negyed2gomb2.setSelected(false);
					negyed2gomb1.setSelected(true);
				} else {
					negyed2gomb2.setSelected(false);
					negyed2gomb1.setSelected(false);
				}
				break;
			}
			case 2: {
				negyed3Rajt.setText(Integer.toString(d.getRajt()));
				negyed3.setText(d.getNev());
				if (d.getNyert() > 1) {
					negyed3gomb2.setSelected(true);
					negyed3gomb1.setSelected(true);
				} else if (d.getNyert() > 0) {
					negyed3gomb2.setSelected(false);
					negyed3gomb1.setSelected(true);
				} else {
					negyed3gomb2.setSelected(false);
					negyed3gomb1.setSelected(false);
				}
				break;
			}
			case 3: {
				negyed4Rajt.setText(Integer.toString(d.getRajt()));
				negyed4.setText(d.getNev());
				if (d.getNyert() > 1) {
					negyed4gomb2.setSelected(true);
					negyed4gomb1.setSelected(true);
				} else if (d.getNyert() > 0) {
					negyed4gomb2.setSelected(false);
					negyed4gomb1.setSelected(true);
				} else {
					negyed4gomb2.setSelected(false);
					negyed4gomb1.setSelected(false);
				}
				break;
			}
			}
		}

		lista = new DbFunctions().selectDonto(kategoria, 3);

		for (int i = 0; i < lista.size(); i++) {
			d = lista.get(i);
			switch (i) {
			case 0: {
				donto1Rajt.setText(Integer.toString(d.getRajt()));
				donto1.setText(d.getNev());
				if (d.getNyert() == 2) {
					gyoztesRajt.setText(Integer.toString(d.getRajt()));
					gyoztes.setText(d.getNev());
				}
				if (d.getNyert() > 1) {
					donto1gomb2.setSelected(true);
					donto1gomb1.setSelected(true);
				} else if (d.getNyert() > 0) {
					donto1gomb2.setSelected(false);
					donto1gomb1.setSelected(true);
				} else {
					donto1gomb2.setSelected(false);
					donto1gomb1.setSelected(false);
				}
				break;
			}
			case 1: {
				donto2Rajt.setText(Integer.toString(d.getRajt()));
				donto2.setText(d.getNev());
				if (d.getNyert() == 2) {
					gyoztesRajt.setText(Integer.toString(d.getRajt()));
					gyoztes.setText(d.getNev());
				}
				if (d.getNyert() > 1) {
					donto2gomb2.setSelected(true);
					donto2gomb1.setSelected(true);
				} else if (d.getNyert() > 0) {
					donto2gomb2.setSelected(false);
					donto2gomb1.setSelected(true);
				} else {
					donto2gomb2.setSelected(false);
					donto2gomb1.setSelected(false);
				}
				break;
			}
			case 2: {
				donto3Rajt.setText(Integer.toString(d.getRajt()));
				donto3.setText(d.getNev());
				if (d.getNyert() == 2) {
					harmadikRajt.setText(Integer.toString(d.getRajt()));
					harmadik.setText(d.getNev());
				}
				if (d.getNyert() > 1) {
					donto3gomb2.setSelected(true);
					donto3gomb1.setSelected(true);
				} else if (d.getNyert() > 0) {
					donto3gomb2.setSelected(false);
					donto3gomb1.setSelected(true);
				} else {
					donto3gomb2.setSelected(false);
					donto3gomb1.setSelected(false);
				}
				break;
			}
			case 3: {
				donto4Rajt.setText(Integer.toString(d.getRajt()));
				donto4.setText(d.getNev());
				if (d.getNyert() == 2) {
					harmadikRajt.setText(Integer.toString(d.getRajt()));
					harmadik.setText(d.getNev());
				}
				if (d.getNyert() > 1) {
					donto4gomb2.setSelected(true);
					donto4gomb1.setSelected(true);
				} else if (d.getNyert() > 0) {
					donto4gomb2.setSelected(false);
					donto4gomb1.setSelected(true);
				} else {
					donto4gomb2.setSelected(false);
					donto4gomb1.setSelected(false);
				}
				break;
			}
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10));

		int x1, x2, x3, y1, y2, y3;

		// SEJEJTEZO 7-6
		x1 = selejt5gomb2.getX() + selejt5gomb2.getWidth();
		y1 = selejt5gomb2.getY() + selejt5gomb2.getHeight() / 2;
		x2 = negyed1Rajt.getX() - (negyed1Rajt.getX() - x1) / 2;
		g2.drawLine(x1, y1, x2, y1);
		y2 = selejt4gomb2.getY() + selejt4gomb2.getHeight() / 2;
		g2.drawLine(x1, y2, x2, y2);
		g2.drawLine(x2, y1, x2, y2);
		y3 = negyed1Rajt.getY() + negyed1Rajt.getHeight() / 2;
		x3 = negyed1Rajt.getX();
		g2.drawLine(x2, y3, x3, y3);

		// SEJEJTEZO 4-9
		x1 = selejt2gomb2.getX() + selejt2gomb2.getWidth();
		y1 = selejt2gomb2.getY() + selejt2gomb2.getHeight() / 2;
		x2 = negyed2Rajt.getX() - (negyed2Rajt.getX() - x1) / 2;
		g2.drawLine(x1, y1, x2, y1);
		y2 = selejt7gomb2.getY() + selejt7gomb2.getHeight() / 2;
		g2.drawLine(x1, y2, x2, y2);
		g2.drawLine(x2, y1, x2, y2);
		y3 = negyed2Rajt.getY() + negyed2Rajt.getHeight() / 2;
		x3 = negyed2Rajt.getX();
		g2.drawLine(x2, y3, x3, y3);

		// SEJEJTEZO 10-3
		x1 = selejt8gomb2.getX() + selejt8gomb2.getWidth();
		y1 = selejt8gomb2.getY() + selejt8gomb2.getHeight() / 2;
		x2 = negyed3Rajt.getX() - (negyed3Rajt.getX() - x1) / 2;
		g2.drawLine(x1, y1, x2, y1);
		y2 = selejt1gomb2.getY() + selejt1gomb2.getHeight() / 2;
		g2.drawLine(x1, y2, x2, y2);
		g2.drawLine(x2, y1, x2, y2);
		y3 = negyed3Rajt.getY() + negyed3Rajt.getHeight() / 2;
		x3 = negyed3Rajt.getX();
		g2.drawLine(x2, y3, x3, y3);

		// SEJEJTEZO 5-8
		x1 = selejt3gomb2.getX() + selejt3gomb2.getWidth();
		y1 = selejt3gomb2.getY() + selejt3gomb2.getHeight() / 2;
		x2 = negyed4Rajt.getX() - (negyed4Rajt.getX() - x1) / 2;
		g2.drawLine(x1, y1, x2, y1);
		y2 = selejt6gomb2.getY() + selejt6gomb2.getHeight() / 2;
		g2.drawLine(x1, y2, x2, y2);
		g2.drawLine(x2, y1, x2, y2);
		y3 = negyed4Rajt.getY() + negyed4Rajt.getHeight() / 2;
		x3 = negyed4Rajt.getX();
		g2.drawLine(x2, y3, x3, y3);

		// NEGYED 1-2
		x1 = negyed1gomb2.getX() + negyed1gomb2.getWidth();
		y1 = negyed1gomb2.getY() + negyed1gomb2.getHeight() / 2;
		x2 = donto1Rajt.getX() - (donto1Rajt.getX() - x1) / 2;
		g2.drawLine(x1, y1, x2, y1);
		y2 = negyed2gomb2.getY() + negyed2gomb2.getHeight() / 2;
		g2.drawLine(x1, y2, x2, y2);
		g2.drawLine(x2, y1, x2, y2);
		y3 = donto1Rajt.getY() + donto1Rajt.getHeight() / 2;
		x3 = donto1Rajt.getX();
		g2.drawLine(x2, y3, x3, y3);

		// NEGYED 3-4
		x1 = negyed3gomb2.getX() + negyed3gomb2.getWidth();
		y1 = negyed3gomb2.getY() + negyed3gomb2.getHeight() / 2;
		x2 = donto2Rajt.getX() - (donto2Rajt.getX() - x1) / 2;
		g2.drawLine(x1, y1, x2, y1);
		y2 = negyed4gomb2.getY() + negyed4gomb2.getHeight() / 2;
		g2.drawLine(x1, y2, x2, y2);
		g2.drawLine(x2, y1, x2, y2);
		y3 = donto2Rajt.getY() + donto2Rajt.getHeight() / 2;
		x3 = donto2Rajt.getX();
		g2.drawLine(x2, y3, x3, y3);

		// DONTO 1-2
		x1 = donto1gomb2.getX() + donto1gomb2.getWidth();
		y1 = donto1gomb2.getY() + donto1gomb2.getHeight() / 2;
		x2 = gyoztesRajt.getX() - (gyoztesRajt.getX() - x1) / 2;
		g2.drawLine(x1, y1, x2, y1);
		y2 = donto2gomb2.getY() + donto2gomb2.getHeight() / 2;
		g2.drawLine(x1, y2, x2, y2);
		g2.drawLine(x2, y1, x2, y2);
		y3 = gyoztesRajt.getY() + gyoztesRajt.getHeight() / 2;
		x3 = gyoztesRajt.getX();
		g2.drawLine(x2, y3, x3, y3);

		// DONTO 3-4
		x1 = donto3gomb2.getX() + donto3gomb2.getWidth();
		y1 = donto3gomb2.getY() + donto3gomb2.getHeight() / 2;
		x2 = harmadikRajt.getX() - (harmadikRajt.getX() - x1) / 2;
		g2.drawLine(x1, y1, x2, y1);
		y2 = donto4gomb2.getY() + donto4gomb2.getHeight() / 2;
		g2.drawLine(x1, y2, x2, y2);
		g2.drawLine(x2, y1, x2, y2);
		y3 = harmadikRajt.getY() + harmadikRajt.getHeight() / 2;
		x3 = harmadikRajt.getX();
		g2.drawLine(x2, y3, x3, y3);

		g2.setStroke(new BasicStroke(1));
	}
}

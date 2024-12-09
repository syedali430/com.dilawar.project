package com.dilawar.project.com.dilawar.project.swingview;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AllocationswingView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllocationswingView frame = new AllocationswingView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AllocationswingView() {
		setTitle("Allocation View\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel Student_Icon = new JLabel("");
		Student_Icon.setIcon(new ImageIcon("C:\\Users\\Alidi\\Downloads\\graduated (1).png"));
		GridBagConstraints gbc_Student_Icon = new GridBagConstraints();
		gbc_Student_Icon.insets = new Insets(0, 0, 5, 5);
		gbc_Student_Icon.gridx = 0;
		gbc_Student_Icon.gridy = 0;
		contentPane.add(Student_Icon, gbc_Student_Icon);
		
		JLabel lblNewLabel = new JLabel("Students");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JComboBox students_names = new JComboBox();
		GridBagConstraints gbc_students_names = new GridBagConstraints();
		gbc_students_names.insets = new Insets(0, 0, 5, 0);
		gbc_students_names.fill = GridBagConstraints.HORIZONTAL;
		gbc_students_names.gridx = 2;
		gbc_students_names.gridy = 0;
		contentPane.add(students_names, gbc_students_names);
		
		JLabel booksicon = new JLabel("");
		booksicon.setIcon(new ImageIcon("C:\\Users\\Alidi\\Downloads\\stack-of-books (1).png"));
		GridBagConstraints gbc_booksicon = new GridBagConstraints();
		gbc_booksicon.insets = new Insets(0, 0, 5, 5);
		gbc_booksicon.gridx = 0;
		gbc_booksicon.gridy = 1;
		contentPane.add(booksicon, gbc_booksicon);
		
		JLabel lblNewLabel_1 = new JLabel("Books");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JComboBox Books_names = new JComboBox();
		GridBagConstraints gbc_Books_names = new GridBagConstraints();
		gbc_Books_names.insets = new Insets(0, 0, 5, 0);
		gbc_Books_names.fill = GridBagConstraints.HORIZONTAL;
		gbc_Books_names.gridx = 2;
		gbc_Books_names.gridy = 1;
		contentPane.add(Books_names, gbc_Books_names);
		
		JLabel calendericon = new JLabel("");
		calendericon.setIcon(new ImageIcon("C:\\Users\\Alidi\\Downloads\\calendar (1).png"));
		GridBagConstraints gbc_calendericon = new GridBagConstraints();
		gbc_calendericon.insets = new Insets(0, 0, 5, 5);
		gbc_calendericon.gridx = 0;
		gbc_calendericon.gridy = 2;
		contentPane.add(calendericon, gbc_calendericon);
		
		JLabel lblNewLabel_2 = new JLabel("Date Start");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField = new JTextField();
		textField.setName("DatestartTextBox");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel calenderenddate = new JLabel("");
		calenderenddate.setIcon(new ImageIcon("C:\\Users\\Alidi\\Downloads\\calendar (1).png"));
		GridBagConstraints gbc_calenderenddate = new GridBagConstraints();
		gbc_calenderenddate.insets = new Insets(0, 0, 5, 5);
		gbc_calenderenddate.gridx = 0;
		gbc_calenderenddate.gridy = 3;
		contentPane.add(calenderenddate, gbc_calenderenddate);
		
		JLabel lblNewLabel_3 = new JLabel("Date End");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setName("DateEndTextBo");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 3;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setName("BookSummary");
		scrollPane.setViewportView(list);
		
		
		
		JButton btnNewButton = new JButton("Release Date");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 7;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Assign Book");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridwidth = 3;
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 8;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
	}

}

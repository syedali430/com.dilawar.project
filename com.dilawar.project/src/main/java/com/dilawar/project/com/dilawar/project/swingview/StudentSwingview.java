package com.dilawar.project.com.dilawar.project.swingview;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StudentSwingview extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField student_id;
	private JTextField name_text;
	private JTextField email_text;
	private JButton Add_Students;
	
	
	 
	    private JButton Update_Students;
	    private JButton Delete_Selected;
	    private JLabel error_Label;
	    private JList<String> students_list;
	    private DefaultListModel<String> studentsListModel;
	
	
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSwingview frame = new StudentSwingview();
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
	public StudentSwingview() {
		Add_Students = new JButton("Add Students");
		Update_Students = new JButton("Update Students");
		student_id = new JTextField();
		name_text = new JTextField();
		email_text = new JTextField();

		student_id.setName("student_id");
		name_text.setName("name_text");
		email_text.setName("email_text");
		Update_Students.setName("Update_Students");

		setTitle("Student Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Student ID");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		GridBagConstraints gbc_student_id = new GridBagConstraints();
		gbc_student_id.insets = new Insets(0, 0, 5, 5);
		gbc_student_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_student_id.gridx = 1;
		gbc_student_id.gridy = 0;
		contentPane.add(student_id, gbc_student_id);
		student_id.setColumns(10);
		
		
		/**
		 * student ID ibi ko dehakta howa bana hai.
		 */
		student_id = new JTextField();
		student_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				handleButtonAndComboBoxStates();
			}

			private void handleButtonAndComboBoxStates() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				checkCharacterIsNumber(e);
			}

			private void checkCharacterIsNumber(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

		});
		
		
		/**
		 * end student id.
		 */
		
		

		JLabel lblNewLabel_1 = new JLabel("Name");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		GridBagConstraints gbc_name_text = new GridBagConstraints();
		gbc_name_text.insets = new Insets(0, 0, 5, 5);
		gbc_name_text.fill = GridBagConstraints.HORIZONTAL;
		gbc_name_text.gridx = 1;
		gbc_name_text.gridy = 1;
		contentPane.add(name_text, gbc_name_text);
		name_text.setColumns(10);
		
		
		
		/**
		 * student name.
		 */
		
		
		name_text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				handleButtonAndComboBoxStates();
			}

		});
		
		/**
		 * student name end.
		 */
		
		

		JLabel lblNewLabel_2 = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		GridBagConstraints gbc_email_text = new GridBagConstraints();
		gbc_email_text.insets = new Insets(0, 0, 5, 5);
		gbc_email_text.fill = GridBagConstraints.HORIZONTAL;
		gbc_email_text.gridx = 1;
		gbc_email_text.gridy = 2;
		contentPane.add(email_text, gbc_email_text);
		email_text.setColumns(10);

		
		
		
		/**
		 * student email.
		 */
		
		
		email_text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				handleButtonAndComboBoxStates();
			}

		});
		
		/**
		 * student Email end.
		 */
		
		
		
		
		JButton update = new JButton("Update");
		update.setEnabled(false);
		update.setName("Update_Students");  // Set the name here

		GridBagConstraints gbc_update = new GridBagConstraints();
		gbc_update.gridwidth = 3;
		gbc_update.insets = new Insets(0, 0, 5, 0);
		gbc_update.gridx = 0;
		gbc_update.gridy = 3;
		contentPane.add(update, gbc_update);

		
		
		
		
		
		
		
		
		
		
		
		
		
		/**
		
		JButton update = new JButton("Update");
		update.setEnabled(false);

		
		
		GridBagConstraints gbc_update = new GridBagConstraints();
		gbc_update.gridwidth = 3;
		gbc_update.insets = new Insets(0, 0, 5, 0);
		gbc_update.gridx = 0;
		gbc_update.gridy = 3;
		contentPane.add(update, gbc_update);
		
		*/
		
		

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		contentPane.add(scrollPane, gbc_scrollPane);

		JList students_list = new JList();
		students_list.setName("students_list");
		students_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(students_list);
		
		
		
		
		
		
		
		
		

		Add_Students.setEnabled(false);
		GridBagConstraints gbc_add_Students = new GridBagConstraints();
		gbc_add_Students.gridwidth = 3;
		gbc_add_Students.insets = new Insets(0, 0, 5, 0);
		gbc_add_Students.gridx = 0;
		gbc_add_Students.gridy = 5;
		contentPane.add(Add_Students, gbc_add_Students);

		name_text.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				Add_Students.setEnabled(!name_text.getText().isEmpty() && !email_text.getText().isEmpty());
			}
		});

		email_text.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				Add_Students.setEnabled(!name_text.getText().isEmpty() && !email_text.getText().isEmpty());
			}
		});

		JButton Delete_Selected = new JButton("Delete Selected");
		Delete_Selected.setEnabled(false);
		GridBagConstraints gbc_Delete_Selected = new GridBagConstraints();
		gbc_Delete_Selected.insets = new Insets(0, 0, 5, 0);
		gbc_Delete_Selected.gridwidth = 3;
		gbc_Delete_Selected.gridx = 0;
		gbc_Delete_Selected.gridy = 6;
		contentPane.add(Delete_Selected, gbc_Delete_Selected);
		
		JLabel error_Label = new JLabel("");
		error_Label.setName("errorMessageLabel");
		GridBagConstraints gbc_error_Label = new GridBagConstraints();
		gbc_error_Label.gridwidth = 3;
		gbc_error_Label.insets = new Insets(0, 0, 0, 5);
		gbc_error_Label.gridx = 0;
		gbc_error_Label.gridy = 7;
		contentPane.add(error_Label, gbc_error_Label);

	}

	protected void handleButtonAndComboBoxStates() {
		// TODO Auto-generated method stub
		
	}
	
	
	  // Helper Methods
    private void handleButtonStates() {
        boolean isIdEmpty = student_id.getText().trim().isEmpty();
        boolean isNameEmpty = name_text.getText().trim().isEmpty();
        boolean isEmailEmpty = email_text.getText().trim().isEmpty();

        Add_Students.setEnabled(!isIdEmpty && !isNameEmpty && !isEmailEmpty);
        Update_Students.setEnabled(!isIdEmpty && !isNameEmpty && !isEmailEmpty);
    }

    
    private void checkCharacterIsNumber(KeyEvent e) {
        char c = e.getKeyChar();
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
            Toolkit.getDefaultToolkit().beep();
            e.consume();
        }
    }

    private void addStudentMethod() {
        String student = "ID: " + student_id.getText() + ", Name: " + name_text.getText() + ", Email: " + email_text.getText();
        studentsListModel.addElement(student);
        resetFields();
        resetErrorLabel();
    }

    private void resetErrorLabel() {
		// TODO Auto-generated method stub
		
	}

	private void resetFields() {
		// TODO Auto-generated method stub
		
	}

	private void updateStudentMethod() {
        int selectedIndex = students_list.getSelectedIndex();
        if (selectedIndex != -1) {
            String updatedStudent = "ID: " + student_id.getText() + ", Name: " + name_text.getText() + ", Email: " + email_text.getText();
            studentsListModel.setElementAt(updatedStudent, selectedIndex);
            resetFields();
            resetErrorLabel();
        } else {
            showError("No student selected for update!");
        }
    }

    private void showError(String string) {
		// TODO Auto-generated method stub
		
	}

	private void deleteStudentMethod() {
        int selectedIndex = students_list.getSelectedIndex();
        if (selectedIndex != -1) {
            studentsListModel.remove(selectedIndex);
            resetErrorLabel();
        } else {
            showError("No student selected for deletion!");
        }
    
	
	
	student_id.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyReleased(KeyEvent e) {
	        handleButtonStates();
	    }
	});

	name_text.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyReleased(KeyEvent e) {
	        handleButtonStates();
	    }
	});

	email_text.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyReleased(KeyEvent e) {
	        handleButtonStates();
	    }
	});
	
	
	
	}

	}

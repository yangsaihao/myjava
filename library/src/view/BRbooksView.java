package view;

import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;

import model.BorrowRecord;
import control.BorrowRecordControl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BRbooksView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;


	/**
	 * Create the dialog.
	 */
	public BRbooksView() {
		setBounds(100, 100, 245, 313);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ΩË È","ªπ È"}));
		comboBox.setBounds(132, 27, 67, 21);
		contentPanel.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(132, 79, 66, 21);
		contentPanel.add(textField);
		textField.setColumns(10); 
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 126, 66, 21);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(132, 176, 66, 21);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u670D\u52A1\u7C7B\u578B");
		lblNewLabel.setBounds(24, 30, 54, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel label = new JLabel("\u8BB0\u5F55\u53F7");
		label.setBounds(24, 82, 54, 15);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("\u4E66\u53F7");
		label_1.setBounds(24, 129, 54, 15);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("\u5B66\u53F7");
		label_2.setBounds(24, 179, 54, 15);
		contentPanel.add(label_2);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 0)
				{
					BorrowRecordControl.getBorrowRecordControl().addBorrowRecord(textField.getText(), textField_1.getText(), textField_2.getText());
					dispose();
				}
				if(comboBox.getSelectedIndex() == 1)
				{
					BorrowRecord b = BorrowRecordControl.getBorrowRecordControl().findByRecordID(textField.getText());
					BorrowRecordControl.getBorrowRecordControl().deleteBorrowRecord(b);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(24, 231, 67, 34);
		contentPanel.add(btnNewButton);
		
		JButton button = new JButton("\u53D6\u6D88");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(132, 231, 67, 34);
		contentPanel.add(button);
	}
}

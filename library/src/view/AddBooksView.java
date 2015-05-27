package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.BooksControl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBooksView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Create the dialog.
	 */
	public AddBooksView() {
		setBounds(100, 100, 217, 213);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("\u4E66\u53F7");
			label.setBounds(29, 35, 54, 15);
			contentPanel.add(label);
		}
		{
			textField = new JTextField();
			textField.setBounds(108, 32, 66, 21);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel label = new JLabel("\u4E66\u540D");
			label.setBounds(29, 86, 54, 15);
			contentPanel.add(label);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(108, 83, 66, 21);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			JButton button = new JButton("\u4FDD\u5B58");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BooksControl.getBooksControl().addBooks(textField.getText(), textField_1.getText());
					dispose();
				}
			});
			button.setBounds(10, 132, 71, 23);
			contentPanel.add(button);
		}
		{
			JButton button = new JButton("\u53D6\u6D88");
			button.setBounds(108, 132, 71, 23);
			contentPanel.add(button);
		}
	}

}

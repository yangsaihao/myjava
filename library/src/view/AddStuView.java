package view;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import control.StudentControl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStuView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField stuIDTextField;
	private JTextField stuNameTextField;

	

	/**
	 * Create the dialog.
	 */
	public AddStuView() {
		
		
		setBounds(100, 100, 331, 282);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			stuIDTextField = new JTextField();
			stuIDTextField.setBounds(143, 32, 127, 27);
			contentPanel.add(stuIDTextField);
			stuIDTextField.setColumns(10);
		}
		{
			stuNameTextField = new JTextField();
			stuNameTextField.setBounds(143, 91, 127, 27);
			contentPanel.add(stuNameTextField);
			stuNameTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("\u5B66\u53F7");
			lblNewLabel.setBounds(62, 32, 49, 27);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
			lblNewLabel_1.setBounds(62, 91, 49, 27);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JButton btnNewButton = new JButton("\u4FDD\u5B58");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StudentControl.getStudentControl().addStudent(stuIDTextField.getText(), stuNameTextField.getText());
					dispose();
				}
			});
			btnNewButton.setBounds(39, 175, 93, 37);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
			btnNewButton_1.setBounds(179, 175, 93, 37);
			contentPanel.add(btnNewButton_1);
		}
	}

}

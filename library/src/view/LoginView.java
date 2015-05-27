package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.ManagerControl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

public class LoginView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField userNameTextField;
	private int loginResult;
	private JPasswordField passwordField;



	/**
	 * Create the dialog.
	 */
	public LoginView() {
		setBounds(100, 100, 224, 231);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u767B\u9646");
		lblNewLabel.setBounds(80, 21, 81, 22);
		lblNewLabel.setFont(new Font("楷体",Font.BOLD,25));
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_1.setBounds(22, 62, 54, 15);
		lblNewLabel_1.setFont(new Font("楷体",Font.BOLD,15));
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u767B\u9646\u5BC6\u7801");
		lblNewLabel_2.setBounds(22, 111, 75, 22);
		lblNewLabel_2.setFont(new Font("楷体",Font.BOLD,15));
		contentPanel.add(lblNewLabel_2);
		
		userNameTextField = new JTextField();
		userNameTextField.setBounds(96, 59, 102, 22);
		contentPanel.add(userNameTextField);
		userNameTextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(96, 111, 102, 22);
		contentPanel.add(passwordField);
		
		final JButton okButton = new JButton("\u786E\u5B9A");
		okButton.setFont(new Font("楷体",Font.BOLD,15));
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ManagerControl.isUser(userNameTextField.getText(),String.valueOf(passwordField.getPassword())))
					{
							loginResult=1;
							okButton.setActionCommand("OK");
							dispose(); 
					}
					else
					{
							loginResult=-1;
							JOptionPane.showMessageDialog(null, "用户名/密码错误！", "警告",JOptionPane.INFORMATION_MESSAGE);
							passwordField.setText(null);
					}
			}
		});
		okButton.setBounds(69, 146, 75, 37);
		contentPanel.add(okButton);
		
		
	}
	public int getLogonResult()
	{
		return this.loginResult;
	}
}

package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginView loginView = new LoginView();
			loginView.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			loginView.setModal(true);
			loginView.setVisible(true);
			if (loginView.getLogonResult()==-1)
				System.exit(0);
			MainView mainUI = new MainView();
			mainUI.setVisible(true);
			//mainUI.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MainView() {
		setBounds(100, 100, 299, 292);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnNewButton = new JButton("\u8BFB\u8005\u7BA1\u7406");
			btnNewButton.setFont(new Font("¿¬Ìå",Font.BOLD,20));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ReaderManageView r = new ReaderManageView();
					r.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					r.setVisible(true);
				}
			});
			btnNewButton.setBounds(35, 23, 223, 49);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("\u501F\u8FD8\u4E66\u7C4D");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BRbooksView br = new BRbooksView();
					br.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					br.setVisible(true);
				}
			});
			btnNewButton_1.setFont(new Font("¿¬Ìå",Font.BOLD,20));
			btnNewButton_1.setBounds(35, 82, 223, 49);
			contentPanel.add(btnNewButton_1);
		}
		{
			JButton btnNewButton_2 = new JButton("\u4E66\u7C4D\u7BA1\u7406");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BooksManageView boo = new BooksManageView();
					boo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					boo.setVisible(true);
				}
			});
			btnNewButton_2.setFont(new Font("¿¬Ìå",Font.BOLD,20));
			btnNewButton_2.setBounds(35, 141, 223, 49);
			contentPanel.add(btnNewButton_2);
		}
		
		JButton btnNewButton_3 = new JButton("\u9000\u51FA");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_3.setBounds(204, 221, 69, 23);
		contentPanel.add(btnNewButton_3);
	}
}

package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Books;
import control.BooksControl;

public class BooksManageView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;


	/**
	 * Create the dialog.
	 */
	public BooksManageView() {
		setBounds(100, 100, 355, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 177, 242);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u4E66\u53F7", "\u4E66\u540D"
			}
		));
		
		InitialTable();
		
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0\u4E66\u7C4D");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBooksView add = new AddBooksView();
				add.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				add.setVisible(true);
			}
		});
		btnNewButton.setBounds(222, 71, 93, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664\u4E66\u7C4D");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BooksControl.getBooksControl().deleteBooks(
						table.getModel().getValueAt(table.getSelectedRow(), 0).toString(),
						table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
			}
		});
		btnNewButton_1.setBounds(222, 127, 93, 23);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u9000\u51FA");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(222, 180, 93, 23);
		contentPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Ë¢ÐÂ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InitialTable();
			}
		});
		btnNewButton_3.setBounds(269, 10, 60, 23);
		contentPanel.add(btnNewButton_3);
	}
	public void InitialTable()
	{
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		if(tableModel.getRowCount() != 0)
		{
			tableModel.setRowCount(0);
		}
		List list = BooksControl.getBooksControl().findAllBooks();
			
		for(int i = 0;i < list.size();i++)
		{
			Books books = (Books)list.get(i);
			tableModel.addRow(new Object[] {
					books.getBookId(),books.getBookName()
				});
		}
		setLocationRelativeTo(null);
	}
}

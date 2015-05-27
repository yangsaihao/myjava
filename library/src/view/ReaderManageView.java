package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Student;
import control.StudentControl;

public class ReaderManageView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	


	/**
	 * Create the dialog.
	 */
	public ReaderManageView() {
		setBounds(100, 100, 345, 292);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 184, 234);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D"
			}
		));
		
		InitialTable();
		
		scrollPane.setViewportView(table);
		
		{
			JButton btnNewButton = new JButton("\u5B66\u751F\u6CE8\u518C");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AddStuView add = new AddStuView();
					add.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					add.setVisible(true);		
				}
			});
			btnNewButton.setBounds(204, 49, 104, 31);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("\u66F4\u6539\u4FE1\u606F");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(table.getSelectedRowCount() == 0)
					{
						JOptionPane.showConfirmDialog(null, "请选择要修改的记录!","提示", JOptionPane.CLOSED_OPTION);
					}
					else
					{
						ModifyStuView mod = new ModifyStuView(
								table.getModel().getValueAt(table.getSelectedRow(), 0).toString(),
								table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
						mod.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);				
						mod.setVisible(true);
					}
					
				}
			});
			btnNewButton_1.setBounds(204, 90, 104, 31);
			contentPanel.add(btnNewButton_1);
		}
		{
			JButton btnNewButton_2 = new JButton("\u5220\u9664\u4FE1\u606F");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(table.getSelectedRowCount() == 0)
					{
						JOptionPane.showConfirmDialog(null, "请选择要删除的记录!","提示", JOptionPane.CLOSED_OPTION);
					}
					else if(table.getSelectedRowCount() == 1)
					{
						int r = table.getSelectedRow();
						System.out.println(r);
						System.out.println(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
						StudentControl.getStudentControl().deleteStudent(
								table.getModel().getValueAt(table.getSelectedRow(), 0).toString(),
								table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
					}
				}
			});
			btnNewButton_2.setBounds(204, 131, 104, 31);
			contentPanel.add(btnNewButton_2);
		}
		
		
		
		
		JButton btnNewButton_3 = new JButton("\u8FD4\u56DE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_3.setBounds(204, 194, 104, 31);
		contentPanel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u5237\u65B0");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InitialTable();
			}
		});
		btnNewButton_4.setBounds(250, 10, 69, 31);
		contentPanel.add(btnNewButton_4);
	}
	
	public void InitialTable()
	{
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		if(tableModel.getRowCount() != 0)
		{
			tableModel.setRowCount(0);
		}
		List list = StudentControl.getStudentControl().findAllStudent();
			
		for(int i = 0;i < list.size();i++)
		{
			Student student = (Student)list.get(i);
			tableModel.addRow(new Object[] {
				student.getStuId(),student.getStuName()
				});
		}
		setLocationRelativeTo(null);
	}
}

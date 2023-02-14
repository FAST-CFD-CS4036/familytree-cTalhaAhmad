package pl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import bll.InterfacePersonBO;
import bll.PersonBO;

public class FamiltyTreeView implements ActionListener {
	
	private JFrame frame;
	private JTextField cnic1;
	private JTextField cnic2;
	private JButton button;
	private JTextArea result;
	private InterfacePersonBO _bo;
	
	public FamiltyTreeView() throws SQLException {
//		bo = new PersonBO();
		frame = new JFrame("Check if two citizens are siblings or not");
		cnic1 = new JTextField("");
		cnic2 = new JTextField("");
		button = new JButton("Check");
		result = new JTextArea();
	}
	public FamiltyTreeView(InterfacePersonBO bo) {
		// TODO Auto-generated constructor stub
		_bo = bo;
	}
	public void viewSibling() {

		cnic1.setBounds(50, 50, 200, 50);
		cnic2.setBounds(50, 100, 200, 50);
		button.setBounds(50, 150, 100, 50);
		button.addActionListener(this);
		result.setBounds(50, 200, 200, 200);
		frame.add(cnic1);
		frame.add(cnic2);
		frame.add(result);
		frame.add(button);
		
		frame.setSize(400,500);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int nic1 = Integer.parseInt(cnic1.getText());
		int nic2 = Integer.parseInt(cnic2.getText());
		if (_bo.CheckSibling(nic1, nic2)) {
			result.setText("Yes, the two citizens are siblings");
		} else {
			result.setText("No, the two citizens are not siblings");
		}
		if (_bo.CheckHalfSibling(nic1, nic2)) {
			result.setText("Yes, the two citizens are siblings");
		} else {
			result.setText("No, the two citizens are not siblings");
		}
	}
	public static void main(String[] args) {
		FamiltyTreeView app;
		try {
			app = new FamiltyTreeView();
			app.viewSibling();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		PersonDAOStub daostub = new PersonDAOStub();
//		PesonBo bll = new PersonBo(daoStub);
	}
}

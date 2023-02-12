package pl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import bll.PersonBO;
//import dal.PersonDAOStub;
import to.PersonTO;

public class FamiltyTreeView implements ActionListener {

	private JFrame frame;
//	private JTextField cnic1;
//	private JTextField cnic2;
	private JTextField name;
	private JButton button;
	private JTextArea result;

	private PersonBO bo;

	public FamiltyTreeView() throws SQLException {
		bo = new PersonBO();
//		frame = new JFrame("Check if two citizens are siblings or not");
//		frame = new JFrame("Check if two citizens are half-siblings or not");
		frame = new JFrame("Search Person");
//		cnic1 = new JTextField("");
//		cnic2 = new JTextField("");
		name = new JTextField("");
//		button = new JButton("Check");
		button = new JButton("Search");
		result = new JTextArea();
	}

	public void viewSibling() {

//		cnic1.setBounds(50, 50, 200, 50);
//		cnic2.setBounds(50, 100, 200, 50);
		name.setBounds(50, 100, 200, 50);
		button.setBounds(50, 150, 100, 50);
		button.addActionListener(this);
		result.setBounds(50, 250, 500, 500);
//		frame.add(cnic1);
//		frame.add(cnic2);
		frame.add(name);
		frame.add(result);
		frame.add(button);

		frame.setSize(1500, 1000);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		int nic1 = Integer.parseInt(cnic1.getText());
//		int nic2 = Integer.parseInt(cnic2.getText());
		String Name = name.getText().toString();

//		if (bo.isSibling(nic1, nic2)) {
//			result.setText("Yes, the two citizens are siblings");
//		} else {
//			result.setText("No, the two citizens are not siblings");
//		}

//		if (bo.isHalfSibling(nic1, nic2)) {
//			result.setText("Yes, the two citizens are half-siblings");
//		} else {
//			result.setText("No, the two citizens are not half-siblings");
//		}

		ArrayList<PersonTO> data = new ArrayList<PersonTO>();
		data = bo.showData(Name);

		for (int person = 0; person < data.size(); person++) {
			result.append(
					"Name: " + data.get(person).getName() + ", CNIC: " + Integer.toString(data.get(person).getCnic())
							+ ", Mother's CNIC: " + Integer.toString(data.get(person).getMother()) + ", Father's CNIC: "
							+ Integer.toString(data.get(person).getFather()) + "\n");
		}
//		result.append(data.get(0).getName());
	}

	public static void main(String[] args) throws SQLException {
//		FamiltyTreeView app;
//		try {
//			app = new FamiltyTreeView();
//			app.viewSibling();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		Connection con = DriverManager.getConnection(null);
//		PersonDAO dao = new PersonDAO(con);
//		PersonDAOStub daoStub = new PersonDAOStub();
		
//		PersonBO bo = new PersonBO(dao);
//		PersonBO bo = new PersonBO(daoStub);
	}
}

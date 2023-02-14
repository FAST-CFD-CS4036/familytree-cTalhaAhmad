package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import to.PersonTO;

public class PersonDAO implements IDAL {
	private Connection con;
	
	public PersonDAO() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/22fallfinal?useSSL=false";
		String user = "root";
		String password = "";
		con = DriverManager.getConnection(url, user, password);
	}
	public PersonDAO(Connection con) {
		this.con = con;
	}
	
	public PersonTO getPerson(int cnic) {
		PersonTO person = new PersonTO(0, null, 0, 0);
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM `citizen` WHERE `cnic` = ?");
			ps.setInt(1, cnic);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				person.setCnic(rs.getInt("cnic"));
				person.setName(rs.getString("name"));
				person.setFather(rs.getInt("father"));
				person.setMother(rs.getInt("mother"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person;
	}
	@Override
	public ArrayList<PersonTO> getMatchinPersons(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}

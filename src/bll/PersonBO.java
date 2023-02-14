package bll;

import java.sql.SQLException;

import dal.IDAL;
import dal.PersonDAO;
import to.PersonTO;

public class PersonBO implements InterfacePersonBO {
	private IDAL dao;
	
	public PersonBO () throws SQLException {
		dao = new PersonDAO();
	}
	public PersonBO(IDAL dao) {
		this.dao = dao;
	}

	public boolean isSibling (int cnic1, int cnic2) {
		PersonTO p1 = dao.getPerson(cnic1);
		PersonTO p2 = dao.getPerson(cnic2);
		
		return p1.getFather() == p2.getFather() && p1.getMother() == p2.getMother();
	}
	
	public boolean isHalfSibling (int cnic1, int cnic2) {
		PersonTO p1 = dao.getPerson(cnic1);
		PersonTO p2 = dao.getPerson(cnic2);
		
		return p1.getFather() == p2.getFather()|| p1.getMother() == p2.getMother();
	}
	
	@Override
	public boolean CheckSibling(int cnic1,int cnic2) {
		return this.isSibling(cnic1,cnic2);
		
	}
	public boolean CheckHalfSibling(int cnic1,int cnic2) {
		return this.isHalfSibling(cnic1,cnic2);		
	}
	
}

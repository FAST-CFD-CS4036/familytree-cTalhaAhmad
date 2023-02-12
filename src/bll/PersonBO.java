package bll;

import java.util.ArrayList;

import dal.IDAL;
import dal.PersonDAOStub;
import to.PersonTO;

public class PersonBO {
	//1.1 private PersonDAO dao;//After creating interface no need of it.
	private IDAL dao;
	public PersonBO () {
		// hard code to give Reference of DAO to BLL layer
		// no dependency injection here
		// hard code here
		
//		dao = new PersonDAO();
	}
	public PersonBO(IDAL dao) {
		// this is doing dependency injection work
		// because the parameter we are passing here will be initialise 
		// instead of hard code
		// low coupling here
		this.dao = dao;
	}

	public boolean isSibling (int cnic1, int cnic2) {
		PersonTO p1 = dao.getPerson(cnic1);
		PersonTO p2 = dao.getPerson(cnic2);
		
		return sameFather(p1, p2) && sameMother(p1, p2);
	}
	
	public boolean isHalfSibling (int cnic1, int cnic2) {
		PersonTO p1 = dao.getPerson(cnic1);
		PersonTO p2 = dao.getPerson(cnic2);
		
		return sameFather(p1, p2) || sameMother(p1, p2);
	}
	
	private boolean sameMother(PersonTO p1, PersonTO p2) {
		return p1.getMother() == p2.getMother();
	}
	private boolean sameFather(PersonTO p1, PersonTO p2) {
		return p1.getFather() == p2.getFather();
	}
	
	public ArrayList<PersonTO> showData(String Name) {
		ArrayList<PersonTO> data = new ArrayList<PersonTO>();
		data = dao.getData(Name);
		
		return data;
	}
	
	public static void main(String[] args)	// this main is for testing purposes - as no need run Presentation Layer since we're only testing BAL
	{// Test case for isSibling()
		PersonDAOStub daoStub = new PersonDAOStub();
		PersonBO bo = new PersonBO(daoStub);
		
		{ // "Test case passed!" if isSibling() == true
			boolean expected = true;
			boolean actual = bo.isSibling(3, 4);
			
			if (expected == actual)
			{
				System.out.println("Test case passed!");
			}
			else
			{
				System.out.println("Test case failed!");
			}
			assert expected == actual;	// it will terminate the code if it's not true
		}
		
		{	// "Test case passed!" if isSibling() == false
			boolean expected = true;
			boolean actual = bo.isSibling(2, 4);
			
			if (expected != actual)
			{
				System.out.println("Test case passed!");
			}
			else
			{
				System.out.println("Test case failed!");
			}
			assert expected == actual;	// it will terminate the code if it's not true
		}
	}
}

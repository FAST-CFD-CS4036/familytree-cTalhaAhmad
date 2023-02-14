package dal;

import java.util.ArrayList;
import java.util.Hashtable;

import to.PersonTO;

public class PersonDAOStub implements IDAL{

	private Hashtable<Integer, PersonTO> table;
	
	public PersonDAOStub() {
		table = new  Hashtable<Integer, PersonTO>();
		table.put(1,new PersonTO(1, "Talha",-1,-1));
		table.put(2,new PersonTO(2, "Farhan",-1,-1));
		
		table.put(3,new PersonTO(3, "Zain",1,2));
		table.put(4,new PersonTO(4, "Waseem",1,2));
		
		table.put(5,new PersonTO(4, "Sajawal",1,-2));
		table.put(6,new PersonTO(4, "Akif",1,1));
		
		table.put(7,new PersonTO(4, "Mujtaba",2,-1));
		table.put(8,new PersonTO(4, "Waleed",-1,-1));
	}
	
	@Override
	public PersonTO getPerson(int cnic) {
		// TODO Auto-generated method stub
		return table.get(cnic);
	}

	@Override
	public ArrayList<PersonTO> getMatchinPersons(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

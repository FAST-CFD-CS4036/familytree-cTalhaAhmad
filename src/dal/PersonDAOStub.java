/*Stub Purpose:
	- Not want to test DAL, rather only BAL
	- DAL might not be accessible
	- DAL Testing might be someone other's responsibility
	- It may use Extra Resources, Time consuming. (Data Query)*/

package dal;

import java.util.ArrayList;
import java.util.Hashtable;

import to.PersonTO;

public class PersonDAOStub implements IDAL {

	private Hashtable<Integer, PersonTO> db;
	
	public PersonDAOStub() {
		super();
		db = new Hashtable<Integer, PersonTO>();
		db.put(1, new PersonTO(1, "Shah Jahan", -1, -1));
		db.put(2, new PersonTO(2, "Mumtaz Mahal", -1, -1));
		db.put(3, new PersonTO(3, "Aurangzeb", 1, 2));
		db.put(4, new PersonTO(4, "Dara Shikoh", 1, 2));
	}
	
	@Override
	public PersonTO getPerson(int cnic) {
		// it is getting person from hash table
		return db.get(cnic);
	}

	@Override
	public ArrayList<PersonTO> getData(String Name) {
		
		return null;
	}

}

/*Purpose:
	- Dependency Injection Principle
*/

package dal;

import java.util.ArrayList;

import to.PersonTO;

public interface IDAL {
	public PersonTO getPerson(int cnic);
	public ArrayList<PersonTO> getData(String Name);
	}
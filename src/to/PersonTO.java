package to;

public class PersonTO {
	public PersonTO() {
		this.setCnic(0);
		this.setName("");
		this.setMother(0);
		this.setFather(0);
	}
	public PersonTO(int cnic, String name, int father, int mother) {
		this.cnic= cnic;
		this.name = name;
		this.father = father;
		this.mother = mother;
	}
	public PersonTO(PersonTO obj)
	{
		this.setCnic(obj.getCnic());
		this.setName(obj.getName());
		this.setMother(obj.getMother());
		this.setFather(obj.getFather());
	}
	public int getCnic() {
		return cnic;
	}
	public void setCnic(int cnic) {
		this.cnic = cnic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFather() {
		return father;
	}
	public void setFather(int father) {
		this.father = father;
	}
	public int getMother() {
		return mother;
	}
	public void setMother(int mother) {
		this.mother = mother;
	}
	private int cnic;
	private String name;
	private int father;
	private int mother;
}
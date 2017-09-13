package business;

public abstract class Facility {
	private int id;
	private String name;
	private String address;
	private String city;
	private String state;
	private String zipCode;

	public int getId() {
		return id;
	}

	// id of -1 indicates that this is a new facility and the id needs to be determined
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String toString() {
		return "[Facility: id="+getId()+", name="+getName()+", address="+getAddress()+
				", city="+getCity()+", state="+getState()+", zip="+getZipCode()+"]";
	}

}

package landingpage.lm.container;

public class Agent {
	private String name;
	private String email;
	private String affiliation;
	
	public Agent(String name, String email, String affiliation)
	{
		this.name = name;
		this.email = email;
		this.affiliation = affiliation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
}

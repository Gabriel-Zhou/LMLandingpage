package landingpage.lm.container;

import java.util.ArrayList;

public class Provenance {
	private ArrayList<Agent> agent;
	private Derivation derivation;
	private String idFieldsOrder;
	private String creationDate;
	private String lastModificationDate;

	public Provenance(ArrayList<Agent> agent, Derivation derivation, String idFieldsOrder, String creationDate,
			String lastModificationDate) {
		this.agent = agent;
		this.idFieldsOrder = idFieldsOrder;
		this.creationDate = creationDate;
		this.lastModificationDate = lastModificationDate;
	}

	public ArrayList<Agent> getAgent() {
		return agent;
	}

	public void setAgent(ArrayList<Agent> agent) {
		this.agent = agent;
	}

	public Derivation getDerivation() {
		return derivation;
	}

	public void setDerivation(Derivation derivation) {
		this.derivation = derivation;
	}

	public String getIdFieldsOrder() {
		return idFieldsOrder;
	}

	public void setIdFieldsOrder(String idFieldsOrder) {
		this.idFieldsOrder = idFieldsOrder;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(String lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}
}

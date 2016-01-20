package landingpage.lm.container;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "VMObject")
public class VMObject {
	@Id
	private String id;

	private String pid;
	private String internalID;
	private String identifier;
	private String name;
	private String description;
	private Manifest manifest;
	private Provenance provenance;
	private ArrayList<Keyword> keywords;

	public VMObject() {

	}

	public VMObject(String pid, String internalID, String identifier, String name, String description,
			Manifest manifest, Provenance provenance, ArrayList<Keyword> keywords) {
		super();
		this.pid = pid;
		this.internalID = internalID;
		this.identifier = identifier;
		this.description = description;
		this.manifest = manifest;
		this.provenance = provenance;
		this.keywords = keywords;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getInternalID() {
		return internalID;
	}

	public void setInternalID(String internalID) {
		this.internalID = internalID;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Manifest getManifest() {
		return manifest;
	}

	public void setManifest(Manifest manifest) {
		this.manifest = manifest;
	}

	public Provenance getProvenance() {
		return provenance;
	}

	public void setProvenance(Provenance provenance) {
		this.provenance = provenance;
	}

	public ArrayList<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(ArrayList<Keyword> keywords) {
		this.keywords = keywords;
	}
}

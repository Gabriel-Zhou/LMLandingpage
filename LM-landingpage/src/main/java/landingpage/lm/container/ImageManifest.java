package landingpage.lm.container;

public class ImageManifest {
	private String hostname;
	private String hostip;
	private String rocksVersion;
	private String speciesDataset;
	private String environmentalDataset;
	private String rollVersion;
	private String lmVersion;
	private String capacity;

	public ImageManifest(String hostname, String hostip, String rocksVersion, String speciesDataset,
			String environmentalDataset, String rollVersion, String lmVersion, String capacity) {
		this.hostname = hostname;
		this.hostip = hostip;
		this.rocksVersion = rocksVersion;
		this.speciesDataset = speciesDataset;
		this.environmentalDataset = environmentalDataset;
		this.rollVersion = rollVersion;
		this.lmVersion = lmVersion;
		this.capacity = capacity;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getHostip() {
		return hostip;
	}

	public void setHostip(String hostip) {
		this.hostip = hostip;
	}

	public String getRocksVersion() {
		return rocksVersion;
	}

	public void setRocksVersion(String rocksVersion) {
		this.rocksVersion = rocksVersion;
	}

	public String getSpeciesDataset() {
		return speciesDataset;
	}

	public void setSpeciesDataset(String speciesDataset) {
		this.speciesDataset = speciesDataset;
	}

	public String getEnvironmentalDataset() {
		return environmentalDataset;
	}

	public void setEnvironmentalDataset(String environmentalDataset) {
		this.environmentalDataset = environmentalDataset;
	}

	public String getRollVersion() {
		return rollVersion;
	}

	public void setRollVersion(String rollVersion) {
		this.rollVersion = rollVersion;
	}

	public String getLmVersion() {
		return lmVersion;
	}

	public void setLmVersion(String lmVersion) {
		this.lmVersion = lmVersion;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
}

package landingpage.lm.container;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProjectionSet")
public class ProjectionSet {
	
	@Id
	private String id;
	
	private String pid;
	private String displayName;
	private String scenarioCode;
	private String boundingBox;
	private String resolution;
	private String lastModified;
	private String occurrenceSetPID;
	private String experimentID;
	private String downloadingURL;
	private String checksum;

	public ProjectionSet()
	{
	}
	
	public ProjectionSet(String pid, String displayName, String scenarioCode, String boundingBox, String resolution, String lastModified, String occurrenceSetPID, String experimentID, String downloadingURL, String checksum)
	{
		super();
		this.pid = pid;
		this.displayName = displayName;
		this.scenarioCode = scenarioCode;
		this.boundingBox = boundingBox;
		this.resolution = resolution;
		this.lastModified = lastModified;
		this.occurrenceSetPID = occurrenceSetPID;
		this.experimentID = experimentID;
		this.downloadingURL = downloadingURL;
		this.checksum = checksum;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getScenarioCode() {
		return scenarioCode;
	}

	public void setScenarioCode(String scenarioCode) {
		this.scenarioCode = scenarioCode;
	}

	public String getBoundingBox() {
		return boundingBox;
	}

	public void setBoundingBox(String boundingBox) {
		this.boundingBox = boundingBox;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public String getOccurrenceSetPID() {
		return occurrenceSetPID;
	}

	public void setOccurrenceSetPID(String occurrenceSetPID) {
		this.occurrenceSetPID = occurrenceSetPID;
	}

	public String getExperimentID() {
		return experimentID;
	}

	public void setExperimentID(String experimentID) {
		this.experimentID = experimentID;
	}

	public String getDownloadingURL() {
		return downloadingURL;
	}

	public void setDownloadingURL(String downloadingURL) {
		this.downloadingURL = downloadingURL;
	}

	public String getChecksum() {
		return checksum;
	}

	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
}

package landingpage.lm.container;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "OccurrenceSet")
public class OccurrenceSet {
		
		@Id
		private String id;
		
		private String pid;
		private String internalID;
		private String displayName;
		private int count;
		private String lastModified;
		private String downloadingURL;
		private String VMpid;
		private String checksum;
		
		public OccurrenceSet(String pid, String internalID, String displayName, int count, String lastModified, String downloadingURL, String VMpid, String checksum)
		{
			super();
			this.pid = pid;
			this.internalID = internalID;
			this.displayName = displayName;
			this.count = count;
			this.lastModified = lastModified;
			this.downloadingURL = downloadingURL;
			this.checksum = checksum;
			this.VMpid = VMpid;
		}
		
		public OccurrenceSet()
		{
			
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

		public String getInternalID() {
			return internalID;
		}

		public void setInternalID(String internalID) {
			this.internalID = internalID;
		}

		public String getDisplayName() {
			return displayName;
		}

		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public String getLastModified() {
			return lastModified;
		}

		public void setLastModified(String lastModified) {
			this.lastModified = lastModified;
		}

		public String getDownloadingURL() {
			return downloadingURL;
		}

		public void setDownloadingURL(String downloadingURL) {
			this.downloadingURL = downloadingURL;
		}
		
		public String getVMpid() {
			return VMpid;
		}

		public void setVMpid(String vMpid) {
			VMpid = vMpid;
		}

		public String getChecksum() {
			return checksum;
		}

		public void setChecksum(String checksum) {
			this.checksum = checksum;
		}
}

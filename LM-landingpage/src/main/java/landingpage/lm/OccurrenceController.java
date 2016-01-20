package landingpage.lm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import landingpage.lm.container.OccurrenceSet;
import landingpage.lm.mongo.OccurrenceRepository;
import landingpage.lm.response.MessageResponse;
import landingpage.lm.response.OccurrenceSetResponse;

/**
 * Handles requests for the occurrence set upload and query
 * 
 */
@RestController
public class OccurrenceController {
	@Autowired
	private OccurrenceRepository occur_repository;

	@RequestMapping("/occurrence/upload")
	@ResponseBody
	public MessageResponse projectionUpload(@RequestParam(value = "pid", required = true) String pid,
			@RequestParam(value = "internalID", required = true) String internalID,
			@RequestParam(value = "displayName", required = true) String displayname,
			@RequestParam(value = "count", required = true) int count,
			@RequestParam(value = "lastModified", required = true) String lastmodified,
			@RequestParam(value = "downloadingURL", required = true) String downloadingurl,
			@RequestParam(value = "VMpid", required = true) String VMpid,
			@RequestParam(value = "checksum", required = true) String checksum) {

		// Check if internal ID exists
		if (!occur_repository.existByInternalID(internalID)) {
			OccurrenceSet occurset = new OccurrenceSet(pid, internalID, displayname, count, lastmodified,
					downloadingurl, VMpid, checksum);
			occur_repository.addSet(occurset);
			MessageResponse response = new MessageResponse(true, "Occurrence set is successfully uploaded.");
			return response;
		} else {
			MessageResponse response = new MessageResponse(false, "Occurence set already exists.");
			return response;
		}
	}

	@RequestMapping("/occurrence/upload/object")
	@ResponseBody
	public MessageResponse projectionUpload(
			@RequestParam(value = "occurrence", required = true) OccurrenceSet occurrence) {

		// Check if internal ID exists
		if (!occur_repository.existByInternalID(occurrence.getInternalID())) {
			occur_repository.addSet(occurrence);
			MessageResponse response = new MessageResponse(true, "Occurrence set is successfully uploaded.");
			return response;
		} else {
			MessageResponse response = new MessageResponse(false, "Occurence set already exists.");
			return response;
		}
	}

	@RequestMapping("/occurrence/list")
	@ResponseBody
	public List<OccurrenceSet> listAll() {
		return occur_repository.listAll();
	}

	@RequestMapping("/occurrence/{internalID}")
	@ResponseBody
	public OccurrenceSetResponse findOccurrence(@PathVariable String internalID) {
		if (occur_repository.existByInternalID(internalID)) {
			OccurrenceSet occurset = occur_repository.findSetByInternalID(internalID);
			OccurrenceSetResponse response = new OccurrenceSetResponse(true, occurset);
			return response;
		} else {
			OccurrenceSetResponse response = new OccurrenceSetResponse(false, null);
			return response;
		}
	}

	@RequestMapping("/occurrence/test/{pid}")
	@ResponseBody
	public MessageResponse test(@PathVariable String pid) {
		MessageResponse response = new MessageResponse(true, pid);
		return response;
	}
}

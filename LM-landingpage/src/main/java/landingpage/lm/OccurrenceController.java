package landingpage.lm;

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
			@RequestParam(value = "displayName", required = true) String displayname,
			@RequestParam(value = "count", required = true) int count,
			@RequestParam(value = "lastModified", required = true) String lastmodified,
			@RequestParam(value = "downloadingURL", required = true) String downloadingurl,
			@RequestParam(value = "checksum", required = true) String checksum) {

		// Check if PID exists
		if (!occur_repository.existByPID(pid)) {
			OccurrenceSet occurset = new OccurrenceSet(pid, displayname, count, lastmodified, downloadingurl, checksum);
			occur_repository.addSet(occurset);
			MessageResponse response = new MessageResponse(true, "Occurrence set is successfully uploaded.");
			return response;
		} else {
			MessageResponse response = new MessageResponse(false, "PID already exists.");
			return response;
		}
	}

	@RequestMapping("/occurrence/{pid}")
	@ResponseBody
	public OccurrenceSetResponse findOccurrence(@PathVariable String pid) {
		if (occur_repository.existByPID(pid)) {
			OccurrenceSet occurset = occur_repository.findSetByPID(pid);
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
		MessageResponse response = new MessageResponse(true,pid);
		return response;
	}
}

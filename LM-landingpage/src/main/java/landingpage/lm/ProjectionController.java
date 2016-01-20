package landingpage.lm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import landingpage.lm.container.ProjectionSet;
import landingpage.lm.mongo.ProjectionRepository;
import landingpage.lm.response.MessageResponse;
import landingpage.lm.response.ProjectionSetResponse;

/**
 * Handles requests for the projection set upload and query
 * 
 */
@RestController
public class ProjectionController {

	@Autowired
	private ProjectionRepository proj_repository;

	@RequestMapping("/projection/upload")
	@ResponseBody
	public MessageResponse projectionUpload(@RequestParam(value = "pid", required = true) String pid,
			@RequestParam(value = "internalID", required = true) String internalID,
			@RequestParam(value = "displayName", required = true) String displayname,
			@RequestParam(value = "scenarioCode", required = true) String scenariocode,
			@RequestParam(value = "boundingBox", required = true) String boundingbox,
			@RequestParam(value = "resolution", required = true) String resolution,
			@RequestParam(value = "lastModified", required = true) String lastmodified,
			@RequestParam(value = "occurrenceSetPID", required = true) String occurrencesetpid,
			@RequestParam(value = "VMpid", required = true) String VMpid,
			@RequestParam(value = "experimentID", required = true) String experimentid,
			@RequestParam(value = "downloadingURL", required = true) String downloadingurl,
			@RequestParam(value = "checksum", required = true) String checksum) {

		// Check if internal ID exists
		if (!proj_repository.existByInternalID(internalID)) {
			ProjectionSet projset = new ProjectionSet(pid, internalID, displayname, scenariocode, boundingbox,
					resolution, lastmodified, occurrencesetpid, VMpid, experimentid, downloadingurl, checksum);
			proj_repository.addSet(projset);
			MessageResponse response = new MessageResponse(true, "Projection set is successfully uploaded.");
			return response;
		} else {
			MessageResponse response = new MessageResponse(false, "Projection set already exists.");
			return response;
		}
	}

	@RequestMapping("/projection/upload/object")
	@ResponseBody
	public MessageResponse projectionUpload(
			@RequestParam(value = "projection", required = true) ProjectionSet projection) {

		// Check if internal ID exists
		if (!proj_repository.existByInternalID(projection.getInternalID())) {
			proj_repository.addSet(projection);
			MessageResponse response = new MessageResponse(true, "Projection set is successfully uploaded.");
			return response;
		} else {
			MessageResponse response = new MessageResponse(false, "Projection set already exists.");
			return response;
		}
	}

	@RequestMapping("/projection/list")
	@ResponseBody
	public List<ProjectionSet> listAll() {
		return proj_repository.listAll();
	}

	@RequestMapping("/projection/{internalID}")
	@ResponseBody
	public ProjectionSetResponse findProjection(@PathVariable String internalID) {
		if (proj_repository.existByInternalID(internalID)) {
			ProjectionSet projset = proj_repository.findSetByInternalID(internalID);
			ProjectionSetResponse response = new ProjectionSetResponse(true, projset);
			return response;
		} else {
			ProjectionSetResponse response = new ProjectionSetResponse(false, null);
			return response;
		}
	}

	@RequestMapping("/projection/pid/{pid}")
	@ResponseBody
	public ProjectionSetResponse findProjectionByPID(@PathVariable String pid) {
		if (proj_repository.existByPID(pid)) {
			ProjectionSet projset = proj_repository.findSetByPID(pid);
			ProjectionSetResponse response = new ProjectionSetResponse(true, projset);
			return response;
		} else {
			ProjectionSetResponse response = new ProjectionSetResponse(false, null);
			return response;
		}
	}
}

package landingpage.lm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import landingpage.lm.container.Keyword;
import landingpage.lm.container.Manifest;
import landingpage.lm.container.Provenance;
import landingpage.lm.container.VMObject;
import landingpage.lm.mongo.VMRepository;
import landingpage.lm.response.MessageResponse;
import landingpage.lm.response.VMObjectResponse;

/**
 * Handles requests for the VM object upload and query
 * 
 */
@RestController
public class VMController {

	@Autowired
	private VMRepository vm_repository;

	@RequestMapping("/lmvm/upload")
	@ResponseBody
	public MessageResponse lmvmUpload(@RequestParam(value = "pid", required = true) String pid,
			@RequestParam(value = "internalID", required = true) String internalID,
			@RequestParam(value = "identifier", required = true) String identifier,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "description", required = true) String description,
			@RequestParam(value = "manifest", required = true) Manifest manifest,
			@RequestParam(value = "manifest", required = true) Provenance provenance,
			@RequestParam(value = "Keywords", required = true) ArrayList<Keyword> keywords) {

		// Check if identifier exists
		if (!vm_repository.existByInternalID(internalID)) {
			VMObject vmobject = new VMObject(pid, internalID, identifier, name, description, manifest, provenance,
					keywords);
			vm_repository.addVM(vmobject);
			MessageResponse response = new MessageResponse(true, "VM object is successfully uploaded.");
			return response;
		} else {
			MessageResponse response = new MessageResponse(false, "VM object already exists.");
			return response;
		}
	}

	@RequestMapping("/lmvm/upload/object")
	@ResponseBody
	public MessageResponse lmvmUpload(@RequestParam(value = "VMObject", required = true) VMObject vmobject) {

		// Check if identifier exists
		if (!vm_repository.existByInternalID(vmobject.getInternalID())) {
			vm_repository.addVM(vmobject);
			MessageResponse response = new MessageResponse(true, "VM object is successfully uploaded.");
			return response;
		} else {
			MessageResponse response = new MessageResponse(false, "VM object already exists.");
			return response;
		}
	}

	@RequestMapping("/lmvm/{internalID}")
	@ResponseBody
	public VMObjectResponse findProjection(@PathVariable String internalID) {
		if (vm_repository.existByInternalID(internalID)) {
			VMObject vmobject = vm_repository.findObjectByInternalID(internalID);
			VMObjectResponse response = new VMObjectResponse(true, vmobject);
			return response;
		} else {
			VMObjectResponse response = new VMObjectResponse(false, null);
			return response;
		}
	}

	@RequestMapping("/lmvm/pid/{pid}")
	@ResponseBody
	public VMObjectResponse findProjectionByPID(@PathVariable String pid) {
		if (vm_repository.existByPID(pid)) {
			VMObject vmobject = vm_repository.findObjectByPID(pid);
			VMObjectResponse response = new VMObjectResponse(true, vmobject);
			return response;
		} else {
			VMObjectResponse response = new VMObjectResponse(false, null);
			return response;
		}
	}

	@RequestMapping("/lmvm/list")
	@ResponseBody
	public List<VMObject> listAll() {
		return vm_repository.listAll();
	}
}

package landingpage.lm.response;

import landingpage.lm.container.VMObject;

/*
 * VM Object REST response
 */
public class VMObjectResponse {
	private Boolean success;
	private VMObject vmobject;

	public VMObjectResponse(Boolean success, VMObject vmobject) {
		this.success = success;
		this.vmobject = vmobject;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public VMObject getVmobject() {
		return vmobject;
	}

	public void setVmobject(VMObject vmobject) {
		this.vmobject = vmobject;
	}
}

package landingpage.lm.response;

import landingpage.lm.container.ProjectionSet;

/*
 * Projection set REST response
 * 
 */
public class ProjectionSetResponse {
	private boolean success;
	private ProjectionSet projset;

	public ProjectionSetResponse(boolean success, ProjectionSet projset) {
		this.success = success;
		this.projset = projset;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public ProjectionSet getProjset() {
		return projset;
	}

	public void setProjset(ProjectionSet projset) {
		this.projset = projset;
	}
}

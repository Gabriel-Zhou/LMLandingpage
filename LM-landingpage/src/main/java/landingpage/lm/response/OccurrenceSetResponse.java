package landingpage.lm.response;

import landingpage.lm.container.OccurrenceSet;

/*
 * Occurrence set REST response
 */

public class OccurrenceSetResponse {
	private boolean success;
	private OccurrenceSet occurset;

	public OccurrenceSetResponse(boolean success, OccurrenceSet occurset) {
		this.success = success;
		this.occurset = occurset;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public OccurrenceSet getOccurset() {
		return occurset;
	}

	public void setOccurset(OccurrenceSet occurset) {
		this.occurset = occurset;
	}
}

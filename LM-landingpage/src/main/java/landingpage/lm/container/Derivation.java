package landingpage.lm.container;

public class Derivation {
	private String VM_PID;
	private String VM_identifier;
	private String relation;
	private String annotation;
	
	public Derivation(String VM_PID, String VM_identifier, String relation, String annotation)
	{
		this.VM_PID = VM_PID;
		this.VM_identifier = VM_identifier;
		this.relation = relation;
		this.annotation = annotation;
	}

	public String getVM_PID() {
		return VM_PID;
	}

	public void setVM_PID(String vM_PID) {
		VM_PID = vM_PID;
	}

	public String getVM_identifier() {
		return VM_identifier;
	}

	public void setVM_identifier(String vM_identifier) {
		VM_identifier = vM_identifier;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}
}

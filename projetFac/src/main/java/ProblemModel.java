
public class ProblemModel {

	private int problemId;
	private int alternativeId;
	private String alternativeName;
	private int critereId;
	private String critereName;
	private int evalId;
	private int evalValue;
	private String evalName;
	
	public ProblemModel(int problemId) {
		this.problemId = problemId;
	}

	public int getProblemId() {
		return problemId;
	}

	public void setProblemId(int problemId) {
			this.problemId = problemId;				
	}

	public int getAlternativeId() {
		return alternativeId;
	}

	public void setAlternativeId(int alternativeId) {
		this.alternativeId = alternativeId;
	}

	public String getAlternativeName() {
		return alternativeName;
	}

	public void setAlternativeName(String alternativeName) {
		this.alternativeName = alternativeName;
	}

	public int getCritereId() {
		return critereId;
	}

	public void setCritereId(int critereId) {
		this.critereId = critereId;
	}

	public String getCritereName() {
		return critereName;
	}

	public void setCritereName(String critereName) {
		this.critereName = critereName;
	}

	public int getEvalId() {
		return evalId;
	}

	public void setEvalId(int evalId) {
		this.evalId = evalId;
	}

	public int getEvalValue() {
		return evalValue;
	}

	public void setEvalValue(int evalValue) {
		this.evalValue = evalValue;
	}

	public String getEvalName() {
		return evalName;
	}

	public void setEvalName(String evalName) {
		this.evalName = evalName;
	}
	
	
}

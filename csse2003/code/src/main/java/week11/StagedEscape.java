package week11;

/**
 * A fake escape staged to entrap a prisoner
 */
public class StagedEscape implements Response {
	
	Person target;
	
	public StagedEscape(Person target) {
		this.target = target;
	}
	
	public Person getTarget() {
		return target;
	}

}

package task;

public class Task {
	public Task(int importance) {
		this.importance = importance;
	}

	// the more importance, the more priority
	private int importance;
	
	
	/**
	 * 
	 * @return importance of each task performed, which can be utilized later
	 */
	public int perform() {

		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getImportance();
	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}
	
	
}

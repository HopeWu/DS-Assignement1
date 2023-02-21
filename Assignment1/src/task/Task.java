package task;

public class Task {
	public Task(int importance) {
		this.importance = importance;
	}

	// the more importance, the more priority
	private int importance;
	
	
	
	public void perform() {
		// do a heavy task that needs 10 milliseconds
//		try {
//			Thread.sleep(1);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}
	
	
}

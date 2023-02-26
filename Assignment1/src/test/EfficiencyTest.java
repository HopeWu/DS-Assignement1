package test;

import java.util.ArrayList;

import queue.Queue;
import task.Task;


/**
 * Compare two queues, efficiency wise.
 * Compare the average workload performed, given the same amount of time period, within one millisecond, given
 * the same task population, sized by this.datasize. Note that although the size of actually performed tasks is fixed and 
 * set by this.batchSize, the tasks performed by the two varies due to their different strategies. e.g. a standard queue
 * simply follows a FIFO manner. a priority queue lets the task with highest priority to perform first. Thus, there is
 * always more high-importance tasks performed by a priority queue than a standard queue.
 * 
 * We will compose the two queues into two different cpus and test on the cpus. A cpu can be treated like a wrapper
 * of a queue.
 * 
 * @author haopengwu
 */
public class EfficiencyTest {

	private Queue queue1;
	private Queue queue2;
	// Create test data
	private Dataset dataset;
	private int datasize;
	private int batchSize;

	EfficiencyTest() {
		this.dataset = new Dataset();
	}

	/**
	 * The first queue to be composed in a cpu and then tested.
	 * @param queue1
	 */
	public void setQueue1(Queue queue1) {
		this.queue1 = queue1;
	}

	/**
	 * The second queue to be composed in a cpu and then tested.
	 * @param queue2
	 */
	public void setQueue2(Queue queue2) {
		this.queue2 = queue2;
	}

	/**
	 * Set the population size for the same data set to be performed on by the two queues.
	 * @param datasize
	 */
	public void setDatasize(int datasize) {
		this.datasize = datasize;
	}

	/**
	 * The size of tasks that are actually performed by the two queues.
	 * @param batchSize
	 */
	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}

	
	/**
	 * 
	 * Configure the probability of occurrence for the tasks with the specified importance. 
	 * e.g. setDatasetProbability(100, 0.1); means the 10% tasks from the population is of importance 100.
	 * 
	 * @param importance
	 * @param probability
	 */
	public void setDatasetProbability(int importance, double probability) {
		this.dataset.setProbability(importance, probability);
	}

	/**
	 * Run the configured task.
	 */
	public void run() {
		_run();
	}

	private int[] _run() {
		/*
		 * construct the two cpus.
		 */

		// Compose the queues with correspondent cpu
		Cpu stdCpu = new Cpu(this.queue1);
		Cpu priCpu = new Cpu(this.queue2);

		// Generate the tasks to assgin to both cpus
		Task[] tasks = dataset.getData(datasize);

		// Load the same work to both cpus
		stdCpu.assign(tasks);
		priCpu.assign(tasks);

		/**
		 * Take the first @TIMES tasks as samples to calculate the the average workload
		 * done within 1 millisecond
		 */
		long start = 0;
		long end = 0;
		// To save working time in milliseconds
		ArrayList<Long> elapsedTime = new ArrayList<Long>();

		Task[] stdTasks, priTasks;
		int stdWork, priWork;

		// Let them run and save the elapsed time.
		start = System.currentTimeMillis();
		stdTasks = stdCpu.performTimesOf(batchSize);
		end = System.currentTimeMillis();
		stdWork = workloadOf(stdTasks);
		elapsedTime.add(end - start);
		System.out.printf("Workload of %s Cpu: %d\n", queue1, stdWork);
		System.out.printf("Time for %s: %d\n", queue1, elapsedTime.get(0));
		System.out.println();

		start = System.currentTimeMillis();
		priTasks = priCpu.performTimesOf(batchSize);
		end = System.currentTimeMillis();
		priWork = workloadOf(priTasks);
		elapsedTime.add(end - start);
		System.out.printf("Workload of %s Cpu: %d\n", queue2, priWork);
		System.out.printf("Time for %s: %d\n", queue2, elapsedTime.get(1));

		// Calculate the efficiencies
		int efficiency1 = (int) (stdWork / elapsedTime.get(0));
		int efficiency2 = (int) (priWork / elapsedTime.get(1));
		
		System.out.println();

		System.out.print("Task population: ");
		System.out.println(Dataset.checkDistruibutionOf(tasks));
		System.out.println();
		System.out.printf("%s tasks's distribution: ", queue1);
		System.out.println(Dataset.checkDistruibutionOf(stdTasks));
		System.out.printf("%s tasks's distribution: ", queue2);
		System.out.println(Dataset.checkDistruibutionOf(priTasks));

		System.out.println();
		System.out.printf("Efficiency for %s is: %d\n", queue1, efficiency1);
		System.out.printf("Efficiency for %s is: %d\n", queue2, efficiency2);

		return new int[] { efficiency1, efficiency2 };
	}

	int workloadOf(Task[] tasks) {
		int sum = 0;
		for (int i = 0; i < tasks.length; ++i) {
			sum += tasks[i].getImportance();
		}
		return sum;
	}

}

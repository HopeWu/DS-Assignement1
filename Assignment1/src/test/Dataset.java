package test;

import java.util.Hashtable;
import java.util.Random;

import task.Task;

public class Dataset {
	public Dataset() {
		super();
		this.rand = new Random();
		this.upperbound = 10;
	}

	// to save the input distribution of data
	private Hashtable<Integer, Double> distribution;
	// to save the rescaledDist of data
	private Hashtable<Integer, Double> rescaledDist;
	// to save the generate dictionary, according to which we generate importance
	private Hashtable<Integer, Integer> generatingDict;
	// to generate random digit
	private Random rand;
	// upper bound, for generating random digits
	private int upperbound;

	public void setProbability(int digit, double probability) {
		if (this.distribution == null)
			this.distribution = new Hashtable<Integer, Double>();
		this.distribution.put(digit, probability);
	}

	public Task[] getData(int size) {
		/*
		 * Generate the testing data according to the distribution.
		 * 
		 * @size, how many tasks to generate
		 */
		
		if (this.distribution == null) {
			System.out.println("Error! Please set probabilities before.");
			return null;
		}

		/**
		 * So that the smallest probability can be seen.
		 */
		this.setDictionaries();
		
		int i = 0;
		Integer importance = 0;

		Task[] tasks = new Task[size];
		for (i = 0; i < tasks.length; ++i) {
			importance = this.generatingDict.get(this.randInt());
			tasks[i] = new Task(importance);
		}
		return tasks;
	}
	
	private void setDictionaries() {
		this.rescaledDist = new Hashtable<Integer, Double>();
		this.generatingDict = new Hashtable<Integer, Integer>();

		// scale the probabilities to make them sum to 1
		Double sum = 0.0;
		sum = this.distribution.values().stream().reduce((x, y) -> x + y).get();
		for (Integer key : this.distribution.keySet()) {
			this.rescaledDist.put(key, this.distribution.get(key) / sum );
		}
				
		setRandUpperBound();

		// prepare the generate dictionary
		int start = 1;
		for (Integer key : this.rescaledDist.keySet()) {
			int steps = (int) Math.round((this.rescaledDist.get(key) * upperbound));
			int _start = start;
			for (int i = _start; i < _start + steps; ++i, ++start) {
				this.generatingDict.put(i, key);
			}
		}
	}
	
	/**
	 * So that the smallest probability can be seen.
	 */
	private void setRandUpperBound() {
		double smallest = Double.POSITIVE_INFINITY;;
		for (Integer key : this.rescaledDist.keySet()) {
			if(this.rescaledDist.get(key) < smallest)
				smallest = this.rescaledDist.get(key);
		}
		this.upperbound = (int) Math.ceil(1.0/smallest);
	}

	/*
	 * randomly return ints from 0 to 9
	 */
	private int randInt() {
		
		// Setting the upper bound to generate the
		// random numbers in specific range
		
		return rand.nextInt(upperbound)+1;
	}
	
	/**
	 * Check the importance distribution of a bunch of tasks. 
	 * Return a hashtable, which shows the counts of each importance within a given 
	 * bunch of tasks.
	 * @param tasks
	 * @return
	 */
	public static Hashtable<Integer, Integer> checkDistruibutionOf(Task[] tasks){
		Hashtable<Integer, Integer> hashtable = new Hashtable<>();
		int i;
		for(i = 0; i < tasks.length; ++i) {
			Integer importance = tasks[i].getImportance();
			Integer count = hashtable.get(importance);
			if (count == null) 
				hashtable.put(importance, 1);
			else 
				hashtable.put(importance, ++count);
		}
		return hashtable;
	}
	
	/*
	 * examples to use this class
	 */
	public static void main(String[] args) {
		// configure the distribution for the data
		Dataset dataset = new Dataset();
		dataset.setProbability(1, 0.1);
		dataset.setProbability(10, 0.7);
		dataset.setProbability(5, 0.2);
		Task[] tasks = dataset.getData(100);
		for (Task task: tasks) {
			System.out.println(task.getImportance());
		}
	}

}

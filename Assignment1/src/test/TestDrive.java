package test;

import java.util.ArrayList;
import java.util.Hashtable;

import halfPrioQueue.HalfPrioQueueByArr;
import halfPrioQueue.HalfPrioQueueByLinkedList;
import priorityQueue.PriorityQueueBySinglyLinkedList;
import priorityQueue.PriorityQueueByDoublyLinkedList;
import queue.Queue;
import standardQueue.StandardQueueByArr;
import standardQueue.StandardQueueByLinkedList;
import task.Task;

public class TestDrive {
	static public void main(String[] string) {

		experimentOne();
	}
	
	static void experimentOne() {
		
		EfficiencyTest efficiencyTest = new EfficiencyTest();
		
		efficiencyTest.setQueue1(new StandardQueueByLinkedList());
		efficiencyTest.setQueue2(new HalfPrioQueueByLinkedList());
		efficiencyTest.setDatasize(1000);
		efficiencyTest.setBatchSize(100);
		efficiencyTest.setDatasetProbability(100, 0.1);
		efficiencyTest.setDatasetProbability(1, 1.0);
		efficiencyTest.run();
	}
	static void experimentTwo() {
		
	}
}

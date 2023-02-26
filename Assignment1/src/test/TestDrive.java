package test;

import java.util.ArrayList; 
import java.util.Hashtable;

import halfPrioQueue.HalfPrioQueueByArr;
import halfPrioQueue.HalfPrioQueueByLinkedList;
import halfPrioQueue.HalfPrioQueueByLinkedListImp1;
import priorityQueue.PriorityQueueBySinglyLinkedList;
import priorityQueue.PriorityQueueByDoublyLinkedList;
import queue.Queue;
import standardQueue.StandardQueueByArr;
import standardQueue.StandardQueueByLinkedList;
import standardQueue.StandardQueueByLinkedListOptim;
import task.Task;

public class TestDrive {
	static public void main(String[] string) {

		experimentOne();
	}
	
	static void experimentOne() {
		
		EfficiencyTest efficiencyTest = new EfficiencyTest();
		
		Queue queue1 = new StandardQueueByLinkedListOptim();
		HalfPrioQueueByLinkedListImp1 queue2 = new HalfPrioQueueByLinkedListImp1();
		queue2.setThreshold(50);
		
		efficiencyTest.setQueue1(queue1);
		efficiencyTest.setQueue2(queue2);
		final int S = 1;
		efficiencyTest.setDatasize(S*1000);
		efficiencyTest.setBatchSize(S*100);
		efficiencyTest.setDatasetProbability(100, 0.1);
		efficiencyTest.setDatasetProbability(1, 0.9);
		efficiencyTest.run();
	}

}

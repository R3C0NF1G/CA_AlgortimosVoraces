package co.edu.unbosque.model;

import java.util.ArrayList;

public class TaskProblem {
	
	private ArrayList<Task> A; //The array that contains all the activities
	//private ArrayList<Task> B; //The array that contains all the solution
	
	public TaskProblem() {
		A = new ArrayList<Task>();
	}
	
	/**
	 * This nested class is used to create local Task objects.
	 * By using this we improve encapsulation and we can store s, name and f attributes of a task in one object
	 * 
	 * @author RootSoftworks
	 *
	 */
	public class Task {
		private String name;
		private int s;
		private int f;
		
		public Task(String name, int s, int f) {
			this.s = s;
			this.f = f;
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getS() {
			return s;
		}

		public void setS(int s) {
			this.s = s;
		}

		public int getF() {
			return f;
		}

		public void setF(int f) {
			this.f = f;
		}
		
		
		
	}

	public void addTask(String name, int s, int f) {
		this.A.add(new Task(name, s, f));
		System.out.println("Added task");
	}
	
	public ArrayList<Task> solve() {
		//Defining the solution array
		ArrayList<Task> B = new ArrayList<Task>();
		
		//Adding the first element of the A array to B array
		B.add(A.get(0)); //The Index 0 will be our starting point
		int k = 0;
		
		//Lets start the greedy part
		//We start in index 1 because index 0 was already taken
		for(int i = 1; i < A.size(); i++) {
			//Lets check if we have compatible tasks
			if(A.get(i).getS() >= A.get(k).getF()) {
				//They are compatible, so lets add it to the solution array
				B.add(A.get(i));
				k = i; //Out last activity is now our next reference
			}
		}
		return B;
	}
	
}

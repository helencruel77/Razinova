import java.util.ArrayList;
import java.util.Random;

public class Planner {

	private int Count = 0;
	private ArrayList<Process> processes;
	Random randomTime = new Random ();
	Random randomCount = new Random ();
	
	public Planner(int Count) {
		this.Count = Count;
		processes = new ArrayList<Process>();
		for(int i = 1; i < Count; i++) {
			processes.add(new Process(i, randomTime.nextInt(10)+5, randomCount.nextInt(5) + 1));
		}
	}
	
	public void run() {
		while(processes.size() != 0) {
			for (int i = 0; i < processes.size(); i++) {
				System.out.println("Выполняется" + processes.get(i).getId());
				processes.get(i).run();
			}
		}
	}
	
	
}

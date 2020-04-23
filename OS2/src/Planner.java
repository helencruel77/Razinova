import java.util.List;

public class Planner {

	private int Count = 0;
	private List<Process> processes;
	int randomTime = (int) Math.random() * 7;
	int randomCount = (int) Math.random() * 5;
	
	public Planner(int Count) {
		for(int i = 0; i < Count; i++) {
			processes.add(new Process(i, randomTime, randomCount));
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

import java.util.List;

public class Planner {

	private int Count = 0;
	private List<Process> processes;
	int random = (int) Math.random() * 5;
	
	public Planner(int Count) {
		for(int i = 0; i < Count; i++) {
			processes.add(new Process(i, random));
		}
	}
	
	public void run() {
		while(!processes.isEmpty()) {
			for (int i = 0; i < processes.size(); i++) {
				System.out.println("Выполняется" + processes.get(i).getId());
				processes.get(i).run();
			}
		}
	}
	
	
}

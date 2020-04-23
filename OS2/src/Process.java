import java.util.List;

public class Process {

	private int id = 0;
	private int quant_Process = 0;
	private int time = 0;
	private List<Thread> threads;
	int randomTime = (int) Math.random() * 7;
	int randomCount = (int) Math.random() * 5;
	
	public Process (int id, int quant_Process, int Count) {
		this.id = id;
		this.quant_Process = quant_Process;
		this.time = quant_Process;
		
		for(int i = 0; i < Count; i ++) {
			threads.add(new Thread(i, randomTime, randomCount));
		}
	}
	
	public String getId() {
		return "Процесс" + id;
	}
	
	public int getQuant() {
		return quant_Process;
	}
	
	public Thread getThread()
    {
        if (threads.size() == 0) 
        	return null;
        return threads.get(0);
    }
	public int reduceTime() {
		--time;
		return time;
	}
	
	public void run() {
		if (getThread().getQuant() >= 0 ) {
			System.out.println(getThread().printWork());
			getThread().reduceQuant();
			reduceTime();
			if (getThread().getQuant() < 0) {
				System.out.println("Поток" + id + "выполнен");
				threads.remove(0);
			}
				
		}
	}
}


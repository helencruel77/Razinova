import java.util.ArrayList;
import java.util.Random;

public class Process {

	private int id;
	private int quant_Process;
	private int time;
	private int Count;
	private ArrayList<Thread> threads;
	Random randomTime = new Random ();
	Random randomCount = new Random ();
	
	public Process (int id, int quant_Process, int Count) {
		this.id = id;
		this.Count = Count;
		this.quant_Process = quant_Process;
		this.time = quant_Process;
		threads = new ArrayList<Thread>();
		for(int i = 0; i < Count; i ++) {
			threads.add(new Thread(i, 
					randomTime.nextInt(10)+5,
					randomCount.nextInt(5) + 1));
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
	
	public boolean restore() {
		if(threads.size() != 0 && getTime() == 0 && getThread().getQuant() > 0) {
			time = quant_Process;
			return true;
		}
		return false;
	}
	public int getTime() {
		return time;
	}
	
	public void run() {
		if (threads.size() != 0)
			System.out.println(getThread().printWork());
		if (threads.size() != 0 && getThread().getQuant() >= 0 ) {
			getThread().reduceQuant();
			reduceTime();
			if (getThread().getQuant() == 0) {
				System.out.println("Поток " + id + " выполнен");
				threads.remove(0);
			}
				
		}
	}

	public int Size() {
		if (threads.size() == 0) 
			return 0;
		return threads.size();
	}
}


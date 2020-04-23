
public class Thread {

	private int id = 0;
	private int quant_Thread = 0;
	private int work;
	private int Count = 0;
	
	public Thread (int id, int quant_Thread, int Count) {
		this.id = id;
		this.quant_Thread = quant_Thread;
		this.Count = Count;
	}
	
	public int getQuant() {
		return quant_Thread;
	}
	
	public int printWork() {
		work++;
		return work;
	}
	
	public int reduceQuant() {
		--quant_Thread;
		return quant_Thread;
	}
}

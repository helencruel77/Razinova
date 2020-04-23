
public class Thread {

	private int id = 0;
	private int quant_Thread = 0;
	
	public Thread (int id, int quant_Thread, int Count) {
		this.id = id;
		this.quant_Thread = quant_Thread;
	}
	public String getId() {
		return "Поток" + id;
	}
	public int getQuant() {
		return quant_Thread;
	}
}

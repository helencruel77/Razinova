
public class Process {

	private int id = 0;
	private int quant_Process = 0;
	
	public Process (int id, int quant_Process) {
		this.id = id;
		this.quant_Process = quant_Process;
	}
	
	public String getId() {
		return "Процесс" + id;
	}
	
	public int getQuant() {
		return quant_Process;
	}
	
	public void run() {
		
	}
}

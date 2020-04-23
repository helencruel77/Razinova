
public class Theard {

	private int id = 0;
	private int quant_Theard = 0;
	
	public Theard (int id, int quant_Theard) {
		this.id = id;
		this.quant_Theard = quant_Theard;
	}
	public String getId() {
		return "Поток" + id;
	}
	public int getQuant() {
		return quant_Theard;
	}
}

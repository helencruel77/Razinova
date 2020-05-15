
public class Page {

	private boolean availability;
	private boolean R;
	private int indexRealPage;
	
	public Page (boolean availability) {
		this.availability = availability;
	}
	
	public int getIndexRealPage() {
		return indexRealPage;
	}
	
	public boolean getAvailability() {
		return availability;
	}
	
	public void setR(boolean R) {
		this.R = R;
	}
	
	public boolean getR() {
		return R;
	}
	
}

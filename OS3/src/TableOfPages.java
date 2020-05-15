import java.util.LinkedList;
import java.util.List;

public class TableOfPages {

	private LinkedList<Page> pagesRecords;
	
	public TableOfPages() {
		pagesRecords = new LinkedList<Page>();
	}
	
	public int Size() {
		return pagesRecords.size();
	}
}

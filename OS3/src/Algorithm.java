import java.util.LinkedList;

public class Algorithm {

	private TableOfPages virtualMemory;
	private LinkedList<Page > realMemory;
	private LinkedList<Integer> loanMemory;
	
	public Algorithm (TableOfPages virtualMemory,
			LinkedList<Page> realMemory, LinkedList<Integer> loanMemory) {
		this.virtualMemory = virtualMemory;
		this.realMemory = realMemory;
		this.loanMemory = loanMemory;
	}
	
	public Object[] LRU(Page page) {
		Object[] result = new Object[3];
		int flag = 0;
		int[] lastUsed = new int[realMemory.size()];
		for(int i = 0; i < lastUsed.length; i++) {
			lastUsed[i] = -1;
		}
		point:
		for(int j = 0; j < loanMemory.size(); j ++) {
			for(int k = 0; k < virtualMemory.Size(); k++) {
				if(virtualMemory.Get(k).getAvailability() && page.getR() &&
						lastUsed[virtualMemory.Get(k).getIndexRealPage()] == -1) {
					lastUsed[virtualMemory.Get(k).getIndexRealPage()] = j;
					if (getAllUsed(lastUsed)) {
						flag = getMinElement(lastUsed);
						break point;
					}
				}
			}
		}
		realMemory.get(flag).setAvailability(false);
		realMemory.get(flag).setIndexRealPage(-43424);
		realMemory.remove(flag);
		page.setIndexRealPage(flag);
        page.setAvailability(true);
        result[0] = realMemory;
        result[1] = virtualMemory.getPagesRecords();
        result[2] = loanMemory;
		return result;
	}
	
	private int getMinElement( int[] elements) {
		int min = elements[0];
    	int index = 0;
    	for (int i = 0; i < elements.length; i++) {
    		if (elements[i] < min) {
    			min = elements[i];
    			index = i;
    		}
    	}
    	return index;
	}
	
	private boolean getAllUsed (int[] all) {
		for ( int i = 0; i < all.length; i++) {
			if(all[i] == 1) {
				return false;
			}
		}
		return true;
	}
}

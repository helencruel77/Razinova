import java.util.LinkedList;

public class Algorithm {

	private TableOfPages virtualMemory;
	private LinkedList<Page > realMemory;
	private LinkedList<Integer> loanMemory;
	
	public Algorithm (TableOfPages virtualMemory,
			LinkedList<Page> realMemory) {
		this.virtualMemory = virtualMemory;
		this.realMemory = realMemory;
		this.loanMemory = loanMemory;
	}
	
	public int[] LRU(Page page) {
		int[] result = new int[3];
		int flag = 0;
		int[] lastUsed = new int[realMemory.size()];
		for(int i = 0; i < lastUsed.length; i++) {
			lastUsed[i] = -1;
			for(int j = 0; j < loanMemory.size(); j ++) {
				int temp = loanMemory.get(i);
			}
		}
		return result;
	}
}

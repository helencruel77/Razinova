import java.util.LinkedList;

public class DispatcherOfMemory {

	private TableOfPages virtualMemory;
	private LinkedList<Page> realMemory;
	private LinkedList<Integer> loanMemory = new LinkedList<>();  ;
	private int frame;
	
	public DispatcherOfMemory(int RAM, int sizePage) {
		virtualMemory = new TableOfPages();
		realMemory = new LinkedList<Page>();
		frame = RAM / sizePage;
		for (int i = 0; i < RAM*2; i++) {
			Page page = new Page(false);
			page.setIndexRealPage(-43424);
			virtualMemory.add(page);
		}
	}
	public void insert(int pageIndex) {
		Object[] resultObjects;
    	Algorithm algorithm = new Algorithm(virtualMemory, realMemory, loanMemory);
    	Page page = virtualMemory.Get(pageIndex);
    	 if(!page.getAvailability()){
    		 if(realMemory.size() < frame){
    			 page.setAvailability(true);
    			 realMemory.add(page);
    			 int indexOfPageFrames = realMemory.indexOf(page);
    			 page.setIndexRealPage(indexOfPageFrames);
    			 loanMemory.add(pageIndex);
    		 }
    		 else if(realMemory.size() == frame) {
    			 resultObjects = algorithm.LRU(page);
    			 loanMemory.add(pageIndex);
    			 realMemory = (LinkedList<Page>)resultObjects[0];
                 virtualMemory.setPagesRecords((LinkedList<Page>)resultObjects[1]);
                 loanMemory = (LinkedList<Integer>)resultObjects[2];
    		 }
    	 }
    	 System.out.println("Физическая память");
    	 for (int i = 0; i < realMemory.size(); i++) {
    		 Page Frame = realMemory.get(i);
    		 System.out.println("i = " + i + "; Проверка присутствия " + Frame.getIndexRealPage());
    	 }
    	 System.out.println("Виртуальная память");
    	 for (int i = 0; i < virtualMemory.Size(); i++) { 
    		 Page Page = virtualMemory.Get(i);
    		 System.out.println("i = " + i + "; Проверка присутствия = "
                     + Page.getIndexRealPage() + "; Индекс кадра = " + Page.getIndexRealPage());
    	 }
    	 
	}
	public int getVirtualMemorySize(){
        return virtualMemory.Size();
    }
}

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;

public class Kernel {
	Stack stack;
    public HashMap<Integer, SystemCall> SystemCalls;
    
    public Kernel(Stack stack)
    {
        this.stack = stack;
        SystemCalls = new HashMap<>();
        SystemCalls.put(10,new SystemCall("a"));
        SystemCalls.put(11,new SystemCall("a", "b"));
        SystemCalls.put(12,new SystemCall("a", "b", "c"));
        SystemCalls.put(13,new SystemCall("a", "b", "c","d"));
        SystemCalls.put(14,new SystemCall("a", "b", "c","d","e"));
    }

    public void ExecuteCall(int id){
    	if (id < 0 || id >= SystemCalls.size()){
            System.out.print("Неверный id\n");
            return;
        }
        List<String> args = SystemCalls.get(id).getArgs();

        ArrayList list = new ArrayList();
      
        while(true) {
        	try {
        		list.add(stack.pop());
        	}
        	catch(Exception ex) {
        		break;
        	}
        }

        if (list.size() != args.size()){
            System.out.print("Кол-во аргументов не совпадает");
            return;
        }

        for (int i = args.size() - 1; i >= 0; i--) {
            if (!stack.pop().equals(args.get(i))) {
                System.out.print("Аргументы не совпадают");
                return;
            }
        }
        System.out.print(SystemCalls.get(id).Execute());

    }

}

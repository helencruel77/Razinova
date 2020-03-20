import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;

public class Kernel {
	Stack stack;
    public HashMap<Integer, SystemCall> SystemCalls = new HashMap<Integer, SystemCall>();
    public Kernel(Stack stack)
    {
        this.stack = stack;
        SystemCalls.put(10,new SystemCall(new Arguments("str")));
        SystemCalls.put(11,new SystemCall(new Arguments("int","str")));
        SystemCalls.put(12,new SystemCall(new Arguments("str","str")));
        SystemCalls.put(13,new SystemCall(new Arguments("int","int")));
        SystemCalls.put(14,new SystemCall(new Arguments("int")));
    }

    public void ExecuteCall(int id){
    	if (!SystemCalls.containsKey(id)){
            System.out.print("Вызов номер "+id+" не существует\n");
            return;
        }

        ArrayList list = new ArrayList();
      
        for (int i = 0; i< list.size(); i++) {
        	if(stack.pop()!=null)
        		list.add(stack.pop());
        }
        if(list.size()==0) {
        	System.out.print("Количество аргументов не совпадает");
        	return;
        }

        for (int i = 0; i<list.size(); i++) {
        	if(list.get(i) != "int" || list.get(i) != "str") {
        		System.out.print("Неверный аргумент");
        		return;
        	}
        }
        
        System.out.print(SystemCalls.get(id).Execute());

    }
}

import java.util.Arrays;
import java.util.List;

public class SystemCall {
	private List<String> Arguments;
    public SystemCall(String... args) {
        Arguments = Arrays.asList(args);
    }
    
    public List getArgs(){
        return Arguments;
    }

    public String Execute(){
    	return "Вызов выполнен";
    }

}

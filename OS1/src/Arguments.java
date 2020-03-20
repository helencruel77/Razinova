import java.util.Arrays;
import java.util.List;

public class Arguments {
	private List<String> list;
	 public Arguments(String... args) {
	        list = Arrays.asList(args);
	    }
	 public List<String> getArgs(){
	        return list;
	    }
}

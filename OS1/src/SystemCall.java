import java.util.Arrays;
import java.util.List;

import com.sun.jdi.connect.Connector.Argument;

public class SystemCall {
	private Arguments argument;
    public SystemCall(Arguments argument) {
        this.argument = argument;
    }
    
    public Arguments getArgs(){
        return argument;
    }

    public String Execute(){
    	return "Вызов выполнен";
    }

}

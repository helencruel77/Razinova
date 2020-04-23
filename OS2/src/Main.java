import java.util.Random;

public class Main {
	public static void main(String[] args) throws Exception {
		int random = (int) Math.random() * 5;
		Planner planner = new Planner(random);
	}
}

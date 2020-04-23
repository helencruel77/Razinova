import java.util.Random;

public class Main {
	public static void main(String[] args) throws Exception {
		Random random = new Random ();
		Planner planner = new Planner(random.nextInt(5) + 1);
		planner.run();
	}
}

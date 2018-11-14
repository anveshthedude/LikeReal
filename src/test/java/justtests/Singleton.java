package justtests;

public class Singleton {

	private static Singleton single_instance = null;

	private Singleton() {

	}

	public static Singleton get_instance() {

		if (single_instance == null)
			single_instance = new Singleton();
		return single_instance;
	}

}

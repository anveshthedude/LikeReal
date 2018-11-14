package justtests;

public class Singleton_Test {

	
	Singleton single; // not allowing to create object of Singleton class
	
	public static void main(String[] args) {
		Singleton.get_instance();
	}
	
}

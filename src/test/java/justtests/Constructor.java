package justtests;

import org.openqa.selenium.WebDriver;

public class Constructor {
	
	private String one;
	private String two = "two";
	
	public Constructor(){
	//this.one="two";
		one = "two";
		System.out.println(one);
		System.out.println("this is constroctor");
		
	}

	public Constructor(int a){
		this.two="three";
		String two="four";
		System.out.println(this.two);
		System.out.println("this is second constructor"    +a);
	}
	
}

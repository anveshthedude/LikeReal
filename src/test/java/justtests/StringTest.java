package justtests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StringTest {

	public static void main(String[] args) throws IOException {
		//stre();
		String a = "12345";
		
		String a1 = "My life is moving  ";

		System.out.println("index "+a1.indexOf("v"));
		System.out.println("charAT"+a1.charAt(5));
		System.out.println("a1="+a1);
		System.out.println("a1="+a1.trim());
		System.out.println("compare"+a1.equalsIgnoreCase(a));
		System.out.println("sub"+a1.substring(3, 7));
		System.out.println("replaceal"+a1.replaceAll("My", "ur"));
		System.out.println("REPLACE"+a1.replace(" ", "bike"));
		
		System.out.println("so"+a1.indexOf("i", a1.indexOf("i")+5));
		
		String one = "13579";
		StringBuffer ss = new StringBuffer();
		ss= ss.append(one);
		
		System.out.println("rever is rever"+ss.reverse());
		String lie = "afkj123jdslfkj123ajflj123";
		
		
		
	String	li= lie.replaceAll("[^0-9]", "");
	Set<Character> set = new HashSet<Character>();
	StringBuffer nn = new StringBuffer();
	
	for (Character i = 0; i <= lie.length(); i++) {
		Character al= li.charAt(i);
		if(set.contains(i))
			set.add(i);
			nn.append(i);
	}
	
		
	System.out.println("li"+li);
	
	
	
System.out.println("*******************************************");
		String avh = "abc123abc8464AFKJAKJDFOI9VAEW";

		avh = avh.replace("8464", "8888"); // To Replace data from a String like
											// 8464 to 8888
		 avh= avh.replaceAll("[^A-Z]", ""); // to Get only capital A-Z, if you need only caps letters from String then [^A-Z].
		
		System.out.println("replace all " + avh);

		int b = Integer.valueOf(a);
		System.out.println(b);

		int c = 987;
		String d = String.valueOf(c);
		System.out.println(d);// String test

		// String ab = new String("calling");
		String ab = "calling";

		// String lesss = new String();
		// String lesss = "";

		Set<Character> sor = new LinkedHashSet<Character>();
		StringBuffer and = new StringBuffer();

		for (int i = 0; i < ab.length(); i++) {
			char cha = ab.charAt(i);
			if (!sor.contains(cha)) {
				sor.add(cha);
				and.append(cha);
			}
		}

		System.out.println("result   nel  " + and.toString());
		String up = and.toString();
		System.out.println("all " + up);

		char ch = ab.charAt(4);
		System.out.println("second " + ch);

		String u = "123456789";
		StringBuffer bu = new StringBuffer(u); // StringBuffer class to reverse
												// a String value

		StringBuffer ii = new StringBuffer(); // Create object of StringBuffer
												// class
		ii.append(u); // Add a String by using append Mehtod
		System.out.println("let's see    " + ii.reverse()); // reverse String value by using Reverse method and print it. :)
															 																										 

		int h = u.length();
	
		String re = "";

		for (int i = h - 1; i >= 0; i--) {
			re = re + u.charAt(i); // it wil iterate values from back due to i--  the String value would be like {re+ u} means 9+8 then 98+7 etc.
									
									 
		}
		System.out.println("reverse 2    " + re);

	}

	public static void stre() throws IOException{
		String multi = "abc123abc123";

		System.out.println(" lol " + multi.replaceFirst("abc", ""));// Replace first method will be used to replace first values from a string to somethingg.
		System.out.println(multi.replaceAll("abc", ""));

		
		XSSFWorkbook name = new XSSFWorkbook(); // To read excel sheet. Add reference variable of fileiputstream in XssfWorkbook constructor like XSSFWorkbook(file); 
		//name.getSheet("sheet name");
		XSSFSheet name2 = name.getSheet("sheet name");
		name2.getLastRowNum();
		
		// to read a properties files 
		Properties file = new Properties();
		FileInputStream st = new FileInputStream("file");
		file.load(st);
	}

	
	
}

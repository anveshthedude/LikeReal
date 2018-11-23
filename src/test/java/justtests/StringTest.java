package justtests;

import java.util.LinkedHashSet;
import java.util.Set;

public class StringTest {

	public static void main(String[] args) {

		String a = "12341";

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

		System.out.println("result     " + and.toString());

		char ch = ab.charAt(4);
		System.out.println("second " + ch);

		String u = "123456789";
		StringBuffer bu = new StringBuffer(u);

		System.out.println("reverse " + bu.reverse());

		int h = u.length();
		String re = "";

		for (int i = h - 1; i >= 0; i--) {
			re = re + u.charAt(i);
		}
		System.out.println("reverse 2    " + re);
		
		
	}

}

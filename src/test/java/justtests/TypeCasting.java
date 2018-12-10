package justtests;

//import java.awt.List;
import java.util.ArrayList;
import java.util.List;

public class TypeCasting {
	public static void main(String[] args) {
		double d=200;
    	int i=(int)d;
    	
    	System.out.println(i);
    	
        ArrayList<String> ar=new ArrayList<String>();
        ar.add("20");

    	//ArrayList ar1=(ArrayList)ar;
    	//System.out.println(ar1);
        List<String> s=(List)ar;
        System.out.println("dlkfja" + s);
	}
  

    
    

}

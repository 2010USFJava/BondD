package FunImplemented;

import java.util.Date;

import AllTheFun.Clown;
import AllTheFun.Party;

public class Driver {

	public static void main(String[] args) {
		Date today = new Date();
		
		Party birthday = new Party ("Matt's House", today);
		Clown a= new Clown ("happy",birthday,20 );
		
		System.out.println(a);

	}

}

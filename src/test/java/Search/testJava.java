package Search;

import java.util.Date;

public class testJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stubpublic int currentDate ()
		{
			Date da = java.util.Calendar.getInstance().getTime();
			String date = da.toString();
			System.out.println(date);

			String[] st = date.split("\\s");

			String st3 = st[1] + st[2];
			int foo = Integer.parseInt(st[2]);
			System.out.println(foo);
			// return foo;
		}

	}

}

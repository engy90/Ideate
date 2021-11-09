package resources1;

import java.util.Date;

public class testtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Date da=java.util.Calendar.getInstance().getTime();
		String date = da.toString();
		System.out.println(date);
		
	     String[] st = date.split("\\s");
	
	    // String date1 = st[0].replaceAll("\\s","");
		System.out.println(st[2]);
		
		String[] number = st[2].split("0");
		
		System.out.println(number[1]);
		
	}

}

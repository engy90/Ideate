package superAdmin_ChallengeCreation;

import java.util.Date;

public class fortest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date da=java.util.Calendar.getInstance().getTime();
		String date = da.toString();
		System.out.println(date);
		
	     String[] st = date.split("\\:");
	
	     String date1 = st[0].replaceAll("\\s","");
		System.out.println(date1);
		
		String date2 = st[2].replaceAll("\\s","");
		System.out.println(date2);
		
		String time = st[1];
		System.out.println(time);
		String[] datearray = new String[]{date1,date2, time};
		
		
		//return datearray;]);
	System.out.println(datearray[1]);
	}

}
/*
 create idea with s=different title , descrption ...etc
 save Idea number 
 
 then search with title , description ..etc 
 compare with idea number 
 


*/
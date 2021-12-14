package superAdmin_ChallengeCreation;

import java.util.Date;

public class fortest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date da = java.util.Calendar.getInstance().getTime();
		String date = da.toString();
		System.out.println(date);

		String[] st = date.split("\\s");
        int foo = Integer.parseInt(st[2]);
		System.out.println(foo);
	}

}

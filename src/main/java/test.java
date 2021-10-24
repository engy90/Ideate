import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub// TODO Auto-generated method stub
		String dbURL="jdbc:oracle:thin:@//OQ-IDEATE-QA:1521/ORA12C" ;
		String userName = "OQ_IDEATE";
		String password = "oq_ideate";
		Connection con = DriverManager.getConnection(dbURL,userName,password);
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		Statement state = con.createStatement();
		
			 
			String quarterID = "Select max(quarter_id) from quarter";
			System.out.println(quarterID);
			String q1="DELETE FROM stages_shortlisted_ideas where idea_id in (SELECT IDEA_ID FROM IDEA WHERE QUARTER_ID = ";
			System.out.println(quarterID);
			String q2= "UPDATE quarter set stage_id = 1 where quarter_id = ";
			String q3= "delete from invited_judge where quarter_id =";
			String q4= "COMMIT";
		    
		
			ResultSet re= state.executeQuery(quarterID);
			 re.next();
				 String id = re.getString(1);
				 System.out.println(id);
				 String qq1 = q1+id+")";
				 System.out.println(qq1);
				 ResultSet r1 = state.executeQuery(qq1);
				 r1.next();
				 
				 String qq2 = q2+id;
				 ResultSet r2 = state.executeQuery(qq2);
				 r2.next();
				 
				 String qq3 = q2+id;
				 ResultSet r3 = state.executeQuery(qq3);
				 r3.next();
				 
				 
				  con.close();


	}

}

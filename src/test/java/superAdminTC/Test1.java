package superAdminTC;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test1 {

	
	public String[] testdataread(String usertype) throws IOException
	{
		
		FileInputStream fis =null;
			fis=  new FileInputStream("C:\\Users\\ihuser\\git\\Ideate\\src\\main\\java\\resources1\\testdataQA.xlsx") ;
		
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
	
		int sheets  = workbook.getNumberOfSheets();
		 String pass =null ;
		 String email1 = null ;
		 String[] data = new String [2];
		  
		for (int i=0;i<sheets ;i++)
		{
			String s= "@";
			System.out.println(workbook.getSheetName(i));
			if (workbook.getSheetName(i).equalsIgnoreCase(usertype))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator() ; 
				
				int count =sheet.getLastRowNum()-sheet.getFirstRowNum();
				System.out.println(count);
				
				
				for (int r = 0 ; r<=count ; r++)
				{
					Row firstrow = sheet.getRow(r);
					
					for (int j=0 ; j<firstrow.getLastCellNum() ; j++)
					{
						if (firstrow.getCell(j).getStringCellValue().contains(s))//  equalsIgnoreCase(email))
						{
							     email1 = firstrow.getCell(j).getStringCellValue();
                                 pass = firstrow.getCell(j+1).getStringCellValue();
                                 data[0]= email1;
                                 data[1]= pass;
                                 System.out.println(email1 + pass);
                         return data ; 
	                     }
					}
					
				}
			}
	}
		return data;
		
	}
}

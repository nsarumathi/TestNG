package readdata.Leaftap;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class EditdataExcel {
	public static String[][] readdata() throws IOException {
		XSSFWorkbook book = new XSSFWorkbook("./data/Leaftap/EditLead.xlsx");
		XSSFSheet sheet = book.getSheetAt(0);
		
		int rowcount = sheet.getLastRowNum();
		short columncount = sheet.getRow(0).getLastCellNum();
		//System.out.println("no of rows::"+rowcount);
		//System.out.println("no of colmn::"+columncount);
		
		String[][] data=new String[rowcount][columncount];
		for(int i=1;i<=rowcount;i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<columncount;j++) {
				XSSFCell colmn = row.getCell(j);
				String cellValue = colmn.getStringCellValue();
				//System.out.println(cellValue);
				data[i-1][j]=cellValue;}}
		book.close();
		return data;
		
}

	@DataProvider(name="fetchdata")
		public String[][] senddata() throws IOException {
			return EditdataExcel.readdata();}}

package readdata.Sericenow;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ServiceNow_data {
	public static String[][] senddata(String filename) throws IOException {
	  XSSFWorkbook workbook = new XSSFWorkbook("./data/Servicenow/"+filename+".xlsx");
	  XSSFSheet sheetAt = workbook.getSheetAt(0);
	  
	
	  int rowNum = sheetAt.getLastRowNum();
	  int cellNum = sheetAt.getRow(0).getLastCellNum();
	  
	  String[][] data= new String[rowNum][cellNum];
	  for(int i=1;i<=rowNum;i++) {
		  XSSFRow row = sheetAt.getRow(i);
		  for(int j=0;j<cellNum;j++) {
			  XSSFCell cell = row.getCell(j);
			  String cellValue = cell.getStringCellValue();
			  data[i-1][j]=cellValue;}}
      workbook.close();
		return data;
		
	}

}

package readdata.Leaftap;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DynamicDatafromExcel {
	public static String[][] readdata(String filename) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook("./data/Leaftap/"+filename+".xlsx");
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
		
}}

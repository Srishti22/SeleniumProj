//how to read and write the data to excel sheet
package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil 
{
	private static XSSFWorkbook wBook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	
	public static void setExcelPath(String sheetName,String path) throws IOException
	{
		FileInputStream fis =new FileInputStream(path);
		
		wBook=new XSSFWorkbook(fis);
		sheet=wBook.getSheet(sheetName);
		
	}
	
	public static String getCellData(int rownum,int colnum)
	{
		String cellData;
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		cellData=cell.getStringCellValue();
		return cellData;
		
	}
	
}

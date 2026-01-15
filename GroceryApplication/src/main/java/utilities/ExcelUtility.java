package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;

public class ExcelUtility {
	
	static FileInputStream f;//file details fetching class 
	static XSSFWorkbook wb; //get details from the workbook 
	static XSSFSheet   sh; // get details from the sheet
	public static String getStringData(int a,int b, String sheet) throws IOException  
	{
		//f=new FileInputStream("C:\\Users\\rethe\\eclipse-workspace\\GroceryApplication\\src\\test\\resources\\TestData.xlsx");//Excel sheet's path
		f=new FileInputStream(Constant.TESTDATA);
		wb= new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);//Add variable name sheet to remove hardcoding
		XSSFRow r =sh.getRow(a); // to get details from the row
		XSSFCell c = r.getCell(b); // column details
		return c.getStringCellValue();
	}
	public static String getIntegerData(int a, int b, String sheet) throws IOException 
	{
		//f= new FileInputStream("C:\\Users\\rethe\\eclipse-workspace\\GroceryApplication\\src\\test\\resources\\TestData.xlsx");
		f= new FileInputStream(Constant.TESTDATA);
		wb= new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);
		XSSFRow r=sh.getRow(a);
		XSSFCell c= r.getCell(b);
		int x=(int) c.getNumericCellValue();// double values converting to int(type casting)
		return String.valueOf(x);
		
	}

}


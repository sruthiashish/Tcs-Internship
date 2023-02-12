package com.tcs.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	FileInputStream ofile;
	XSSFWorkbook oworkbook;
	XSSFSheet osheet;
	XSSFRow orow;
	XSSFCell ocell;
	public ExcelUtility(String fileName,String sheetName) throws IOException
	{
	this.ofile=new FileInputStream(fileName);
	this.oworkbook= new XSSFWorkbook(ofile);
	this.osheet=oworkbook.getSheet(sheetName);}
	
	
	public String getExcelData(int rowNo,int colNo)
	{
		String content=null;
		try
		{		this.orow=osheet.getRow(rowNo);
		this.ocell=orow.getCell(colNo);
		content=ocell.getStringCellValue();
		System.out.println("Value from excel is::"+content);

	}catch (Exception e) {
		e.printStackTrace();
	}
return content;
}

		
	public String getExcelData(String fileName,String sheetName,int rowNo,int colNo)
	{
		String content=null;
		try
	{
		FileInputStream ofile=new FileInputStream(fileName);
		XSSFWorkbook oworkbook= new XSSFWorkbook(ofile);
		XSSFSheet osheet=oworkbook.getSheet(sheetName);
		XSSFRow orow=osheet.getRow(rowNo);
		XSSFCell ocell=orow.getCell(colNo);
		
		content=ocell.getStringCellValue();
		

		System.out.println("Value from excel is::"+content);

	}catch (Exception e) {
		e.printStackTrace();// TODO: handle exception
	}
		return content;
	}


	public String getExcelData(int rowN0, String colName) {
		// TODO Auto-generated method stub
		String content=null;
		int colNo=0;
		try
		{	
			orow=osheet.getRow(0);
			for(int i=0;i<=orow.getLastCellNum();i++)
			{
				if(orow.getCell(i).getStringCellValue().equalsIgnoreCase(colName))
				{
					colNo=i;
					break;
				}
			}
			this.orow=osheet.getRow(rowN0);
		 this.ocell=orow.getCell(colNo);

		content=ocell.getStringCellValue();

		
		System.out.println("Value from excel is::"+content);

	}catch (Exception e) {
		e.printStackTrace();
	}
return content;

	}
	public int getTotalRows()
	{
		return osheet.getLastRowNum();}
	}




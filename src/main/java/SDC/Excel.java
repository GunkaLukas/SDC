package SDC;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	XSSFWorkbook wb;
	ArrayList<Long> excelContent; 
	
	public Excel(String path, int numSheet, int numColumn)throws IOException {
		loadFile(path);
		loadContent(numSheet, numColumn);
	}

	/**
	 * Load data from "xml" file to "wb" work book
	 * @param path your xml file
	 */
	private void loadFile(String path) throws IOException {
		InputStream inst = new FileInputStream(path);
		wb = new XSSFWorkbook(inst);
		wb.close();
	}

	/**
	 * Load data from work book and insert them to "excelContent" list
	 * @param numSheet  number of sheet -1
	 * @param numColumn number of column -1
	 */
	private void loadContent(int numSheet, int numColumn) throws IOException {
		XSSFSheet sheet = wb.getSheetAt(numSheet);
		DataFormatter formatter = new DataFormatter();
		excelContent = new ArrayList<Long>();
		Row row;
		Cell cell;

		Iterator<Row> itr = sheet.iterator();
		while (itr.hasNext()) {
            row = itr.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
            	cell = cellIterator.next();
            	if(cell.getColumnIndex() == numColumn ) {
            		try {
						excelContent.add(Long.parseLong(formatter.formatCellValue(cell)));
            		}
            		catch (NumberFormatException e) {};
            	}
            }
		}
	}
	
	/**
	 * @return "excelContent" arrayList with content of work book
	 */
	public ArrayList<Long> getContent(){
		return excelContent;
	}
}

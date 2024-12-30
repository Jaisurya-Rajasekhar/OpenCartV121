package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFColor;

public class ExcelUtility {

    private FileInputStream fi;
    private FileOutputStream fo;
    private XSSFWorkbook wb;
    private XSSFSheet ws;
    private XSSFRow row;
    private XSSFCell cell;
    private String path;

    public ExcelUtility(String path) {
        this.path = path;
    }

    public int getRowCount(String xlsheet) throws IOException {
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        int rowCount = ws.getLastRowNum();
        wb.close();
        fi.close();
        return rowCount;
    }

    public int getCellCount(String xlsheet, int rownum) throws IOException {
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);
        int cellCount = row.getLastCellNum();
        wb.close();
        fi.close();
        return cellCount;
    }

    public String getCellData(String xlsheet, int rownum, int colnum) throws IOException {
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);
        cell = row.getCell(colnum);

        DataFormatter formatter = new DataFormatter();
        String data;

        try {
            data = formatter.formatCellValue(cell);
        } catch (Exception e) {
            data = "";
        }

        wb.close();
        fi.close();
        return data;
    }

    public void setCellData(String xlsheet, int rownum, int colnum, String data, boolean isValid) throws IOException {
        File xfile = new File(path);
        if (!xfile.exists()) {
            wb = new XSSFWorkbook();
            fo = new FileOutputStream(path);
            wb.write(fo);
        }

        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);

        if (wb.getSheetIndex(xlsheet) == -1) {
            wb.createSheet(xlsheet);
        }
        ws = wb.getSheet(xlsheet);

        if (ws.getRow(rownum) == null) {
            ws.createRow(rownum);
        }
        row = ws.getRow(rownum);

        cell = row.createCell(colnum);
        cell.setCellValue(data);
        
        

        // Apply Green for Valid and Red for Invalid
        CellStyle style = wb.createCellStyle();
        XSSFColor color = isValid ? 
            new XSSFColor(new java.awt.Color(0, 255, 0), null) : // Green
            new XSSFColor(new java.awt.Color(255, 0, 0), null);  // Red
        style.setFillForegroundColor(color);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);

        fo = new FileOutputStream(path);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }
}

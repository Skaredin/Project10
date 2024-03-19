package lisen7;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
public class Main {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Tovar");
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Tovar");
        headerRow.createCell(1).setCellValue("Harakteristica");
        headerRow.createCell(2).setCellValue("Stoimost");

        Row headerRow1 = sheet.createRow(1);
        headerRow1.createCell(0).setCellValue("Kniga");
        headerRow1.createCell(1).setCellValue("Janor: Fantastika, Avtor: Ivanov I.I.");
        headerRow1.createCell(2).setCellValue(500.0);

        Row headerRow2 = sheet.createRow(2);
        headerRow2.createCell(0).setCellValue("PS");
        headerRow2.createCell(1).setCellValue("Proc: i7-12700kf");
        headerRow2.createCell(2).setCellValue(56000);

        String filePath = "src/lisen7/example.xlsx";
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("File" + filePath);




    }
}
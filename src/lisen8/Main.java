package lisen8;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;


public class Main {
    public static void main(String[] args) throws IOException {
        String filePath ="src/lisen8/example.xlsx";
        FileInputStream inputStream = new FileInputStream(filePath);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Tovar");

        for (Row row:sheet)
        {
            for (Cell cell:row)
            {
                System.out.println(cell.toString() +"\t");

            }
            System.out.println();
        }
        workbook.close();
        inputStream.close();
    }
}

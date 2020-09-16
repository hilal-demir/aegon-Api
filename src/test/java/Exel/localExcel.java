package Exel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import mail.mail;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class localExcel {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public void createAnExcell(List<List<Object>> data, String Name) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(Name+".xlsx");
        String[][] array = new String[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            List<Object> row = data.get(i);
            array[i] = row.toArray(new String[row.size()]);
        }

        Object[][] bookData = array;

        int rowCount = 0;

        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(++rowCount);

            int columnCount = 0;

            for (Object field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }

        }


        try (FileOutputStream outputStream = new FileOutputStream("Test Reports/"+Name+".xlsx")) {
            workbook.write(outputStream);
        }
        logger.info(Name+".xlsx"+" dosyası oluşturuldu");
        mail Mail=new mail();
      //  Mail.sendReport(Name+".xlsx",count(array));
    }
    public String count(String[][] data){
        System.out.println("cont");
        int row = data.length;
        int col = data[0].length;
        int failCount=0;
        int passCount=0;
        int count;
        System.out.println(row);
        System.out.println(col);
        for (int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(data[i][j].equals("Fail")){

                    failCount++;
                }else if(data[i][j].equals("Pass")){
                    passCount++;
                }
            }
        }
        count=passCount+failCount;
        return "\nKoşulan senaryo= "+count+"\nPass= "+passCount+"\nFail= "+failCount;
    }

}

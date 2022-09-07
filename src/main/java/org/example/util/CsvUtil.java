package org.example.util;

import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.example.model.CustomerBalance;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CsvUtil {

    public List<CustomerBalance>  readCsv(String fileName) throws FileNotFoundException {
        List<CustomerBalance> customerBalances = new CsvToBeanBuilder(new FileReader(new File(fileName)))
                .withSeparator(';')  // custom CSV parser
                .withType(CustomerBalance.class)
                .build()
                .parse();

        return customerBalances;
    }

    public void writeCsv(List<CustomerBalance> customerBalances, String fileName) {

        CSVPrinter csvPrinter = null;
        FileWriter fileWriter = null;
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setRecordSeparator("\n").build();
        final Object[] CSV_FILE_HEADERS = {"id", "Nama", "Age", "Balanced", "No 2b Thread-No", "No 3 Thread-No", "Previous Balanced",
        "Average Balanced", "No 1 Thread-No", "Free Transfer", "No 2a Thread-No"};
        try {
            fileWriter = new FileWriter(fileName);
            csvPrinter = new CSVPrinter(fileWriter, csvFormat);
            csvPrinter.printRecord(CSV_FILE_HEADERS);
            for (CustomerBalance csvObject : customerBalances) {
                List<String> data = Arrays.asList(
                        String.valueOf(csvObject.getId()),
                        csvObject.getName(),
                        String.valueOf(csvObject.getAge()),
                        String.valueOf(csvObject.getBalanced()),
                        csvObject.getNo2bThread(),
                        csvObject.getNo3Thread(),
                        String.valueOf(csvObject.getPreviousBalanced()),
                        String.valueOf(csvObject.getAverageBalanced()),
                        csvObject.getNo1Thread(),
                        String.valueOf(csvObject.getFreeTransfer()),
                        csvObject.getNo2aThread()
                );
                csvPrinter.printRecord(data);
            }
        } catch (Exception e) {
            System.out.println("CSV writing error");
            e.printStackTrace();
        } finally {
            try {
                if(fileWriter != null) {
                    fileWriter.flush();
                    fileWriter.close();
                }
                if(csvPrinter != null) {
                    csvPrinter.close();
                }
            } catch (IOException e) {
                System.out.println("closing error");
                e.printStackTrace();
            }
        }
    }

}

package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadCsv implements Runnable {
    private String filePath;
    private List<CsvData> dataList;

    public ReadCsv(String filePath, List<CsvData> dataList) {
        this.filePath = filePath;
        this.dataList = dataList;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                CsvData csvData = new CsvData(values[0].trim(), Integer.parseInt(values[1].trim()));
                dataList.add(csvData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "C:\\Sarpemiu\\Laborator-java\\lab6\\src\\classes\\Truck_sales.csv";
        List<CsvData> dataList = new ArrayList<>();
        ReadCsv csvReader = new ReadCsv(filePath, dataList);

        Thread readerThread = new Thread(csvReader);
        readerThread.start();

        try {
            readerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Collections.sort(dataList);

        for (CsvData data : dataList) {
            System.out.println(data);
        }
    }
}

package HomeWork5;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class AppData {

    public static final String DELIMITER = ";";

    private String[] header;
    private Integer[][] data;

    public String[] getHeader() {
        return header;
    }

    public Integer[][] getData() {
        return data;
    }

    public void readFromFile(String file) {

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            ArrayList<Integer[]> rowsList = new ArrayList<>();
            header = (reader.readLine().split(DELIMITER));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] strArr = line.split(DELIMITER);
                Integer[] intArr = new Integer[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    intArr[i] = parseInt(strArr[i]);
                }
                rowsList.add(intArr);
            }
            data = rowsList.toArray(new Integer[][]{});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToCSV(String resultFileName) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultFileName), StandardCharsets.UTF_8));

            StringBuffer oneLine = new StringBuffer();
            for (int i = 0; i < header.length; i++) {
                oneLine.append(header[i]);
                oneLine.append(DELIMITER);
            }
            bw.write(oneLine.toString());
            bw.newLine();

            for (int i = 0; i < data.length; i++) {
                Integer[] rowData = data[i];
                oneLine.delete(0, oneLine.length());
                for (int j = 0; j < rowData.length; j++) {
                    oneLine.append(rowData[j]);
                    oneLine.append(DELIMITER);
                }
                bw.write(oneLine.toString());
                bw.newLine();
            }

            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
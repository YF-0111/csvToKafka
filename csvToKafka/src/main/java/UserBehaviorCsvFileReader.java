import com.csvreader.CsvReader;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class UserBehaviorCsvFileReader implements Supplier<UserBehavior> {

    private final String filePath;
    private CsvReader csvReader;

    public UserBehaviorCsvFileReader(String filePath) throws IOException {

        this.filePath = filePath;
        try {
            csvReader = new CsvReader(filePath);
            csvReader.readHeaders();
        } catch (IOException e) {
            throw new IOException("Error reading TaxiRecords from file: " + filePath, e);
        }
    }

    @Override
    public UserBehavior get() {
        UserBehavior userBehavior = null;
        try{
            if(csvReader.readRecord()) {
                csvReader.getRawRecord();
                System.out.println("id = "+csvReader.get(0)+"\ntime = "+csvReader.get(1)+"\nlati = "+csvReader.get(2)+"\nlong = "+csvReader.get(3));
                userBehavior = new UserBehavior(
                        csvReader.get(0),
                        csvReader.get(1),
                        Integer.valueOf(csvReader.get(2)),
                        Integer.valueOf(csvReader.get(3)),
                        Long.valueOf(csvReader.get(4)),
                        Double.valueOf(csvReader.get(5)),
                        Double.valueOf(csvReader.get(6)),
                        Double.valueOf(csvReader.get(7)),
                        Double.valueOf(csvReader.get(8)),
                        Double.valueOf(csvReader.get(9))
                        );
                System.out.println("id = "+csvReader.get(0)+"\ntime"+csvReader.get(1)+"\nlati"+csvReader.get(2)+"\nlong"+csvReader.get(3));
            }

        } catch (IOException e) {
            throw new NoSuchElementException("IOException from " + filePath);
        }

        if (null==userBehavior) {
            throw new NoSuchElementException("All records read from " + filePath);
        }
        System.out.println("UserBehaviorCsvFileReader");
        return userBehavior;
    }

}
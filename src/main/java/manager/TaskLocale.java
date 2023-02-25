package manager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskLocale {
    public static void main(String[] args) {
        String data1="1-12-2023";
        String data2="12/01/2023";
        System.out.println( data1.equals(data2));

        LocalDate local1 = LocalDate.parse(data1, DateTimeFormatter.ofPattern("d-MM-yyyy"));
        System.out.println(local1);

        LocalDate local2 = LocalDate.parse(data2, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(local2);

        System.out.println(local1.equals(local2));

        LocalDate now = LocalDate.now();
        System.out.println(now);

        int diff = now.getDayOfMonth()-local1.getDayOfMonth() ;

        System.out.println(local1.isBefore(now));
    }
}

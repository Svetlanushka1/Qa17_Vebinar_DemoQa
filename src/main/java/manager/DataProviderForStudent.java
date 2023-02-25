package manager;

import models.Student;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderForStudent {

    @DataProvider
    public Iterator<Object[]> myDPMethod(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Student.builder().firstName("John")
                .lastName("Dow")
                .email("john@mail.com")
                .gender("Male")
                .phone("12121234567")
                .birthday("30 June 2000")
                .subject("Math,Chemistry")
                .hobbies("Sports,Music")
                .address("Tel Aviv")
                .state("NCR")
                .city("Gurgaon").build()});


        list.add(new Object[]{Student.builder().firstName("Lisa")
                .lastName("Simpson")
                .email("lisa@mail.com")
                .gender("Female")
                .phone("12121234567")
                .birthday("30 June 2000")
                .subject("Math,Chemistry")
                .hobbies("Sports,Music")
                .address("Tel Aviv")
                .state("NCR")
                .city("Gurgaon").build()});
        list.add(new Object[]{Student.builder().firstName("Don")
                .lastName("Los")
                .email("don@mail.com")
                .gender("Male")
                .phone("12121234567")
                .birthday("30 June 2000")
                .subject("Math,Chemistry")
                .hobbies("Sports,Music")
                .address("Tel Aviv")
                .state("NCR")
                .city("Gurgaon").build()});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> myDPFile() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/Users/tayahatum/Qa17/Qa17_Vebinar_DemoQa/src/test/resources/data.csv")));
        String  line =bufferedReader.readLine(); // "Lisa,Simpson,Female,12121234567,30 June 2000,Math;Chemistry,Sports;Music,Tel Aviv,NCR,Gurgaon"
        while(line !=null){
            String [] split = line.split(",");// ["Lisa"] ["Simpson"] ["Female"]....
            list.add(new Object[]{Student.builder()
                    .firstName(split[0])
                    .lastName(split[1])
                    .email(split[2])
                    .gender(split[3])
                    .phone(split[4])
                    .birthday(split[5])
                    .subject(split[6])
                    .hobbies(split[7])
                    .address(split[8])
                    .state(split[9])
                    .city(split[10])
                    .build()});
            line=bufferedReader.readLine();

        }


        return list.iterator();
    }
}

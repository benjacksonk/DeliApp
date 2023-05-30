package org.yup.deliapp;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderManager {

    //Where the reader and writer are
    static LocalDateTime currentDateTime = LocalDateTime.now();
    static DateTimeFormatter receiptFormat = DateTimeFormatter.ofPattern("yyyy.MM.dd - hh:mm:ss");
    static String receiptDateTime = currentDateTime.format(receiptFormat);

    public static void orderWriter(){
        try{
            FileWriter receipt = new FileWriter(receiptDateTime + ".txt");
            BufferedWriter receiptWriter = new BufferedWriter(receipt);

        }catch(IOException e){
            System.out.println("ERROR");

        }
    }

    public static void orderReader(){
        try{
            FileReader receipt2 = new FileReader(receiptDateTime + ".txt");
            BufferedReader receiptReader = new BufferedReader(receipt2);

            String receiptLine;

            while (((receiptLine) = receiptReader.readLine()) != null) {
                System.out.println(receiptLine);
            }

        }catch(IOException e){
            System.out.println("ERROR: Cannot VIEW Receipt");

        }
    }
}

package org.yup.deliapp;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderManager {

    //Where the reader and writer are
    private static int orderCounter;
    private static final String ORDERS_DIRECTORY = "orders/";

    public OrderManager() {
        orderCounter = readOrderCounter();
    }

    public static void writeOrder(Order order) {
        int currentOrderNumber = incrementOrderCounter();
        String fileName = generateFileName(currentOrderNumber);

        try {
            FileWriter receipt = new FileWriter(fileName);
            BufferedWriter receiptWriter = new BufferedWriter(receipt);
            receiptWriter.write(orderToString(order));

        } catch (IOException e) {
            System.out.println("ERROR: Could not write receipt.");
            e.printStackTrace();
        }

        writeOrderCounter();
    }

    public static void readOrder(int orderNumber) {

        String fileName = generateFileName(orderNumber);

        try {
            FileReader receipt2 = new FileReader(fileName);
            BufferedReader receiptReader = new BufferedReader(receipt2);

            String receiptLine;

            while (((receiptLine) = receiptReader.readLine()) != null) {
                System.out.println(receiptLine);
            }

        } catch (IOException e) {
            System.out.println("ERROR: Cannot VIEW Receipt");

        }
    }

    public static int readOrderCounter() {
        try (BufferedReader reader = new BufferedReader(new FileReader("order_counter.txt"))) {
            String receiptLine = reader.readLine();
            return Integer.parseInt(receiptLine);
        } catch (IOException | NumberFormatException e) {
            return 0; // Default value if file not found or invalid value
        }
    }

    public static void writeOrderCounter() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("order_counter.txt"))) {
            writer.write(Integer.toString(orderCounter));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int incrementOrderCounter() {
        orderCounter++;
        return orderCounter;
    }

    public static String generateFileName(int orderNumber) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter receiptFormat = DateTimeFormatter.ofPattern("yyyy.MM.dd_hh:mm:ss");
        String receiptDateTime = currentDateTime.format(receiptFormat);

        return ORDERS_DIRECTORY + receiptDateTime + "_OrderNo.:" + orderNumber + ".txt";

    }

    public static String orderToString(Order order) {
        String orderStringFormat = String.format("");
        return orderStringFormat;
    }

    public static void stringToOrder(String orderStringFormat){

    }

}



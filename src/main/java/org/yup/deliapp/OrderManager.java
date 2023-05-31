package org.yup.deliapp;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

public class OrderManager {

    //Where the reader and writer are
    private static final String ordersDirectory = "orders/";

    public static void writeOrder(Order order) {

        UUID orderID = UUID.randomUUID();
        String fileName = generateFileName(orderID);

        try {
            FileWriter receipt = new FileWriter(fileName);
            BufferedWriter receiptWriter = new BufferedWriter(receipt);
            receiptWriter.write(orderToString(order));

        } catch (IOException e) {
            System.out.println("ERROR: Could not write receipt.");
            e.printStackTrace();
        }
    }

    public static void readOrder() {

        UUID currentOrderID = UUID.randomUUID();
        String fileName = generateFileName(currentOrderID);

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

    private static int readOrderCounter() {
        try (BufferedReader reader = new BufferedReader(new FileReader("order_counter.txt"))) {
            String numberLine = reader.readLine();
            return Integer.parseInt(numberLine);
        } catch (IOException | NumberFormatException e) {
            return 0; // Default value if file not found or invalid value
        }
    }

    private static String generateFileName(UUID orderID) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter receiptFormat = DateTimeFormatter.ofPattern("yyyy.MM.dd_hh:mm:ss");
        String receiptDateTime = currentDateTime.format(receiptFormat);

        return ordersDirectory + receiptDateTime + "_OrderID.:" + orderID.toString() + ".txt";

    }

    private static String orderToString(Order order) {
        StringBuilder receiptBuilder = new StringBuilder();
        receiptBuilder.append("Order Number: ").append(order.getOrderNumber()).append("\n");

        ArrayList<OrderItem> orderItems = order.getOrderItems();
        for (OrderItem item : orderItems) {
            receiptBuilder.append(itemToString(item)).append("\n");
        }

        return receiptBuilder.toString();
    }

    private static String itemToString(OrderItem item) {
        if (item instanceof Sandwich) {
            Sandwich sandwich = (Sandwich) item;
            return "Sandwich: ";
        }else if (item instanceof Drinks) {
            Drinks drink = (Drinks) item;
            return "Drink: " + drink.getFlavor();
        }else if (item instanceof Chips) {
            Chips chips = (Chips) item;
            return "Chips: " + chips.getChipFlavor();
        }else {
            return "Unknown item";
        }
    }

    public static void stringToOrder(String orderStringFormat){

    }

}



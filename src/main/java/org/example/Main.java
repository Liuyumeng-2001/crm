package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<OrderInfo> orderInfoList = Jdbc.getOrderInfo("10234424");

        System.out.println(orderInfoList);

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }
}
package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Jdbc {
    public static List<OrderInfo> getOrderInfo(String order_serial) {
        // 数据库连接URL，用户名和密码
        String url = "jdbc:mysql://localhost:3306/crm";
        String user = "root";
        String password = "lym123456";

        // 数据库连接
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<OrderInfo> orderInfoList = new ArrayList<>();

        try {
            // 加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 建立连接
            conn = DriverManager.getConnection(url, user, password);

            // 创建Statement对象
            stmt = conn.createStatement();

            // 执行查询
            rs = stmt.executeQuery("select serial, order_name,customers.name customers_name,salesmen.name salesmen_name from orders inner join customers on orders.customer_id = customers.id inner join salesmen on orders.salesman_id = salesmen.id where serial = "+order_serial);


            // 处理结果
            while (rs.next()) {
                OrderInfo orderInfo = new OrderInfo();

                orderInfo.setSerial(rs.getString("serial"));
                orderInfo.setOrderName(rs.getString("order_name"));
                orderInfo.setCustomerName(rs.getString("customers_name"));
                orderInfo.setSalesName(rs.getString("salesmen_name"));
//                System.out.println(rs.getString("serial")+);

                orderInfoList.add(orderInfo);

            }
            return orderInfoList;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            // 关闭资源
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
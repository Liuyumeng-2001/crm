package org.example;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class MainTest {

    @Test
    void testgetOrderInfoList() {
        OrderInfo mockOrderInfo = new OrderInfo();
        mockOrderInfo.setSerial("10234424");
        mockOrderInfo.setOrderName("测试订单");
        mockOrderInfo.setCustomerName("测试客户");
        mockOrderInfo.setSalesName("测试销售");

        List<OrderInfo> mockOrderInfoList = new ArrayList<>();

        Jdbc mockJdbc = mock(Jdbc.class);
        when(mockJdbc.getOrderInfo("10234424")).thenReturn(mockOrderInfoList);

        //执行查询操作
        Main main = new Main();
        List<OrderInfo> result = main.getOrderInfoList(mockOrderInfo.getSerial());

        // 验证输出
        String expectedOutput = "[订单编号：10234424,订单名：测试订单,客户：测试客户,销售：测试销售]";
        assertEquals(expectedOutput, result);
    }
}
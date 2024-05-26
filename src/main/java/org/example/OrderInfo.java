package org.example;

public class OrderInfo {

    private String serial;
    private String orderName;
    private String customerName;
    private String salesName;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    @Override
    public String toString() {
        return "订单编号："+serial+",订单名："+orderName+",客户："+customerName+",销售："+salesName;
    }
}

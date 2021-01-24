package lk.ijse.thogakade.dto;

import java.util.Date;

public class OrdersDTO {
    private String orderId;
    private Date date;
    private  String cusID;

    public OrdersDTO(String orderId, Date date, String cusID) {
        this.orderId = orderId;
        this.date = date;
        this.cusID = cusID;
    }

    public OrdersDTO() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    @Override
    public String toString() {
        return "OrdersDTO{" +
                "orderId='" + orderId + '\'' +
                ", date=" + date +
                ", cusID='" + cusID + '\'' +
                '}';
    }
}

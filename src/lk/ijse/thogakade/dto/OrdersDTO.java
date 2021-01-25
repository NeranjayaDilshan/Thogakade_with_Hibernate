package lk.ijse.thogakade.dto;

import java.util.ArrayList;
import java.util.Date;

public class OrdersDTO {
    private String orderId;
    private Date date;
    private  String cusID;
    private double total;
    private ArrayList<OrderInDTO> dtos;

    public OrdersDTO(String orderId, Date date, String cusID, double total, ArrayList<OrderInDTO> dtos) {
        this.orderId = orderId;
        this.date = date;
        this.cusID = cusID;
        this.total = total;
        this.dtos = dtos;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<OrderInDTO> getDtos() {
        return dtos;
    }

    public void setDtos(ArrayList<OrderInDTO> dtos) {
        this.dtos = dtos;
    }

    @Override
    public String toString() {
        return "OrdersDTO{" +
                "orderId='" + orderId + '\'' +
                ", date=" + date +
                ", cusID='" + cusID + '\'' +
                ", total=" + total +
                ", dtos=" + dtos +
                '}';
    }
}

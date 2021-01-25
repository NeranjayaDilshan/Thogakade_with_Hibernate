package lk.ijse.thogakade.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OrderDetails implements SuperEntity {
    @Id
    private String orderID;
    private String itemCode;
    private String itemName;
    private double qty;
    private double total;
    @OneToOne
    private Item item;

    public OrderDetails(String orderID, String itemCode, String itemName, double qty, double total) {
        this.orderID = orderID;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.qty = qty;
        this.total = total;
    }

    public OrderDetails(String orderID, String itemCode, String itemName, double qty, double total, Item item) {
        this.orderID = orderID;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.qty = qty;
        this.total = total;
        this.item = item;
    }

    public OrderDetails() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderID='" + orderID + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", qty=" + qty +
                ", total=" + total +
                ", item=" + item +
                '}';
    }
}

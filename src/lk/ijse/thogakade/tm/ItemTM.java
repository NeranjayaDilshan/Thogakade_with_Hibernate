package lk.ijse.thogakade.tm;

import javafx.scene.control.Button;

public class ItemTM {
    private String itemCode;
    private  String itemName;
    private  double qtyOnHand;
    private double unitPrice;
    private Button btn;

    public ItemTM(String itemCode, String itemName, double qtyOnHand, double unitPrice, Button btn) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.qtyOnHand = qtyOnHand;
        this.unitPrice = unitPrice;
        this.btn = btn;
    }

    public ItemTM() {
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

    public double getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(double qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}

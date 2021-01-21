package lk.ijse.thogakade.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import lk.ijse.thogakade.bo.BOFactory;
import lk.ijse.thogakade.bo.BOType;
import lk.ijse.thogakade.bo.custom.impl.ItemBOImpl;
import lk.ijse.thogakade.dto.ItemDTO;

public class ItemController {

    ItemBOImpl itemBO = BOFactory.getInstance().getBO(BOType.ITEM);
    @FXML
    private JFXTextField txtItemCode;
    @FXML
    private JFXTextField txtUnitPrice;
    @FXML
    private JFXTextField txtQtyOnHand;
    @FXML
    private JFXTextField txtItemName;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXTextField txtSearch;

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String itemCode = txtItemCode.getText();
        String itemName = txtItemName.getText();
        Double qtyOnHand = Double.valueOf(txtQtyOnHand.getText());
        Double unitPrice = Double.valueOf(txtUnitPrice.getText());
        ItemDTO itemDTO = new ItemDTO(itemCode, itemName, qtyOnHand, unitPrice);
        System.out.println(itemDTO);
        try {
            boolean isAdded = itemBO.addItem(itemDTO);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "OK").showAndWait();
            } else {
                new Alert(Alert.AlertType.WARNING, "OK").showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void txtItemCodeOnAction(ActionEvent event) {

    }

    @FXML
    void txtItemNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtQtyOnHandOnAction(ActionEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

    @FXML
    void txtUnitPriceOnAction(ActionEvent event) {

    }

}
package lk.ijse.thogakade.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.thogakade.bo.BOFactory;
import lk.ijse.thogakade.bo.BOType;
import lk.ijse.thogakade.bo.custom.impl.ItemBOImpl;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.tm.ItemTM;

import java.util.ArrayList;

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
    private TableView<ItemTM> tblItem;
    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableColumn<?, ?> colQtyOnHand;

    @FXML
    private TableColumn<?, ?> colStatus;

    public void initialize() {
        loadDetails();
    }

    private void loadDetails() {
//        txtName.requestFocus();
        colID.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("btn"));
        tblItem.setItems(loadAllItemDetails());
    }

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
    void txtUnitPriceOnAction(ActionEvent event) {

    }


    private ObservableList<ItemTM> loadAllItemDetails() {
        ArrayList<ItemDTO> allItemDetails = null;
        try {
            allItemDetails = itemBO.getAllItems();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ObservableList<ItemTM> itemTMS = FXCollections.observableArrayList();

        for (ItemDTO i : allItemDetails) {
            Button btn = new Button("Delete");
            btn.setStyle("-fx-background-color: #f83a26");
            ItemTM itemTM = new ItemTM(
                    i.getItemCode(),
                    i.getItemName(),
                    i.getQtyOnHand(),
                    i.getUnitPrice(),
                    btn
            );
            itemTMS.add(itemTM);
            /*btn.setOnAction((e) -> {
                try {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Dialog");
                    alert.setHeaderText("Confirmation Delete");
                    alert.setContentText("Are you Sure to Delete ?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        boolean isDeleted = vehicleBO.deleteCustomer(i.getVehicleNumber());
                        if (isDeleted) {
                            new Alert(Alert.AlertType.CONFIRMATION, "Deleted Success!", ButtonType.OK).show();
                            tblCustomer.setItems(loadAllCustomersDetails());
                        } else {
                            new Alert(Alert.AlertType.WARNING, "Deleted UnSuccess!", ButtonType.OK).show();
                        }
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            });*/
        }
        return itemTMS;
    }

}
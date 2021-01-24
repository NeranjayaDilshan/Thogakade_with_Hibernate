package lk.ijse.thogakade.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.thogakade.bo.BOFactory;
import lk.ijse.thogakade.bo.BOType;
import lk.ijse.thogakade.bo.custom.impl.CustomerBOImpl;
import lk.ijse.thogakade.bo.custom.impl.ItemBOImpl;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.dto.ItemDTO;

import java.util.ArrayList;

public class OrderController {

    CustomerBOImpl customerBO = BOFactory.getInstance().getBO(BOType.CUSTOMER);
    ItemBOImpl itemBO = BOFactory.getInstance().getBO(BOType.ITEM);
    @FXML
    private TableView<?> tblOrders;
    @FXML
    private TableColumn<?, ?> colItemCode;
    @FXML
    private TableColumn<?, ?> colItemName;
    @FXML
    private TableColumn<?, ?> colUnitPrice;
    @FXML
    private TableColumn<?, ?> colQty;
    @FXML
    private TableColumn<?, ?> colStatus;
    @FXML
    private JFXComboBox<String> lblCustId;
    @FXML
    private JFXComboBox<String> lblItemCode;
    @FXML
    private JFXTextField txtItemName;
    @FXML
    private JFXTextField txtUnitPrice;
    @FXML
    private JFXTextField txtQtyOnHand;
    @FXML
    private JFXTextField txtQty;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnPay;

    public void initialize() throws Exception {
        loadAllCustomers();
        loadAllItems();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnPayOnAction(ActionEvent event) {

    }

    @FXML
    void lblCustIdOnAction(ActionEvent event) {

    }

    @FXML
    void lblItemCodeOnAction(ActionEvent event) {
        String itemCode = lblItemCode.getValue();

    }

    @FXML
    void txtItemNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtQtyOnAction(ActionEvent event) {

    }

    @FXML
    void txtQtyOnHandOnAction(ActionEvent event) {

    }

    @FXML
    void txtUnitPriceOnAction(ActionEvent event) {

    }

    private void loadAllCustomers() throws Exception {
        ArrayList<CustomerDTO> allCustomerDTOS = customerBO.getAllCustomer();
        ObservableList<String> dtoObservableList = FXCollections.observableArrayList();
        for (CustomerDTO customerDTO : allCustomerDTOS) {
            dtoObservableList.add(customerDTO.getId());
        }
        lblCustId.setItems(dtoObservableList);
    }

    private void loadAllItems() throws Exception {
        ArrayList<ItemDTO> allItemDTOS = itemBO.getAllItems();
        ObservableList<String> dtoObservableList = FXCollections.observableArrayList();
        for (ItemDTO itemDTO : allItemDTOS) {
            dtoObservableList.add(itemDTO.getItemCode());
        }
        lblItemCode.setItems(dtoObservableList);
    }
}

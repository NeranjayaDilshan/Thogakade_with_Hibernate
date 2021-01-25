package lk.ijse.thogakade.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.thogakade.bo.BOFactory;
import lk.ijse.thogakade.bo.BOType;
import lk.ijse.thogakade.bo.custom.impl.CustomerBOImpl;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.tm.CustomerTM;

import java.util.ArrayList;
import java.util.Optional;

public class CustomerController {
    CustomerBOImpl customerBO = BOFactory.getInstance().getBO(BOType.CUSTOMER);
    @FXML
    private JFXTextField txtID;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtContact;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXTextField txtSearch;
    @FXML
    private TableColumn<?, ?> colID;
    @FXML
    private TableColumn<?, ?> colName;
    @FXML
    private TableColumn<?, ?> colContact;
    @FXML
    private TableColumn<?, ?> colAddress;
    @FXML
    private TableColumn<?, ?> colStatus;
    @FXML
    private TableView<CustomerTM> tblCustomer;

    public void initialize() {
        loadDetails();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtID.getText();
        String name = txtName.getText();
        String contact = txtContact.getText();
        String address = txtAddress.getText();
        CustomerDTO customerDTO = new CustomerDTO(id, name, contact, address);
        try {
            boolean isAdded = customerBO.addCustomer(customerDTO);
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
    void txtContactOnAction(ActionEvent event) {

    }

    @FXML
    void txtNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

    @FXML
    void txtIDOnAction(ActionEvent actionEvent) {
    }

    private void loadDetails() {
//        txtName.requestFocus();
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("btn"));
        tblCustomer.setItems(loadAllCustomersDetails());
    }

    private ObservableList<CustomerTM> loadAllCustomersDetails() {
        ArrayList<CustomerDTO> allCustomersDetails = null;
        try {
            allCustomersDetails = customerBO.getAllCustomer();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ObservableList<CustomerTM> customerTMS = FXCollections.observableArrayList();

        for (CustomerDTO c : allCustomersDetails) {
            Button btn = new Button("Delete");
            btn.setStyle("-fx-background-color: #f83a26");
            CustomerTM customerTM = new CustomerTM(
                    c.getId(),
                    c.getName(),
                    c.getContact(),
                    c.getAddress(),
                    btn
            );
            customerTMS.add(customerTM);
            btn.setOnAction((e) -> {
                try {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Dialog");
                    alert.setHeaderText("Confirmation Delete");
                    alert.setContentText("Are you Sure to Delete ?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        boolean isDeleted = customerBO.delectCustomer(c.getId());
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
            });
        }
        return customerTMS;

    }
}

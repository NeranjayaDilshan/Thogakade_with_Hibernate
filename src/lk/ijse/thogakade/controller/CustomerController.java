package lk.ijse.thogakade.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import lk.ijse.thogakade.bo.BOFactory;
import lk.ijse.thogakade.bo.BOType;
import lk.ijse.thogakade.bo.custom.impl.CustomerBOImpl;
import lk.ijse.thogakade.dto.CustomerDTO;

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
    void btnSaveOnAction(ActionEvent event) {
        String id = txtID.getText();
        String name = txtName.getText();
        String contact = txtContact.getText();
        String address = txtAddress.getText();
        CustomerDTO customerDTO = new CustomerDTO(id, name, contact, address);
        try {
            boolean isAdded = customerBO.addCustomer(customerDTO);
            if (isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"OK").showAndWait();
            }else {
                new Alert(Alert.AlertType.WARNING,"OK").showAndWait();
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
}

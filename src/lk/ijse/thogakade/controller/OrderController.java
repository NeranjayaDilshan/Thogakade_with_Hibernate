package lk.ijse.thogakade.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.thogakade.bo.BOFactory;
import lk.ijse.thogakade.bo.BOType;
import lk.ijse.thogakade.bo.custom.OrdersBO;
import lk.ijse.thogakade.bo.custom.impl.CustomerBOImpl;
import lk.ijse.thogakade.bo.custom.impl.ItemBOImpl;
import lk.ijse.thogakade.bo.custom.impl.OrdersBOImpl;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.dto.OrderInDTO;
import lk.ijse.thogakade.dto.OrdersDTO;
import lk.ijse.thogakade.entity.Item;
import lk.ijse.thogakade.tm.CartTM;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderController {

    CustomerBOImpl customerBO = BOFactory.getInstance().getBO(BOType.CUSTOMER);
    ItemBOImpl itemBO = BOFactory.getInstance().getBO(BOType.ITEM);
    ArrayList<OrderInDTO> orderInDTOS = new ArrayList<>();
    ObservableList<CartTM> data = FXCollections.observableArrayList();
    double total = 0.0;
    double tot = 0.0;
    double qtyToUpdate = 0.0;
    int btnId;
    OrdersBOImpl bo =  BOFactory.getInstance().getBO(BOType.ORDERS);
    @FXML
    private TableView<CartTM> tblOrders;
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
    private TableColumn<?, ?> colTotal;
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
    @FXML
    private Label lblTotal;
    @FXML
    private JFXTextField txtOrderID;

    public void initialize() throws Exception {
        loadAllCustomers();
        loadAllItems();
        cart();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        loadToCart();
    }

    @FXML
    void btnPayOnAction(ActionEvent event) {
//        OrdersBOImpl ordersBO = BOFactory.getInstance().getBO(BOType.ORDERS);

        try {
            String custId = lblCustId.getValue();
            String orderId = txtOrderID.getText();
            Date date = Date.valueOf(LocalDate.now());
            double total = Double.parseDouble(lblTotal.getText());
            ArrayList<OrderInDTO> orderInDTO2 = new ArrayList<>();
            for (OrderInDTO o : orderInDTOS) {
                OrderInDTO orderInDTO = new OrderInDTO(
                        o.getItemCode(),
                        o.getItemName(),
                        o.getUnitPrice(),
                        o.getQty(),
                        o.getTotal()
                );
                orderInDTO2.add(orderInDTO);
            }
            OrdersDTO dto = new OrdersDTO(orderId, date, custId, total, orderInDTO2);
            boolean add = bo.addOrder(dto);
            if (add) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved", ButtonType.OK).show();
//                clearOrderIN();
            } else {
                new Alert(Alert.AlertType.WARNING, "UnSaved", ButtonType.OK).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void lblCustIdOnAction(ActionEvent event) {

    }

    @FXML
    void lblItemCodeOnAction(ActionEvent event) {
        String itemCode = lblItemCode.getValue();
        System.out.println(itemCode);
        try {
            System.out.println("Inside try ");
            Item search = itemBO.search(itemCode);
            System.out.println("Order Controller : " + search);
            if (search != null) {
                txtItemName.setText(search.getItemName());
                txtUnitPrice.setText(search.getUnitPrice() + "");
                txtQtyOnHand.setText(search.getQtyOnHand() + "");
            } else {

            }
        } catch (Exception e) {
        }

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

    public int isExisted(OrderInDTO orderInDTO) {
        for (int k = 0; k < orderInDTOS.size(); k++) {
            if (orderInDTOS.get(k).getItemCode().equals(orderInDTO.getItemCode())) {
                return k;
            }
        }
        return -1;
    }

    public void loadToCart() {
        try {
            OrderInDTO orderInDTO = new OrderInDTO(
                    lblItemCode.getValue(),
                    txtItemName.getText(),
                    Double.parseDouble(txtUnitPrice.getText()),
                    Double.parseDouble(txtQty.getText()),
                    Double.parseDouble(txtUnitPrice.getText()) * Double.parseDouble(txtQty.getText())

            );

            if (btnAdd.getText().equalsIgnoreCase("Add")) {
                int existed = isExisted(orderInDTO);
                if (existed == -1) {
                    tblOrders.getItems().clear();
                    orderInDTOS.add(orderInDTO);
                    forLoopIn();
                } else {
                    tblOrders.getItems().clear();
                    OrderInDTO orderInDTONew = new OrderInDTO(
                            lblItemCode.getValue(),
                            txtItemName.getText(),
                            Double.parseDouble(txtUnitPrice.getText()),
                            Double.parseDouble(txtQty.getText()) + qtyToUpdate,
                            (Double.parseDouble(txtUnitPrice.getText())) * (Double.parseDouble(txtQty.getText()) + qtyToUpdate)

                    );
                    orderInDTOS.set(existed, orderInDTONew);
                    qtyToUpdate = 0.0;
                    forLoopIn();
                    btnAdd.setText("Add To Cart");
                    btnAdd.setStyle(" -fx-background-color:#10ac84;-fx-background-radius:20");
                }
            } else {
                tblOrders.getItems().clear();
                qtyToUpdate = 0.0;
                orderInDTOS.set(btnId, orderInDTO);
                forLoopIn();
                btnAdd.setText("Add To Cart");
                btnAdd.setStyle(" -fx-background-color:#10ac84;-fx-background-radius:20");
            }
        } catch (Exception e) {
//            txtWeight.setFocusColor(Paint.valueOf("red"));
//            txtWeight.requestFocus();
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }
    }

    public void cart() {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("btn"));
    }

    public void forLoopIn() {
        for (int i = 0; i < orderInDTOS.size(); i++) {
            Button btn = new Button("Remove");
            btn.setStyle("-fx-background-color: #f83a26");
            btn.setId(String.valueOf(i));
            CartTM cartTM = new CartTM(
                    orderInDTOS.get(i).getItemCode(),
                    orderInDTOS.get(i).getItemName(),
                    orderInDTOS.get(i).getUnitPrice(),
                    orderInDTOS.get(i).getQty(),
                    orderInDTOS.get(i).getTotal(),
                    btn
            );
            btn.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    orderInDTOS.remove(Integer.parseInt(btn.getId()));
                    tblOrders.getItems().remove(Integer.parseInt(btn.getId()));
                    totalIn();
                }
            });
            totalIn();
            data.add(cartTM);
        }
        tblOrders.setItems(data);
        lblTotal.setText(total + "");
        total = 0;
        tot = 0;
    }

    public void totalIn() {
        total = 0;
        tot = 0;
        for (OrderInDTO dto : orderInDTOS) {
            total = tot + dto.getTotal();
            tot = total;
        }
        lblTotal.setText(total + "");
    }
}

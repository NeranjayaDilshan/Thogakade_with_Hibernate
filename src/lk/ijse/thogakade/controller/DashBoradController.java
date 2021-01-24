package lk.ijse.thogakade.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class DashBoradController {

    @FXML
    private Pane customerpane;

    @FXML
    private Pane itemPane;

    @FXML
    private Pane orderPane;

    @FXML
    private Pane pane;
    public void setUi(String location) throws IOException {
        pane.getChildren().clear();
        pane.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/" + location + ".fxml")));
    }
    @FXML
    void customerpaneOnAction(MouseEvent event) throws IOException {
        setUi("Customer");
    }

    @FXML
    void itemPaneOnAction(MouseEvent event) throws IOException {
        setUi("Item");

    }

    @FXML
    void orderPaneOnAction(MouseEvent event) throws IOException {
        setUi("Order");

    }

}

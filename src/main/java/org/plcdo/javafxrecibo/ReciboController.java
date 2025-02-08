package org.plcdo.javafxrecibo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.plcdo.javafxrecibo.services.ImprimirRecibo;

public class ReciboController {
    public String productName = "Pão Careca";
    public String quantity = "";
    public String quantityDisplay = "Qtd: " + quantity + " unidades";
    public String barcodeData = "";
    public String barcodeDataDisplay = quantity+"*" + barcodeData;
    public String barcodeDataString = quantityDisplay + " " + barcodeDataDisplay;
    ImprimirRecibo imprimirRecibo = new ImprimirRecibo();

    @FXML
    private TextField quantityField;
    @FXML
    private TextField barcodeDataField;
    @FXML
    private Label quantityLabel;

    @FXML
    protected void onSaveButtonClick() {
        this.quantity = quantityField.getText();
        this.barcodeData = barcodeDataField.getText();
        System.out.println("Quantity: " + quantity);
        System.out.println("Barcode Data: " + barcodeData);
        imprimirRecibo.printRecibo(quantity, barcodeData);
        quantityLabel.setText(quantityField.getText() + " " + barcodeDataField.getText());
    }
//    @FXML
//    protected void onHelloButtonClick() {
//        quantityLabel.setText("Hello World!");
//    }
}

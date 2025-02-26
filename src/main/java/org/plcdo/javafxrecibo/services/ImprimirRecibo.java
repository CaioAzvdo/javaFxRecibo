package org.plcdo.javafxrecibo.services;

import java.awt.image.BufferedImage;

public class ImprimirRecibo {

    public void printRecibo(String quantity, String barcodeData) {
        try {
            CreateImage createImage = new CreateImage();
            PrintImage printImage = new PrintImage();

            // Dados para o rótulo
            String productName = "Mercado Massape - Volte Sempre!";
//            String quantity = "5";
            String quantityDisplay = "Qtd: " + quantity + " unidades";
//            String barcodeData = "252";
            String barcodeDataDisplay = quantity+"*" + barcodeData;
            String barcodeDataString = quantityDisplay;

            // Gerar imagem
            BufferedImage labelImage2 = createImage.createLabelImage(productName, quantityDisplay, barcodeDataDisplay, barcodeDataString);

            // Imprimir a imagem
            printImage.printImagePrinter(labelImage2);
//            printImage(labelImage2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


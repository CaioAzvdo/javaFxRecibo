package org.plcdo.javafxrecibo.services;

import java.awt.*;
import java.awt.image.BufferedImage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

public class CreateImage {
    private static final int WIDTH = 2480;  // 105mm em 600 DPI
    private static final int HEIGHT = 1748; // 148mm em 600 DPI

    public final BufferedImage createLabelImage(String name, String quantity, String barcodeData, String barcodeDataString) throws Exception {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        // Fundo branco
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);

        // Configurações de fonte
        Font font = new Font("Arial", Font.BOLD, 160);
        g.setFont(font);

        // Desenhar nome do produto
        drawCenteredString(g, name, WIDTH/2, 200);
        drawCenteredString(g, barcodeDataString, WIDTH/2, 450);

        // Desenhar quantidade
        font = font.deriveFont(120f);
        g.setFont(font);
//        drawCenteredString(g, quantity, WIDTH/2, 350);

        // Gerar código de barras
        BufferedImage barcode = generateBarcode(barcodeData, WIDTH - 400, 600);
        g.drawImage(barcode, 200, 500, null);

        g.dispose();
        return image;
    }
    private void drawCenteredString(Graphics g, String text, int x, int y) {
        FontMetrics metrics = g.getFontMetrics();
        int textWidth = metrics.stringWidth(text);
        g.drawString(text, x - (textWidth / 2), y);
    }
    private static BufferedImage generateBarcode(String data, int width, int height) throws Exception {
        BitMatrix matrix = new MultiFormatWriter().encode(
                data,
                BarcodeFormat.CODE_128,
                width,
                height
        );

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? 0x000000 : 0xFFFFFF);
            }
        }
        return image;
    }
}

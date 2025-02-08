module org.plcdo.javafxrecibo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.desktop;
    requires com.google.zxing;

    opens org.plcdo.javafxrecibo to javafx.fxml;
    exports org.plcdo.javafxrecibo;
    exports org.plcdo.javafxrecibo.services;
    opens org.plcdo.javafxrecibo.services to javafx.fxml;
}

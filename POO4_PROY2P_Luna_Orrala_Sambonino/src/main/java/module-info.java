/**
 * modulo
 */
module com.pooespol.poo4_proy2p_luna_orrala_sambonino {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.pooespol.poo4_proy2p_luna_orrala_sambonino to javafx.fxml;
    opens com.pooespol.poo4_proy2p_modelo to javafx.base;
    exports com.pooespol.poo4_proy2p_luna_orrala_sambonino;
}

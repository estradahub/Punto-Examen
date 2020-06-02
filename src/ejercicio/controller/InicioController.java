package ejercicio.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.awt.*;
import java.io.IOException;

public class InicioController {

    @FXML
    private BorderPane cajeroContainer;
    @FXML
    private Label lbl_infoCliente;

    public void mnuFinalizar_action(){System.exit(0);}
    public void mnuCrearCuenta_action(){
        try{
            AnchorPane createAccount = FXMLLoader.load(getClass().getResource("../view/crear-cuenta.fxml"));
            this.cajeroContainer.setCenter(createAccount);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    public void mnuConsignar_action(){
        try{
            AnchorPane deposit = FXMLLoader.load(getClass().getResource("../view/consignar-dinero.fxml"));
            this.cajeroContainer.setCenter(deposit);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    public void mnuRetirar_action(){
        try{
            AnchorPane withdraw = FXMLLoader.load(getClass().getResource("../view/retirar-dinero.fxml"));
            this.cajeroContainer.setCenter(withdraw);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    public void mnuTransferir_action(){
        try{
            AnchorPane transfer = FXMLLoader.load(getClass().getResource("../view/transferir-dinero.fxml"));
            this.cajeroContainer.setCenter(transfer);

        }catch (IOException ioe){
            ioe.printStackTrace();
        }

    }
}

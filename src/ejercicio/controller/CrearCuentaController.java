package ejercicio.controller;

import ejercicio.bsn.ClienteBsn;
import ejercicio.dao.exception.ClienteYaExisteException;
import ejercicio.model.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class CrearCuentaController {

    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtPassword;


    private ClienteBsn clienteBsn = new ClienteBsn();

    @FXML
    public void initialize(){
        txtId.setTextFormatter(new TextFormatter<>(change -> {
            if(change.getControlNewText().matches("([1-9][0-9]*)?")){
                return change;
            }
            return null;
        }));
    }

    public void btnCrearCuenta_action(){
        String idIngresado = txtId.getText().trim();
        String nombreIngresado = txtNombre.getText().trim();
        String passwordIngresado = txtPassword.getText().trim();

        boolean esValido = validarCampos(idIngresado,nombreIngresado,passwordIngresado);

        if(!esValido){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Registro de cliente");
            alert.setHeaderText("Registro de cliente");
            alert.setContentText("Diligencie todos los campos");
            alert.showAndWait();
            return;
        }
        Cliente cliente = new Cliente(idIngresado,nombreIngresado,passwordIngresado);
        try{
            clienteBsn.registrarCliente(cliente);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registro de cliente");
            alert.setHeaderText("Registro de cliente");
            alert.setContentText("¡Su cuenta única ha sido creada exitosamente!");
            alert.showAndWait();
            limpiarCampos();


        }catch (ClienteYaExisteException cye){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Registro de cliente");
            alert.setHeaderText("Registro de cliente");
            alert.setContentText("¡Ha ocurrido un error!");
            alert.showAndWait();
            return;
        }
    }
    private boolean validarCampos(String ... campos){
        for(int i=0;i<campos.length;i++){
            if(campos[i] == null || "".equals(campos[i])){
                return false;
            }
        }
        return true;
    }
    private void limpiarCampos(){
        txtId.clear();
        txtNombre.clear();
        txtPassword.clear();
    }

}

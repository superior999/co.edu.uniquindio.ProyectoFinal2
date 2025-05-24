package co.edu.uniquindio.proyecto.viewController;

import co.edu.uniquindio.proyecto.mapping.dto.UsuarioDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginViewController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnLogin;

    @FXML
    private AnchorPane imgLogin;

    @FXML
    private Label lblBilleteraVirtual;

    @FXML
    private Label lblContraseniaLogin;

    @FXML
    private Label lblIdentificacionLogin;

    @FXML
    private Label lblLogintl;

    @FXML
    private Hyperlink linkOlvidoContrasenia;

    @FXML
    private Hyperlink linkRegistrarCuenta;

    @FXML
    private PasswordField txtContraseniaLogin;

    @FXML
    private TextField txtIdentificacionLogin;

    @FXML
    void IngresarLogin(ActionEvent event) {


    }

    @FXML
    void irAOlvidoContrasenia(ActionEvent event) {
        try {
            // Cargar el archivo FXML de registro
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/proyecto/OlvidoContrasenia.fxml"));
            Parent root = loader.load();

            // Obtener la escena actual desde el hyperlink
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cambiar la escena
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    private void irARegistroUsuario(ActionEvent event) {
        try {
            // Cargar el archivo FXML de registro
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/proyecto/RegistroUsuarios.fxml"));
            Parent root = loader.load();

            // Obtener la escena actual desde el hyperlink
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cambiar la escena
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    void initialize() {}

}


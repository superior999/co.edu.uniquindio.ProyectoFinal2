package co.edu.uniquindio.proyecto.viewController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import co.edu.uniquindio.proyecto.factory.ModelFactory;
import co.edu.uniquindio.proyecto.model.GestionBilletera;
import co.edu.uniquindio.proyecto.model.Usuario;
import co.edu.uniquindio.proyecto.model.builder.UsuarioBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import co.edu.uniquindio.proyecto.Controller.UsuarioController;
public class RegistroUsuarioviewController {

    UsuarioController usuarioController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegistrarUsuario;

    @FXML
    private Label lblBilleteraVirtual;

    @FXML
    private Label lblContrasenia;

    @FXML
    private Label lblEmailUsuario;

    @FXML
    private Label lblIdUsuario;

    @FXML
    private Label lblRegistroTl;

    @FXML
    private Label lblTelefonoUsuario;

    @FXML
    private Label lblnombreUsuario;

    @FXML
    private Hyperlink linkInicioSesion;

    @FXML
    private TextField txtEmailUsuario;

    @FXML
    private TextField txtIdeusuario;

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    private TextField txtTelefonoUsuario;

    @FXML
    private TextField txtcontrasenia;
    @FXML
    void initialize() {
        usuarioController=new UsuarioController();
        initView();
    }
    private void initView() {
    }
    @FXML
    void IrinicioSesion(ActionEvent event) {
        try {
            // Cargar el archivo FXML de registro
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/proyecto/Login.fxml"));
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
    void onRegistrar(ActionEvent event) {
        // Obtener datos del formulario
        String idUsuario = txtIdeusuario.getText();
        String nombreUsuario = txtNombreUsuario.getText();
        String emailUsuario = txtEmailUsuario.getText();
        String telefonoUsuario = txtTelefonoUsuario.getText();
        String contraseniaUsuario = txtcontrasenia.getText();

        // Validación básica
        if (idUsuario.isEmpty() || nombreUsuario.isEmpty() || emailUsuario.isEmpty()
                || telefonoUsuario.isEmpty() || contraseniaUsuario.isEmpty()) {
            mostrarAlerta("Campos incompletos", null, "Por favor complete todos los campos.");
            return;
        }

        // Crear el builder y construir el usuario
        UsuarioBuilder usuario = new UsuarioBuilder()
                .setNombreUsuario(nombreUsuario)
                .setIdUsuario(idUsuario)
                .setEmailUsuario(emailUsuario)
                .setTelefonoUsuario(telefonoUsuario)
                .setContraseniaUsuario(contraseniaUsuario);

        GestionBilletera gestion = usuarioController.getGestionBilletera();
        boolean creado = gestion.crearUsuario(usuario);

        if (creado) {
            mostrarAlerta("Éxito", null, "Usuario registrado exitosamente.");
            txtIdeusuario.clear();
            txtNombreUsuario.clear();
            txtEmailUsuario.clear();
            txtTelefonoUsuario.clear();
            txtcontrasenia.clear();

            // Mostrar la lista actual de usuarios
            String listaUsuarios = "Usuarios registrados:\n";
            for (Usuario u : gestion.getListaUsuarios()) {
                listaUsuarios += "- " + u.getNombreUsuario() + " (ID: " + u.getIdUsuario() + ")\n";
            }
            mostrarAlerta("Lista de Usuarios", null, listaUsuarios);

        } else {
            mostrarAlerta("Error", null, "El usuario ya existe o ocurrió un error.");
        }
    }


    private void mostrarAlerta(String titulo, String encabezado, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(contenido);
        alert.showAndWait();
    }





}



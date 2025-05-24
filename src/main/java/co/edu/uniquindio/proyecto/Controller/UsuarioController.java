package co.edu.uniquindio.proyecto.Controller;

import co.edu.uniquindio.proyecto.factory.ModelFactory;
import co.edu.uniquindio.proyecto.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyecto.model.GestionBilletera;

import java.util.List;

public class UsuarioController {
    ModelFactory modelFactory;
    public UsuarioController() {modelFactory=ModelFactory.getInstance();}
    public List<UsuarioDto>obtenerUsuarios(){
        return modelFactory.obtenerUsuario();}

    public GestionBilletera getGestionBilletera(){
        return modelFactory.getGestionBilletera();
    }
}

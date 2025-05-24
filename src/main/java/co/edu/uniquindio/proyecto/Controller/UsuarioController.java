package co.edu.uniquindio.proyecto.Controller;

import co.edu.uniquindio.proyecto.factory.ModelFactory;
import co.edu.uniquindio.proyecto.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyecto.model.GestionBilletera;

import java.util.List;

public class UsuarioController {
    ModelFactory modelFactory;
    public UsuarioController() {modelFactory=ModelFactory.getInstance();}
    public List<UsuarioDto>obtenerUsuarios(){
        return modelFactory.obtenerUsuarios();}

    public GestionBilletera getGestionBilletera(){
        return modelFactory.getGestionBilletera();
    }
    public UsuarioDto obtenerUsuario(String id){
        return modelFactory.obtenerUsuario(id);
    }

    public boolean existeUsuario(String id){
        return modelFactory.existeUsuario(id);
    }
}

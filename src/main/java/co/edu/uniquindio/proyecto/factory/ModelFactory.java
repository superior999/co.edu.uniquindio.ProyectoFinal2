package co.edu.uniquindio.proyecto.factory;

import co.edu.uniquindio.proyecto.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyecto.mapping.mappers.ProyectoMappingImpl;
import co.edu.uniquindio.proyecto.model.GestionBilletera;
import co.edu.uniquindio.proyecto.model.Usuario;
import co.edu.uniquindio.proyecto.model.builder.UsuarioBuilder;
import co.edu.uniquindio.proyecto.services.IModelFactoryServices;
import co.edu.uniquindio.proyecto.services.IProyectoMapping;

import java.util.List;

public class ModelFactory implements IModelFactoryServices {
    private static ModelFactory modelFactory;
    private GestionBilletera gestionBilletera;
    private IProyectoMapping mapper;

    public static ModelFactory getInstance() {
        if (modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }
    public GestionBilletera getGestionBilletera() {
        return gestionBilletera;
    }

    private ModelFactory() {

       mapper=new ProyectoMappingImpl();

        gestionBilletera = new GestionBilletera();
    }

    @Override
    public boolean crearUsuario(UsuarioBuilder NuevoUsuario) {
        return false;
    }

    @Override
    public boolean eliminarUsuario(String idUsuario) {
        return false;
    }

    @Override
    public boolean agregarCuenta() {
        return false;
    }

    @Override
    public boolean eliminarCuenta() {
        return false;
    }

    @Override
    public boolean actualizarCuenta() {
        return false;
    }

    @Override
    public List<UsuarioDto> obtenerUsuarios() {
        return mapper.getUsuarioDtos(gestionBilletera.getListaUsuarios());
    }

    @Override
    public void mostrarInfoBilletera() {

    }

   public UsuarioDto obtenerUsuario(String idUsuario) {
        Usuario usuario = gestionBilletera.obtenerUsuario(idUsuario);

        return mapper.usuarioToUsuarioDto(usuario);
   }

   public boolean existeUsuario(String id){
        return gestionBilletera.existeUsuario(id);
   }


    @Override
    public boolean mostrarListaUsuarios() {
        return false;
    }

    @Override
    public boolean mostrarListaBanco() {
        return false;
    }

    @Override
    public boolean agregarUsuario(UsuarioDto usuariodto) {
        return false;
    }

    @Override
    public boolean actualizarUsuario(UsuarioDto usuariodto) {
        return false;
    }
}

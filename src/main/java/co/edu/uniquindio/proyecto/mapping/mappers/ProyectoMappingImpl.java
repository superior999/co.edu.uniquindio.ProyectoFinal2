package co.edu.uniquindio.proyecto.mapping.mappers;

import co.edu.uniquindio.proyecto.mapping.dto.UsuarioDto;

import co.edu.uniquindio.proyecto.model.Usuario;
import co.edu.uniquindio.proyecto.services.IProyectoMapping;

import java.util.ArrayList;
import java.util.List;

public class ProyectoMappingImpl implements IProyectoMapping {

    @Override
    public List<UsuarioDto> getUsuarioDtos(List<Usuario> listaUsuarios) {
        if (listaUsuarios == null) {
            return null;
        }
        List<UsuarioDto> listaUsuariosDto = new ArrayList<UsuarioDto>(listaUsuarios.size());
        for (Usuario usuario : listaUsuarios) {
            listaUsuariosDto.add(usuarioToUsuarioDto(usuario));
        }
        return listaUsuariosDto;
    }

    @Override
    public UsuarioDto usuarioToUsuarioDto(Usuario usuario) {
        return new UsuarioDto(
                usuario.getNombreUsuario()
                ,usuario.getIdUsuario()
                ,usuario.getEmailUsuario()
                ,usuario.getContraseniaUsuario()
                ,usuario.getNombreUsuario()
                );
    }

    @Override
    public Usuario usuarioDtoToUsuario(UsuarioDto usuario) {
        return Usuario.builder()
                .nombreUsuario(usuario.nombreUsuario())
                .idUsuario(usuario.idUsuario())
                .contraseniaUsuario(usuario.contraseniaUsuario())
                .telefonoUsuario(usuario.telefonoUsuario())
                .emailUsuario(usuario.emailUsuario())
                .build();
    }




}
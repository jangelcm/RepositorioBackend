package pe.com.targethr.authserver.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.com.targethr.authserver.dao.EmpleadoRepository;
import pe.com.targethr.authserver.dao.UsuarioRepository;
import pe.com.targethr.authserver.model.entity.EmpleadoEntity;
import pe.com.targethr.authserver.model.entity.UsuarioEntity;
import pe.com.targethr.authserver.model.entity.pk.EmpleadoId;
import pe.com.targethr.authserver.model.jwt.CustomClaims;
import pe.com.targethr.authserver.service.UsuarioService;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService, UsuarioService {

    private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsServiceImpl.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Buscando usuario {}", username);
        try {
            UsuarioEntity usuarioEntity = usuarioRepository.findByUsernameAndActivated(username, 1).get();

            log.info("Usuario encontrado");
            UserDetails customUser = new User(usuarioEntity.getUsername(), usuarioEntity.getPassword(),
                    Collections.emptyList());
            return customUser;
        } catch (NoSuchElementException e) {
            log.error("Usuario no encontrado", e);
            throw new UsernameNotFoundException(String.format("Usuario %s no encontrado en la base de datos", username),
                    e);
        } catch (Exception e) {
            log.error("Error de conexion a bd", e);
            throw new UsernameNotFoundException("Error de conexion a bd", e);
        }
    }


    @Override
    public List<CustomClaims> listarSubordinados(CustomClaims customClaims) {
        log.info("buscando informacion de subordinados");
        EmpleadoId idJefe = new EmpleadoId();
       // idJefe.setCodigoCompania(customClaims.getCodigoCompania());
        idJefe.setIdSucursal(Integer.parseInt(customClaims.getCodigoSucursal()));
        idJefe.setCodigoTrabajador(customClaims.getCodigoTrabajador());
        List<EmpleadoEntity> listaSubordinados = empleadoRepository.findByIdJefeAndEstado(idJefe, "1");

        return listaSubordinados.stream().map((empleadoEntity) -> {
            CustomClaims customClaimsSubordinado = new CustomClaims();
            customClaimsSubordinado.setCodigoCompania("036");
            customClaimsSubordinado.setCodigoSucursal(""+empleadoEntity.getId().getIdSucursal());
            customClaimsSubordinado.setCodigoTrabajador(empleadoEntity.getId().getCodigoTrabajador());
            customClaimsSubordinado.setNombre(empleadoEntity.getNombre());
            customClaimsSubordinado.setApellidoPaterno(empleadoEntity.getApellidoPaterno());
            customClaimsSubordinado.setApellidoMaterno(empleadoEntity.getApellidoMaterno());
            customClaimsSubordinado.setCodigoTrabajadorJefe(empleadoEntity.getJefeCodigo());
            customClaimsSubordinado.setNivel("2");

            log.info("buscando subordinados del empleado {}", empleadoEntity.getId().getCodigoTrabajador());
            long subordinados = empleadoRepository.countByCodigoTrabajadorJefe(
                     ""+empleadoEntity.getId().getIdSucursal(),
                    empleadoEntity.getId().getCodigoTrabajador());
            log.debug("nro de subordinados: {}", subordinados);
            customClaimsSubordinado.setJefe(subordinados > 0);
            return customClaimsSubordinado;
        }).collect(Collectors.toList());
    }

    @Override
    public CustomClaims obtenerDetalleJefe(CustomClaims customClaims) {
        log.info("buscando informacion de jefe");
        EmpleadoId id = new EmpleadoId();
       // id.setCodigoCompania(customClaims.getCodigoCompania());
        id.setIdSucursal(Integer.parseInt(customClaims.getCodigoSucursal()));
        id.setCodigoTrabajador(customClaims.getCodigoTrabajadorJefe());
        Optional<EmpleadoEntity> optionalJefe = empleadoRepository.findByIdAndEstado(id, "1");

        CustomClaims customClaimsJefe = new CustomClaims();

        if (optionalJefe.isPresent()) {
            EmpleadoEntity empleadoEntity = optionalJefe.get();
            customClaimsJefe.setCodigoCompania("039");
            customClaimsJefe.setCodigoSucursal(""+empleadoEntity.getId().getIdSucursal());
            customClaimsJefe.setCodigoTrabajador(empleadoEntity.getId().getCodigoTrabajador());
            customClaimsJefe.setNombre(empleadoEntity.getNombre());
            customClaimsJefe.setApellidoPaterno(empleadoEntity.getApellidoPaterno());
            customClaimsJefe.setApellidoMaterno(empleadoEntity.getApellidoMaterno());
            customClaimsJefe.setCodigoTrabajadorJefe(empleadoEntity.getJefeCodigo());
            customClaimsJefe.setNivel("2");

            log.info("buscando subordinados del empleado {}", empleadoEntity.getId().getCodigoTrabajador());
            long subordinados = empleadoRepository.countByCodigoTrabajadorJefe(
                     ""+empleadoEntity.getId().getIdSucursal(),
                    empleadoEntity.getId().getCodigoTrabajador());
            log.debug("nro de subordinados: {}", subordinados);
            customClaimsJefe.setJefe(subordinados > 0);
        }
        return customClaimsJefe;
    }
}
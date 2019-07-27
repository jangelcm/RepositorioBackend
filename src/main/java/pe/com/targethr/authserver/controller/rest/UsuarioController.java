package pe.com.targethr.authserver.controller.rest;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.targethr.authserver.model.dto.Respuesta;
import pe.com.targethr.authserver.model.jwt.CustomClaims;
import pe.com.targethr.authserver.service.UsuarioService;
import pe.com.targethr.authserver.utils.AuthUtils;

/**
 * UsuarioController
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarios")
public class UsuarioController {

    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UsuarioService usuarioService;

    @PreAuthorize("hasAuthority('jefe')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, params = "tipo=subordinados")
    public ResponseEntity<Respuesta<List<CustomClaims>>> listarSubordinados(Authentication auth) {
        log.info("=== Inicio de metodo listarSubordinados ===");

        List<CustomClaims> usuarios = usuarioService.listarSubordinados(AuthUtils.getCustomClaims(auth, objectMapper));
        Respuesta<List<CustomClaims>> res = new Respuesta<>();
        res.setMensaje(Respuesta.MENSAJE_LECTURA_EXITOSA);
        res.setData(usuarios);

        log.info("=== Fin de metodo listarSubordinados ===");
        return new ResponseEntity<Respuesta<List<CustomClaims>>>(res, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, params = "tipo=jefe")
    public ResponseEntity<Respuesta<CustomClaims>> detalleJefe(Authentication auth) {
        log.info("=== Inicio de metodo detalleJefe ===");

        CustomClaims jefe = usuarioService.obtenerDetalleJefe(AuthUtils.getCustomClaims(auth, objectMapper));
        Respuesta<CustomClaims> res = new Respuesta<>();
        res.setMensaje(Respuesta.MENSAJE_LECTURA_EXITOSA);
        res.setData(jefe);

        log.info("=== Fin de metodo detalleJefe ===");
        return new ResponseEntity<Respuesta<CustomClaims>>(res, HttpStatus.OK);
    }

}
package pe.com.targethr.authserver.service;

import java.util.List;

import pe.com.targethr.authserver.model.jwt.CustomClaims;

/**
 * UsuarioService
 */
public interface UsuarioService {

    List<CustomClaims> listarSubordinados(CustomClaims customClaims);

    CustomClaims obtenerDetalleJefe(CustomClaims customClaims);
}
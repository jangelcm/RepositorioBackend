package pe.com.targethr.authserver.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.targethr.authserver.model.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    Optional<UsuarioEntity>  findByUsernameAndActivated(String username, Integer activated);
}
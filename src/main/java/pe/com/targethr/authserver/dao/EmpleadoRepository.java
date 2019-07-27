package pe.com.targethr.authserver.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import pe.com.targethr.authserver.model.entity.EmpleadoEntity;
import pe.com.targethr.authserver.model.entity.UsuarioEntity;
import pe.com.targethr.authserver.model.entity.pk.EmpleadoId;

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, EmpleadoId> {

    @Query(value = "select emp.* "
            + "from HR_EMPLEADO emp join TECH_USER usu on emp.CODIGO_TRABAJADOR = usu.CODIGO_TRABAJADOR "
            + "where usu.USER_ID = ?1 and emp.ACTIVATED = ?2", nativeQuery = true)
    Optional<EmpleadoEntity> findByCodigoUsuarioAndEstado(Long codigoUsuario, String estado);

    @Query(value = "select count(*) from HR_EMPLEADO where ID_SUCURSAL = ?1 and CODIGO_TRABAJADOR = ?2 ", nativeQuery = true)
    long countByCodigoTrabajadorJefe(String codigoSucursal, String codigoTrabajadorJefe);

    @Query(value = "select emp.* "
            + "from HR_EMPLEADO emp "
            + "where emp.ID_SUCURSAL = ?#{[0].idSucursal} and emp.CODIGO_TRABAJADOR = ?#{[0].codigoTrabajador} "
            + "and emp.ACTIVATED = ?#{[1]}", nativeQuery = true)
    List<EmpleadoEntity> findByIdJefeAndEstado(EmpleadoId idJefe, String estado);

    @Query(value = "select emp.* "
            + "from HR_EMPLEADO emp "
            + "where emp.ID_SUCURSAL = ?#{[0].idSucursal} and emp.CODIGO_TRABAJADOR = ?#{[0].codigoTrabajador} "
            + "and emp.ACTIVATED = ?#{[1]}", nativeQuery = true)
    Optional<EmpleadoEntity> findByIdAndEstado(EmpleadoId id, String estado);

    @Query("select u from  UsuarioEntity u where u.userId = :codigoUsuario")
    Optional<UsuarioEntity> getUsuarioAll (@Param("codigoUsuario") Long codigoUsuario);
}
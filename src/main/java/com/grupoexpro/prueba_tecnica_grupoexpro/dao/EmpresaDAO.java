package com.grupoexpro.prueba_tecnica_grupoexpro.dao;

import com.grupoexpro.prueba_tecnica_grupoexpro.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaDAO extends JpaRepository<Empresa, Integer> {
    @Query(value = "SELECT * FROM Empresa e where e.estado=1 ORDER BY e.id_empresa DESC limit 3", nativeQuery = true)
    List<Empresa> findFirstLasts();
    Empresa findByRuc(String ruc);
}

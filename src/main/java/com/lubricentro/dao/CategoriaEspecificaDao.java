
package com.lubricentro.dao;

import com.lubricentro.domain.CategoriaEspecifica; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaEspecificaDao extends JpaRepository <CategoriaEspecifica, Long> {
    
}

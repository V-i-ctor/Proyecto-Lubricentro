
package com.lubricentro.service;

import com.lubricentro.domain.CategoriaEspecifica;
import java.util.List;

public interface CategoriaEspecificaService {
    
    public List<CategoriaEspecifica> getCategoriasEspecificas(boolean activos);

    public CategoriaEspecifica getCategoriaEspecifica(CategoriaEspecifica categoriageneral); 

    public void save(CategoriaEspecifica categoriageneral);

    public void delete(CategoriaEspecifica categoriageneral); 
}

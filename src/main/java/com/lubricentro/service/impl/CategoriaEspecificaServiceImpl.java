
package com.lubricentro.service.impl;

import com.lubricentro.dao.CategoriaEspecificaDao;
import com.lubricentro.domain.CategoriaEspecifica;
import com.lubricentro.service.CategoriaEspecificaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaEspecificaServiceImpl implements CategoriaEspecificaService  {
    
       @Autowired
    private CategoriaEspecificaDao categoriaespecificaDao;

    @Override
    @Transactional(readOnly=true)
    public List<CategoriaEspecifica> getCategoriasEspecificas(boolean activos) {
        var lista = categoriaespecificaDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public CategoriaEspecifica getCategoriaEspecifica(CategoriaEspecifica categoriaespecifica) {
        return categoriaespecificaDao.findById(categoriaespecifica.getIdCategoriaEspecifica()).orElse(null);
    }
    

    @Override
    @Transactional
    public void save(CategoriaEspecifica categoriaespecifica) {
        categoriaespecificaDao.save(categoriaespecifica);
    }

    @Override
    @Transactional
    public void delete(CategoriaEspecifica categoriaespecifica) {
        categoriaespecificaDao.delete(categoriaespecifica);
    }
}

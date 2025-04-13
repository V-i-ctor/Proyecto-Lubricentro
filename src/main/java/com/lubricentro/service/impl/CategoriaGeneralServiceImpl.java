package com.lubricentro.service.impl;

import com.lubricentro.dao.CategoriaGeneralDao;
import com.lubricentro.domain.CategoriaGeneral;
import com.lubricentro.service.CategoriaGeneralService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaGeneralServiceImpl implements CategoriaGeneralService {

    @Autowired
    private CategoriaGeneralDao categoriageneralDao;

    @Override
    @Transactional(readOnly=true)
    public List<CategoriaGeneral> getCategoriasGenerales(boolean activos) {
        var lista = categoriageneralDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public CategoriaGeneral getCategoriaGeneral(CategoriaGeneral categoriageneral) {
        return categoriageneralDao.findById(categoriageneral.getIdCategoriaGeneral()).orElse(null);
    }
    

    @Override
    @Transactional
    public void save(CategoriaGeneral categoriageneral) {
        categoriageneralDao.save(categoriageneral);
    }

    @Override
    @Transactional
    public void delete(CategoriaGeneral categoriageneral) {
        categoriageneralDao.delete(categoriageneral);
    }
}

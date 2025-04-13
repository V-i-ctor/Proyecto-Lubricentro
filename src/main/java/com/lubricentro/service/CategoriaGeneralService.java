package com.lubricentro.service;

import com.lubricentro.domain.CategoriaGeneral;
import java.util.List;

public interface CategoriaGeneralService {

    public List<CategoriaGeneral> getCategoriasGenerales(boolean activos);

    public CategoriaGeneral getCategoriaGeneral(CategoriaGeneral categoriageneral); //Actualizar

    public void save(CategoriaGeneral categoriageneral); // Guardar

    public void delete(CategoriaGeneral categoriageneral); //Eliminar
}
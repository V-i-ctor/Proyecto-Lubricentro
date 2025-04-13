package com.lubricentro.controller;

import com.lubricentro.domain.CategoriaGeneral;
import com.lubricentro.service.CategoriaGeneralService;
import com.lubricentro.service.Impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/categoriageneral")
public class CategoriaGeneralController {
  
    @Autowired
    private CategoriaGeneralService categoriageneralService;
    
    @GetMapping("/listado")
    private String listado(Model model) {
        var categoriasgenerales = categoriageneralService.getCategoriasGenerales(false);
        model.addAttribute("categoriasgenerales", categoriasgenerales);
        model.addAttribute("totalCategoriasGenerales",categoriasgenerales.size());
        return "/categoriageneral/listado";
    }
    
    @GetMapping("/nuevo")
    public String categoriageneralNuevo(CategoriaGeneral categoriageneral) {
        return "/categoriageneral/modifica";
    }
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String categoriageneralGuardar(CategoriaGeneral categoriageneral,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            categoriageneralService.save(categoriageneral);
            categoriageneral.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "categoriageneral", 
                            categoriageneral.getIdCategoriaGeneral()));
        }
        categoriageneralService.save(categoriageneral);
        return "redirect:/categoriageneral/listado";
    }

    @GetMapping("/eliminar/{idCategoriaGeneral}")
    public String categoriageneralEliminar(CategoriaGeneral categoriageneral) {
        categoriageneralService.delete(categoriageneral);
        return "redirect:/categoriageneral/listado";
    }

    @GetMapping("/modifica/{idCategoriaGeneral}")
    public String categoriageneralModificar(CategoriaGeneral categoriageneral, Model model) {
        categoriageneral = categoriageneralService.getCategoriaGeneral(categoriageneral);
        model.addAttribute("categoriageneral", categoriageneral);
        return "/categoriageneral/modifica";
    }
}

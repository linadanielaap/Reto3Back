package com.co.Reto3.controlador;

import com.co.Reto3.modelo.Category;
import com.co.Reto3.servicio.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST})
public class CategoryController {
    @Autowired
    private CategoryService catService;

    @GetMapping("/all")
    public List<Category> getCategories(){
        return catService.getAllCategories();
    }

    @PostMapping("/save")
    public Category saveCategory(@RequestBody Category categoria){
        return catService.saveCategory(categoria);
    }
}

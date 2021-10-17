package com.co.Reto3.servicio;

import com.co.Reto3.modelo.Category;
import com.co.Reto3.repositorio.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository catRepository;

    public List<Category> getAllCategories(){return catRepository.getAllCategories();}

    public Optional<Category> getCategory(int idCat){
        return catRepository.getCategory(idCat);
    }

    public Category saveCategory(Category categoria){
        if(categoria.getCategory_id()==null){
            return catRepository.saveCategory(categoria);
        }else{
            Optional<Category> selCategory = catRepository.getCategory(categoria.getCategory_id());
            if(selCategory.isEmpty()){
                return catRepository.saveCategory(categoria);
            }else{
                return categoria;
            }
        }
    }
}

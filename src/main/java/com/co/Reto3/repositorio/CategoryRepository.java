package com.co.Reto3.repositorio;

import com.co.Reto3.modelo.Category;
import com.co.Reto3.repositorio.crud.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryRepo;

    public List<Category> getAllCategories(){
        return (List<Category>) categoryRepo.findAll();
    }

    public Optional<Category> getCategory (int id){
        return categoryRepo.findById(id);
    }

    public Category saveCategory(Category categoria){
        return categoryRepo.save(categoria);
    }
}

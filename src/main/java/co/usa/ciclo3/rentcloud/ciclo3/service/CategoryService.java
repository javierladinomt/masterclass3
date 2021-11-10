package co.usa.ciclo3.rentcloud.ciclo3.service;

import co.usa.ciclo3.rentcloud.ciclo3.model.Category;
import co.usa.ciclo3.rentcloud.ciclo3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public List<Category> getAll(){
       return repository.getAll();
    }

    public Optional<Category> getCategory(int categoryId){
        return repository.getOne(categoryId);
    }

    public Category save(Category category){
        if(category.getId()==null){
            return repository.save(category);
        }else{
            Optional<Category> existCategory=repository.getOne(category.getId());
            if(existCategory.isEmpty()){
                return repository.save(category);
            }else{
                return category;
            }
        }
    }
    public Category update(Category category){
        if (category.getId() != null){
            Optional<Category> existCategory = repository.getOne(category.getId());
            if (existCategory.isPresent()){
                if (category.getName() != null){
                    existCategory.get().setName(category.getName());
                }
                if (category.getDescription() != null){
                    existCategory.get().setDescription(category.getDescription());
                }
                if (category.getClouds() != null){
                    existCategory.get().setClouds(category.getClouds());
                }
                return repository.save(existCategory.get());
            }else{
                return category;
            }
        }else{
            return category;
        }
    }

    public boolean delete(int categoryId){
        Boolean response = getCategory(categoryId).map(category -> {
            repository.delete(category);
            return true;
        }).orElse(false);
        return response;
    }
}

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
    public Optional<Category> getCategory(int CategoryId){
        return repository.getCategory(CategoryId);
    }
    public Category save(Category Category){
        if(Category.getId()==null){
            return repository.save(Category);
        }else{
            Optional<Category> existCategory=repository.getCategory(Category.getId());
            if(existCategory.isEmpty()){
                return repository.save(Category);
            }else{
                return Category;
            }
        }
    }
}

package co.usa.ciclo3.rentcloud.ciclo3.web;

import co.usa.ciclo3.rentcloud.ciclo3.model.Category;
import co.usa.ciclo3.rentcloud.ciclo3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/all")
    public List<Category> getCategory(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Category> getOne(@PathVariable ("id") int categoryId){
        return service.getCategory(categoryId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category){
        return service.save(category);
    }
}

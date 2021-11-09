package co.usa.ciclo3.rentcloud.ciclo3.repository;

import co.usa.ciclo3.rentcloud.ciclo3.model.Category;
import co.usa.ciclo3.rentcloud.ciclo3.repository.crud.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author JALP
 */
@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository repository;

    /**
     * SELECT * FROM CATEGORY
     * @return Retorna todas las categorias
     */
    public List<Category> getAll() {
        return (List<Category>) this.repository.findAll();
    }

    /**
     * SELECT * FROM CATEGORY WHERE ID = id
     * @param id
     * @return Retorna una categoria por su ID espedifico
     */
    public Optional<Category> getOne(int id) {
        return this.repository.findById(id);
    }

    /**
     * INSERT & UPDATE
     * @param category
     * @return
     */
    public Category save(Category category){
        return this.repository.save(category);
    }
}

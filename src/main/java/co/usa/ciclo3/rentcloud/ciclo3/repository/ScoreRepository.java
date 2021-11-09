package co.usa.ciclo3.rentcloud.ciclo3.repository;

import co.usa.ciclo3.rentcloud.ciclo3.model.Score;
import co.usa.ciclo3.rentcloud.ciclo3.repository.crud.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository repository;

    /**
     * SELECT * FROM SCORE
     * @return Retorna todas las calificaciones
     */
    public List<Score> getAll(){
        return (List<Score>) this.repository.findAll();
    }

    /**
     * SELECT * FROM SCORE WHERE ID = id
     * @param id
     * @return Retorna una calificacion por su ID especifico
     */
    public Optional<Score> getOne(int id){
        return this.repository.findById(id);
    }
    /**
     * INSERT & UPDATE
     * @param score
     * @return Actualiza o guarda una calificacion
     */
    public Score save(Score score){
        return (Score) this.repository.save(score);
    }
}

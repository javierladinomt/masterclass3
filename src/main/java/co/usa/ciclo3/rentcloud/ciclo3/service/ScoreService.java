package co.usa.ciclo3.rentcloud.ciclo3.service;

import co.usa.ciclo3.rentcloud.ciclo3.model.Score;
import co.usa.ciclo3.rentcloud.ciclo3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }

    public Score save(Score s){
        if (s.getIdScore()==null){
            return scoreRepository.save(s);
        }else{
            Optional<Score> sAux = scoreRepository.getScore(s.getIdScore());
            if(sAux.isEmpty()){
                return scoreRepository.save(s);
            }else{
                return s;
            }
        }
    }
}

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
    private ScoreRepository repository;

    public List<Score> getAll(){
        return repository.getAll();
    }

    public Optional<Score> getScore(int scoreId){
        return repository.getOne(scoreId);
    }

    public Score save(Score score){
        if (score.getIdScore()==null){
            return repository.save(score);
        }else{
            Optional<Score> existScore = repository.getOne(score.getIdScore());
            if(existScore.isEmpty()){
                return repository.save(score);
            }else{
                return score;
            }
        }
    }

    public Score update(Score score){
        if (score.getIdScore() != null){
            Optional<Score> existScore = repository.getOne(score.getIdScore());
            if (existScore.isPresent()){
                if (score.getMessageText() != null){
                    existScore.get().setMessageText(score.getMessageText());
                }
                if (score.getReservation() != null){
                    existScore.get().setReservation(score.getReservation());
                }
                if (score.getIdScore() != null){
                    existScore.get().setIdScore(score.getIdScore());
                }
                return repository.save(existScore.get());
            }else{
                return score;
            }
        }else{
            return score;
        }
    }

    public boolean delete(int scoreId){
        Boolean response = getScore(scoreId).map(score -> {
            repository.delete(score);
            return true;
        }).orElse(false);
        return response;
    }
}

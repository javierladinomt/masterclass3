package co.usa.ciclo3.rentcloud.ciclo3.web;

import co.usa.ciclo3.rentcloud.ciclo3.model.Score;
import co.usa.ciclo3.rentcloud.ciclo3.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ScoreController {
    @Autowired
    private ScoreService service;

    @GetMapping("/all")
    public List<Score> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Score> getOne(@PathVariable ("id") int scoreId){
        return service.getScore(scoreId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score score ){
        return service.save(score);
    }
}

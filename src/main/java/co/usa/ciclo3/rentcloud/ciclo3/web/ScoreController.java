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
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> getScore(){
        return scoreService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Score> getScore(@PathVariable ("id") int id){
        return scoreService.getScore(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score s){
        return scoreService.save(s);
    }
}

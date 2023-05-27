package com.example.Reto3.Controller;

import com.example.Reto3.Model.Score;
import com.example.Reto3.Service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Score")

public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all") //local host/api/Score/all
    public List<Score> getAll(){
        return scoreService.getAll();
    }

    @GetMapping("/{id}") //local host/api/Score/id
    public Optional<Score> getScore(@PathVariable int id){
        return scoreService.getScore(id);
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save (@RequestBody Score score){
        return scoreService.save(score);


    }
    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update (@RequestBody Score score){
        return scoreService.update(score);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id){
        return scoreService.deleteScore(id);

    }
}
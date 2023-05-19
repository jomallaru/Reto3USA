package com.example.Reto3.Controller;

import com.example.Reto3.Model.Score;
import com.example.Reto3.Service.ScoreService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Score")

public class ScoreController {
    private ScoreService scoreService;

    @GetMapping("/all") // ->>>> localhost../api/Score/all
    public List<Score> getAll(){
        return scoreService.getAll();
    }

    @GetMapping("/{id}") // ->>>> localhost../api/Score/
    public Optional<Score> getScore(@PathVariable int id){
        return scoreService.getScore(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public  Score save(@RequestBody Score score){
        return scoreService.save(score);
    }
}
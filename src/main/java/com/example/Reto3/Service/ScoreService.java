package com.example.Reto3.Service;


import com.example.Reto3.Model.Score;
import com.example.Reto3.Repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.findAll();
    }

    public Optional<Score> getScore(int id) {
        return scoreRepository.getScore(id);
    }

    public Score save(Score score) {
        if (score.getIdScore() == null) {
            return scoreRepository.save(score);
        } else {
            Optional<Score> scoreEncontrado = getScore(score.getIdScore());
            if (scoreEncontrado.isEmpty()) {
                return scoreRepository.save(score);
            } else {
                return score;
            }
        }
    }

    public Score update(Score score) {
        if (score.getIdScore() != null) {
            Optional<Score> scoreEncontrado = getScore(score.getIdScore());
            if (scoreEncontrado.isPresent()) {
                if (score.getMessageText() != null) {
                    scoreEncontrado.get().setMessageText(score.getMessageText());
                }
                if (score.getStars() != null) {
                    scoreEncontrado.get().setStars(score.getStars());
                }

                return scoreRepository.save(scoreEncontrado.get());
            }else{
                return score;
            }
        }else {
            return score;
        }
    }
    public boolean deleteScore (int id){
        Boolean respuesta =getScore(id).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(false);
        return  respuesta;
    }
    
}

package de.beyondjava.angularTetris.score;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class HighScoreTableBean {
    private List<HighScore> highscores;
    
    @PostConstruct
    public void init() {
        setHighscores(new HighScoreDAO().loadHighScoreTable());
    }

    public List<HighScore> getHighscores() {
        return highscores;
    }

    public void setHighscores(List<HighScore> highscores) {
        this.highscores = highscores;
    }

}

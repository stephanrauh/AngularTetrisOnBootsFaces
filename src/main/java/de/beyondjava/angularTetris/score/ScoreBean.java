package de.beyondjava.angularTetris.score;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Size;

@ManagedBean
@SessionScoped
public class ScoreBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private HighScoreDAO dao = new HighScoreDAO();
    private int score;

    @Size(min=3, max=20)
    private String name;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void saveScore() {
        try {
            HighScore highScore = new HighScore();
            highScore.setName(name);
            highScore.setScore(score);
            highScore.setDate(new Date());
            dao.persistScore(highScore);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Sucessfully saved"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Couldn't save the high score"));
            e.printStackTrace();
        }
    }
}

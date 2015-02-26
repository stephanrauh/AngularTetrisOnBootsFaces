package de.beyondjava.angularTetris.score;

import java.io.Serializable;
import java.util.Date;


public class HighScore implements Serializable {
    private static final long serialVersionUID = -126125731394613414L;

    private int score;

    private String name;

    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}

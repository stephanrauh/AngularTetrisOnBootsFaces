package de.beyondjava.angularTetris.score;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HighScore implements Serializable {
    private static final long serialVersionUID = -126125731394613414L;

    public HighScore() {
    }

    public HighScore(String name, int score) {
        setName(name);
        this.score = score;
        this.date = new Date();
        id -= score; // make sure the id is unique
    }

    @Id
    // @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id = System.nanoTime();

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
        if (this.name != null) {
            this.name = this.name.replace("'", "&#x0027;").replace("\"", "&#x0022;");
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

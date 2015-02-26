package de.beyondjava.angularTetris.score;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class ScoreBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int score;
	
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
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sucessfully saved"));
    }
}

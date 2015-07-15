package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;


@Entity
@Table(name = "level_aux")
public class Level_Aux extends Model{

	@Id
	protected Long id;

	@ManyToOne
	Level level;

	@OneToOne(mappedBy = "level_aux", cascade = CascadeType.ALL)
	Course_Aux course_aux;

	public Level_Aux(){

	}

	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

	public void setLevel(Level level){
		this.level = level;
	}

	public Level getLevel(){
		return this.level;
	}

	public void setCourse_aux(Course_Aux course_aux){
		this.course_aux = course_aux;
	}

	public Course_Aux getCourse_aux(){
		return this.course_aux;
	}
}
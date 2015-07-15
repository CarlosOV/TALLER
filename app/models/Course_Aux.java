package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;


@Entity
@Table(name = "course_aux")
public class Course_Aux extends Model{

	@Id
	protected Long id;

	@ManyToOne
	Course course;

	@ManyToOne
	Theme theme;

	@OneToOne
	Level_Aux level_aux;

	public Course_Aux(){

	}

	public void setId(Long Id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

	public void setCourse(Course course){
		this.course = course;
	}

	public Course getCourse(){
		return this.course;
	}

	public void setTheme(Theme theme){
		this.theme = theme;
	}

	public Theme getTheme(){
		return this.theme;
	}

	public void setLevel_aux(Level_Aux level_aux){
		this.level_aux = level_aux;
	}

	public Level_Aux getLevel_Aux(){
		return this.level_aux;
	}
}
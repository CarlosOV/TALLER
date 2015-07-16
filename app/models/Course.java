package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;


@Entity
@Table(name = "courses")
public class Course extends Model{

	@Id
	protected Long id;

	String name;

	@ManyToOne
  	Area area;

  	@ManyToOne
  	Tutor tutor;

  	@OneToMany(mappedBy = "course", cascade=CascadeType.ALL)
  	List<Course_Aux> courses_aux;

	public Course(){
	}

	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setArea(Area area){
		this.area = area;
	}

	public Area getArea(){
		return this.area;
	}

	public void setTutor(Tutor tutor){
		this.tutor = tutor;
	}

	public Tutor getTutor(){
		return this.tutor;
	}

	public void setTheme(List<Course_Aux> courses_aux){
		this.courses_aux = courses_aux;
	}

	public List<Course_Aux> getTheme(){
		return this.courses_aux;
	}
}
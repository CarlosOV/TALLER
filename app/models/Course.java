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

	@ManyToOne(cascade=CascadeType.ALL)
  	Area area;

  	@ManyToMany(cascade=CascadeType.ALL)
  	List<Tutor> tutors;

  	@ManyToMany(cascade=CascadeType.ALL)
  	List<Level> levels;

  	@OneToMany(mappedBy = "course" ,cascade=CascadeType.ALL)
	List<Theme> themes;

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

	public void setTutors(List<Tutor> tutor){
		this.tutors = tutors;
	}

	public List<Tutor> getTutor(){
		return this.tutors;
	}

	public void setLevel(Level level){
		this.levels.add(level);
	}

	public List<Level> getLevels(){
		return this.levels;
	}

	public void setTheme(Theme theme){
		this.themes.add(theme);
	}

	public List<Theme> getTheme(){
		return this.themes;
	}
}
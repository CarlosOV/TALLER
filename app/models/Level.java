package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;


@Entity
@Table(name = "level")
public class Level extends Model{

	@Id
	protected Long id;

	String name;

	@OneToMany(mappedBy = "level" ,cascade=CascadeType.ALL)
	List<Theme> themes;

	@ManyToMany(cascade=CascadeType.ALL)
	List<Course> courses;

	public Level(){

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

	public void setThemes(Theme theme){
		this.themes.add(theme);
	}

	public List<Theme> getThemes(){
		return this.themes;
	}

	public void setCourse(Course course){
		courses.add(course);
	}

	public List<Course> getCourses(){
		return this.courses;
	}
}
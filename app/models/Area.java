package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;


@Entity
@Table(name = "area")
public class Area extends Model{

	@Id
	Long id;

	String name;

	@OneToMany(mappedBy = "area" ,cascade=CascadeType.ALL)
	List<Course> courses;

	public Area(){

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

	public void setCourses(List<Course> courses){
		this.courses = courses;
	}

	public List<Course> getCourses(){
		return this.courses;
	}
}
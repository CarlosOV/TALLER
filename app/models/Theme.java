package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;


@Entity
@Table(name = "theme")
public class Theme extends Model{

	@Id
	protected Long id;

	String name;

	@OneToMany(mappedBy = "theme", cascade=CascadeType.ALL)
	List<Course_Aux> courses_aux;

	@OneToOne(mappedBy = "theme", cascade=CascadeType.ALL)
	Report report;

	public Theme(){

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

	public void setCourses_aux(List<Course_Aux> courses_aux){
		this.courses_aux = courses_aux;
	}

	public List<Course_Aux> getCourses_aux(){
		return this.courses_aux;
	}

	public void setReport(Report report){
		this.report = report;
	}

	public Report getReport(){
		return this.report;
	}
	
}
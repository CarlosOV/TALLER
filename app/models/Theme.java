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

	@OneToOne(mappedBy = "theme", cascade=CascadeType.ALL)
	Course_Aux course_aux;

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

	public void setCourse_aux(Course_Aux course_aux){
		this.course_aux = course_aux;
	}

	public Course_Aux getCourse_aux(){
		return this.course_aux;
	}

	public void setReport(Report report){
		this.report = report;
	}

	public Report getReport(){
		return this.report;
	}
	
}
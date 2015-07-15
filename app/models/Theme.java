package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;


@Entity
@Table(name = "themes")
public class Theme extends Model{

	@Id
	protected Long id;

  	@ManyToOne(cascade=CascadeType.ALL)
  	Level level;

  	@OneToOne(mappedBy = "theme" ,cascade=CascadeType.ALL)
	List<Report> reports;

	String name;

	public Theme(){

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

	public void setReports(List<Report> reports){
		this.reports = reports;
	}

	public List<Report> getReports(){
		return reports;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}
}
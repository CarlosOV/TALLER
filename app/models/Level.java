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
	Long id;
	String name;

	@OneToMany(mappedBy = "level" ,cascade=CascadeType.ALL)
	List<Theme> themes;

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

	public void setThemes(List<Theme> themes){
		this.themes = themes;
	}

	public List<Theme> getThemes(){
		return this.themes;
	}
}
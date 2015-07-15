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

	@OneToMany(mappedBy = "level" , cascade = CascadeType.ALL)
	List<Level_Aux> levels_aux;

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

	public void setLevels_aux(List<Level_Aux> levels_aux){
		this.levels_aux = levels_aux;
	}

	public List<Level_Aux> getLevels_Aux(){
		return levels_aux;
	}
}
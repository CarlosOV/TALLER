package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;


@Entity
@Table(name = "report")
public class Report extends Model{

	@Id
	protected Long id;
	
	@OneToOne
  	Theme theme;
	
	@ManyToOne
  	Tutor tutor;

  	@OneToMany(mappedBy = "report" ,cascade=CascadeType.ALL)
	List<Report_Aux> reports_aux;

	@Formats.DateTime(pattern="dd/MM/yyyy")
  	Date date_registry = new Date();

	@Formats.DateTime(pattern="dd/MM/yyyy")
  	Date date_submit = new Date();

	Boolean var_state;

	public Report(){
	}

	public void setId(Long id){
		this.id = id;
	} 

	public Long getId(){
		return id;
	}

	public void setTheme(Theme theme){
		this.theme = theme;
	}

	public Theme getTheme(){
		return theme;
	}

	public void setTutor(Tutor tutor){
		this.tutor = tutor;
	}

	public Tutor getTutor(){
		return tutor;
	}

	public void setReports_Aux(Report_Aux report_aux){
		reports_aux.add(report_aux);
	}

	public List<Report_Aux> getReports_Aux(){
		return reports_aux;
	}

	public void setDate_registry(Date date_registry){
		this.date_registry = date_registry;
	}

	public Date getDate_registry(){
		return date_registry;
	}

	public void setDate_submit(Date date_submit){
		this.date_submit = date_submit;
	}

	public Date getDate_submit(){
		return date_submit;
	}

	public void setVar_state(Boolean var_state){
		this.var_state = var_state;
	}

	public Boolean getVar_state(){
		return var_state;
	}

}
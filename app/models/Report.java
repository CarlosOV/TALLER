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

	Boolean var_submit;

}
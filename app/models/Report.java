package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;


@Entity
@Table(name = "reports")
public class Report extends Model{

	@Id
	protected Long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
  	Theme theme;
	
	@ManyToOne(cascade=CascadeType.ALL)
  	Tutor tutor;

  	@OneToMany(mappedBy = "report" ,cascade=CascadeType.ALL)
	List<ReportAux> report_auxs;

	@Formats.DateTime(pattern="dd/MM/yyyy")
  	Date date_registry = new Date();

	@Formats.DateTime(pattern="dd/MM/yyyy")
  	Date date_submit = new Date();

	Boolean var_submit;

}
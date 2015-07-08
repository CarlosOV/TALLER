package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;


@Entity
@Table(name = "file_aux")
public class FileAux extends Model{

	@Id
	Long id;

	@ManyToOne(cascade=CascadeType.ALL)
  	File file;

  	@ManyToOne(cascade=CascadeType.ALL)
  	ReportAux report_aux;

	

}
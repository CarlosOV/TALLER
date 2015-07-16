package models;

import java.util.Date;

public class Reporte{

	private long idTema;
	private long idTutor;
	private String fecha;

	public Reporte(){
		this.idTema = 0;
		this.idTutor = 0;
	}

	public void setIdTema(long idTema){
		this.idTema = idTema;
	}

	public long getIdTema(){
		return idTema;
	}

	public void setIdTutor(long idTutor){
		this.idTutor = idTutor;
	}

	public long getIdTutor(){
		return idTutor;
	}

	public void setFecha(String fecha){
		this.fecha = fecha;
	}

	public String getFecha(){
		return fecha;
	}

}
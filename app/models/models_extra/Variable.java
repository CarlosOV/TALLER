package models;

import java.util.*;

public class Variable{

	private int idAdmin;
	private int idArea;
	private int idTutor;
	private int idCourse;
	private int idLevel;

	//CAMPOS PARA LA TABLA DE CURSOS
	private String name;
	private String area;
	private String tutor;

	//CAMPOS PARA LA TABLA DE TEMAS
	private String theme;
	private String course;
	private String level;

	public Variable(){
		this.idAdmin = 0;
		this.idArea = 0;
	}

	public void setIdAdmin(int idAdmin){
		this.idAdmin = idAdmin;
	}

	public int getIdAdmin(){
		return idAdmin;
	}

	public void setIdArea(int idArea){
		this.idArea = idArea;
	}

	public int getIdArea(){
		return idArea;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setIdTutor(int idTutor){
		this.idTutor = idTutor;
	}

	public int getIdTutor(){
		return this.idTutor;
	}

	public void setIdCourse(int idCourse){
		this.idCourse = idCourse;
	}

	public int getIdCourse(){
		return this.idCourse;
	}

	public void setIdLevel(int idLevel){
		this.idLevel = idLevel;
	}

	public int getIdLevel(){
		return this.idLevel;
	}

	public String getName(){
		return this.name;
	}

	public void setArea(String area){
		this.area = area;
	}

	public String getArea(){
		return this.area;
	}

	public void setTutor(String tutor){
		this.tutor = tutor;
	}

	public String getTutor(){
		return this.tutor;
	}

	public void setTheme(String theme){
		this.theme = theme;
	}

	public String getTheme(){
		return this.theme;
	}

	public void setCourse(String course){
		this.course = course;
	}

	public String getCourse(){
		return this.course;
	}

	public void setLevel(String level){
		this.level = level;
	}

	public String getLevel(){
		return this.level;
	}
}
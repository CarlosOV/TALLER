package models;

public class Tema{

	private long idTheme;
	private long idCurso;
	private long idNivel;

	public Tema(){
		this.idTheme=0;
		this.idCurso=0;
		this.idNivel=0;
	}

	public void setIdTheme(long idTheme){
		this.idTheme = idTheme;
	}

	public long getIdTheme(){
		return idTheme;
	}

	public void setIdCurso(long idCurso){
		this.idCurso = idCurso;
	}

	public long getIdCurso(){
		return idCurso;
	}

	public void setIdNivel(long idNivel){
		this.idNivel = idNivel;
	}

	public long getIdNivel(){
		return idNivel;
	}

}
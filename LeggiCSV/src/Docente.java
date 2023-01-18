public class Docente 
{
	String nome;
	String cognome;
	char [] classeConcorso = new char[4];
	
	public Docente(String nome, String cognome, String classeConcorso) 
	{
		this.nome = nome;
		this.cognome = cognome;
		this.classeConcorso = classeConcorso.toCharArray();	
	}
}

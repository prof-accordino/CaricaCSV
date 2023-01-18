import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass 
{
    	static ArrayList<Docente> listaDocente = new ArrayList<Docente>();

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
    	ArrayList<String> righeTabellaDocente = leggiFile("INSERIRE PRECORSO");
    	
		for(String riga : righeTabellaDocente)
		{
			// Il -1 serve per acquisire anche gli elementi senza valore come stringhe vuote
			// Se non lo usassi sballerebbe l'ordine delle colonne dato che mancano valori
			String[] colonne = riga.split(",", -1);
			System.out.println("Trovato prof. " + colonne[1] + " " + colonne[2]);
			listaDocente.add(new Docente(colonne[1],colonne[2],colonne[3]));
		}
    
	}
	static ArrayList<String> leggiFile(String percorsoFile)
	{
		// Creiamo un arrayList che conterrà tutte le linee del file csv
    	ArrayList<String> righe = new ArrayList<String>();
    	
        // Istanzio un oggetto della classe File
    	File f = new File(percorsoFile);

    	// Scanner può leggere anche dai file, lo creiamo ma per ora non lo inizializziamo 
        Scanner fileScanner;
        // L'assegnazione del file va messa dentro un blocco try (il file potrebbe non esistere)
		try  
		{
			fileScanner = new Scanner(f);
		} 
		// Se il file non esiste entrerò nel blocco catch ed eviterò di leggere un file non esistente
		catch (FileNotFoundException e) 
		{		
			System.out.println("File non trovato!");
			return null;
		}
        
        // Se siamo arrivati qui il file esiste, quindi posso leggerlo
        while (fileScanner.hasNextLine()) // Se c'è una nuova riga
        {
            String line = fileScanner.nextLine(); // La leggo
            righe.add(line); // E la metto nell'arrayList
        }
        // Quando finisco con in file chiudo lo scanner così non tengo bloccata la risorsa
        fileScanner.close(); 
        return righe;
	}
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
    	ArrayList<String> righeTabellaDocente = leggiFile("INSERIRE PRECORSO");
    	
    	for(String riga : righeTabellaDocente)
    	{
    		String[] colonne = riga.split(",");
    		System.out.println("Trovato prof. " + colonne[0] + " " + colonne[1]);
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

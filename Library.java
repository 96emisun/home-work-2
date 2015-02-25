
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 * @author Emil Sundqvist
 */
public class Library{
    
    private String filnamn;
    
    public Library(){
        
    }
    
    public void väljFil() {
        JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
        fc.showDialog(null, "Välj Fil");
        
        try{
            filnamn = fc.getSelectedFile().getName();
            System.out.println("Filen " + filnamn + " är nu vald");
        }
        catch(NullPointerException e){}
    }
    
    public void checkFileExistence(String fil){
        try{
                BufferedReader lasfil = new BufferedReader(new FileReader(fil));
            } 
            catch (FileNotFoundException ex) {
                System.out.println("Filen hittades inte, skapar fil...");
                try {
                    PrintWriter skrivfil = new PrintWriter(new BufferedWriter(new FileWriter(fil, true)));
                    skrivfil.println("Namn,Genre,Utgivningsår,Typ");
                    System.out.println("Filen har skapats");
                    skrivfil.close();
                } catch (IOException ex1) {
                    System.out.println("Någonting gick fel när filen skulle sparas.");
                }
            }
    }
    
    public void writeToFile(String fil, AbstractItemWIP item){
        try{
            PrintWriter skrivfil = new PrintWriter(new BufferedWriter(new FileWriter(fil, true)));

                System.out.println("Skriver till fil...");
                skrivfil.println(item.toString());
                skrivfil.close();
                System.out.println("Sparningen lyckades");
        }
        catch(FileNotFoundException e){
            System.out.println("Filen kunde inte hittas. Vänligen kontrollera att filen existerar");
        }
        catch(IOException e){
                System.out.println("Någonting gick fel när filen skulle sparas.");
        }
    }
    
    public String getFilnamn(){
        return filnamn;
    }
}

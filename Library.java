
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
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
    
    public void writeToCSV(String fil, AbstractItemWIP item){
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
        catch(NullPointerException e){
            System.out.println("Du har inte valt om objektet är en fil, en låt eller ett spel.");
        }
        catch(IOException e){
                System.out.println("Någonting gick fel när filen skulle sparas.");
        }
    }
    
    public ArrayList readFromCSV(String filnamn){
        if(filnamn == null){
            System.out.println("Du måste välja en fil att läsa från!");
            return null;
        }
        else{
            try{
                BufferedReader lasfil = new BufferedReader(new FileReader(filnamn));

                String[] datapost;
                String[] rubriker;
                
                String line = lasfil.readLine();
                rubriker = line.split(",");
                
                line = lasfil.readLine();
                
                ArrayList<AbstractItem> info = new ArrayList<>();
                
                while(line != null){
                    
                    datapost = line.split(",");
                    
                    AbstractItem item = new AbstractItem(datapost[0], datapost[1], datapost[2], datapost[3]);
                    info.add(item);
                    
                    line = lasfil.readLine();
                    
                }
                
                Collections.sort(info);
                
                lasfil.close();
                
                return info;
            }
            
            catch(FileNotFoundException e){
                System.out.println("Filen kunde inte hittas. Vänligen kontrollera att filen existerar.");
                return null;
            }
            
            catch(IOException e){
                System.out.println("Någonting gick fel när filen skulle läsas.");
                return null;
            }
        }
    }
    
    public String[] getRubriker(String filnamn) throws FileNotFoundException, IOException{
        BufferedReader lasfil = new BufferedReader(new FileReader(filnamn));
        
        String[] rubriker;

        String line = lasfil.readLine();
        rubriker = line.split(",");

        return rubriker;
    }
    
    public String getFilnamn(){
        return filnamn;
    }
}

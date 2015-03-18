
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * @author Emil Sundqvist
 */

/*
    This class contains all the code related to reading or writing from/to a file
*/
public class Library{
    private String filename;
    public Library(){
        filename = null;
    }
    
    /*
        Returns the filetype (the 3 last characters of the filename)
    */
    public String getFormat(String file){
        
        try{
            if(!"".equals(file)){
                return filename.substring(filename.length() - 3);
            }
            else{
                return null;
            }
        } catch(NullPointerException e){
            return null;
        }
    }
    
    /*
        Opens a JFileChooser and saves the selected file in the variable filename
    */
    public String chooseFile() {
        JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
        fc.showDialog(null, "Choose File");
        
        try{
            filename = fc.getSelectedFile().getName();
            if("csv".equals(getFormat(filename))){
                checkFileExistence(filename);
            }
            else{
                JOptionPane.showMessageDialog(null, "The file has to be a CSV file");
            }
        }
        catch(NullPointerException e){}
        return filename;
    }
    
    /*
        If the selected file does not exist, a new file is created
    */
    public void checkFileExistence(String file){
        try{
            BufferedReader readFile = new BufferedReader(new FileReader(file));
            } 
            //If a FileNotFoundException is caught, a new file is created
            catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "The file was not found, attempting to create"); 
                try {
                    PrintWriter writeFile = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
                    writeFile.println("Name;Genre;Released;Type;Damaged;On Loan");
                    JOptionPane.showMessageDialog(null, "The file has now been successfully saved"); 
                    writeFile.close();
                } catch (IOException ex1) {
                    JOptionPane.showMessageDialog(null, "Something went wrong when creating the file"); 
                }
            }
    }
    
    /*
        Saves data to a CSV file
    */
    public boolean writeToCSV(String file, AbstractItem item){
        try{
            PrintWriter writeFile = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));

            writeFile.println(item.toString());
            writeFile.close();
            return true;
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "You have not selected a type");
            return false;
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Something went wrong when saving the file"); 
            return false;
        }
    }
    
    /*
        Creates a new node in an XML document
    */
    private void createNode(XMLEventWriter eventWriter, String name,
        String value) throws XMLStreamException {

        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        XMLEvent end = eventFactory.createDTD("\n");
        XMLEvent tab = eventFactory.createDTD("\t");
        // Creates Start node
        StartElement sElement = eventFactory.createStartElement("", "", name);
        eventWriter.add(tab);
        eventWriter.add(tab);
        eventWriter.add(sElement);
        // Creates content
        Characters characters = eventFactory.createCharacters(value);
        eventWriter.add(characters);

        // create End node
        EndElement eElement = eventFactory.createEndElement("", "", name);
        eventWriter.add(eElement);
        eventWriter.add(end);

    }
    
    /*
        Reads data from a CSV file
    */
    public ArrayList readFromCSV(String sorting){
        if(filename == null){
            JOptionPane.showMessageDialog(null, "You have to choose a file to read from"); 
            return null;
        }
        else{
            try{
                BufferedReader readFile = new BufferedReader(new FileReader(filename));

                /*
                    All the neccessary data for an item is conatined within a 
                    single line. So in order to extract this data, an array is created
                */
                String[] data;
                String[] headlines;
                
                String line = readFile.readLine();
                headlines = line.split(";");
                
                line = readFile.readLine();
                
                ArrayList<AbstractItem> info = new ArrayList<>();
                
                // Do until the end of the file is reached
                while(line != null){
                    
                    // Add the data to the array
                    data = line.split(";");
                    
                    AbstractItem item = null;
                    
                    // Create a new object based on type
                    switch (data[3]) {
                        case "Movie":
                            item = new Movie(data[0], data[1], data[2], data[4], data[5], sorting);
                            break;
                        case "Music":
                            item = new Music(data[0], data[1], data[2], data[4], data[5], sorting);
                            break;
                        case "Game":
                            item = new Game(data[0], data[1], data[2], data[4], data[5], sorting);
                            break;
                    }
                    
                    info.add(item);
                    
                    line = readFile.readLine();
                    
                }
                
                Collections.sort(info);
                
                readFile.close();
                
                return info;
            }
            
            catch(FileNotFoundException e){
                JOptionPane.showMessageDialog(null, "The file could not be found, please make sure that it exists");
                return null;
            }
            
            catch(IOException e){
                JOptionPane.showMessageDialog(null, "Something went wrong when reading from the file");
                return null;
            }
        }
    }
    
    /*
        Returns the headlines of the CSV file
    */
    public String[] getHeadlines(String filename) throws FileNotFoundException, IOException{
        BufferedReader readFile = new BufferedReader(new FileReader(filename));
        
        String[] headlines;

        String line = readFile.readLine();
        headlines = line.split(";");

        return headlines;
    }
    
    /*
        Returns the name of the selected file
    */
    public String getFilename(){
        return filename;
    }
    
    /*
        Runs different methods for reading depending on the filetype of the selected file
    */
    public ArrayList<AbstractItem> read(String sort, String format){
        switch(format){
            case "csv":
                return readFromCSV(sort);
            case "xml":
                return readFromXML();
            default:
                return null;
        }
    }
    
    /*
        Reads data from an XML document
    */
    public ArrayList<AbstractItem> readFromXML() {

        String name = null;
        String genre = null;
        String year = null;
        String type = null;
        String damaged = null;
        String onLoan = null;
        AbstractItem item = null;

        ArrayList<AbstractItem> items = new ArrayList<>();
        
        if(!"xml".equals(getFormat(filename))){
            
            try {

                // First, create a new XMLInputFactory
                XMLInputFactory inputFactory = XMLInputFactory.newInstance();

                // Setup a new eventReader
                InputStream in = new FileInputStream(filename);
                XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

                // Read the XML document
                while (eventReader.hasNext()) {
                    XMLEvent event = eventReader.nextEvent();
                    if (event.isStartElement()) {
                        StartElement startElement = event.asStartElement();

                        // If we have an item element, we create a new item
                        if ("item".equals(startElement.getName().getLocalPart())) {
                            Iterator<Attribute> attributes = startElement.getAttributes();
                            while (attributes.hasNext()) {
                                Attribute attribute = attributes.next();
                                if ("name".equals(attribute.getName().toString())) {
                                    name = attribute.getValue();
                                }
                            }
                        }

                        // Reads the data from the children of <item>
                        if (event.isStartElement()) {
                            if ("name".equals(event.asStartElement().getName().getLocalPart())) {
                                event = eventReader.nextEvent();
                                name = event.asCharacters().getData();
                                continue;
                            }
                        }

                        if ("genre".equals(event.asStartElement().getName().getLocalPart())) {
                            event = eventReader.nextEvent();
                            genre = event.asCharacters().getData();
                            continue;
                        }

                        if ("year".equals(event.asStartElement().getName().getLocalPart())) {
                            event = eventReader.nextEvent();
                            year = event.asCharacters().getData();
                            continue;
                        }

                        if ("type".equals(event.asStartElement().getName().getLocalPart())) {
                            event = eventReader.nextEvent();
                            type = event.asCharacters().getData();
                            continue;
                        }

                        if ("damaged".equals(event.asStartElement().getName().getLocalPart())) {
                            event = eventReader.nextEvent();
                            damaged = event.asCharacters().getData();
                            continue;
                        }

                        if ("onLoan".equals(event.asStartElement().getName().getLocalPart())) {
                            event = eventReader.nextEvent();
                            onLoan = event.asCharacters().getData();
                            continue;
                        }
                    }

                    if("Movie".equals(type)){
                        item = new Movie(name, genre, year, damaged, onLoan, null);
                    } else if("Music".equals(type)){
                        item = new Music(name, genre, year, damaged, onLoan, null);
                    } else if("Game".equals(type)){
                        item = new Game(name, genre, year, damaged, onLoan, null);
                    }

                    // If we reach the end of an item element, we add it to the list
                    if (event.isEndElement()) {
                        EndElement endElement = event.asEndElement();
                        if ("item".equals(endElement.getName().getLocalPart())) {
                            items.add(item);
                        }
                    }

                }
            } 
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } 
            catch (XMLStreamException e) {}

            return items;
        } else{
            return null;
        }
    }
    
    /*
        The String xml is a String containing the xml code fetched from IMDB's API.
        This method parses the String and returns an ArrayList containing all the data
    */
    public ArrayList<String[]> readFromIMDB(String xml) throws IOException{
        
        /*
            The FileInputStream has to read from a file, so a file containing the
            XML code is created
        */
        PrintWriter writeFile = new PrintWriter(new BufferedWriter(new FileWriter("temp.xml")));

        writeFile.println(xml);
        writeFile.close();
        
        String[] attributeNames = new String[19];
        String[] attributeValues = new String[19];
        int i = 0;
        
        try {
            
            // Create a new XMLInputFactory and EventReader
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();

            InputStream in = new FileInputStream("temp.xml");
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

            // Read the XML document
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();

                    if ("movie".equals(startElement.getName().getLocalPart())) {
                        
                        Iterator<Attribute> attributes = startElement.getAttributes();
                        
                        // Puts all the names and values of the attributes in arrays
                        while (attributes.hasNext()) {
                            
                        Attribute attribute = attributes.next();

                        // Changes the first letter of each attribute to uppercase
                        String attributeName = attribute.getName().toString();
                        char upper = Character.toUpperCase(attributeName.charAt(0));
                        String finalName = upper + attributeName.substring(1);

                        attributeNames[i] = finalName;
                        attributeValues[i] = attribute.getValue();
                        ++i;
                            
                        }
                    }
                }
            }
        } 
        catch (XMLStreamException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong, please check that you have selected an XML file");
        }
        
        ArrayList<String[]> arrays = new ArrayList<>();
        
        arrays.add(attributeNames);
        arrays.add(attributeValues);
        
        // The file is removed since it's no longer needed
        File f = new File("temp.xml");
        f.delete();
        
        return arrays;
    }
    
    /*
        Sends a request to IMDB's API and returns a String containing the XML
        code for the object
    */
    public String getXMLString(String title, String year) throws MalformedURLException, IOException{
        
        String url = "http://www.omdbapi.com/?t="+title+"&y="+year+"&plot=short&r=xml";
        String urlFixed = url.replaceAll(" ", "+");

        URL oracle = new URL(urlFixed);
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine;
        inputLine = in.readLine();
        in.close();
        
        return inputLine;
    }
    
    /*
        Removes a specific item from the library
    */
    public void deleteItem(String itemName, ArrayList<AbstractItem> list) throws IOException{
        
        PrintWriter writeFile = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
        writeFile.println("Name;Genre;Year;Type;Damaged;On Loan");
        
        // Saves all the items except the one that matches itemName
        for(AbstractItem abItem : list){
            if(!itemName.equals(abItem.getName())){
                writeFile.println(abItem.toString());
            }
        }
        
        writeFile.close();
        JOptionPane.showMessageDialog(null, itemName + " was successfully deleted");
    }
    
    /*
        Changes the imformation of a specific item in the library
    */
    public void updateItem(String itemName, ArrayList<AbstractItem> list, String damaged, String onLoan) throws IOException{
        
        PrintWriter writeFile = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
        writeFile.println("Name;Genre;Year;Type;Damaged;On Loan");
        
        for(int i = 0; i<list.size(); i++){
            
            // If the name of the item matches itemName, replace the item with a new one
            if(itemName.equals(list.get(i).getName())){
                
                String name = list.get(i).getName();
                String genre = list.get(i).getGenre();
                String year = list.get(i).getYear();
                String type = list.get(i).getType();
                
                AbstractItem item = null;
                
                switch(type){
                    case "Movie":
                        item = new Movie(name, genre, year, damaged, onLoan, null);
                        list.set(i, item);
                        break;
                        
                    case "Music":
                        item = new Music(name, genre, year, damaged, onLoan, null);
                        list.set(i, item);
                        break;
                        
                    case "Game":
                        item = new Game(name, genre, year, damaged, onLoan, null);
                        list.set(i, item);
                        break;
                }
            }
            writeFile.println(list.get(i).toString());
        }
        
        writeFile.close();
        JOptionPane.showMessageDialog(null, itemName + " was successfully updated");
    }

    /*
        Exports the data in the ArrayList to a selected XML file
    */
    public void export(String file, ArrayList<AbstractItem> items) {
        try{
            
            // Create an XMLOutputFactory
            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            // create XMLEventWriter
            XMLEventWriter eventWriter = outputFactory
                    .createXMLEventWriter(new FileOutputStream(file));

            // Create an EventFactory
            XMLEventFactory eventFactory = XMLEventFactory.newInstance();
            XMLEvent end = eventFactory.createDTD("\n");
            XMLEvent tab = eventFactory.createDTD("\t");
            // Create and write Start Tag
            StartDocument startDocument = eventFactory.createStartDocument();
            eventWriter.add(startDocument);

            // Create config open tag
            StartElement libStartElement = eventFactory.createStartElement("",
                    "", "library");
            eventWriter.add(end);
            eventWriter.add(libStartElement);
            eventWriter.add(end);
            StartElement itemStartElement = eventFactory.createStartElement("",
                    "", "item");
            
            // Add the items
            for(AbstractItem abItem : items){
                
                eventWriter.add(tab);
                eventWriter.add(itemStartElement);
                eventWriter.add(end);

                createNode(eventWriter, "name", abItem.getName());
                createNode(eventWriter, "genre", abItem.getGenre());
                createNode(eventWriter, "year", abItem.getYear());
                createNode(eventWriter, "type", abItem.getType());
                createNode(eventWriter, "damaged", abItem.getDamaged());
                createNode(eventWriter, "onLoan", abItem.getOnLoan());

                eventWriter.add(tab);
                eventWriter.add(eventFactory.createEndElement("", "", "item"));
                eventWriter.add(end);
                }

                //end
                eventWriter.add(eventFactory.createEndElement("", "", "library"));
                eventWriter.add(end);
                eventWriter.add(eventFactory.createEndDocument());
                eventWriter.close();
                
                JOptionPane.showMessageDialog(null, "Successfully exported to " + file); 
        } 
        
        catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }
}
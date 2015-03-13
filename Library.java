
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
public class Library{
    
    private String filename;
    private String NAME;
    private String GENRE;
    private String YEAR;
    private String TYPE;
    private String ITEM;
    
    public Library(){
        NAME = "name";
        GENRE = "genre";
        YEAR = "year";
        TYPE = "type";
        ITEM = "item";
    }
    
    public void chooseFile() {
        JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
        fc.showDialog(null, "Choose File");
        
        try{
            filename = fc.getSelectedFile().getName();
            JOptionPane.showMessageDialog(null, "The file " + filename + " has now been selected"); 
        }
        catch(NullPointerException e){}
    }
    
    public void checkFileExistence(String file){
        try{
                BufferedReader readFile = new BufferedReader(new FileReader(file));
            } 
            catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "The file was not found, attempting to create"); 
                try {
                    PrintWriter writeFile = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
                    writeFile.println("Name,Genre,Released,Type");
                    JOptionPane.showMessageDialog(null, "The file has now been created"); 
                    writeFile.close();
                } catch (IOException ex1) {
                    JOptionPane.showMessageDialog(null, "Something went wrong when creating the file"); 
                }
            }
    }
    
    public boolean writeToCSV(String fil, AbstractItem item){
        try{
            PrintWriter writeFile = new PrintWriter(new BufferedWriter(new FileWriter(fil, true)));

                writeFile.println(item.toString());
                writeFile.close();
                JOptionPane.showMessageDialog(null, "Successfully wrote to file"); 
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
    
    private static void createNode(XMLEventWriter eventWriter, String name,
        String value) throws XMLStreamException {

        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        XMLEvent end = eventFactory.createDTD("\n");
        XMLEvent tab = eventFactory.createDTD("\t");
        // create Start node
        StartElement sElement = eventFactory.createStartElement("", "", name);
        eventWriter.add(tab);
        eventWriter.add(tab);
        eventWriter.add(sElement);
        // create Content
        Characters characters = eventFactory.createCharacters(value);
        eventWriter.add(characters);

        // create End node
        EndElement eElement = eventFactory.createEndElement("", "", name);
        eventWriter.add(eElement);
        eventWriter.add(end);

    }
    
    public boolean writeToXML(String filename, AbstractItem item) {
        try{
            
            // create an XMLOutputFactory
            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            // create XMLEventWriter
            XMLEventWriter eventWriter = outputFactory
                    .createXMLEventWriter(new FileOutputStream(filename, true));

            // create an EventFactory
            XMLEventFactory eventFactory = XMLEventFactory.newInstance();
            XMLEvent end = eventFactory.createDTD("\n");
            XMLEvent tab = eventFactory.createDTD("\t");
            // create and write Start Tag
            StartDocument startDocument = eventFactory.createStartDocument();
            eventWriter.add(startDocument);

            // create config open tag
            StartElement libStartElement = eventFactory.createStartElement("",
                    "", "library");
                      eventWriter.add(end);
            eventWriter.add(libStartElement);
            eventWriter.add(end);
            StartElement itemStartElement = eventFactory.createStartElement("",
                    "", "item");//för id

            // Contact1
            //for each
            eventWriter.add(tab);
            eventWriter.add(itemStartElement);
            eventWriter.add(end);
            createNode(eventWriter, NAME, item.getName());
            createNode(eventWriter, GENRE, item.getGenre());
            createNode(eventWriter, YEAR, item.getYear());
            createNode(eventWriter, TYPE, item.getType());
            eventWriter.add(tab);
            eventWriter.add(eventFactory.createEndElement("", "", "item"));
            eventWriter.add(end);

            //end for
            eventWriter.add(eventFactory.createEndElement("", "", "library"));
            eventWriter.add(end);
            eventWriter.add(eventFactory.createEndDocument());
            eventWriter.close();
            
            return true;
        } 
        catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<AbstractItem> readXML(String fileName) {
        ArrayList<AbstractItem> contacts = new ArrayList<>();
        try {
            // First, create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            InputStream in = new FileInputStream(fileName);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            // read the XML document
            AbstractItem item = null;
            while (eventReader.hasNext()) {
                
                XMLEvent event = eventReader.nextEvent();
                
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    
                    // If we have an item element, we create a new item
                    if (ITEM.equals(startElement.getName().getLocalPart())) {
                        item = new AbstractItem() {};
                        Iterator<Attribute> attributes = startElement.getAttributes();
                        
                        while (attributes.hasNext()) {
                            Attribute attribute = attributes.next();
                            
                            if (attribute.getName().toString().equals(NAME)) {
                                item.setName( attribute.getValue() );
                            }
                        }
                    } else {
                    }
                    if (event.isStartElement()) {
                            if ( event.asStartElement().getName().getLocalPart().equals(NAME) ) {
                                event = eventReader.nextEvent();
                                item.setName(event.asCharacters().getData());
                                continue;
                            }
                    }

                    if (event.asStartElement().getName().getLocalPart().equals(ADRESS) ) {
                            event = eventReader.nextEvent();
                            item.setAdress(event.asCharacters().getData());
                            continue;
                    }
                    if (event.asStartElement().getName().getLocalPart().equals(PHONE) ) {
                            event = eventReader.nextEvent();
                            item.setPhone(event.asCharacters().getData());
                            continue;
                    }
                }
                // If we reach the end of an item element, we add it to the list
                if (event.isEndElement()) {
                        EndElement endElement = event.asEndElement();
                        if (endElement.getName().getLocalPart() == (ITEM)) {
                                contacts.add(item);
                        }
                }

            }
        } 
        catch (FileNotFoundException e) {
                    e.printStackTrace();
        } 
        catch (XMLStreamException e) {
                    e.printStackTrace();
        }
        return contacts;
    }
    
    public ArrayList readFromCSV(String filename, String sorting){
        if(filename == null){
            JOptionPane.showMessageDialog(null, "You have to choose a file to read from"); 
            return null;
        }
        else{
            try{
                BufferedReader readFile = new BufferedReader(new FileReader(filename));

                String[] data;
                String[] headlines;
                
                String line = readFile.readLine();
                headlines = line.split(",");
                
                line = readFile.readLine();
                
                ArrayList<AbstractItem> info = new ArrayList<>();
                
                while(line != null){
                    
                    data = line.split(",");
                    
                    AbstractItem item = null;
                    
                    switch (data[3]) {
                        case "Movie":
                            item = new Movie(data[0], data[1], data[2], sorting);
                            break;
                        case "Music":
                            item = new Music(data[0], data[1], data[2], sorting);
                            break;
                        case "Game":
                            item = new Game(data[0], data[1], data[2], sorting);
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
    
    public String[] getHeadlines(String filename) throws FileNotFoundException, IOException{
        BufferedReader readFile = new BufferedReader(new FileReader(filename));
        
        String[] headlines;

        String line = readFile.readLine();
        headlines = line.split(",");

        return headlines;
    }
    
    public String getFilename(){
        return filename;
    }
}

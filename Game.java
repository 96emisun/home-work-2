public class Game extends AbstractItem{
    
    private String name;
    private String genre;
    private String year;
    private String sorting;
    private String damaged;
    private String onLoan;
    
    public Game(){
        this.name = "";
        this.genre = "";
        this.year = "";
        this.sorting = "";
        this.damaged = "";
        this.onLoan = "";
    }
    
    /**
     * 
     * @param name The name of the item
     * @param genre The genre of the item
     * @param year The release year of the item
     * @param damaged The condition of the item
     * @param onLoan The status of the item
     * @param sorting How to sort the item. This is only needed when reading from a file
     */
    public Game(String name, String genre, String year, String damaged, String onLoan, String sorting){
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.sorting = sorting;
        this.damaged = damaged;
        this.onLoan = onLoan;
    }
    
    /**
     * 
     * @return Returns the name of the item
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * 
     * @return Returns the genre of the item
     */
    @Override
    public String getGenre() {
        return genre;
    }

    /**
     * 
     * @return Returns the release year of the item
     */
    @Override
    public String getYear() {
        return year;
    }
    
    /**
     * 
     * @return Returns the type of the item
     */
    @Override
    public String getType() {
        return "Game";
    }
    
    /**
     * Creates the String that is used for sorting the list in the correct order
     * 
     * @return The String used for sorting
     */
    @Override
    public String getSortString() {
        String fullString = "Game" + this.name + this.year + this.genre;
        return fullString;
    }
    
    /**
     * 
     * @return Returns 1 if damaged, otherwise 0
     */
    @Override
    public String getDamaged() {
        return this.damaged;
        
    }
    
    /**
     * 
     * @return Returns 1 if on loan, otherwise 0
     */
    @Override
    public String getOnLoan() {
        return this.onLoan;
        
    }
    
    @Override
    public String getStatusString() {
        
        if("1".equals(damaged) && "1".equals(onLoan)){
            return "On loan, damaged";
        }
        else if("1".equals(damaged) && "0".equals(onLoan)){
            return "Damaged";
        }
        else if("0".equals(damaged) && "1".equals(onLoan)){
            return "On loan";
        }
        else{
            return "N/A";
        }
        
    }
    
    /**
     * Creates the String used for displaying the status of the item
     * 
     * @return The String containing the status of the item
     */
    @Override
    public String toString(){
        return this.name + ";" + this.genre + ";" + this.year + ";" + 
                "Game" + ";" + this.damaged + ";" + this.onLoan;
    }
    
    /**
     * Compares this item with another item and returns an integer based on the result
     * 
     * @param other The object to compare this item to
     * @return Returns 0 if equal. More than 0 if greater than argument and
     * less than 0 if lesser than argument
     */
    @Override
    public int compareTo(Object other) {
        AbstractItem o = (AbstractItem) other;
        
        switch(sorting){
            case "Default":
                return this.getSortString().compareTo(o.getSortString());
            case "Name":
                return this.getName().compareTo(o.getName());
            case "Genre":
                return this.genre.compareTo(o.getGenre());
            case "Year":
                return this.year.compareTo(o.getYear());
            default:
                return 0;
        }
    }
}
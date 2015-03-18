public abstract class AbstractItem implements Comparable {
    
    private String name;
    private String genre;
    private String year;
    private String sorting;
    private String damaged;
    private String onLoan;
    
    /**
     * This abstract class contains methods used for working with the
     * different items
     */
    public AbstractItem(){
        
    }
    
    /**
     * Puts all the variables together to a single String that can
     * be used for saving the object to a CSV file
     * 
     * @return The String used for saving the object
     */
    @Override
    public abstract String toString();

    /**
     * 
     * @return Returns the name of the item
     */
    public String getName(){
        return name;
    }

    /**
     * 
     * @return Returns the genre of the item
     */
    public String getGenre(){
        return genre;
    }

    /**
     * 
     * @return Returns the release year of the item
     */
    public String getYear(){
        return year;
    }
    
    /**
     * 
     * @return Returns the type of the item
     */
    public abstract String getType();
    
    /**
     * Creates the String that is used for sorting the list in the correct order
     * 
     * @return The String used for sorting
     */
    public abstract String getSortString();
    
    /**
     * 
     * @return Returns 1 if damaged, otherwise 0
     */
    public String getDamaged(){
        return damaged;
    }
    
    /**
     * 
     * @return Returns 1 if on loan, otherwise 0
     */
    public String getOnLoan(){
        return onLoan;
    }
    
    /**
     * Creates the String used for displaying the status of the item
     * 
     * @return The String containing the status of the item
     */
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

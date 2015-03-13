public abstract class AbstractItem implements Comparable {
    
    private String name;
    private String genre;
    private String year;
    private String sorting;
    
    public AbstractItem(){
        
    }
    
    @Override
    public abstract String toString();

    public abstract String getName();

    public abstract String getGenre();

    public abstract String getYear();
    
    public abstract String getType();
    
    public abstract String getSorting();
    
    @Override
    public abstract int compareTo(Object other);
    
}

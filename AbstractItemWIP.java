public abstract class AbstractItemWIP implements Comparable {
    
    private String namn;
    private String genre;
    private String år;
    
    public AbstractItemWIP(){
        
    }
    
    @Override
    public abstract String toString();

    public String getNamn() {
        return namn;
    }

    public String getGenre() {
        return genre;
    }

    public String getÅr() {
        return år;
    }
    
    @Override
    public abstract int compareTo(Object other);
    
}

public abstract class AbstractItemWIP implements Comparable {
    
    private String namn;
    private String genre;
    private String år;
    private String typ;
    
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
    
    public String getTyp() {
        return typ;
    }
    
    @Override
    public abstract int compareTo(Object other);
    
}

public class AbstractItem implements Comparable{
    
    protected String namn;
    protected String genre;
    protected String år;
    protected String typ;
    
    public AbstractItem(){
        this.namn = "";
        this.genre = "";
        this.år = "";
        this.typ = "";
    }
    
    public AbstractItem(String namn, String genre, String år, String typ){
        this.namn = namn;
        this.genre = genre;
        this.år = år;
        this.typ = typ;
    }
    
    @Override
    public String toString(){
        return this.namn + "," + this.genre + "," + this.år + "," + this.typ;
    }

    public String getNamn() {
        return namn;
    }

    public String getGenre() {
        return genre;
    }
    
    public String getÅr(){
        return år;
    }
    
    public String getTyp(){
        return typ;
    }

    @Override
    public int compareTo(Object other) {
        AbstractItem o = (AbstractItem) other;
        return this.namn.compareTo(o.getNamn());
    }
}

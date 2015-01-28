public class Spel extends AbstractItemWIP{
    
    private String namn;
    private String genre;
    private String år;
    
    public Spel(){
        this.namn = "";
        this.genre = "";
        this.år = "";
    }
    
    public Spel(String namn, String genre, String år){
        this.namn = namn;
        this.genre = genre;
        this.år = år;
    }
    
    @Override
    public String toString(){
        return this.namn + "," + this.genre + "," + this.år + "," + "Spel";
    }

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
    public int compareTo(Object other) {
        AbstractItem o = (AbstractItem) other;
        return this.namn.compareTo(o.getNamn());
    }
}
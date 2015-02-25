public class Musik extends AbstractItemWIP{
    
    private String namn;
    private String genre;
    private String år;
    
    public Musik(){
        this.namn = "";
        this.genre = "";
        this.år = "";
    }
    
    public Musik(String namn, String genre, String år){
        this.namn = namn;
        this.genre = genre;
        this.år = år;
    }
    
    @Override
    public String toString(){
        return this.namn + "," + this.genre + "," + this.år + "," + "Musik";
    }
    
    @Override
    public int compareTo(Object other) {
        AbstractItem o = (AbstractItem) other;
        return this.namn.compareTo(o.getNamn());
    }
}
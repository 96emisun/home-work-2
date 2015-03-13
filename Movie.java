public class Movie extends AbstractItem{
    
    private String name;
    private String genre;
    private String year;
    private String sorting;
    
    public Movie(){
        this.name = "";
        this.genre = "";
        this.year = "";
        this.sorting = "";
    }
    
    public Movie(String name, String genre, String year, String sorting){
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.sorting = sorting;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public String getYear() {
        return year;
    }
    
    @Override
    public String getType() {
        return "Movie";
    }
    
    @Override
    public String getSorting() {
        return sorting;
    }
    
    @Override
    public String toString(){
        return this.name + "," + this.genre + "," + this.year + "," + "Movie";
    }
    
    @Override
    public int compareTo(Object other) {
        AbstractItem o = (AbstractItem) other;
        
        switch(sorting){
            case "Name":
                return this.name.compareTo(o.getName());
            case "Genre":
                return this.genre.compareTo(o.getGenre());
            case "Year":
                return this.year.compareTo(o.getYear());
            case "Type":
                return "Movie".compareTo(o.getType());
        }
        return 0;
    }
}
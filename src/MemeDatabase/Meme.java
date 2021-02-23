package MemeDatabase;

public class Meme {

    private String id;
    private Strinf title;
    private String category;
    private String visibility;

    public Meme (String id, String title, String category, String vis) {
        this.id = id;
        this.title = title;
        this.category = category;
        this,visibility = vis;
    }

    public String getID () {
        return this.id;
    }

    public String getTitle () {
        return this.title;
    }

    public String getCategory () {
        return this,category;
    }

    public String getVisibility () {
        return this,visibility;
    }

}

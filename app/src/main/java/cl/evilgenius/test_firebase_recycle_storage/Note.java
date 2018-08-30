package cl.evilgenius.test_firebase_recycle_storage;

public class Note {
    private String tittle;
    private String description;
    private int priority;

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Note(){
        //empty constructor needed
    }

    public Note(String tittle, String description, int priority) {
        this.tittle = tittle;
        this.description = description;
        this.priority = priority;
    }

    public String getTittle() {
        return tittle;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}

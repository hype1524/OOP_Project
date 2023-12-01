import java.time.LocalDate;
import java.time.LocalTime;

public class Folder {
    private int id;
    private int userId;
    private String name;
    private String description;
    private LocalDate dateCreate;
    private LocalTime timeCreate;
    private int numberList;

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public LocalTime getTimeCreate() {
        return timeCreate;
    }

    public int getNumberList() {
        return numberList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public void setTimeCreate(LocalTime timeCreate) {
        this.timeCreate = timeCreate;
    }

    public void setNumberList(int numberList) {
        this.numberList = numberList;
    }
}

import java.time.LocalDate;
import java.time.LocalTime;

public class Topic extends Folder {
    private int folderId;
    private int numberWord;
    private boolean status;

    public int getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }


    public int getNumberWord() {
        return numberWord;
    }

    public void setNumberWord(int numberWord) {
        this.numberWord = numberWord;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
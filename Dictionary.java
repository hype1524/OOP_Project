import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private List<Word> dictionary;
    public Dictionary() {
        dictionary = new ArrayList<Word>();
    }
    public void addWord(Word newWord) {
        dictionary.add(newWord);
    }
    public void print() {
        for (Word i : dictionary) {
            System.out.println(i.getWord_target() + " : " + i.getWord_explain());
        }
    }
}

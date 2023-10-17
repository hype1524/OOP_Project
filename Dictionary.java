import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    protected List<Word> dictionary;

    public Dictionary() {
        dictionary = new ArrayList<>();
    }

    public void addWord(Word newWord) {
        dictionary.add(newWord);
    }

    public void removeWord(String wordTarget) {
        for (int i = 0; i < dictionary.size(); i++) {
            if (dictionary.get(i).getWordTarget().equals(wordTarget)) {
                dictionary.remove(i);
            }
        }
    }

    public void editWord(String wordTarget, String wordExplain) {
        for (Word word : dictionary) {
            if (word.getWordTarget().equals(wordTarget)) {
                word.setWordExplain(wordExplain);
            }
        }
    }

    public String getExplain(String wordTarget) {
        String wordExplain = new String();
        for (Word word : dictionary) {
            if (word.getWordTarget().equals(wordTarget)) {
                wordExplain = word.getWordExplain();
                break;
            }
        }
        if (wordExplain == null) {
            return "!";
        }
        return wordExplain;
    }

    public int getSize() {
        return dictionary.size();
    }

    public Word getWord(int index) {
        return dictionary.get(index);
    }
}

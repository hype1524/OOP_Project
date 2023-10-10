import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class DictionaryManagement extends Dictionary {
    private TreeMap<String, List<String>> mapDictionary;

    public DictionaryManagement() {
        mapDictionary = new TreeMap<>();
    }

    @Override
    public void addWord(Word newWord) {
        super.addWord(newWord);
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < newWord.getWordTarget().length(); i++) {
            key.append(newWord.getWordTarget().charAt(i));
            if (mapDictionary.get(key.toString()) == null) {
                ArrayList<String> b = new ArrayList<>();
                b.add(newWord.getWordTarget());
                mapDictionary.put(key.toString(), b);
            } else {
                mapDictionary.get(key.toString()).add(newWord.getWordTarget());
            }
        }
    }

    @Override
    public void removeWord(String wordTarget) {
        super.removeWord(wordTarget);
        for (Word word : dictionary) {
            if (word.getWordTarget().equals(wordTarget)) {
                StringBuilder wordRemoved = new StringBuilder();
                for (int j = 0; j < wordTarget.length(); j++) {
                    wordRemoved.append(wordTarget.charAt(j));
                    List<String> a = mapDictionary.get(wordRemoved.toString());
                    a.remove(wordTarget);
                }
            }
        }
    }

    public void insertFromFile(String filePath) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("C:\\Users\\Laptop\\IdeaProjects\\ProjectOOPJavaFX\\dictionaries.txt");
            //"C:\\Users\\Laptop\\IdeaProjects\\ProjectOOPJavaFX\\dictionaries.txt"
            Scanner scanner = new Scanner(new BufferedInputStream(fileInputStream));
            while (scanner.hasNext()) {
                String wordTarget = scanner.next();
                scanner.skip("\t");
                String wordExplain = scanner.nextLine();
                Word newWord = new Word(wordTarget, wordExplain);
                this.addWord(newWord);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> lookUp(String key) {
        return mapDictionary.get(key);
    }

    public void dictionaryExportToFile() {

    }
}

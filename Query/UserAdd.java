import com.example.oopproject.Entity.*;

public class UserAdd {
    public static MyString addFolder(Folder folder) {
        return GenericPost.addAndEdit("http://171.244.63.46/api/add/addFolder", folder);
    }

    public static MyString addTopic(Topic topic) {
        return GenericPost.addAndEdit("http://171.244.63.46/api/add/addTopic", topic);
    }

    public static MyString addWord(PersonalWord personalWord) {
        return GenericPost.addAndEdit("http://171.244.63.46/api/add/addWord", personalWord);
    }

    public static MyString addNotification(Notification notification) {
        return GenericPost.addAndEdit("http://171.244.63.46/api/add/addNotification", notification);
    }

    public static MyString addDefaultTopic(Topic topic) {
        return GenericPost.addAndEdit("http://171.244.63.46/api/add/addDefaultTopic", topic);
    }

    public static MyString addDefaultWord(PersonalWord personalWord) {
        return GenericPost.addAndEdit("http://171.244.63.46/api/add/addDefaultWord", personalWord);
    }
}

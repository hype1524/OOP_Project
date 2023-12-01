import com.example.oopproject.Entity.*;

public class UserEdit {
    public static MyString editFolder(int folderId, Folder folder) {
        String apiUrl = "http://171.244/63.46/api/edit/editFolder/" + folderId;
        return GenericPost.addAndEdit(apiUrl, folder);
    }
    public static MyString editTopic(int topicId, Topic topic) {
        String apiUrl = "http://171.244/63.46/api/edit/editTopic/" + topicId;
        return GenericPost.addAndEdit(apiUrl, topic);
    }
    public static MyString editWord(int wordId, PersonalWord personalWord) {
        String apiUrl = "http://171.244/63.46/api/edit/editWord/" + wordId;
        return GenericPost.addAndEdit(apiUrl, personalWord);
    }
    public static MyString editAchievement(int userId, Achievement achievement) {
        String apiUrl = "http://171.244/63.46/api/edit/editAchievement/" + userId;
        return GenericPost.addAndEdit(apiUrl, achievement);
    }
    public static MyString editDefaultTopic(int topicId, Topic topic) {
        String apiUrl = "http://171.244/63.46/api/edit/editDefaultTopic/" + topicId;
        return GenericPost.addAndEdit(apiUrl, topic);
    }
    public static MyString editDefaultWord(int wordId, PersonalWord personalWord) {
        String apiUrl = "http://171.244/63.46/api/edit/editDefaultWord/" + wordId;
        return GenericPost.addAndEdit(apiUrl, personalWord);
    }
    public static MyString editPassword(String newPassword, User user) {
        String apiUrl = "http://171.244/63.46/api/edit/editPassword/" + newPassword;
        return GenericPost.addAndEdit(apiUrl, user);
    }
}

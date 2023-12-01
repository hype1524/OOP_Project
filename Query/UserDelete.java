import com.example.oopproject.Entity.MyString;

public class UserDelete {
    public static MyString deleteFolder(int folderId) {
        String apiUrl = "http://171.244.63.46/api/delete/deleteFolder/" + folderId;
        return GenericPost.delete(apiUrl);
    }

    public static MyString deleteTopic(int topicId) {
        String apiUrl = "http://171.244.63.46/api/delete/deleteTopic/" + topicId;
        return GenericPost.delete(apiUrl);
    }

    public static MyString deleteWord(int wordId) {
        String apiUrl = "http://171.244.63.46/api/delete/deleteWord/" + wordId;
        return GenericPost.delete(apiUrl);
    }

    public static MyString deleteAllTopic(int folderId) {
        String apiUrl = "http://171.244.63.46/api/delete/deleteAllTopic/" + folderId;
        return GenericPost.delete(apiUrl);
    }

    public static MyString deleteAllWord(int topicId) {
        String apiUrl = "http://171.244.63.46/api/delete/deleteAllWord/" + topicId;
        return GenericPost.delete(apiUrl);
    }

    public static MyString deleteNotification(int notificationId) {
        String apiUrl = "http://171.244.63.46/api/delete/deleteNotification/" + notificationId;
        return GenericPost.delete(apiUrl);
    }

    public static MyString deleteDefaultTopic(int topicId) {
        String apiUrl = "http://171.244.63.46/api/delete/deleteDefaultTopic/" + topicId;
        return GenericPost.delete(apiUrl);
    }

    public static MyString deleteDefaultWord(int wordId) {
        String apiUrl = "http://171.244.63.46/api/delete/deleteDefaultWord/" + wordId;
        return GenericPost.delete(apiUrl);
    }

    public static MyString deleteAllDefaultTopic(int folderId) {
        String apiUrl = "http://171.244.63.46/api/delete/deleteAllDefaultTopic/" + folderId;
        return GenericPost.delete(apiUrl);
    }

    public static MyString deleteAllDefaultWord(int topicId) {
        String apiUrl = "http://171.244.63.46/api/delete/deleteAllDefaultWord/" + topicId;
        return GenericPost.delete(apiUrl);
    }
}

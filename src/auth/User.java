package auth;

public class User {
    private static final User instance = new User();

    private static int id;
    private static String username;
    private static String email;
    private static String birthday;

    private User(){}

    public static User getInstance() {
        return instance;
    }

    public static void setInformation(
        int id,
        String username,
        String email,
        String birthday
    ) {
        User.id = id;
        User.username = username;
        User.email = email;
        User.birthday = birthday;
    }

    public static int getId() {
        return User.id;
    }

    public static String getUsername() {
        return User.username;
    }

    public static String getEmail() {
        return User.email;
    }

    public static String getBirthday() {
        return User.birthday;
    }
}

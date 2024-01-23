package auth;

public class User {
    private static final User instance = new User();

    private int id;
    private String username;
    private String email;
    private String birthday;

    private User(){}

    public static User getInstance() {
        return instance;
    }

    public void setInformation(
        int id,
        String username,
        String email,
        String birthday
    ) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.birthday = birthday;
    }

    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getBirthday() {
        return this.birthday;
    }
}

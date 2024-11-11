package view.login;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> users = new HashMap<>();

    public boolean registerUser(String username, String password) {
        if (!users.containsKey(username)) {
            users.put(username, new User(username, password));
            System.out.println("User registered successfully!");
            return true;
        } else {
            System.out.println("Username already exists!");
            return false;
        }
    }

    public boolean loginUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid username or password!");
            return false;
        }
    }
}
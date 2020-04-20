package lesson33w04hw;

import java.util.HashMap;
import java.util.Map;

public class DataBase {

    static Map<String,String> users = new HashMap();

    public String register(String login, String password, String passwordConfirm) {
        if (users.containsKey(login)){
            return "The login is already used, please use a new one!";
        }else if (password.equals(passwordConfirm) && !users.containsKey(login)
                && !login.isEmpty() && !password.isEmpty()){
            users.put(login,password);
            System.out.println(users.entrySet());
        return "You have registered successfully!";}
        return "Something went wrong!";
    }

    public String check(String login, String password) {
        if (users.containsKey(login) && users.containsValue(password))
            return "Welcome "+login;
        return "Access denied!";
    }
}

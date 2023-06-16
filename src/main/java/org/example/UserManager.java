package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserManager {
    public List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }
    public void addUser(User user){
        this.users.add(user);
    }
    public List<User> getUsers() {
        return users;
    }

    public boolean findUser(Command cmd) {
        for (User user:this.users) {
            if (cmd.param1.equals(user.getName()) && cmd.param2.equals((user.getPwd()))){
                return true;
            }
        }
        return false;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
}

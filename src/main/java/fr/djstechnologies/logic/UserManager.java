package fr.djstechnologies.logic;

import fr.djstechnologies.business.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
  private List<User> users;

    public UserManager() {
        this.loadUsers();
    }

    public UserManager(List<User> users) {
        this.users = users;
    }

    private void loadUsers(){
        this.users = new ArrayList<>();
        User admin = new User("admin","admin","Diabate","Jean","0102030405");
        this.users.add(admin);
        User bernard = new User("jean","js","Bernard","Frederic","0807060504");
        this.users.add(bernard);
    }

    public User isAuth(String login, String pwd){
        User user = null;
        for (User u: this.users){
            if (u.getLogin().equals(login) && u.getPwd().equals(pwd)){
                user = u;
            }
        }
        return user;
    }
}

package com.VigyanshalaMeetingpoint.Service;

import com.VigyanshalaMeetingpoint.Entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserService {
    private static final List<User> USERS_LIST = new ArrayList<>();
//    {
//        USERS_LIST.add(new User("Akash","akash123@gmail.com","123","unknown"));
//    }
    public void register(User user)
    {
        user.setStatus("Online");
        USERS_LIST.add(user);

    }

    public User login(User user)
    {
        var userIndex = IntStream.range(0,USERS_LIST.size())
                .filter(i->USERS_LIST.get(i).getEmail().equals(user.getEmail()))
                .findAny()
                .orElseThrow(()-> new RuntimeException("User Not Found"));


        var cUser=USERS_LIST.get(userIndex);

        if(!cUser.getPassword().equals(user.getPassword()))
        {
            throw new RuntimeException("Password Incorrect");
        }

        cUser.setStatus("Online");
        return cUser;
    }

    public void logout(String email)
    {
        var userIndex = IntStream.range(0,USERS_LIST.size())
                .filter(i->USERS_LIST.get(i).getEmail().equals(email))
                .findAny()
                .orElseThrow(()-> new RuntimeException("User Not Found"));
        USERS_LIST.get(userIndex).setStatus("Offline");
    }

   public List<User> findAll(){
        return USERS_LIST;
   }
}



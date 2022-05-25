package sk.example.util;

import sk.example.entity.User;

public class UserUtil {
    
    public static User createUser(Long userId, String userGuid, String userName) {
        User user = new User();
        user.setUserId(userId);
        user.setUserGuid(userGuid);
        user.setUserName(userName);
        return user;
    }
}

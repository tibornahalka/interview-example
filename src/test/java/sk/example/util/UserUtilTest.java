package sk.example.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sk.example.entity.User;

class UserUtilTest {

    @Test
    void createUser() {
        Long userId = 1l;
        String userGuid = "a1";
        String userName = "Robert";

        User user = UserUtil.createUser(userId, userGuid, userName);

        Assertions.assertEquals(userId, user.getUserId());
        Assertions.assertEquals(userGuid, user.getUserGuid());
        Assertions.assertEquals(userName, user.getUserName());
    }
}
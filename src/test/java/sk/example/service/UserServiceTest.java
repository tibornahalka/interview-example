package sk.example.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sk.example.entity.User;
import sk.example.util.UserUtil;

class UserServiceTest {

    UserService service = new UserService();

    @AfterEach
    void cleanupDb() {
        service.deleteAll();
    }

    @Test
    void addUser() {
        User user = UserUtil.createUser(1L, "a1", "Robert");
        service.addUser(user);
        Assertions.assertEquals(user, service.findAll().get(0));
    }

    @Test
    void deleteAll() {
        User user = UserUtil.createUser(1L, "a1", "Robert");
        service.addUser(user);
        Assertions.assertEquals(user, service.findAll().get(0));
        service.deleteAll();
        Assertions.assertTrue(service.findAll().isEmpty());
    }

    @Test
    void exampleDemonstration() {
        User user1 = UserUtil.createUser(1L, "a1", "Robert");
        service.addUser(user1);
        User user2 = UserUtil.createUser(2L, "a2", "Martin");
        service.addUser(user2);
        Assertions.assertEquals(2, service.findAll().size());
        Assertions.assertEquals(user1, service.findAll().get(0));
        Assertions.assertEquals(user2, service.findAll().get(1));

        // print all - should print 2 users
        System.out.println("First print: ");
        service.printAll();

        service.deleteAll();
        Assertions.assertTrue(service.findAll().isEmpty());

        System.out.println("Second print: ");
        // print all - should not print any user
        service.printAll();
    }
}
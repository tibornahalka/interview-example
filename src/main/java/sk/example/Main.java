package sk.example;

import sk.example.entity.User;
import sk.example.service.UserService;
import sk.example.util.UserUtil;

public class Main {

    public static void main(String args[]) {

        User robert = UserUtil.createUser(1L, "a1", "Robert");
        User martin = UserUtil.createUser(2L, "a2", "Martin");

        UserService service = new UserService();

        System.out.println("Adding first user: " + robert.getUserName());
        service.addUser(robert);
        System.out.println("Adding second user: " + martin.getUserName());
        service.addUser(martin);

        System.out.println("Printing all users in DB: ");
        service.printAll();

        System.out.println("Delete all users in DB. ");
        service.deleteAll();

        System.out.println("Printing all users in DB: ");
        service.printAll();
    }


}

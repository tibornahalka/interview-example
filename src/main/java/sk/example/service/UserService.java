package sk.example.service;

import sk.example.dao.UserDaoImpl;
import sk.example.entity.User;

import java.util.List;

public class UserService {

    private static UserDaoImpl userDao;

    public UserService() {
        userDao = new UserDaoImpl();
    }

    public void addUser(User user) {
        userDao.openCurrentSessionwithTransaction();
        userDao.addUser(user);
        userDao.closeCurrentSessionwithTransaction();
    }

    public List<User> findAll() {
        userDao.openCurrentSession();
        List<User> users = userDao.findAll();
        userDao.closeCurrentSession();
        return users;
    }

    public void deleteAll() {
        userDao.openCurrentSessionwithTransaction();
        userDao.deleteAll();
        userDao.closeCurrentSessionwithTransaction();
    }

    public void printAll() {
        List<User> users = findAll();
        for (User user : users) {
            System.out.println("USER_ID: " + user.getUserId() + " , USER_GUID: " + user.getUserGuid() + " , USER_NAME: " + user.getUserName());
        }
    }
}

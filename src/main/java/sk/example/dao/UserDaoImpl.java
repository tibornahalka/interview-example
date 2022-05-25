package sk.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import sk.example.entity.User;

import java.util.List;

public class UserDaoImpl implements UserDao<User, String> {

    private Session currentSession;

    private Transaction currentTransaction;
    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(User.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public void delete(User user) {
        currentSession.delete(user);
    }

    @Override
    public void addUser(User user) {
        currentSession.save(user);
    }

    @Override
    public List<User> findAll() {
        List<User> users = (List<User>) currentSession.createQuery("from User").list();
        return users;
    }

    @Override
    public void deleteAll() {
        List<User> usersList = findAll();
        for (User user : usersList) {
            delete(user);
        }
    }
}

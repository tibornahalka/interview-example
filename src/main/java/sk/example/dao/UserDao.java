package sk.example.dao;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public interface UserDao<T, Id extends Serializable> {

    public void addUser(T entity);

    public List<T> findAll();

    public void deleteAll();
}

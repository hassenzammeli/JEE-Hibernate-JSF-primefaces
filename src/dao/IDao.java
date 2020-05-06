package dao;

import java.util.List;

/**
 *
 * @author hassen-zammeli
 */
public interface IDao <T>{
    boolean create(T o);

    boolean update(T o);

    boolean delete(T o);

    List<T> getAll();

    T getById(int id);
}

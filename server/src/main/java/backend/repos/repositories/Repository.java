package backend.repos.repositories;

import java.util.List;


public interface Repository<T,I>{

    T save(T entity);
    boolean delete(T entity);
    T findById(I id);
    List<T> findAll();
    T update(T entity);


}

package icu.praise.petclinic.services;

import java.util.Set;

public interface MyCrudService<T, ID> {
    T save(T object);
    T findById(ID id);
    Set<T> findAll();
    T delete(T object);
}

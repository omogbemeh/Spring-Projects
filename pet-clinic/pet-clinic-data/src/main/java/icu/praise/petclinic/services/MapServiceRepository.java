package icu.praise.petclinic.services;

import icu.praise.petclinic.model.Owner;

import java.util.Set;

public interface MapServiceRepository<T, ID> {
    Set<T> findAll();
    T findById(ID id);
    T save(ID id, T object);
    void delete(T object);
    void deleteById(ID id);
    int count();
}

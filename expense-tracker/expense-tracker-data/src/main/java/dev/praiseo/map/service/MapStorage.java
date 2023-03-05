package dev.praiseo.map.service;

import java.util.HashSet;
import java.util.Set;

public interface MapStorage<T, ID> {
    Set<T> findAll();
    T findById(ID id);
    T save(T obj);
    void delete(T obj);
    void deleteById(ID id);
    Long count();
}

package icu.praise.petclinic.services.map;

import icu.praise.petclinic.services.MapRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract class MapImpl<T, ID> implements MapRepository<T, ID> {
    protected java.util.Map<ID, T> map = new HashMap();

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T findById(ID id) {
        return map.get(id);
    }

    public T save(ID id, T object) {
        map.put(id, object);
        return object;
    }

    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.equals(object));
    }

    public void deleteById(Long id) {
        map.remove(id);
    }

    public int count() {
        return map.size();
    }
}

package icu.praise.petclinic.services.map;

import icu.praise.petclinic.model.Owner;
import icu.praise.petclinic.model.Person;
import icu.praise.petclinic.services.MapServiceRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class MapService<T, ID> implements MapServiceRepository<T, ID> {
    protected Map<ID, T> map = new HashMap();

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
}

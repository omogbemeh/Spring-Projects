package dev.praiseo.map;

import dev.praiseo.map.service.MapStorage;
import dev.praiseo.model.BaseEntity;

import java.util.*;

import static java.util.Collections.*;

public abstract class AbstractMap<T extends BaseEntity,ID extends Long> implements MapStorage<T, ID> {
    protected HashMap<ID, T> map = new HashMap<>();

    @Override
    public Set<T> findAll() {
        return new HashSet<T>(map.values());
    }

    @Override
    public void delete(T obj) {
        if (obj != null) {
            try {
                map.remove(obj.getId());
            } catch (NoSuchElementException e) {
                throw new RuntimeException("Object does not exist");
            }
        } else {
            throw new RuntimeException("Object is empty");
        }
    }

    @Override
    public void deleteById(ID id) {
        try {
            map.remove(id);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("ID does not exist");
        }
    }

    @Override
    public Long count() {
        return (long) map.size();
    }

    @Override
    public T findById(ID id) {
        return map.get(id);
    }

    public T save(T obj) {
        if (obj != null) {
            if (obj.getId() == null) {
                obj.setId(getNextId());
                map.put((ID) obj.getId(), obj);
            }
        } else {
            throw new RuntimeException("Object is null");
        }
        return obj;
    }

    private Long getNextId() {
        Long nextId = null;
        try {
            nextId = max(map.keySet());
            Long.sum(nextId, 1L);
        } catch (NoSuchElementException e) {
            nextId = null;
        }
        return nextId;
    }
}

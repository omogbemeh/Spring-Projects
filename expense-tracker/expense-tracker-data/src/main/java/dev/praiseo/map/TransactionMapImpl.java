package dev.praiseo.map;

import dev.praiseo.map.service.MapStorage;
import dev.praiseo.model.Transaction;

import java.util.Set;

public class TransactionMapImpl extends AbstractMap<Transaction, Long> {
    @Override
    public Set<Transaction> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Transaction obj) {
        super.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public Long count() {
        return super.count();
    }

    @Override
    public Transaction findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Transaction save(Transaction obj) {
        return super.save(obj);
    }
}

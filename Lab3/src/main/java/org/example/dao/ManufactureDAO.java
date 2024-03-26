package org.example.dao;

import org.example.domain.Manufacture;
import org.example.domain.Phone;
import org.example.repository.Repository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;

public class ManufactureDAO implements Repository<Manufacture,Integer> {
    private Session session;
    public ManufactureDAO(Session session) {
        this.session = session;
    }
    @Override
    public boolean add(Manufacture item) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public Manufacture get(Integer id) {
        return session.get(Manufacture.class, id);
    }

    @Override
    public ArrayList<Manufacture> getAll() {
        Query<Manufacture> query = session.createQuery("from Manufacture", Manufacture.class);
        return new ArrayList<>(query.list());
    }

    @Override
    public boolean removeById(Integer id) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Manufacture manufacture = session.get(Manufacture.class, id);
            if (manufacture != null) {
                session.delete(manufacture);
                transaction.commit();
                return true;
            } else {
                System.out.println("Sorry this Id doesn't exist!");
                return false;
            }
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public boolean remove(Manufacture item) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(item);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public boolean update(Manufacture item) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(item);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    public boolean allManufacturersHaveMoreThan100Employees() {
        Query<Long> query = session.createQuery("select count(*) from Manufacture where employee < 100", Long.class);
        Long count = query.getSingleResult();
        return count == 0;
    }

    public int sumOfEmployees() {
        Query<Integer> query = session.createQuery("select sum(employee) from Manufacture", Integer.class);
        Integer sum = query.getSingleResult();
        return sum != null ? sum : 0;
    }

    public Manufacture getLastManufactureInUS() throws InvalidObjectException {
        Query<Manufacture> query = session.createQuery("from Manufacture where location='US' order by id desc", Manufacture.class);
        query.setMaxResults(1);
        List<Manufacture> manufactures = query.list();
        if (manufactures.isEmpty()) {
            throw new InvalidObjectException("No manufacturer in the US found");
        } else {
            return manufactures.get(0);
        }
    }
}

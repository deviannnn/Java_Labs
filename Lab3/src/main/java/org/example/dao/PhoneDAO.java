package org.example.dao;

import org.example.domain.Phone;
import org.example.repository.Repository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class PhoneDAO implements Repository<Phone,Integer> {
    private Session session;
    public PhoneDAO(Session session) {
        this.session = session;
    }

    @Override
    public boolean add(Phone item) {
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
    public Phone get(Integer id) {
        return session.get(Phone.class, id);
    }

    @Override
    public ArrayList<Phone> getAll() {
        Query<Phone> query = session.createQuery("from Phone", Phone.class);
        return new ArrayList<>(query.list());
    }

    @Override
    public boolean removeById(Integer id) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Phone phone = session.get(Phone.class, id);
            if (phone != null) {
                session.delete(phone);
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
    public boolean remove(Phone item) {
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
    public boolean update(Phone item) {
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

    public Phone getPhoneWithHighestSellingPrice() {
        Query<Phone> query = session.createQuery("from Phone order by price desc", Phone.class);
        query.setMaxResults(1);
        List<Phone> phones = query.list();
        return phones.isEmpty() ? null : phones.get(0);
    }

    public ArrayList<Phone> getPhonesSortedByCountryName() {
        Query<Phone> query = session.createQuery("from Phone order by country asc, price desc", Phone.class);
        return new ArrayList<>(query.list());
    }

    public boolean hasPhonePricedAbove50Million() {
        Query<Phone> query = session.createQuery("from Phone where price > 50000000", Phone.class);
        query.setMaxResults(1);
        return query.uniqueResult() != null;
    }

    public Phone getFirstPinkPhoneOver15Million() {
        Query<Phone> query = session.createQuery("from Phone where color = 'Pink' and price > 15000000", Phone.class);
        query.setMaxResults(1);
        return query.uniqueResult();
    }
}

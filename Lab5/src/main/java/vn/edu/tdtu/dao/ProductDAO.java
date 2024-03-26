package vn.edu.tdtu.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.edu.tdtu.model.Product;
import vn.edu.tdtu.repository.ProductRepository;
import vn.edu.tdtu.utils.HibernateUtils;

import java.util.List;

public class ProductDAO implements ProductRepository {
    @Override
    public void insert(Product item) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<Product> readAll() {
        Transaction transaction = null;
        List <Product> productList = null;
        try (Session session = HibernateUtils.getFactory().openSession()) {
            transaction = session.beginTransaction();
            productList = session.createQuery("from Product").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return productList;
    }

    @Override
    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFactory().openSession()) {
            transaction = session.beginTransaction();
            Product p = session.get(Product.class, id);
            if (p != null) {
                session.delete(p);
                transaction.commit();
            }
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}

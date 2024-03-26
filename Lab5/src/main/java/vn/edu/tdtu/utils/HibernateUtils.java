package vn.edu.tdtu.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import vn.edu.tdtu.model.Product;
import vn.edu.tdtu.model.User;

public class HibernateUtils {
    //	muốn hằng số tạo ra 1 lần dùng chung static final
    private static final SessionFactory FACTORY;//tạo getFactory
    //khối tĩnh này chạy 1 lần
    static {
        Configuration conf = new Configuration();
        //C1. cung cấp thông tin cấu hình file xml
        conf.configure("hibernate.cfg.xml");

        conf.addAnnotatedClass(Product.class);
        conf.addAnnotatedClass(User.class);
        //ServiceRegistry lớp trừ tượng ko thay đổi theo thời gian
        ServiceRegistry registry= new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }
    public static SessionFactory getFactory() {
        return FACTORY;
    }

}

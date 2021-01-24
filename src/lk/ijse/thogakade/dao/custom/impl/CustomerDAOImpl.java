package lk.ijse.thogakade.dao.custom.impl;

import lk.ijse.thogakade.dao.custom.CustomerDAO;
import lk.ijse.thogakade.entity.Customer;
import lk.ijse.thogakade.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean add(Customer customer) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.delete(id);

        transaction.commit();

        session.close();
        return true;
    }

    @Override
    public boolean update(Customer customer) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.update(customer);

        transaction.commit();

        session.close();
        return true;
    }

    @Override
    public Customer search(String id) throws Exception {
        return null;
    }

    @Override
    public List<Customer> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query query = session.createQuery("from Customer");
        List<Customer> list = query.getResultList();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        return list;
    }
}

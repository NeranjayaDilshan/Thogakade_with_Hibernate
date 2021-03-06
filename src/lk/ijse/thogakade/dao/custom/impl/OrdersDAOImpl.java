package lk.ijse.thogakade.dao.custom.impl;

import lk.ijse.thogakade.dao.custom.OrdersDAO;
import lk.ijse.thogakade.entity.Orders;
import lk.ijse.thogakade.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrdersDAOImpl implements OrdersDAO {
    @Override
    public boolean add(Orders entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();

        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Orders entity) throws Exception {
        return false;
    }

    @Override
    public Orders search(String s) throws Exception {
        return null;
    }

    @Override
    public List<Orders> getAll() throws Exception {
        return null;
    }
}

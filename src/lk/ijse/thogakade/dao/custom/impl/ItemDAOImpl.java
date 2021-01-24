package lk.ijse.thogakade.dao.custom.impl;

import lk.ijse.thogakade.dao.custom.ItemDAO;
import lk.ijse.thogakade.entity.Customer;
import lk.ijse.thogakade.entity.Item;
import lk.ijse.thogakade.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean add(Item item) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.save(item);

        transaction.commit();

        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.delete(s);

        transaction.commit();

        session.close();
        return true;
    }

    @Override
    public boolean update(Item item) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.update(item);

        transaction.commit();

        session.close();
        return true;
    }

    @Override
    public Item search(String s) throws Exception {
        return null;
    }

    @Override
    public List<Item> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query query = session.createQuery("from Item");
        List<Item> list = query.getResultList();
        for (Item item : list) {
            System.out.println(item);
        }
        return list;
    }
}

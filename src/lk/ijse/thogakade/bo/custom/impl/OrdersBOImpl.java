package lk.ijse.thogakade.bo.custom.impl;

import lk.ijse.thogakade.bo.custom.OrdersBO;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.DAOType;
import lk.ijse.thogakade.dao.custom.impl.ItemDAOImpl;
import lk.ijse.thogakade.dao.custom.impl.OrderDetailDAOImpl;
import lk.ijse.thogakade.dao.custom.impl.OrdersDAOImpl;
import lk.ijse.thogakade.dto.OrderInDTO;
import lk.ijse.thogakade.dto.OrdersDTO;
import lk.ijse.thogakade.entity.Customer;
import lk.ijse.thogakade.entity.Item;
import lk.ijse.thogakade.entity.OrderDetails;
import lk.ijse.thogakade.entity.Orders;

public class OrdersBOImpl implements OrdersBO {
    ItemDAOImpl itemDAO = DAOFactory.getInstance().getDAO(DAOType.ITEM);
    @Override
    public boolean addOrder(OrdersDTO c) throws Exception {
        OrderDetailDAOImpl orderDetailDAO = DAOFactory.getInstance().getDAO(DAOType.ORDERDETAILS);
        OrdersDAOImpl ordersDAO = DAOFactory.getInstance().getDAO(DAOType.ORDER);
        Orders orders = new Orders(c.getOrderId(), c.getDate(), new Customer(c.getCusID()));
        boolean add = ordersDAO.add(orders);
        if (add) {
            for (OrderInDTO o : c.getDtos()) {
                OrderDetails orderDetails = new OrderDetails(c.getOrderId(), o.getItemCode(), o.getItemName(), o.getQty(), o.getTotal());
                boolean isAdd = orderDetailDAO.add(orderDetails);
                if (isAdd){
                    Item item = new Item(o.getItemCode(), o.getQty());
                    boolean update = itemDAO.update(item);
                }
            }
        }
        return true;
    }
}

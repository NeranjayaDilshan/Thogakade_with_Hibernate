package lk.ijse.thogakade.bo.custom;

import lk.ijse.thogakade.bo.SuperBO;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.dto.OrdersDTO;

public interface OrdersBO extends SuperBO {
    boolean addOrder(OrdersDTO ordersDTO)throws Exception;
}

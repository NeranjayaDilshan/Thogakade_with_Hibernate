package lk.ijse.thogakade.bo.custom.impl;

import lk.ijse.thogakade.bo.custom.ItemBO;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.DAOType;
import lk.ijse.thogakade.dao.custom.impl.ItemDAOImpl;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.entity.Item;

public class ItemBOImpl implements ItemBO {
    ItemDAOImpl itemDAO = DAOFactory.getInstance().getDAO(DAOType.ITEM);

    @Override
    public boolean addItem(ItemDTO item) throws Exception {
        return itemDAO.add(new Item(item.getItemCode(),
                item.getItemName(),
                item.getQtyOnHand(),
                item.getUnitPrice()));
    }
}

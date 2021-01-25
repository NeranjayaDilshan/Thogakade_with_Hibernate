package lk.ijse.thogakade.bo.custom;

import lk.ijse.thogakade.bo.SuperBO;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.entity.Item;

import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    boolean addItem(ItemDTO itemDTO) throws Exception;

    ArrayList<ItemDTO> getAllItems() throws Exception;

    Item search(String itemCode) throws Exception;
}

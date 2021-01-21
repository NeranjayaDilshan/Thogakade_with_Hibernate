package lk.ijse.thogakade.bo.custom;

import lk.ijse.thogakade.bo.SuperBO;
import lk.ijse.thogakade.dto.ItemDTO;

public interface ItemBO extends SuperBO {
    boolean addItem(ItemDTO itemDTO)throws Exception;
}

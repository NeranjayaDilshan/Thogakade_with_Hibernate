package lk.ijse.thogakade.bo.custom;

import lk.ijse.thogakade.bo.SuperBO;
import lk.ijse.thogakade.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    boolean addCustomer(CustomerDTO customer) throws Exception;

    ArrayList<CustomerDTO> getAllCustomer() throws Exception;

    boolean delectCustomer(String id) throws Exception;
}

package lk.ijse.thogakade.bo.custom.impl;

import lk.ijse.thogakade.bo.custom.CustomerBO;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.DAOType;
import lk.ijse.thogakade.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAOImpl customerDAO = DAOFactory.getInstance().getDAO(DAOType.CUSTOMER);
    @Override
    public boolean addCustomer(CustomerDTO customer) throws Exception {
        return customerDAO.add(new Customer(customer.getId(),
                customer.getName(),
                customer.getContact(),
                customer.getAddress()));
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws Exception {
        List<Customer> all = customerDAO.getAll();
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
        for ( Customer c : all) {
            CustomerDTO customerDTO = new CustomerDTO(
                    c.getId(),
                    c.getName(),
                    c.getContact(),
                    c.getAddress()
            );
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    @Override
    public boolean delectCustomer(String id) throws Exception {
        return customerDAO.delete(id);
    }
}

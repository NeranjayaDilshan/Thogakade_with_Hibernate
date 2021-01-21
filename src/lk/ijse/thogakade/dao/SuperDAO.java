package lk.ijse.thogakade.dao;

import lk.ijse.thogakade.entity.SuperEntity;

import java.io.Serializable;
import java.util.List;

public interface SuperDAO<Entity extends SuperEntity, ID extends Serializable> {
    boolean add(Entity entity) throws Exception;

    boolean delete(ID id) throws Exception;

    boolean update(Entity entity) throws Exception;

    Entity search(ID id) throws Exception;

    List<Entity> getAll() throws Exception;
}

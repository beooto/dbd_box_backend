package myapp.dbd_box.dao;

import myapp.dbd_box.pojo.Offering;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferingDao {
    Offering getOfferingById(Integer Id);
    List<Offering> getOfferingListByClass(String class_name);
    List<Offering> getOfferingListByBelong(Integer Id);

}

package myapp.dbd_box.dao;

import myapp.dbd_box.pojo.Addon;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface AddonDao {
    List<Addon> getAddonList();
    List<Addon> getAddonListByKillerID(Integer ID);
    
}

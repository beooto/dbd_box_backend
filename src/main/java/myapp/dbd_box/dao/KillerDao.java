package myapp.dbd_box.dao;

import myapp.dbd_box.pojo.Killer;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository
public interface KillerDao {
    List<Killer> getKillerList();
    Killer getKillerById(Integer killerId);
    List<Killer> getKillerListByName(String killerName);

}
package myapp.dbd_box.dao;

import myapp.dbd_box.pojo.Survivor;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface SurvivorDao {
    List<Survivor> getSurvivorList();
    Survivor getSurvivorById(Integer id);
    List<Survivor> getSurvivorListByName(String name);
}

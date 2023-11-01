package myapp.dbd_box.dao;

import myapp.dbd_box.pojo.Skill;
import java.util.List;
import org.springframework.stereotype.Repository;
@Repository
public interface SkillDao {
    List<Skill> getKillerSkillList();
    Skill getKillerSkillById(Integer id);
    List<Skill> getKillerSkillByName(String name);
    List<Skill> getKillerSkillByDetail(String detail);
    List<Skill> getKillerSkillByKillerID(Integer id);
    List<Skill> getSurvivorSkillList();
    Skill getSurvivorSkillById(Integer id);
    List<Skill> getSurvivorSkillByName(String name);
    List<Skill> getSurvivorSkillByDetail(String detail);
    List<Skill> getSurvivorSkillBySurvivorId(Integer id);

}
package myapp.dbd_box.service;

import myapp.dbd_box.pojo.Skill;
import myapp.dbd_box.vo.SkillVO;

import java.util.List;

public interface SkillService {
    List<SkillVO> getKillerSkillVOList();
    Skill getKillerSkillById(Integer id);
    //NAD name and detail
    List<Skill> searchKillerSkill(String KNAD);
    List<Skill> getKillerSkillByKillerId(Integer id);
    SkillVO getRandomKillerSkill();
    List<SkillVO> getSurvivorSkillVOList();
    Skill getSurvivorSkillById(Integer id);
    List<Skill> searchSurvivorSkill(String SNAD);
    List<Skill> getSurvivorSkillBySurvivorId(Integer id);
    SkillVO getRandomSurvivorSkill();

}

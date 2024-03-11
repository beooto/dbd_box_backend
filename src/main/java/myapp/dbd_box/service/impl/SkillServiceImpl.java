package myapp.dbd_box.service.impl;

import myapp.dbd_box.dao.SkillDao;
import myapp.dbd_box.pojo.Skill;
import myapp.dbd_box.service.SkillService;
import myapp.dbd_box.util.AboutObject;
import myapp.dbd_box.vo.SkillVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    private SkillDao skillDao;
    @Autowired
    private AboutObject aboutObject;
    @Override
    public List<SkillVO> getKillerSkillVOList() {
        List<Skill> killerSkillList = skillDao.getKillerSkillList();
        List<SkillVO> killerSkillVOList = aboutObject.SkillTOVO(killerSkillList);
        return killerSkillVOList;
    }
    @Override
    public Skill getKillerSkillById(Integer skillId) {
        return skillDao.getKillerSkillById(skillId);
    }
    @Override
    public List<Skill> searchKillerSkill(String KNAD) {
        List<Skill> killerSkillListN = skillDao.getKillerSkillByName(KNAD);
        List<Skill> killerSkillListD = skillDao.getKillerSkillByDetail(KNAD);
        List<Skill> killerSkillList = Stream.concat(killerSkillListN.stream(), killerSkillListD.stream())
                .collect(Collectors.toList());
        return  killerSkillList;
    }
    @Override
    public List<Skill> getKillerSkillByKillerId(Integer killerId) {
        return skillDao.getKillerSkillByKillerID(killerId);
    }
    @Override
    public SkillVO getRandomKillerSkill(){
        List<SkillVO> killerSkillVOList = this.getKillerSkillVOList();
        Random random = new Random();
        return killerSkillVOList.get(random.nextInt(killerSkillVOList.size()));
    }
    @Override
    public List<SkillVO> getSurvivorSkillVOList() {
        List<Skill> survivorSkillList = skillDao.getSurvivorSkillList();
        List<SkillVO> survivorSkillVOList = aboutObject.SkillTOVO(survivorSkillList);
        return survivorSkillVOList;
    }
    @Override
    public Skill getSurvivorSkillById(Integer skillId) {
        return skillDao.getSurvivorSkillById(skillId);
    }
    @Override
    public List<Skill> searchSurvivorSkill(String KNAD) {
        List<Skill> survivorSkillListN = skillDao.getSurvivorSkillByName(KNAD);
        List<Skill> survivorSkillListD = skillDao.getSurvivorSkillByDetail(KNAD);
        List<Skill> survivorSkillList = Stream.concat(survivorSkillListN.stream(), survivorSkillListD.stream())
                .collect(Collectors.toList());
        return  survivorSkillList;
    }
    @Override
    public List<Skill> getSurvivorSkillBySurvivorId(Integer killerId) {
        return skillDao.getSurvivorSkillBySurvivorId(killerId);
    }
    @Override
    public SkillVO getRandomSurvivorSkill(){
        List<SkillVO> survivorSkillVOList = this.getSurvivorSkillVOList();
        Random random = new Random();
        return survivorSkillVOList.get(random.nextInt(survivorSkillVOList.size()));
    }
}

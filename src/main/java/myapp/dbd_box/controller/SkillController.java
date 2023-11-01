package myapp.dbd_box.controller;

import myapp.dbd_box.pojo.Skill;

import io.swagger.annotations.ApiOperation;
import myapp.dbd_box.service.SkillService;
import myapp.dbd_box.vo.SkillVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@ApiOperation("killerSkill相关")
public class SkillController {
    @Autowired
    private SkillService skillService;
    // 获取killerSkill基础信息列表
    @GetMapping("killerSkillList")
    public List<SkillVO> getKillerSkillList(){
        return skillService.getKillerSkillVOList();
    }
    // 通过ID获取killerSkill
    @GetMapping("killerSkill")
    public Skill getKillerSkillById(Integer killerSkillId){
        return skillService.getKillerSkillById(killerSkillId);
    }
    // 通过搜索name和detail搜索skill
    @GetMapping("searchKillerSkill")
    public ResponseEntity<List<SkillVO>> searchKillerSkill(String KNAD){
        List<SkillVO> skillVOList = skillService.searchKillerSkill(KNAD);
        if (skillVOList != null){
            return ResponseEntity.ok(skillVOList);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    // 通过KillerID获取skill
    @GetMapping("killerSkills")
    public List<Skill> killerSkills(@RequestParam("id") Integer id){
        return skillService.getKillerSkillByKillerId(id);
    }
    // 获得随机killer技能
    @GetMapping("randomKillerSkill")
    public SkillVO getRandomKillerSkill(){
        return skillService.getRandomKillerSkill();
    }
    // 获取survivorSkill基础信息列表
    @GetMapping("survivorSkillList")
    public List<SkillVO> getSurvivorSkillList(){
        return skillService.getSurvivorSkillVOList();
    }
    // 通过ID获取survivorSkill
    @GetMapping("survivorSkill")
    public Skill getSurvivorSkillById(Integer survivorSkillId){
        return skillService.getSurvivorSkillById(survivorSkillId);
    }
    // 通过搜索name和detail搜索skill
    @GetMapping("searchSurvivorSkill")
    public ResponseEntity<List<SkillVO>> searchSurvivorSkill(String KNAD){
        List<SkillVO> skillVOList = skillService.searchSurvivorSkill(KNAD);
        if (skillVOList != null){
            return ResponseEntity.ok(skillVOList);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    // 通过SurvivorID获取skill
    @GetMapping("survivorSkills")
    public List<Skill> survivorSkills(Integer id){
        return skillService.getSurvivorSkillBySurvivorId(id);
    }
    // 获得随机survivor技能
    @GetMapping("randomSurvivorSkill")
    public SkillVO getRandomSurvivorSkill(){
        return skillService.getRandomSurvivorSkill();
    }

}

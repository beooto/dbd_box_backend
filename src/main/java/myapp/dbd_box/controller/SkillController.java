package myapp.dbd_box.controller;

import myapp.dbd_box.pojo.Skill;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import myapp.dbd_box.service.SkillService;
import myapp.dbd_box.vo.SkillVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "SkillController", description = "Skill 相关操作")
public class SkillController {
    @Autowired
    private SkillService skillService;

    @GetMapping("skill/killer")
    @ApiOperation("获取所有 Killer 的 Skill 基础信息")
    public ResponseEntity<List<SkillVO>> getKillerSkillList() {
        List<SkillVO> skillVOList = skillService.getKillerSkillVOList();
        return ResponseEntity.ok(skillVOList);
    }

    @GetMapping("skill/killer/skill_id={skill_id}")
    @ApiOperation("通过 Skill ID 获取相应 Killer 的 Skill")
    @ApiParam(name = "skill_id", value = "Killer Skill 的 ID", required = true)
    public ResponseEntity<Skill> getKillerSkillById(@PathVariable Integer skill_id) {
        Skill skill = skillService.getKillerSkillById(skill_id);
        if (skill != null) {
            return ResponseEntity.ok(skill);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("skill/killer/search/{KNAD}")
    @ApiOperation("通过名称和详情搜索 Killer 的 Skill")
    @ApiParam(name = "KNAD", value = "Killer 的名称或详情", required = true)
    public ResponseEntity<List<SkillVO>> searchKillerSkill(@PathVariable String KNAD) {
        List<SkillVO> skillVOList = skillService.searchKillerSkill(KNAD);
        if (!skillVOList.isEmpty()) {
            return ResponseEntity.ok(skillVOList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("skill/killer/killer={killer_id}")
    @ApiOperation("通过 Killer ID 获取相应 Killer 的所有 Skill")
    @ApiParam(name = "killer_id", value = "Killer 的 ID", required = true)
    public ResponseEntity<List<Skill>> killerSkills(@PathVariable Integer killer_id) {
        List<Skill> skills = skillService.getKillerSkillByKillerId(killer_id);
        return ResponseEntity.ok(skills);
    }

    @GetMapping("skill/killer/random")
    @ApiOperation("通过 Killer ID 获取相应 Killer 的随机 Skill")
    public ResponseEntity<SkillVO> getRandomKillerSkill() {
        SkillVO skillVO = skillService.getRandomKillerSkill();
        return ResponseEntity.ok(skillVO);
    }

    @GetMapping("skill/survivor")
    @ApiOperation("获取所有 Survivor 的 Skill 基础信息")
    public ResponseEntity<List<SkillVO>> getSurvivorSkillList() {
        List<SkillVO> skillVOList = skillService.getSurvivorSkillVOList();
        return ResponseEntity.ok(skillVOList);
    }

    @GetMapping("skill/survivor/skill_id={skill_id}")
    @ApiOperation("通过 Skill ID 获取相应 Survivor 的 Skill")
    @ApiParam(name = "skill_id", value = "Survivor Skill 的 ID", required = true)
    public ResponseEntity<Skill> getSurvivorSkillById(@PathVariable Integer skill_id) {
        Skill skill = skillService.getSurvivorSkillById(skill_id);
        if (skill != null) {
            return ResponseEntity.ok(skill);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("skill/survivor/search/{KNAD}")
    @ApiOperation("通过名称和详情搜索 Survivor 的 Skill")
    @ApiParam(name = "KNAD", value = "Survivor 的名称或详情", required = true)
    public ResponseEntity<List<SkillVO>> searchSurvivorSkill(@PathVariable String KNAD) {
        List<SkillVO> skillVOList = skillService.searchSurvivorSkill(KNAD);
        if (!skillVOList.isEmpty()) {
            return ResponseEntity.ok(skillVOList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("skill/survivor/survivor_id={survivor_id}")
    @ApiOperation("通过 Survivor ID 获取相应 Survivor 的所有 Skill")
    @ApiParam(name = "survivor_id", value = "Survivor 的 ID", required = true)
    public ResponseEntity<List<Skill>> survivorSkills(@PathVariable Integer survivor_id) {
        List<Skill> skills = skillService.getSurvivorSkillBySurvivorId(survivor_id);
        return ResponseEntity.ok(skills);
    }

    @GetMapping("skill/survivor/random")
    @ApiOperation("通过 Survivor ID 获取相应 Survivor 的随机 Skill")
    public ResponseEntity<SkillVO> getRandomSurvivorSkill() {
        SkillVO skillVO = skillService.getRandomSurvivorSkill();
        return ResponseEntity.ok(skillVO);
    }
}

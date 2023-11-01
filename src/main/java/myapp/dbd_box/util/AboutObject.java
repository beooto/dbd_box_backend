package myapp.dbd_box.util;

import myapp.dbd_box.pojo.*;
import myapp.dbd_box.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class AboutObject {

    public List<KillerVO> KillerTOVO(List<Killer> killerList){
        System.out.println(killerList);
        try {
            List<KillerVO> killerVOList = killerList.stream()
                    .map(Killer -> {
                        KillerVO killerVo = new KillerVO();
                        killerVo.setKiller_id(Killer.getKiller_id());
                        killerVo.setKiller_name(Killer.getKiller_name());
                        killerVo.setKiller_icon(Killer.getKiller_icon());
                        return killerVo;
                    })
                    .collect(Collectors.toList());
            return killerVOList;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public List<SurvivorVO> SurvivorTOVO(List<Survivor> survivorList){
        System.out.println(survivorList);
        try {
            List<SurvivorVO> survivorVOList = survivorList.stream()
                    .map(Survivor -> {
                        SurvivorVO survivorVO = new SurvivorVO();
                        survivorVO.setSurvivor_id(Survivor.getSurvivor_id());
                        survivorVO.setSurvivor_name(Survivor.getSurvivor_name());
                        survivorVO.setSurvivor_icon(Survivor.getSurvivor_icon());
                        return survivorVO;
                    })
                    .collect(Collectors.toList());
            return survivorVOList;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public List<SkillVO> SkillTOVO(List<Skill> skillList){
        System.out.println(skillList);
        try {
            List<SkillVO> skillVOList = skillList.stream()
                    .map(Skill -> {
                        SkillVO skillVO = new SkillVO();
                        skillVO.setSkill_id(Skill.getSkill_id());
                        skillVO.setSkill_name(Skill.getSkill_name());
                        skillVO.setSkill_icon(Skill.getSkill_icon());
                        return skillVO;
                    })
                    .collect(Collectors.toList());
            return skillVOList;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

}

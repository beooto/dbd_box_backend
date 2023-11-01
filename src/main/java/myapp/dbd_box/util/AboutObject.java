package myapp.dbd_box.util;

import myapp.dbd_box.pojo.*;
import myapp.dbd_box.vo.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class AboutObject {

    public List<KillerVO> KillerTOVO(List<Killer> killerList){
        try {
            List<KillerVO> killerVOList = killerList.stream()
                    .map(Killer -> {
                        KillerVO killerVo = new KillerVO();
                        killerVo.setId(Killer.getId());
                        killerVo.setName(Killer.getName());
                        killerVo.setIcon(Killer.getIcon());
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
        try {
            List<SurvivorVO> survivorVOList = survivorList.stream()
                    .map(Survivor -> {
                        SurvivorVO survivorVO = new SurvivorVO();
                        survivorVO.setId(Survivor.getId());
                        survivorVO.setName(Survivor.getName());
                        survivorVO.setIcon(Survivor.getIcon());
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
        try {
            List<SkillVO> skillVOList = skillList.stream()
                    .map(Skill -> {
                        SkillVO skillVO = new SkillVO();
                        skillVO.setId(Skill.getSkill_id());
                        skillVO.setName(Skill.getName());
                        skillVO.setIcon(Skill.getIcon());
                        return skillVO;
                    })
                    .collect(Collectors.toList());
            return skillVOList;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public List<AddonVO> AddonTOVO(List<Addon> addonList){
        try {
            List<AddonVO> addonVOList = addonList.stream()
                    .map(Addon -> {
                        AddonVO addonVO = new AddonVO();
                        addonVO.setAddon_id(Addon.getAddonId());
                        addonVO.setKiller_id(Addon.getKillerId());
                        addonVO.setIcon(Addon.getIcon());
                        addonVO.setName(Addon.getName());
                        return addonVO;
                    })
                    .collect(Collectors.toList());
            return addonVOList;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

}

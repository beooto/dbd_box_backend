package myapp.dbd_box.controller;

import myapp.dbd_box.vo.SurvivorVO;
import myapp.dbd_box.pojo.Survivor;
import myapp.dbd_box.service.SurvivorService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@ApiOperation("survivor相关")
public class SurvivorController {
    @Autowired
    SurvivorService survivorService;
    // 获取survivor基础信息列表
    @GetMapping("survivorList")
    public List<SurvivorVO> getSurvivorVOList() {
        return survivorService.getSurvivorVOList();
    }
    // 通过ID获取具体的survivor对象
    @GetMapping("getSurvivorList")
    public Survivor getSurvivor(@RequestParam("id") Integer survivorId){
        return survivorService.getSurvivorById(survivorId);
    }
    // 通过name和other_name模糊搜索survivorVO对象并返回list
    @GetMapping("searchSurvivor")
    public ResponseEntity<List<SurvivorVO>> getSurvivorListByName(String name){
        List<SurvivorVO> survivorVOList = survivorService.searchSurvivor(name);
        if (survivorVOList != null){
            return ResponseEntity.ok(survivorVOList);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    // 随机获取一个survivor
    @GetMapping("randomSurvivor")
    public SurvivorVO getRandomSurvivorVO(){
        return survivorService.getRandomSurvivorVO();
    }
}

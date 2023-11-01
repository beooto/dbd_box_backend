package myapp.dbd_box.controller;

import myapp.dbd_box.vo.KillerVO;
import myapp.dbd_box.pojo.Killer;
import myapp.dbd_box.service.KillerService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ApiOperation("killer相关")
public class KillerController {
    @Autowired
    private KillerService killerService;

    // 获取killer基础信息列表
    @GetMapping("killerList")
    public List<KillerVO> getKillerVOList() {
        return killerService.getKillerVOList();
    }

    // 通过ID获取具体killer对象
    @GetMapping("getKillerById")
    public ResponseEntity<Killer> getKillerById(@RequestParam("id") Integer killerId) {
        Killer killer = killerService.getKillerById(killerId);
        return ResponseEntity.ok(killer);
    }
    // 通过name和other_name模糊搜索具体killerVO对象并返回list
    @GetMapping("searchKiller")
    public ResponseEntity<List<KillerVO>> getKillerVOListByName(String name){
        List<KillerVO> killerVOList = killerService.searchKiller(name);
        if (killerVOList != null){
            return ResponseEntity.ok(killerVOList);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    // 随机获取一个killerVO对象
    @GetMapping("randomKiller")
    public KillerVO getRandomKillerVO(){
        return killerService.getRandomKillerVO();
    }
}

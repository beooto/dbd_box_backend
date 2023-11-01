package myapp.dbd_box.controller;

import myapp.dbd_box.vo.KillerVO;
import myapp.dbd_box.pojo.Killer;
import myapp.dbd_box.service.KillerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "KillerController", description = "Killer 相关操作")
public class KillerController {
    @Autowired
    private KillerService killerService;

    @GetMapping("killer")
    @ApiOperation("获取所有 Killer 的基础信息列表")
    public ResponseEntity<List<KillerVO> >getKillerVOList() {
        List<KillerVO> killerVOList = killerService.getKillerVOList();
        return ResponseEntity.ok(killerVOList);
    }

    @GetMapping("killer/{id}")
    @ApiOperation("通过 ID 获取具体 Killer 对象")
    @ApiParam(name = "id", value = "Killer 的 ID", required = true)
    public ResponseEntity<Killer> getKillerById(@PathVariable Integer id) {
        Killer killer = killerService.getKillerById(id);
        if (killer != null) {
            return ResponseEntity.ok(killer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("killer/search/{name}")
    @ApiOperation("通过名称和别名模糊搜索 KillerVO 对象并返回列表")
    @ApiParam(name = "name", value = "Killer 的名称或别名", required = true)
    public ResponseEntity<List<KillerVO>> getKillerVOListByName(@PathVariable String name) {
        List<KillerVO> killerVOList = killerService.searchKiller(name);
        if (!killerVOList.isEmpty()) {
            return ResponseEntity.ok(killerVOList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("killer/random")
    @ApiOperation("随机获取一个 KillerVO 对象")
    public ResponseEntity<KillerVO> getRandomKillerVO() {
        KillerVO killerVO = killerService.getRandomKillerVO();
        return ResponseEntity.ok(killerVO);
    }
}

package cn.i7baozh.cloud.provider.controller;

import cn.i7baozh.cloud.api.bean.DeptBean;
import cn.i7baozh.cloud.provider.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/view/{id}")
    public DeptBean getById(@PathVariable Long id) {

        return deptService.getById(id);
    }

    @PostMapping("/update")
    public DeptBean getById(Long id, String name) {
        DeptBean deptBean = deptService.updateById(id, name);

        return deptBean;
    }

    @GetMapping("/delete/{id}")
    public Integer deleteById(@PathVariable Long id) {
        return deptService.deleteById(id);
    }
}

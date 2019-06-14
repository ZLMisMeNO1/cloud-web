package cn.i7baozh.cloud.consumer.controller;

import cn.i7baozh.cloud.api.bean.DeptBean;
import cn.i7baozh.cloud.consumer.config.RestTemplateConfig;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: 使用URL的方式访问服务，一般不使用这种方式
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    /**
     * 这里注意下 只有使用了ribbon后才能使用实例名，不然会报错
     * @see RestTemplateConfig#restTemplate()
     */
    private static final String baseUrl = "http://dept-provider";

//    private static final String baseUrl = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/view/{id}")
    public DeptBean getById(@PathVariable Long id) {

        DeptBean deptBean =  restTemplate.getForObject(baseUrl + "/dept/view/" + id,DeptBean.class);
        return deptBean;
    }

    @GetMapping("/update")
    public DeptBean update( Long id ,String name) {
        Map<String, Object> param = new HashMap<>();
        param.put("id",id );
        param.put("name",name );
        DeptBean updateBean = new DeptBean().setId(id).setDeptName(name);
        String s = JSONObject.toJSONString(updateBean);
        ResponseEntity<DeptBean> deptBeanResponseEntity = restTemplate.postForEntity(baseUrl + "/update", param, DeptBean.class);
        return deptBeanResponseEntity.getBody();
    }
}

package cn.i7baozh.cloud.api.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Title: @Accessors(chain = true)的作用 能够使用这种方式构建对象
 *              new DeptBean().setId().setDeptName()
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class DeptBean implements Serializable {

    private Long id;

    private String deptName;
}

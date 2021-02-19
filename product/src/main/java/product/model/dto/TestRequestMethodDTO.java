package product.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: gaolingfeng
 * @date: 2021/1/28 14:41
 * @description:
 */
@Data
@AllArgsConstructor
public class TestRequestMethodDTO implements Serializable {
    private static final long serialVersionUID = -7859552030607577860L;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    public TestRequestMethodDTO() {

    }
}

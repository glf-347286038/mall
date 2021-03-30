package com.mall.product.common.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: gaolingfeng
 * @date: 2021/2/26 23:35
 * @description:
 */
@Data
@NoArgsConstructor
public class Pagination<T> {
    @ApiModelProperty(value = "当前页，默认1",required = true)
    private int current = 1;
    @ApiModelProperty(value = "页面大小，默认10",required = true)
    private int size = 10;
    @ApiModelProperty(value = "从start开始")
    private int start;
    @ApiModelProperty(value = "到end结束")
    private int end;
    @ApiModelProperty(value = "共多少条数据")
    private long total;
    @ApiModelProperty(value = "总页数")
    private int totalPage;
    @ApiModelProperty(value = "主数据")
    private List<T> records;
    @ApiModelProperty(value = "是否分页，Y/N")
    private String flag;
    /**
     * 获得开始、结束数据下标
     * 1 10 -> 0 9    2 20 -> 20 39  3 10 -> 20 29
     * @author: gaolingfeng
     * @date: 2021/2/27 0:03
     * @param current 当前页
     * @param size 页面大小
     * @return Pagination
     */
    public Pagination(int current, int size) {
        this.current = current;
        this.size = size;
        this.start = (current-1)*size;
        this.end = (current-1)*size+(size-1);
    }

    public int getStart() {
        return (current-1)*size;
    }

    public int getEnd() {
        return (current-1)*size +(size-1);
    }

    /**
     * 查询数目和页数
     * @author: gaolingfeng   25 10  3
     * @date: 2021/2/27 23:19
     * @param total 总数目
     */
    public void setTotalAndTotalPage(int total) {
        this.total = total;
        this.totalPage = total/size + 1;
    }
}

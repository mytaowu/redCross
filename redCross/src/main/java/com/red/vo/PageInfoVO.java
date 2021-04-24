package com.red.vo;

import io.swagger.models.auth.In;

import java.util.List;

/**
 * @author: TMingYi
 * @date: 2020/6/21 10:12
 */
public class PageInfoVO<T> {

    private Integer total;

    private List<T> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public PageInfoVO() {
    }

    public PageInfoVO(Integer total, List rows) {
        this.total = total;
        this.rows = rows;
    }
}

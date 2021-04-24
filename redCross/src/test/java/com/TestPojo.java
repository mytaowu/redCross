package com;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author: TMingYi
 * @date: 2020/4/23 18:28
 */
public class TestPojo {

    @JsonFormat(pattern = "yy-MM-dd",timezone = "GMT+8")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

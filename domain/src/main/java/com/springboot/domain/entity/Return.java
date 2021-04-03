package com.springboot.domain.entity;

import java.io.Serializable;

/**
 * @author wuhui
 * @Date 2018/11/21
 * @Description
 */
public class Return implements Serializable {
    private static final long serialVersionUID = -5158708077742187883L;
    /* 状态码 */
    private String code;
    /* 数据 */
    private Object data;
    /* 数据量 */
    private Integer count;

    public Return() {
    }

    public Return(String code, Object data) {
        super();
        this.code = code;
        this.data = data;
    }

    public Return(String code, Object data, Integer count) {
        super();
        this.code = code;
        this.data = data;
        this.count = count;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Return [code=" + code + ", data=" + data + ", count=" + count + "]";
    }

}

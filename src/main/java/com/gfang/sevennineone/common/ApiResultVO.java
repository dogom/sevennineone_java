package com.gfang.sevennineone.common;


import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xs
 *         <p>接口返回Map</p>
 * @since <p>项目版本号</p>
 */
public class ApiResultVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

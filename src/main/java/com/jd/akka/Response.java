package com.jd.akka;

import java.io.Serializable;

/**
 * Created by yangyuan on 7/26/18.
 */
public class Response implements Serializable{

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

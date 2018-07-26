package com.jd.akka;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by yangyuan on 7/26/18.
 */
public class Request implements Serializable{

    private String traceId;

    private String className;

    private String methodName;

    private Class[] paramTypes;

    private Object[] paramValues;

    private Map  extData;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getParamValues() {
        return paramValues;
    }

    public void setParamValues(Object[] paramValues) {
        this.paramValues = paramValues;
    }

    public Map getExtData() {
        return extData;
    }

    public void setExtData(Map extData) {
        this.extData = extData;
    }
}

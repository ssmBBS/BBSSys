package com.spring.bbs.dto;

/**
 * @author RickZhou
 *         Created by RickZhou on 2018/4/18 0018.
 */
public class ResultInfo {
    private boolean result;
    private Object data;
    private String reason;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

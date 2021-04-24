package com.red.vo;

/**
 * 结果返回的类；返回获得的结果集；
 *
 * @param <T>:表示返回数据的类型；
 */
public class InfomationVO<T> {

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";
    public static final String NO_MSG = "NO_MSG";
    public static final String NO_DATA = "NO_DATA";

    //响应结果集
    private String result;

    //在相应结果为FAILED的时候的默认提示消息，默认情况下没有消息；
    private String message = NO_MSG;

    //封装返回的数据；
    private T data;


    //设置构造函数和get、set方法；
    public InfomationVO() {

    }

    public InfomationVO(String result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

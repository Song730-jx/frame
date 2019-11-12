package com.example.frame.controller;


import com.example.frame.bean.ResultBean;

public class BaseController extends ResultBean {
    public static ResultBean success() {//成功，没有数据
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(true);
        resultBean.setCode("0");
        resultBean.setData(null);
        return resultBean;
    }

    public static ResultBean success(Object data) {//成功，有数据
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(true);
        resultBean.setCode("0");
        resultBean.setData(data);
        //12
        return resultBean;
    }

    public static ResultBean success(Object data,int count) {
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(true);
        resultBean.setCode("0");
        resultBean.setData(data);
        resultBean.setCount(count);
        return resultBean;
    }

    public static  ResultBean failure() {//失败
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(false);
        resultBean.setCode("-1");
        resultBean.setMsg("msg", "");
        return resultBean;
    }

    public static ResultBean failure(String msg) {//失败有数据
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(false);
        resultBean.setCode("-1");
        resultBean.setMsg("msg", msg);
        return resultBean;
    }

    public static ResultBean failure(int code) {//失败，带错误编码
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(false);
        resultBean.setCode("-1");
        resultBean.setMsg("msg", "");
        return resultBean;
    }

    public static ResultBean failure(int code, String msg) {//失败，给错误编码和信息
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(false);
        resultBean.setCode("-1");
        resultBean.setMsg("msg", msg);
        return resultBean;
    }
}

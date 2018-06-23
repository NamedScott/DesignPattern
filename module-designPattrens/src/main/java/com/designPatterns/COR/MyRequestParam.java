package com.designPatterns.COR;

/**
 * @author yanzhen
 * @date 2018/6/23
 * @project-name ModuleProject
 * @package-name com.designPatterns.COR
 * 请求参数
 */
public class MyRequestParam {

    private String requestStr ;

    public MyRequestParam (String requestStr){
        this.requestStr = requestStr ;
    }

    public String getRequestStr() {
        return requestStr;
    }

    public void setRequestStr(String requestStr) {
        this.requestStr = requestStr;
    }
}

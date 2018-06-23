package com.designPatterns.COR;

/**
 * @author yanzhen
 * @date 2018/6/23
 * @project-name ModuleProject
 * @package-name com.designPatterns.COR
 */
public interface MyFilter {
     void doChain(MyRequestParam requestParam,FilterChain chain);
}

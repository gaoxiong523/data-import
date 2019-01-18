package com.gaoxiong.dataimport.service;

import com.gaoxiong.dataimport.model.User;

/**
 * @author gaoxiong
 * @ClassName UserParse
 * @Description 主要用于处理数据解析,也就是将一行记录转换为User对象
 * @date 2019/1/17 18:20
 */
public interface UserParse {
    /**
     * 把每一行的数据转换为User对象
     * @param line
     * @return
     */
    User parse(String line);
}

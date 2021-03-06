package com.shengdingbox.blog.core.config;

import org.springframework.stereotype.Component;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 
 * @author Dabao (17600004572@163.com)
 * @version 1.0
 * @website https://www.zhouzifei.com
 * @date 2019年7月16日
 * @since 1.0
 */
@Component
@MapperScan("com.shengdingbox.blog.persistence.mapper")
public class MybatisConfig {
}

package com.shengdingbox.blog.persistence.beans;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author Dabao (17611555590@163.com)
 * @version 1.0
 * @website https://www.shengdingbox.com
 * @date 2019年7月16日
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysLink extends AbstractDO {
    private String url;
    private String name;
    private String description;
    private String email;
    private String qq;
    private String favicon;
    private Boolean status;
    private Boolean homePageDisplay;
    private String remark;
    private String source;
}

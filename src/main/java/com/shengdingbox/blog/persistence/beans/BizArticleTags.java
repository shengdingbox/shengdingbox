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
public class BizArticleTags extends AbstractDO {
    private Long tagId;
    private Long articleId;
}

package com.shengdingbox.blog.persistence.mapper;


import com.shengdingbox.blog.core.BaseMapper;
import com.shengdingbox.blog.persistence.beans.BizArticleLook;
import com.shengdingbox.blog.vo.ArticleLookConditionVO;

import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 
 * @author Dabao (17611555590@163.com)
 * @version 1.0
 * @website https://www.shengdingbox.com
 * @date 2019年7月16日
 * @since 1.0
 */
@Repository
public interface BizArticleLookMapper extends BaseMapper<BizArticleLook> {

    /**
     * 分页查询
     * @param vo
     *
     * @return
     */
    List<BizArticleLook> findPageBreakByCondition(ArticleLookConditionVO vo);
}

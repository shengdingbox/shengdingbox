package com.shengdingbox.blog.persistence.mapper;

import com.shengdingbox.blog.core.BaseMapper;
import com.shengdingbox.blog.persistence.beans.SysUpdateRecorde;
import com.shengdingbox.blog.vo.UpdateRecordeConditionVO;

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
public interface SysUpdateRecordeMapper extends BaseMapper<SysUpdateRecorde> {

    /**
     * 分页查询
     * @param vo
     *
     * @return
     */
    List<SysUpdateRecorde> findPageBreakByCondition(UpdateRecordeConditionVO vo);
}

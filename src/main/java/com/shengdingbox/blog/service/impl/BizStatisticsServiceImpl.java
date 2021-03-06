package com.shengdingbox.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.shengdingbox.blog.entity.Article;
import com.shengdingbox.blog.entity.Statistics;
import com.shengdingbox.blog.persistence.beans.BizStatistics;
import com.shengdingbox.blog.persistence.mapper.BizStatisticsMapper;
import com.shengdingbox.blog.service.BizArticleService;
import com.shengdingbox.blog.service.BizStatisticsService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 统计
 * @author Dabao (17611555590@163.com)
 * @version 1.0
 * @website https://www.shengdingbox.com
 * @date 2019年7月16日
 * @since 1.0
 */
@Service
public class BizStatisticsServiceImpl implements BizStatisticsService {

    @Autowired
    private BizStatisticsMapper statisticsMapper;
    @Autowired
    private BizArticleService articleService;

    /**
     * 获取热门文章
     *
     * @return
     */
    @Override
    public List<Article> listHotArticle(int pageSize) {
        return articleService.listHotArticle(pageSize);
    }

    /**
     * 获取爬虫统计
     *
     * @return
     */
    @Override
    public List<Statistics> listSpider(int pageSize) {
        PageHelper.startPage(1, pageSize);
        List<BizStatistics> entityList = statisticsMapper.listSpider();
        if (CollectionUtils.isEmpty(entityList)) {
            return null;
        }
        List<Statistics> list = new ArrayList<>();
        for (BizStatistics entity : entityList) {
            list.add(new Statistics(entity));
        }
        return list;
    }

    /**
     * 获取文章分类统计
     *
     * @return
     */
    @Override
    public List<Statistics> listType(int pageSize) {
        PageHelper.startPage(1, pageSize);
        List<BizStatistics> entityList = statisticsMapper.listType();
        if (CollectionUtils.isEmpty(entityList)) {
            return null;
        }
        List<Statistics> list = new ArrayList<>();
        for (BizStatistics entity : entityList) {
            list.add(new Statistics(entity));
        }
        return list;
    }

}

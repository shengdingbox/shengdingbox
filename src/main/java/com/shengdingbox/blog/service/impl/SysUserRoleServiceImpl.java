package com.shengdingbox.blog.service.impl;

import com.shengdingbox.blog.entity.UserRole;
import com.shengdingbox.blog.persistence.beans.SysUserRole;
import com.shengdingbox.blog.persistence.mapper.SysUserRoleMapper;
import com.shengdingbox.blog.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户角色
 * @author Dabao (17611555590@163.com)
 * @version 1.0
 * @website https://www.shengdingbox.com
 * @date 2019年7月16日
 * @since 1.0
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper resourceMapper;

    @Override
    public UserRole insert(UserRole entity) {
        Assert.notNull(entity, "UserRole不可为空！");
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        resourceMapper.insert(entity.getSysUserRole());
        return entity;
    }

    @Override
    public void insertList(List<UserRole> entities) {
        Assert.notNull(entities, "entities不可为空！");
        List<SysUserRole> sysUserRole = new ArrayList<>();
        for (UserRole UserRole : entities) {
            UserRole.setUpdateTime(new Date());
            UserRole.setCreateTime(new Date());
            sysUserRole.add(UserRole.getSysUserRole());
        }
        resourceMapper.insertList(sysUserRole);
    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return resourceMapper.deleteByPrimaryKey(primaryKey) > 0;
    }

    @Override
    public boolean updateSelective(UserRole entity) {
        Assert.notNull(entity, "UserRole不可为空！");
        entity.setUpdateTime(new Date());
        return resourceMapper.updateByPrimaryKeySelective(entity.getSysUserRole()) > 0;
    }

    @Override
    public UserRole getByPrimaryKey(Long primaryKey) {
        Assert.notNull(primaryKey, "PrimaryKey不可为空！");
        SysUserRole sysUserRole = resourceMapper.selectByPrimaryKey(primaryKey);
        return null == sysUserRole ? null : new UserRole(sysUserRole);
    }

    @Override
    public List<UserRole> listAll() {
        List<SysUserRole> sysUserRole = resourceMapper.selectAll();
        return getUserRole(sysUserRole);
    }

    private List<UserRole> getUserRole(List<SysUserRole> sysUserRole) {
        if (CollectionUtils.isEmpty(sysUserRole)) {
            return null;
        }
        List<UserRole> UserRole = new ArrayList<>();
        for (SysUserRole r : sysUserRole) {
            UserRole.add(new UserRole(r));
        }
        return UserRole;
    }

    /**
     * 添加用户角色
     *
     * @param userId
     * @param roleIds
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public void addUserRole(Long userId, String roleIds) {
        //删除
        removeByUserId(userId);
        //添加
        String[] roleIdArr = roleIds.split(",");
        if (roleIdArr.length == 0) {
            return;
        }
        UserRole u = null;
        List<UserRole> roles = new ArrayList<>();
        for (String roleId : roleIdArr) {
            u = new UserRole();
            u.setUserId(userId);
            u.setRoleId(Long.parseLong(roleId));
            roles.add(u);
        }
        insertList(roles);
    }

    /**
     * 根据用户ID删除用户角色
     *
     * @param userId
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public void removeByUserId(Long userId) {
        Example example = new Example(SysUserRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userId);
        resourceMapper.deleteByExample(example);
    }
}

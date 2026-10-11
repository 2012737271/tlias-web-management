package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {
    //查询所有部门
    List<Dept> findAll();
/**
 *根据部门ID删除部门
 **/
    void deleteById(Integer id);

    //新增部门
    void add(Dept dept);

    //根据部门ID查询部门数据
    Dept getById(Integer id);

    //修改部门
    void update(Dept dept);
}

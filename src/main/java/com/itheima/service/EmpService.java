package com.itheima.service;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public interface EmpService {
    //分页查询
    //page:当前页码
    //pageSize:每页记录数
//    PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender,
//                           LocalDate begin, LocalDate end);
    PageResult<Emp> page(EmpQueryParam empQueryParam);
//新增员工
    void save(Emp emp) throws Exception;

}

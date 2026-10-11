package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.net.Inet4Address;
import java.util.List;
@Slf4j
//抽取公共路径
@RequestMapping("/depts")
@RestController
public class DeptController {
//    private final Logger log= LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

//    @RequestMapping(value="/depts",method = RequestMethod.GET)//method：指定请求方法
@GetMapping
    public Result list() {
//        System.out.println("查询全部部门数据");
    log.info("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();
        return  Result.success(deptList);
    }
//删除部门方式一：HttpServletResquest 获取请求参数（操作繁琐不推荐）
    //定义删除部门的方法
   /* @DeleteMapping("/depts")
    public Result delete(HttpServletRequest request){
    String idStr=request.getParameter("id");
    int id= Integer.parseInt(idStr);
        System.out.println("根据id删除部门"+id);
        return Result.success();
    } */
/*方式二：通过Srping提供的@ResquestParam注解，将请求参数绑定给方法形参
    *注意事项：一旦声明了@ResquestParam，该参数在请求是必须传递，不传递会报错（默认requestd=true）
*/
//@DeleteMapping("/depts")
//public Result delete(@RequestParam("id") Integer deptId){
//    System.out.println("根据id删除部门"+deptId);
//    return Result.success();
//}

/*
方式三:省略RequestParam(前端传递的请求参数名与服务端方法形参名一致)
*/
    @DeleteMapping
public Result delete(Integer id){
//        System.out.println("根据id删除部门"+id);
    log.info("根据id删除部门{}",id);
    deptService.deleteById(id);
    return Result.success();
}
/*

 /*新增部门*/
@PostMapping
    public Result add(@RequestBody Dept dept){
//    System.out.println("新增部门："+dept);
    log.info("新增部门{}",dept);
    deptService.add(dept);
    return Result.success();
}
/**根据id查询部门
 *
@GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable("id") Integer deptID){
        System.out.println("根据id查询部门"+deptID);

        return Result.success();
}
*/
/**根据id查询部门
 */
@GetMapping("/{id}")
public Result getInfo(@PathVariable Integer id){
//    System.out.println("根据id查询部门"+id);
    log.info("根据id查询部门{}",id);
    Dept dept=deptService.getById(id);
    return Result.success(dept);
}
/**修改部门
 */
@PutMapping
public Result update(@RequestBody Dept dept){
//    System.out.println("修改部门："+dept);
    log.info("修改部门{}",dept);
    deptService.update(dept);
    return Result.success();
}

}
package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 部门管理Controller
 */
//为简化开发流程，请求路径都是/depts，可以加上@RequestMapping("/depts")
@RequestMapping("/depts")
@Slf4j
@RestController
public class DeptController {

   // private static Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;//调用接口

    /**
     * 查询部门操作
     * @return
     */
   // @RequestMapping(value = "/depts",method = RequestMethod.GET)
   // @GetMapping("/depts")
    @GetMapping
    public Result list(){
       //尽量不用这中记录日志 System.out.println("查询全部部门数据");
       log.info("查询所有部门数据");
       //调用service查询部门数据 返回的应该是一个集合
        List<Dept> deptList =  deptService.list();
        return Result.success(deptList);
    }

    /**
     * delete部门操作
     */
    //@DeleteMapping("/depts/{id}")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门:{}",id);//一个{}就是一个参数占位符
        deptService.delete(id);
        return Result.success();
    }
    /**
     * 新增部门操作
     */
    //@PostMapping("/depts")
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        deptService.add(dept);
        return Result.success();//成功就返回 code：1
    }
    //获取部门
    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") Integer id){
        log.info("查询部门: {}",id);
        //调service
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
    /**
     * 修改部门
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门：{}",dept.getName());
        deptService.update(dept);
        return Result.success();
    }
}

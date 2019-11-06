package ab.tjl.oa.controller;

import ab.tjl.oa.entity.Department;
import ab.tjl.oa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
/**
 * Descrption: 部门控制层
 */
@Controller("departmentController")
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    /**
     * Descrption: 部门列表
     * @Param: [map]
     * @Return: java.lang.String
     */
    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        map.put("list", departmentService.getAll());
        return "department_list";
    }
    
    /**
     * Descrption: 打开添加部门界面
     * @Param: [map]
     * @Return: java.lang.String
     */
    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("department",new Department());
        return "department_add";
    }
    
    /**
     * Descrption: 添加部门功能
     * @Param: [department]
     * @Return: java.lang.String
     */
    @RequestMapping("/add")
    public String add(Department department){
        departmentService.add(department);
        return "redirect:list";
    }

    /**
     * Descrption: 打开修改部门信息界面
     * @Param: [sn, map]
     * @Return: java.lang.String
     */
    @RequestMapping(value = "/to_update",params = "sn")
    public String toUpdate(String sn,Map<String,Object> map){
        map.put("department", departmentService.get(sn));
        return "department_update";
    }
    /**
     * Descrption: 修改部门信息功能
     * @Param: [department]
     * @Return: java.lang.String
     */
    @RequestMapping("/update")
    public String update(Department department){
        departmentService.edit(department);
        return "redirect:list";
    }
    /**
     * Descrption: 根据部门号删除部门
     * @Param: [sn]
     * @Return: java.lang.String
     */
    @RequestMapping(value = "/remove",params = "sn")
    public String remove(String sn){
        departmentService.remove(sn);
        return "redirect:list";
    }

}

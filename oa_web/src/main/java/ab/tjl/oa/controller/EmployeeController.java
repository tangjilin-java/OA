package ab.tjl.oa.controller;

import ab.tjl.oa.entity.Employee;
import ab.tjl.oa.global.Contant;
import ab.tjl.oa.service.DepartmentService;
import ab.tjl.oa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
/**
 * Descrption: 员工控制层
 */
@Controller("employeeController")
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;

    /**
     * Descrption: 员工列表
     * @Param: [map]
     * @Return: java.lang.String
     */
    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        map.put("list", employeeService.getAll());
        return "employee_list";
    }
    /**
     * Descrption: 打开添加员工界面
     * @Param: [map]
     * @Return: java.lang.String
     */
    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("employee",new Employee());
        map.put("dlist", departmentService.getAll());
        map.put("plist", Contant.getPosts());
        return "employee_add";
    }
    /**
     * Descrption: 添加员工功能
     * @Param: [employee]
     * @Return: java.lang.String
     */
    @RequestMapping("/add")
    public String add(Employee employee){
        employeeService.add(employee);
        return "redirect:list";
    }

    /**
     * Descrption: 打开修改员工信息界面
     * @Param: [sn, map]
     * @Return: java.lang.String
     */
    @RequestMapping(value = "/to_update",params = "sn")
    public String toUpdate(String sn,Map<String,Object> map){
        map.put("employee", employeeService.get(sn));
        map.put("dlist", departmentService.getAll());
        map.put("plist", Contant.getPosts());
        return "employee_update";
    }
    /**
     * Descrption: 修改员工信息功能
     * @Param: [employee]
     * @Return: java.lang.String
     */
    @RequestMapping("/update")
    public String update(Employee employee){
        employeeService.edit(employee);
        return "redirect:list";
    }
    /**
     * Descrption: 根据工号删除员工
     * @Param: [sn]
     * @Return: java.lang.String
     */
    @RequestMapping(value = "/remove",params = "sn")
    public String remove(String sn){
        employeeService.remove(sn);
        return "redirect:list";
    }

    /**
     * Descrption: 根据工号查找员工信息
     * @Param: [sn, map]
     * @Return: java.lang.String
     */
    @RequestMapping(value = "/find",params = "sn")
    public String find(String sn,Map<String,Object> map){
        map.put("employee", employeeService.get(sn));
        return "find";
    }

}

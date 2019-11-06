package ab.tjl.oa.controller;

import ab.tjl.oa.entity.Employee;
import ab.tjl.oa.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
/**
 * Descrption: 基本信息控制层
 */
@Controller("basicController")
public class BasicController {
    @Autowired
    private BasicService basicService;
    /**
     * Descrption:打开登录界面
     * @Param: []
     * @Return: java.lang.String
     */
    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }
    /**
     * Descrption: 登录功能
     * @Param: [session, sn, password]
     * @Return: java.lang.String
     */
    @RequestMapping("/login")
    public String login(HttpSession session, @RequestParam String sn, @RequestParam String password){
        Employee employee = basicService.login(sn,password);
        if (employee == null) {
            return "redirect:to_login";
        }
        session.setAttribute("employee",employee);
        return "redirect:self";
    }
    /**
     * Descrption:个人信息
     * @Param: []
     * @Return: java.lang.String
     */
    @RequestMapping("/self")
    public String self(){
        return  "self";
    }
    /**
     * Descrption: 退出功能
     * @Param: [session]
     * @Return: java.lang.String
     */
    @RequestMapping("/quit")
    public String quit(HttpSession session){
        session.setAttribute("employee",null);
        return "redirect:to_login";
    }
    /**
     * Descrption:打开修改密码界面
     * @Param: []
     * @Return: java.lang.String
     */
    @RequestMapping("/to_change_password")
    public String toChangePassword(){
        return "change_password";
    }
    /**
     * Descrption: 修改密码功能
     * @Param: [session, old, new1, new2]
     * @Return: java.lang.String
     */
    @RequestMapping("/change_password")
    public String changePassword(HttpSession session, @RequestParam String old, @RequestParam String new1 ,@RequestParam String new2){
        Employee employee = (Employee)session.getAttribute("employee");
        if(employee.getPassword().equals(old)){
            if(new1.equals(new2)){
                employee.setPassword(new1);
                basicService.changePassword(employee);
                return "redirect:self";
            }
        }
        return "redirect:to_change_password";
    }

}

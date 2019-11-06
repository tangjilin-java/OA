package ab.tjl.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:登录控制层
 */
@Controller
@RequestMapping("/")
public class LoginController {

    /**
     * Descrption: 登录功能
     * @Param: []
     * @Return: java.lang.String
     */
    @RequestMapping("/")
    public String login(){
        return "login";
    }

}

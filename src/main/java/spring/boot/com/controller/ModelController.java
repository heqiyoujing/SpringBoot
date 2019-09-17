package spring.boot.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: yiqq
 * @date: 2018/8/14
 * @description:
 */
@Controller
public class ModelController {

    @Autowired
    UserController userController;

    @RequestMapping("/")
    public String index(ModelMap map) {

        String msg = userController.show("百达宁");
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", msg);
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }
}

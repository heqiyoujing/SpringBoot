package spring.boot.com.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.com.dao.UserRepositoty;
import spring.boot.com.email.EmailUtils;
import spring.boot.com.entity.User;

/**
 * @author: yiqq
 * @date: 2018/8/8
 * @description:
 */
@RestController
public class UserController {

    @Autowired
    private UserRepositoty userRepositoty;

    @RequestMapping("/hello")
    public String hello() {
        return "hello world!";
    }

    @RequestMapping(value = "/show")
    public String show(@RequestParam(value = "name")String name){
        User user = userRepositoty.findByName(name);
        if(null != user)
            return user.getId()+"/"+user.getName()+"/"+user.getRole();
        else
            return "null";
    }

    @RequestMapping("sendEmail")
    public String sendEmail() throws JsonProcessingException {
        boolean isSend = EmailUtils.sendEmail("这是一封测试邮件", new String[]{"931380652@qq.com"}, null, "<h3><a href='http://www.baidu.com'>百度一下，你就知道</a></h3>", null);
        return "发送邮件:" + isSend;
    }



}

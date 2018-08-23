package com.example.demo.cotroller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserDAO;

@RestController
public class UserController {
    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/login")
    public String getUSer() {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken("123", "234");
        // 执行认证登陆
        subject.login(token);
        //根据权限，指定返回数据
        String role = userDAO.getRoleByUserName("123");
        if ("user".equals(role)) {
            return "欢迎登陆";
        }
        if ("admin".equals(role)) {
            return "欢迎来到管理员页面";
        } 
        return "权限错误！";
    }
}

package com.example;

import com.example.domain.TUser;
import com.example.mapper.TUserDao;
import com.example.repository.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * @Description: java类作用描述
 * @Author: gaoxi
 * @CreateDate: 2019/6/10 23:34
 * @Version: 1.0
 * https://www.cnblogs.com/shyf/p/9851025.html(没有登录方法。登了方法自己写的)
 */
@Controller
@RequestMapping("/tuser")
public class TUserController {

    @Autowired
    private TUserDao tUserDao;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/forlogin")
    public String login(){
        return "login";
    }

    @GetMapping("/zhuce")
    public String zhuce() {
        return "zhuce";
    }

    @PostMapping("/save")
    public String save(String username,String password){
        TUser tUser = new TUser();
        tUser.setId(UUID.randomUUID().toString());
        tUser.setUsername(username);
        tUser.setPassword(password);
        tUserDao.save(tUser);
        return "login";
    }
    /**
     * 登录
     * @param user 用户名和密码
     * @return Result
     * https://blog.csdn.net/byteArr/article/details/80955703
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public Result login(TUser user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            String userId = tUserDao.findByUsernameAndPassword(user);
//            String userId =tUserDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
            if(userId == null){
                result.setMsg("用户名或密码错误");
            }else{
                result.setMsg("登录成功");
                result.setSuccess(true);
                user.setId(userId);
                result.setDetail(user);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

}
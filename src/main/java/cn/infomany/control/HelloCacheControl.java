package cn.infomany.control;

import cn.infomany.model.User;
import cn.infomany.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloCacheControl {

    @Autowired
    private HelloService service;

    @GetMapping("getUser")
    @ResponseBody
    public User getUser(Integer id) {
        System.out.println("访问控制层：id = " + id);
        return service.getUser(id);
    }

    @GetMapping("delUser")
    @ResponseBody
    public boolean delUser(Integer id) {
        System.out.println("访问控制层删除：id = " + id);
        return service.delUser(id);
    }

    @GetMapping("putUser")
    @ResponseBody
    public User putUser(Integer id, String name) {
        System.out.println("访问控制层更新：name = " + name);
        User user = new User();
        user.setId(id);
        user.setAge(23);
        user.setName(name);
        user.setSex(false);
        return service.putUser(user);
    }

}

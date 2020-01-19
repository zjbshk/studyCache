package cn.infomany.service;


import cn.infomany.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Cacheable(value = "getUser", key = "#id")
    public User getUser(Integer id) {
        System.out.println("访问服务层：id = " + id);
        User user = new User();
        user.setId(id);
        user.setAge(23);
        user.setName("zjb");
        user.setSex(false);
        return user;
    }

    @CacheEvict(value = "getUser", key = "#id")
    public boolean delUser(Integer id) {
        System.out.println("服务层删除：id = " + id);
        return true;
    }

    // user.id | #result.id都可以
    @CachePut(value = "getUser", key = "#root.args[0].id")
    public User putUser(User user) {
        System.out.println("访问服务层更新：id = " + user.getId());
        return user;
    }
}

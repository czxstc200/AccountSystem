package cn.edu.bupt.controller;

import cn.edu.bupt.dao.user.UserDao;
import cn.edu.bupt.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.utils.UUIDs;
import java.util.UUID;

/**
 * Created by CZX on 2018/3/23.
 */
@RestController
public class HelloController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/")
    public String welcome(){
        return "hello";
    }
    @RequestMapping("/add")
    public String add(){
        User user = new User();
        user.setName("test");
        user.setTenant_id(UUID.fromString("9e3d50f0-2e75-11e8-8ecc-d92ed4f0141c"));
        user.setCustomer_id(UUID.fromString("f7637871-2e76-11e8-92bc-d92ed4f0141c"));
        user.setAuthority("SYS_ADMIN");
        return userDao.save(user).toString();

    }

    @RequestMapping("/delete")
    public boolean delete(){
        return userDao.removeById(UUID.fromString("f7637872-2e76-11e8-92bc-d92ed4f0141c"));
    }

    @RequestMapping("/findbyid")
    public String findbyid(){
        return userDao.findById(UUID.fromString("9e3d50f2-2e75-11e8-8ecc-d92ed4f0141c")).toString();
    }

    @RequestMapping("/findbyemail")
    public String findbyemail(){
        return userDao.findByEmail("test").toString();
    }
}

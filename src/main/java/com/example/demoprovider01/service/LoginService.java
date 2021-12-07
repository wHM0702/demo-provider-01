package com.example.demoprovider01.service;

import com.example.demoprovider01.config.RedisUtils;
import com.example.demoprovider01.dao.UserDao;
import model.entity.User;
import model.entity.detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class LoginService {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private UserDao userDao;

    @RequestMapping("/login")
    public User login(String userName, String password){
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println(userName);
        User user = userDao.checkLogin(userName, password);
        if(user!=null){
            if(userName.equals(user.getUserName()) && password.equals(user.getPassword())){
                return user;
            }else {
                return null;
            }
        }
        return null;
    }


    @RequestMapping("/queryDetail")
    public List<detail> queryDetail(){
        List<detail> details = userDao.queryAll();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (detail detail : details) {
            detail.setCreateDateStr(sdf.format(detail.getCreateDate()));
        }
        return details;
    }

    @RequestMapping("/addComm")
    public boolean addComm(int bid,int id,String content){
        int i = userDao.addComment(bid, content, id);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }
//    @RequestMapping("/login1")
//    public String login1(int count) throws InterruptedException {
////        Thread.sleep(1000);
//        System.out.println("yy");
//        return "login>>> " + count + "demom-provider:9003";
//    }
//
//    @RequestMapping("/buy")
//    @JmsListener(destination = "whm")
//    public void buy(){
//        try {
//            while (redisUtils.setnx("suo","xx")){
//                Thread.sleep(500);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        int stock = new Integer((String) redisUtils.get("stock"));
//        System.out.println("来购买，目前库存："+stock);
//        if(stock>0){
//            stock--;
//            redisUtils.set("stock",stock+"");
//            System.out.println("购买了一个");
//        }else {
//            System.out.println("来购买，但没货了");
//        }
////        return "demom-provider:9003";
//
//        redisUtils.delete("suo");
//    }
}

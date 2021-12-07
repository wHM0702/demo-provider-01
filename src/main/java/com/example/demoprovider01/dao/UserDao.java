package com.example.demoprovider01.dao;


import model.entity.User;
import model.entity.detail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserDao {

    User checkLogin(@Param("userName") String userName, @Param("password") String password);

    List<detail> queryAll();

    int addComment(@Param("bid") int bid,@Param("content")String content,@Param("id")int id);
}

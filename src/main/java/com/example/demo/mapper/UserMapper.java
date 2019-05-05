package com.example.demo.mapper;

import com.example.demo.model.User;
//import org.apache.ibatis.annotations.Result;
//import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select name, age from test")
//    @Results({
//            @Result(property = "age",  column = "age"),
//            @Result(property = "name", column = "name")
//    })
    List<User> getAll();
}

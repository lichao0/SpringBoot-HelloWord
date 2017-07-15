package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;

import com.example.pojo.User;

//@Mapper
public interface UserMapper {

	@Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
	int insert(@Param("name") String name, @Param("age") Integer age);

	@Insert("INSERT INTO USER(name, age, sex) VALUES(#{name}, #{age}, #{sex})")
	int insertUser(User user);

	@Select("SELECT * FROM USER WHERE NAME = #{name}")
	User findByName(@Param("name") String name);

	@Update("UPDATE USER SET age=#{age} WHERE name=#{name}")
	void update(User user);

	@Delete("DELETE FROM USER WHERE id=#{id}")
	void delete(Long id);
	
	@Results({@Result(property="name", column="name")})
	@Select("SELECT name, age FROM user")
	List<User> findAll();
}

package cc.yuerblog.sb.mapper.userdb;

import cc.yuerblog.sb.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user(`name`,`age`) values(#{name}, #{age})")
    void insertUser(@Param("name") String name, @Param("age") int age);

    @Update("update user set age=#{age} where id=#{id}")
    int update(@Param("age") int age, @Param("id") long id);

    @Delete("delete from user where id=#{id}")
    int delete(@Param("id") long id);
}

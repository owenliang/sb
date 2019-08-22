package cc.yuerblog.sb.mapper.articledb;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper {
    @Insert("insert into article(`name`,`content`) values(#{name}, #{content})")
    void insertArticle(@Param("name") String name, @Param("content") String content);
}

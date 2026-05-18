package com.example.dormitory.mapper;
import com.example.dormitory.entity.Notice;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface NoticeMapper {
    @Select("SELECT * FROM notice ORDER BY id DESC")
    List<Notice> findAll();

    @Insert("INSERT INTO notice(title, publisher, content, publish_date, photo_url) VALUES(#{title}, #{publisher}, #{content}, #{publishDate}, #{photoUrl})")
    int insert(Notice notice);

    @Update("UPDATE notice SET title=#{title}, publisher=#{publisher}, content=#{content}, publish_date=#{publishDate}, photo_url=#{photoUrl} WHERE id=#{id}")
    int update(Notice notice);

    @Delete("DELETE FROM notice WHERE id = #{id}")
    int deleteById(Integer id);
}

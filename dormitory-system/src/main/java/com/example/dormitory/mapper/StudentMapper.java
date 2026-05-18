package com.example.dormitory.mapper;

import com.example.dormitory.entity.Student;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface StudentMapper {
    // 查询所有学生
    @Select("SELECT * FROM student")
    List<Student> findAll();

    // 根据姓名模糊搜索
    @Select("SELECT * FROM student WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<Student> findByName(String name);

    // 高级组合搜索
    @Select("<script>" +
            "SELECT * FROM student WHERE 1=1" +
            "<if test='name != null and name != \"\"'> AND name LIKE CONCAT('%', #{name}, '%')</if>" +
            "<if test='gender != null and gender != \"\"'> AND gender = #{gender}</if>" +
            "<if test='dormId != null and dormId != \"\"'> AND dorm_id LIKE CONCAT('%', #{dormId}, '%')</if>" +
            "<if test='startDate != null and startDate != \"\"'> AND check_in_date &gt;= #{startDate}</if>" +
            "<if test='endDate != null and endDate != \"\"'> AND check_in_date &lt;= #{endDate}</if>" +
            "</script>")
    List<Student> findByConditions(@Param("name") String name,
                                   @Param("gender") String gender,
                                   @Param("dormId") String dormId,
                                   @Param("startDate") String startDate,
                                   @Param("endDate") String endDate);

    // 增加学生
    @Insert("INSERT INTO student(stu_num, name, gender, phone, dorm_id, check_in_date, photo_url) " +
            "VALUES(#{stuNum}, #{name}, #{gender}, #{phone}, #{dormId}, #{checkInDate}, #{photoUrl})")
    int insert(Student student);

    // 修改学生信息
    @Update("UPDATE student SET stu_num=#{stuNum}, name=#{name}, gender=#{gender}, phone=#{phone}, " +
            "dorm_id=#{dormId}, check_in_date=#{checkInDate}, photo_url=#{photoUrl} WHERE id=#{id}")
    int update(Student student);

    // 删除学生
    @Delete("DELETE FROM student WHERE id = #{id}")
    int deleteById(Integer id);

    // 批量删除学生
    @Delete("<script>" +
            "DELETE FROM student WHERE id IN " +
            "<foreach collection='ids' item='id' open='(' separator=',' close=')'>" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    int deleteBatch(@Param("ids") List<Integer> ids);
}

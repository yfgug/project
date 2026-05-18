package com.example.dormitory.mapper;
import com.example.dormitory.entity.Repair;
import org.apache.ibatis.annotations.*;
import java.util.List;
@Mapper
public interface RepairMapper {
    @Select("SELECT * FROM repair ORDER BY id DESC")
    List<Repair> findAll();
    @Insert("INSERT INTO repair(stu_name, dorm_id, device, description, status, submit_date) VALUES(#{stuName}, #{dormId}, #{device}, #{description}, #{status}, #{submitDate})")
    int insert(Repair repair);
    @Update("UPDATE repair SET status = '已解决' WHERE id = #{id}")
    int resolve(Integer id);
    @Delete("DELETE FROM repair WHERE id = #{id}")
    int deleteById(Integer id);
}
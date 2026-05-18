package com.example.dormitory.service;

import com.example.dormitory.entity.Student;
import com.example.dormitory.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> getAllStudents() { return studentMapper.findAll(); }

    public List<Student> getStudentsByName(String name) { return studentMapper.findByName(name); }

    public List<Student> getStudentsByConditions(String name, String gender, String dormId,
                                                 String startDate, String endDate) {
        return studentMapper.findByConditions(name, gender, dormId, startDate, endDate);
    }

    public boolean addStudent(Student student) { return studentMapper.insert(student) > 0; }

    public boolean updateStudent(Student student) { return studentMapper.update(student) > 0; }

    public boolean deleteStudent(Integer id) { return studentMapper.deleteById(id) > 0; }

    public boolean deleteBatch(List<Integer> ids) { return studentMapper.deleteBatch(ids) > 0; }
}

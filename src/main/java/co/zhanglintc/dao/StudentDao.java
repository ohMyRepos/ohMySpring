package co.zhanglintc.dao;

import co.zhanglintc.pojo.Student;

import java.util.List;

public interface StudentDao {
    int insertStudent(Student student);
    void deleteStudentById(int id);
    List<Student> selectStudents();
}

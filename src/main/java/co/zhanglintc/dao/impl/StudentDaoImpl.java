package co.zhanglintc.dao.impl;

import co.zhanglintc.dao.StudentDao;
import co.zhanglintc.pojo.Student;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private StudentDao sd;

    @Override
    public int insertStudent(Student student) {
        sd.insertStudent(student);
        return student.getId();
    }

    @Override
    public void deleteStudentById(int id) {
        sd.deleteStudentById(id);
    }

    @Override
    public List<Student> selectStudents() {
        return sd.selectStudents();
    }

    public void setSd(StudentDao sd) {
        this.sd = sd;
    }
}

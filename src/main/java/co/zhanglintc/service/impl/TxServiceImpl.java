package co.zhanglintc.service.impl;

import co.zhanglintc.dao.StudentDao;
import co.zhanglintc.pojo.Student;
import co.zhanglintc.service.TxService;
import org.springframework.transaction.annotation.Transactional;

public class TxServiceImpl implements TxService {
    private StudentDao studentDao;

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    private void doInner(boolean doThrow) {
        Student tom = new Student();
        tom.setName("tom");
        tom.setAge(22);
        System.out.println("insert student");
        int id = studentDao.insertStudent(tom);
        System.out.println("insert done");
        if (doThrow) {
            throw new RuntimeException("some RuntimeException in a Transaction");
        }
        System.out.println("delete student");
        studentDao.deleteStudentById(id);
        System.out.println("delete done");
    }

    @Override
    @Transactional
    public void doSome(boolean doThrow) {
        doInner(doThrow);
    }

    @Override
    public void doAnother(boolean doThrow) {
        doInner(doThrow);
    }
}
